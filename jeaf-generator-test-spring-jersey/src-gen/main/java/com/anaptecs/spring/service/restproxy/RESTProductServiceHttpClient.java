/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.restproxy;

import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.Callable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.stereotype.Component;

import com.anaptecs.jeaf.json.api.JSONMessages;
import com.anaptecs.jeaf.json.problem.Problem;
import com.anaptecs.jeaf.json.problem.RESTProblemException;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.tools.api.http.HTTPStatusCode;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.checks.Assert;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.anaptecs.jeaf.xfun.api.errorhandling.FailureMessage;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.jeaf.xfun.api.health.HealthStatus;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

/**
 * Class implements a http client implementation that can be used to call RESTProductService. This implementation
 * supports a wide range of configuration parameters for Apache HTTP client and Resilience4J circuit breaker.
 */
@Component
public class RESTProductServiceHttpClient {
  /**
   * Constant for problem JSON content type.
   */
  private static final String PROBLEM_JSON_CONTENT_TYPE = "application/problem+json";

  /**
   * Reference to object holding all the required configuration values for the HTTP client and circuit breaker.
   */
  @Inject
  private RESTProductServiceConfiguration configuration;

  /**
   * Instance of http client that is used to call proxied REST service. Configuration of HTTP client is according to the
   * defined configuration values.
   * 
   * @see #initializeHTTPClient()
   */
  private CloseableHttpClient httpClient;

  /**
   * Circuit breaker instance that is used when calling the REST service.
   * 
   * @see #initializeCircuitBreaker()
   */
  private CircuitBreaker circuitBreaker;

  /**
   * Object mapper is used for serialization and deserialization of objects from Java to JSON and vice versa.
   */
  @Inject
  private ObjectMapper objectMapper;

  /**
   * Method is called after service startup and performs initialization of Apache HTTP Client.
   */
  @PostConstruct
  private void initializeHTTPClient( ) {
    // Create connection manager that can be used by multiple threads in parallel.
    SocketConfig lSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
    Registry<ConnectionSocketFactory> lRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
        .register(URIScheme.HTTP.id, PlainConnectionSocketFactory.getSocketFactory())
        .register(URIScheme.HTTPS.id, SSLConnectionSocketFactory.getSocketFactory()).build();
    // Configure connection manager according to provided configuration parameters
    PoolingHttpClientConnectionManager lConnectionManager =
        new PoolingHttpClientConnectionManager(lRegistry, PoolConcurrencyPolicy.LAX, PoolReusePolicy.LIFO,
            TimeValue.ofMilliseconds(configuration.getKeepAliveDuration()));
    lConnectionManager.setMaxTotal(configuration.getMaxPoolSize());
    lConnectionManager.setDefaultMaxPerRoute(configuration.getMaxIdleConnections());
    lConnectionManager
        .setValidateAfterInactivity(TimeValue.ofMilliseconds(configuration.getValidateAfterInactivityDuration()));
    lConnectionManager.setDefaultSocketConfig(lSocketConfig);
    // Create pool for http connections that is used for this proxy.
    HttpClientBuilder lBuilder = HttpClientBuilder.create();
    lBuilder.setConnectionManager(lConnectionManager);
    // Configure request specific parameters.
    RequestConfig.Builder lConfigBuilder = RequestConfig.custom();
    lConfigBuilder.setConnectionKeepAlive(TimeValue.ofMilliseconds(configuration.getKeepAliveDuration()));
    lConfigBuilder.setConnectTimeout(Timeout.ofMilliseconds(configuration.getConnectTimeout()));
    lConfigBuilder.setResponseTimeout(Timeout.ofMilliseconds(configuration.getResponseTimeout()));
    lConfigBuilder.setExpectContinueEnabled(true);
    lBuilder.setDefaultRequestConfig(lConfigBuilder.build());
    // Define retry behavior.
    lBuilder.setRetryStrategy(new DefaultHttpRequestRetryStrategy(configuration.getMaxRetries(),
        TimeValue.ofMilliseconds(configuration.getRetryInterval())));
    // Finally we have to create the http client.
    httpClient = lBuilder.build();
  }

