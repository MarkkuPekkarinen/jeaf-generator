/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.service1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class TechnicalHeaderContext implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "reseller".
   */
  public static final String RESELLER = "reseller";

  /**
   * Constant for the name of attribute "authenticationToken".
   */
  public static final String AUTHENTICATIONTOKEN = "authenticationToken";

  private String reseller;

  private String authenticationToken;

  /**
   * Map contains all custom headers that were set on the object.
   */
  private Map<String, String> customHeaders = new HashMap<String, String>();

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected TechnicalHeaderContext( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TechnicalHeaderContext( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    reseller = pBuilder.reseller;
    authenticationToken = pBuilder.authenticationToken;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new TechnicalHeaderContext objects. The method never
   * returns null.
   */
  public static Builder builder( TechnicalHeaderContext pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>TechnicalHeaderContext</code>.
   */
  public static class Builder {
    private String reseller;

    private String authenticationToken;

    /**
     * Use {@link TechnicalHeaderContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TechnicalHeaderContext#builder(TechnicalHeaderContext)} instead of private constructor to create new
     * builder.
     */
    protected Builder( TechnicalHeaderContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        reseller = pObject.reseller;
        authenticationToken = pObject.authenticationToken;
      }
    }

    /**
     * Method sets attribute {@link #reseller}.<br/>
     *
     * @param pReseller Value to which {@link #reseller} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setReseller( String pReseller ) {
      // Assign value to attribute
      reseller = pReseller;
      return this;
    }

    /**
     * Method sets attribute {@link #authenticationToken}.<br/>
     *
     * @param pAuthenticationToken Value to which {@link #authenticationToken} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setAuthenticationToken( String pAuthenticationToken ) {
      // Assign value to attribute
      authenticationToken = pAuthenticationToken;
      return this;
    }

    /**
     * Method creates a new instance of class TechnicalHeaderContext. The object will be initialized with the values of
     * the builder.
     *
     * @return TechnicalHeaderContext Created object. The method never returns null.
     */
    public TechnicalHeaderContext build( ) {
      TechnicalHeaderContext lObject = new TechnicalHeaderContext(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class TechnicalHeaderContext. The object will be initialized with the
     * values of the builder and validated afterwards.
     *
     * @return TechnicalHeaderContext Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public TechnicalHeaderContext buildValidated( ) throws ConstraintViolationException {
      TechnicalHeaderContext lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns attribute {@link #reseller}.<br/>
   *
   * @return {@link String} Value to which {@link #reseller} is set.
   */
  public String getReseller( ) {
    return reseller;
  }

  /**
   * Method sets attribute {@link #reseller}.<br/>
   *
   * @param pReseller Value to which {@link #reseller} should be set.
   */
  public void setReseller( String pReseller ) {
    // Assign value to attribute
    reseller = pReseller;
  }

  /**
   * Method returns attribute {@link #authenticationToken}.<br/>
   *
   * @return {@link String} Value to which {@link #authenticationToken} is set.
   */
  public String getAuthenticationToken( ) {
    return authenticationToken;
  }

  /**
   * Method sets attribute {@link #authenticationToken}.<br/>
   *
   * @param pAuthenticationToken Value to which {@link #authenticationToken} should be set.
   */
  public void setAuthenticationToken( String pAuthenticationToken ) {
    // Assign value to attribute
    authenticationToken = pAuthenticationToken;
  }

  /**
   * Method returns map with all custom headers that were added
   *
   * @return {@link Map} Map with all custom headers. The method never returns null. The returned map is unmodifiable.
   */
  public Map<String, String> getCustomHeaders( ) {
    return Collections.unmodifiableMap(customHeaders);
  }

  /**
   * Method adds the passed values as custom headers. The passed name and value of the http header must be compliant
   * with guidelines about http headers.
   *
   * @param pHeaderName Name of the HTTP header. The parameter must not be null,
   * @param pHeaderValue Value of the http header the parameter may be null.
   */
  public void addCustomHeader( String pHeaderName, String pHeaderValue ) {
    if (pHeaderName != null) {
      customHeaders.put(pHeaderName, pHeaderValue);
    }
    else {
      throw new IllegalArgumentException("Parameter 'pHeaderName' must not be null.");
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("reseller: ");
    lBuilder.append(reseller);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("authenticationToken: ");
    lBuilder.append(authenticationToken);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }
}