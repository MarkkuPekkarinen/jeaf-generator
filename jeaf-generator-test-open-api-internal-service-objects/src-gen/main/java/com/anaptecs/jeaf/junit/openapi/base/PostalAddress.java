/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.6.x
 */
@Valid
public class PostalAddress implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private String street;

  /**
   * 
   */
  @NotNull
  private String houseNumber;

  /**
   * 
   */
  @NotNull
  private String city;

  /**
   * 
   */
  private int postalCode;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected PostalAddress( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PostalAddress( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    street = pBuilder.street;
    houseNumber = pBuilder.houseNumber;
    city = pBuilder.city;
    postalCode = pBuilder.postalCode;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PostalAddress objects. The method never returns
   * null.
   */
  public static Builder builder( PostalAddress pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class PostalAddress. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private String street;

    /**
     * 
     */
    private String houseNumber;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private int postalCode;

    /**
     * Use {@link PostalAddress#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PostalAddress#builder(PostalAddress)} instead of private constructor to create new builder.
     */
    protected Builder( PostalAddress pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        street = pObject.street;
        houseNumber = pObject.houseNumber;
        city = pObject.city;
        postalCode = pObject.postalCode;
      }
    }

    /**
     * Method sets the attribute "street".
     * 
     * @param pStreet Value to which the attribute "street" should be set.
     */
    public Builder setStreet( String pStreet ) {
      // Assign value to attribute
      street = pStreet;
      return this;
    }

    /**
     * Method sets the attribute "houseNumber".
     * 
     * @param pHouseNumber Value to which the attribute "houseNumber" should be set.
     */
    public Builder setHouseNumber( String pHouseNumber ) {
      // Assign value to attribute
      houseNumber = pHouseNumber;
      return this;
    }

    /**
     * Method sets the attribute "city".
     * 
     * @param pCity Value to which the attribute "city" should be set.
     */
    public Builder setCity( String pCity ) {
      // Assign value to attribute
      city = pCity;
      return this;
    }

    /**
     * Method sets the attribute "postalCode".
     * 
     * @param pPostalCode Value to which the attribute "postalCode" should be set.
     */
    public Builder setPostalCode( int pPostalCode ) {
      // Assign value to attribute
      postalCode = pPostalCode;
      return this;
    }

    /**
     * Method creates a new instance of class PostalAddress. The object will be initialized with the values of the
     * builder.
     * 
     * @return PostalAddress Created object. The method never returns null.
     */
    public PostalAddress build( ) {
      return new PostalAddress(this);
    }

    /**
     * Method creates a new validated instance of class PostalAddress. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return PostalAddress Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PostalAddress buildValidated( ) throws ConstraintViolationException {
      PostalAddress lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "street".
   * 
   * 
   * @return String Value to which the attribute "street" is set.
   */
  public String getStreet( ) {
    return street;
  }

  /**
   * Method sets the attribute "street".
   * 
   * 
   * @param pStreet Value to which the attribute "street" should be set.
   */
  public void setStreet( String pStreet ) {
    // Assign value to attribute
    street = pStreet;
  }

  /**
   * Method returns the attribute "houseNumber".
   * 
   * 
   * @return String Value to which the attribute "houseNumber" is set.
   */
  public String getHouseNumber( ) {
    return houseNumber;
  }

  /**
   * Method sets the attribute "houseNumber".
   * 
   * 
   * @param pHouseNumber Value to which the attribute "houseNumber" should be set.
   */
  public void setHouseNumber( String pHouseNumber ) {
    // Assign value to attribute
    houseNumber = pHouseNumber;
  }

  /**
   * Method returns the attribute "city".
   * 
   * 
   * @return String Value to which the attribute "city" is set.
   */
  public String getCity( ) {
    return city;
  }

  /**
   * Method sets the attribute "city".
   * 
   * 
   * @param pCity Value to which the attribute "city" should be set.
   */
  public void setCity( String pCity ) {
    // Assign value to attribute
    city = pCity;
  }

  /**
   * Method returns the attribute "postalCode".
   * 
   * 
   * @return int Value to which the attribute "postalCode" is set.
   */
  public int getPostalCode( ) {
    return postalCode;
  }

  /**
   * Method sets the attribute "postalCode".
   * 
   * 
   * @param pPostalCode Value to which the attribute "postalCode" should be set.
   */
  public void setPostalCode( int pPostalCode ) {
    // Assign value to attribute
    postalCode = pPostalCode;
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
    lBuilder.append("street: ");
    lBuilder.append(street);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("houseNumber: ");
    lBuilder.append(houseNumber);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("city: ");
    lBuilder.append(city);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("postalCode: ");
    lBuilder.append(postalCode);
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