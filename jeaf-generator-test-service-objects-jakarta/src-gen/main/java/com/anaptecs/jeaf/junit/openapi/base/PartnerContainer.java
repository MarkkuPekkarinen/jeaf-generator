/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.checks.Check;

public class PartnerContainer implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "partners".
   */
  public static final String PARTNERS = "partners";

  private List<Partner> partners;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected PartnerContainer( ) {
    partners = new ArrayList<Partner>();
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected PartnerContainer( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.partners != null) {
      partners = pBuilder.partners;
    }
    else {
      partners = new ArrayList<Partner>();
    }
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new PartnerContainer objects. The method never
   * returns null.
   */
  public static Builder builder( PartnerContainer pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>PartnerContainer</code>.
   */
  public static class Builder {
    private List<Partner> partners;

    /**
     * Use {@link PartnerContainer#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link PartnerContainer#builder(PartnerContainer)} instead of private constructor to create new builder.
     */
    protected Builder( PartnerContainer pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        partners = pObject.partners;
      }
    }

    /**
     * Method sets association {@link #partners}.<br/>
     *
     * @param pPartners Collection to which {@link #partners} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setPartners( List<Partner> pPartners ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPartners != null) {
        partners = new ArrayList<Partner>(pPartners);
      }
      else {
        partners = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class PartnerContainer. The object will be initialized with the values of the
     * builder.
     *
     * @return PartnerContainer Created object. The method never returns null.
     */
    public PartnerContainer build( ) {
      PartnerContainer lObject = new PartnerContainer(this);
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }

    /**
     * Method creates a new validated instance of class PartnerContainer. The object will be initialized with the values
     * of the builder and validated afterwards.
     *
     * @return PartnerContainer Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public PartnerContainer buildValidated( ) throws ConstraintViolationException {
      PartnerContainer lObject = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lObject);
      return lObject;
    }
  }

  /**
   * Method returns association {@link #partners}.<br/>
   *
   * @return {@link List<Partner>} Value to which {@link #partners} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Partner> getPartners( ) {
    // Return all Partner objects as unmodifiable collection.
    return Collections.unmodifiableList(partners);
  }

  /**
   * Method adds the passed object to {@link #partners}.
   *
   * @param pPartners Object that should be added to {@link #partners}. The parameter must not be null.
   */
  public void addToPartners( Partner pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add passed object to collection of associated Partner objects.
    partners.add(pPartners);
  }

  /**
   * Method adds all passed objects to {@link #partners}.
   *
   * @param pPartners Collection with all objects that should be added to {@link #partners}. The parameter must not be
   * null.
   */
  public void addToPartners( Collection<Partner> pPartners ) {
    // Check parameter "pPartners" for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Add all passed objects.
    for (Partner lNextObject : pPartners) {
      this.addToPartners(lNextObject);
    }
  }

  /**
   * Method removes the passed object from {@link #partners}.<br/>
   *
   * @param pPartners Object that should be removed from {@link #partners}. The parameter must not be null.
   */
  public void removeFromPartners( Partner pPartners ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPartners, "pPartners");
    // Remove passed object from collection of associated Partner objects.
    partners.remove(pPartners);
  }

  /**
   * Method removes all objects from {@link #partners}.
   */
  public void clearPartners( ) {
    // Remove all objects from association "partners".
    partners.clear();
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