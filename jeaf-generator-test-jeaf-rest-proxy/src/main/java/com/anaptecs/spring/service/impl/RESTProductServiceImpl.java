
/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import com.anaptecs.jeaf.core.annotations.JEAFServiceProvider;
import com.anaptecs.jeaf.core.api.Component;
import com.anaptecs.jeaf.xfun.api.health.CheckLevel;
import com.anaptecs.jeaf.xfun.api.health.HealthCheckResult;
import com.anaptecs.spring.base.ChannelCode;
import com.anaptecs.spring.base.Context;
import com.anaptecs.spring.base.CurrencyCode;
import com.anaptecs.spring.base.Product;
import com.anaptecs.spring.base.Sortiment;
import com.anaptecs.spring.service.restproxy.RESTProductServiceRESTProxyServiceProvider;

/**
 * Implementation of RESTProductService.
 */
final class RESTProductServiceImpl extends RESTProductServiceImplBase {
  @JEAFServiceProvider
  private RESTProductServiceRESTProxyServiceProvider proxy;

  /**
   * Initialize object.
   */
  RESTProductServiceImpl( Component pComponent ) {
    super(pComponent);
  }

  /**
   * Method checks the current state of the service. Therefore JEAF defines three different check levels: internal
   * Checks, infrastructure checks and external checks. For further details about the check levels {@see CheckLevel}.
   * 
   * @param pLevel Check level on which the check should be performed. The parameter is never null.
   * @return {@link HealthCheckResult} Object describing the result of the check. The method may return null. This means
   * that the service does not implement any checks. In order to use as less memory as possible the method should use
   * the constant {@link HealthCheckResult#CHECK_OK} if no errors or warnings occurred during the check.
   */
  public HealthCheckResult check( CheckLevel pLevel ) {
    return null;
  }

  /**
   * Operation returns all available product.
   * 
   * 
   * @param pMaxResultSize
   * @return {@link Product}
   */

  @Override
  public List<Product> getProducts( int pMaxResultSize ) {
    return proxy.getProducts(pMaxResultSize);
  }

  /**
   * 
   * @param pProductID
   * @return {@link Product}
   */

  @Override
  public Product getProduct( String pProductID ) {
    return proxy.getProduct(pProductID);
  }

  /**
   * 
   * @param pProduct
   * @return {@link Boolean}
   */

  @Override
  public boolean createProduct( Product pProduct ) {
    return proxy.createProduct(pProduct);
  }

  /**
   * 
   * @param pContext
   * @return {@link Sortiment}
   */

  @Override
  public Sortiment getSortiment( Context pContext ) {
    return proxy.getSortiment(pContext);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link ChannelCode}
   */

  @Override
  public ChannelCode createChannelCode( String pChannelCode ) {
    return proxy.createChannelCode(pChannelCode);
  }

  /**
  * 
  */

  @Override
  public void ping( ) {
    proxy.ping();
  }

  /**
  * 
  */

  @Override
  public void testInit( ) {
    proxy.testInit();
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrencies( ChannelCode pChannelCode ) {
    return proxy.getSupportedCurrencies(pChannelCode);
  }

  /**
   * 
   * @param pChannelCode
   * @return {@link CurrencyCode}
   */

  @Override
  public List<CurrencyCode> getSupportedCurrenciesAsync( ChannelCode pChannelCode ) {
    return proxy.getSupportedCurrenciesAsync(pChannelCode);
  }

  /**
   * 
   * @param pBigDecimalHeader
   * @param pIntCookieParam
   * @param pLocaleQueryParam
   * @return {@link String}
   */

  @Override
  public String testParams( BigDecimal pBigDecimalHeader, int pIntCookieParam, Locale pLocaleQueryParam ) {
    return proxy.testParams(pBigDecimalHeader, pIntCookieParam, pLocaleQueryParam);
  }
}