  /**
   * Method is called after service startup and performs initialization of resilience4J circuit breaker.
   */
  @PostConstruct
  private void initializeCircuitBreaker( ) {
    // Create circuit break configuration for target.
    CircuitBreakerConfig.Builder lConfigBuilder = CircuitBreakerConfig.custom();
    lConfigBuilder.failureRateThreshold(configuration.getFailureRateThreshold());
    lConfigBuilder.waitDurationInOpenState(Duration.ofMillis(configuration.getDurationInOpenState()));
    lConfigBuilder.slowCallDurationThreshold(Duration.ofMillis(configuration.getSlowRequestDuration()));
    lConfigBuilder.slowCallRateThreshold(configuration.getSlowRequestRateThreshold());
    lConfigBuilder.permittedNumberOfCallsInHalfOpenState(configuration.getPermittedCallsInHalfOpenState());
    lConfigBuilder.slidingWindowSize(configuration.getSlidingWindowSizeSeconds());
    lConfigBuilder.recordExceptions(IOException.class, RuntimeException.class);
    CircuitBreakerRegistry lCircuitBreakerRegistry = CircuitBreakerRegistry.of(lConfigBuilder.build());
    circuitBreaker = lCircuitBreakerRegistry.circuitBreaker("Product Service Circuit Breaker");
  }

