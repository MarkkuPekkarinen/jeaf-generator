/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Company.class, name = "Company"),
  @JsonSubTypes.Type(value = Person.class, name = "Person") })
public class Partner implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "postalAddresses".
   */
  public static final String POSTALADDRESSES = "postalAddresses";

  /**
   * 
   */
  private List<PostalAddress> postalAddresses = new ArrayList<PostalAddress>();

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Partner( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Partner( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.postalAddresses != null) {
      postalAddresses.addAll(pBuilder.postalAddresses);
    }
  }

  /**
   * Class implements builder to create a new instance of class Partner. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<PostalAddress> postalAddresses;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Partner)} instead of private constructor to create new builder.
     */
    protected Builder( Partner pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        postalAddresses = pObject.postalAddresses;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new ImmutablePOJOParent objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new Partner objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Partner pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "postalAddresses".
     * 
     * @param pPostalAddresses Collection with objects to which the association should be set.
     */
    public Builder setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pPostalAddresses != null) {
        postalAddresses = new ArrayList<PostalAddress>(pPostalAddresses);
      }
      else {
        postalAddresses = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Partner. The object will be initialized with the values of the builder.
     * 
     * @return Partner Created object. The method never returns null.
     */
    public Partner build( ) {
      return new Partner(this);
    }

    /**
     * Method creates a new validated instance of class Partner. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Partner Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Partner buildValidated( ) throws ConstraintViolationException {
      Partner lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "postalAddresses".
   * 
   *
   * @return Collection All PostalAddress objects that belong to the association "postalAddresses". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public List<PostalAddress> getPostalAddresses( ) {
    // Return all PostalAddress objects as unmodifiable collection.
    return Collections.unmodifiableList(postalAddresses);
  }

  /**
   * Method sets the association "postalAddresses" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pPostalAddresses Collection with objects to which the association should be set. The parameter must not be
   * null.
   */
  void setPostalAddresses( List<PostalAddress> pPostalAddresses ) {
    // Check of parameter is not required.
    // Remove all objects from association "postalAddresses".
    this.clearPostalAddresses();
    // If the association is null, removing all entries is sufficient.
    if (pPostalAddresses != null) {
      postalAddresses = new ArrayList<PostalAddress>(pPostalAddresses);
    }
  }

  /**
   * Method adds the passed PostalAddress object to the association "postalAddresses".
   * 
   * 
   * @param pPostalAddresses Object that should be added to the association "postalAddresses". The parameter must not be
   * null.
   */
  public void addToPostalAddresses( PostalAddress pPostalAddresses ) {
    // Check parameter "pPostalAddresses" for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Add passed object to collection of associated PostalAddress objects.
    postalAddresses.add(pPostalAddresses);
  }

  /**
   * Method adds all passed objects to the association "postalAddresses".
   * 
   * 
   * @param pPostalAddresses Collection with all objects that should be added to the association "postalAddresses". The
   * parameter must not be null.
   */
  public void addToPostalAddresses( Collection<PostalAddress> pPostalAddresses ) {
    // Check parameter "pPostalAddresses" for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Add all passed objects.
    for (PostalAddress lNextObject : pPostalAddresses) {
      this.addToPostalAddresses(lNextObject);
    }
  }

  /**
   * Method removes the passed PostalAddress object from the association "postalAddresses".
   * 
   * 
   * @param pPostalAddresses Object that should be removed from the association "postalAddresses". The parameter must
   * not be null.
   */
  public void removeFromPostalAddresses( PostalAddress pPostalAddresses ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pPostalAddresses, "pPostalAddresses");
    // Remove passed object from collection of associated PostalAddress objects.
    postalAddresses.remove(pPostalAddresses);
  }

  /**
   * Method removes all objects from the association "postalAddresses".
   * 
   */
  public void clearPostalAddresses( ) {
    // Remove all objects from association "postalAddresses".
    Collection<PostalAddress> lPostalAddresses = new HashSet<PostalAddress>(postalAddresses);
    Iterator<PostalAddress> lIterator = lPostalAddresses.iterator();
    while (lIterator.hasNext()) {
      this.removeFromPostalAddresses(lIterator.next());
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
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
    return this.toStringBuilder().toString();
  }
}