  /**
   * Method check state state of this http client based on the state of the circuit breaker.
   * 
   * @param pLevel Check level is not consider for the executed checks.
   * @return {@link HealthCheckResult} Result of the check. Method returns null in case that everything is fine.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    // Determine circuit breaker state.
    CircuitBreaker.State lState = circuitBreaker.getState();
    // Determine health state depending on circuit breaker state.
    HealthCheckResult lCheckResult;
    switch (lState) {
      // Everything is fine
      case CLOSED:
        lCheckResult = null;
        break;
      // Circuit breaker is not active
      case DISABLED:
      case METRICS_ONLY:
        FailureMessage lWarning = new FailureMessage(JSONMessages.CIRCUIT_BREAKER_NOT_ACTIVE, "RESTProductService",
            configuration.getExternalServiceURL(), lState.name());
        lCheckResult = new HealthCheckResult(HealthStatus.WARNING, lWarning, null);
        break;
      // Besides open states also half open is treated as open to avoid flipping back and forth of health state
      case OPEN:
      case FORCED_OPEN:
      case HALF_OPEN:
        FailureMessage lError = new FailureMessage(JSONMessages.CIRCUIT_BREAKER_NOT_ACTIVE, "RESTProductService",
            configuration.getExternalServiceURL(), lState.name());
        lCheckResult = new HealthCheckResult(HealthStatus.ERROR, null, lError);
        break;
      default:
        Assert.unexpectedEnumLiteral(lState);
        lCheckResult = null;
    }
    return lCheckResult;
  }

  /**
   * Method executes a HTTP request that is expected to return a collection of objects as result.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   * @param pCollectionClass Class object of collection class that should be returned e.g. java.util.List. The parameter
   * must not be null.
   * @param pTypeClass Type of the objects that will be inside the collection. The parameter must not be null.
   * @return T Collection of objects as it was defined by <code>pCollectionClass</code> and <code>pTypeClass</code>
   */
  @SuppressWarnings({ "rawtypes" })
  public <T> T executeCollectionResultRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode, Class<? extends Collection> pCollectionClass, Class<?> pTypeClass ) {
    // Check parameters
    Check.checkInvalidParameterNull(pRequest, "pRequest");
    Check.checkInvalidParameterNull(pCollectionClass, "pCollectionClass");
    Check.checkInvalidParameterNull(pTypeClass, "pTypeClass");
    // Create matching response type for collections as defined by the passed parameters
    JavaType lResponseType = objectMapper.getTypeFactory().constructCollectionType(pCollectionClass, pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, lResponseType);
  }

  /**
   * Method executes a HTTP request that is expected to return a single non collection object as result.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   * @param pTypeClass Type of the object that will be returned by the call. The parameter must not be null.
   * @return T Single object as it was defined by <code>pTypeClass</code>
   */
  public <T> T executeSingleObjectResultRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode, Class<?> pTypeClass ) {
    // Check parameters
    Check.checkInvalidParameterNull(pRequest, "pRequest");
    Check.checkInvalidParameterNull(pTypeClass, "pTypeClass");
    // Create matching response type as defined by the passed parameters
    JavaType lResponseType = objectMapper.getTypeFactory().constructType(pTypeClass);
    // Execute request and return result.
    return executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, lResponseType);
  }

  /**
   * Method executes a HTTP request that is expected to return no response content.
   * 
   * @param pRequest HTTP request that should be executed. The parameter must not be null.
   * @param pSuccessfulStatusCode HTTP status code that represents a successful call. This status code is required in
   * order to be able to distinguish between successful and failed requests.
   */
  public void executeNoResponseContentRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext,
      int pSuccessfulStatusCode ) {
    // Check parameters
    Check.checkInvalidParameterNull(pRequest, "pRequest");
    // Execute request and return result.
    executeRequest(pRequest, pHttpContext, pSuccessfulStatusCode, null);
  }

  /**
   * Method executes the passed HTTP request using the configured HTTP client and circuit breaker.
   * 
   * @param pRequest Request that should b executed. The parameter must not be null.
   * @param pSuccessfulStatusCode Status code that defines that the call was successful.
   * @param pResponseType Object describing the response type of the call. The parameter may be null in case that
   * operation does not return any content e.g. void operations.
   * @return T Object of defined response type. If the called REST resource returns no content as response then null
   * will be returned.
   */
  private <T> T executeRequest( ClassicHttpRequest pRequest, HttpContext pHttpContext, int pSuccessfulStatusCode,
      JavaType pResponseType ) {
    // Try to execute call to REST resource
    CloseableHttpResponse lResponse = null;
    try {
      // Decorate call to proxy with circuit breaker.
      Callable<CloseableHttpResponse> lCallable =
          CircuitBreaker.decorateCallable(circuitBreaker, new Callable<CloseableHttpResponse>() {
            @Override
            public CloseableHttpResponse call( ) throws IOException {
              return httpClient.execute(pRequest, pHttpContext);
            }
          });
      // Execute request to REST resource
      lResponse = circuitBreaker.executeCallable(lCallable);
      // If call was successful then we have to convert response into real objects.
      int lStatusCode = lResponse.getCode();
      if (lStatusCode == pSuccessfulStatusCode) {
        T lResultObject;
        HttpEntity lEntity = lResponse.getEntity();
        if (lEntity.getContentLength() > 0) {
          lResultObject = objectMapper.readValue(lEntity.getContent(), pResponseType);
        }
        else {
          lResultObject = null;
        }
        return lResultObject;
      }
      // Error when trying to execute REST call.
      else {
        // If server provided problem JSON then we will return this information.
        if (PROBLEM_JSON_CONTENT_TYPE.equals(lResponse.getEntity().getContentType())) {
          throw new RESTProblemException(lStatusCode, lResponse.getEntity().getContent());
        }
        // Build up problem JSON from the information we have.
        else {
          // Try to resolve some details.
          Problem.Builder lProblemBuilder = Problem.Builder.newBuilder().setStatus(lStatusCode);
          lProblemBuilder.setType(pRequest.getUri().toString());
          HttpEntity lEntity = lResponse.getEntity();
          if (lEntity != null && lEntity.getContentLength() > 0) {
            lProblemBuilder.setDetail(Tools.getStreamTools().getStreamContentAsString(lEntity.getContent()));
          }
          throw new RESTProblemException(lProblemBuilder.build());
        }
      }
    }
    //
    // In all the cases below we will use status code 500 INTERNAL_SERVER error as it is not the clients fault that the
    // request could not be processed
    //
    // IOException can result from communication or serialization problems.
    catch (IOException e) {
      Problem.Builder lProblemBuilder =
          Problem.Builder.newBuilder().setStatus(HTTPStatusCode.INTERNAL_SERVER_ERROR.getCode());
      lProblemBuilder.setType(pRequest.toString());
      lProblemBuilder.setDetail(e.getMessage());
      throw new RESTProblemException(lProblemBuilder.build(), e);
    }
    // Thanks to circuit breaker interface definition of Resilience4J we have to handle RuntimeExceptions
    catch (RuntimeException e) {
      throw e;
    }
    // Thanks to circuit breaker interface definition of Resilience4J we also have to catch java.lang.Exception ;-(
    catch (Exception e) {
      Problem.Builder lProblemBuilder =
          Problem.Builder.newBuilder().setStatus(HTTPStatusCode.INTERNAL_SERVER_ERROR.getCode());
      lProblemBuilder.setType(pRequest.toString());
      lProblemBuilder.setDetail(e.getMessage());
      throw new RESTProblemException(lProblemBuilder.build(), e);
    }
    // No matter what happened we have at least close the http response if possible.
    finally {
      if (lResponse != null) {
        try {
          lResponse.close();
        }
        catch (IOException e) {
          XFun.getTrace().warn(JSONMessages.UNABLE_TO_CLOSE_HTTP_RESPONSE, e, pRequest.getRequestUri(), e.getMessage());
        }
      }
    }
  }
}