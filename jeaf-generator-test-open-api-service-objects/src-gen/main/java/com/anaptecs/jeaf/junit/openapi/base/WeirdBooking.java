/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2021. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class WeirdBooking implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  @NotNull
  private ComplexBookingID booking;

  /**
   * 
   */
  private List<ComplexBookingID> additionalBookings;

  /**
   * 
   */
  @NotNull
  private VersionedObjectSoftLink versionedObjectSoftLink;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected WeirdBooking( ) {
    additionalBookings = new ArrayList<ComplexBookingID>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected WeirdBooking( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    booking = pBuilder.booking;
    if (pBuilder.additionalBookings != null) {
      additionalBookings = pBuilder.additionalBookings;
    }
    else {
      additionalBookings = new ArrayList<ComplexBookingID>();
    }
    versionedObjectSoftLink = pBuilder.versionedObjectSoftLink;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new WeirdBooking objects. The method never returns
   * null.
   */
  public static Builder builder( WeirdBooking pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class WeirdBooking. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ComplexBookingID booking;

    /**
     * 
     */
    private List<ComplexBookingID> additionalBookings;

    /**
     * 
     */
    private VersionedObjectSoftLink versionedObjectSoftLink;

    /**
     * Use {@link WeirdBooking#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link WeirdBooking#builder(WeirdBooking)} instead of private constructor to create new builder.
     */
    protected Builder( WeirdBooking pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        booking = pObject.booking;
        additionalBookings = pObject.additionalBookings;
        versionedObjectSoftLink = pObject.versionedObjectSoftLink;
      }
    }

    /**
     * Method sets the association "booking".
     * 
     * @param pBooking ComplexBookingID to which the association "booking" should be set.
     */
    public Builder setBooking( ComplexBookingID pBooking ) {
      booking = pBooking;
      return this;
    }

    /**
     * Method sets the association "additionalBookings".
     * 
     * @param pAdditionalBookings Collection with objects to which the association should be set.
     */
    public Builder setAdditionalBookings( List<ComplexBookingID> pAdditionalBookings ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pAdditionalBookings != null) {
        additionalBookings = new ArrayList<ComplexBookingID>(pAdditionalBookings);
      }
      else {
        additionalBookings = null;
      }
      return this;
    }

    /**
     * Method sets the association "versionedObjectSoftLink".
     * 
     * @param pVersionedObjectSoftLink VersionedObjectSoftLink to which the association "versionedObjectSoftLink" should
     * be set.
     */
    public Builder setVersionedObjectSoftLink( VersionedObjectSoftLink pVersionedObjectSoftLink ) {
      versionedObjectSoftLink = pVersionedObjectSoftLink;
      return this;
    }

    /**
     * Method creates a new instance of class WeirdBooking. The object will be initialized with the values of the
     * builder.
     * 
     * @return WeirdBooking Created object. The method never returns null.
     */
    public WeirdBooking build( ) {
      return new WeirdBooking(this);
    }

    /**
     * Method creates a new validated instance of class WeirdBooking. The object will be initialized with the values of
     * the builder and validated afterwards.
     * 
     * @return WeirdBooking Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public WeirdBooking buildValidated( ) throws ConstraintViolationException {
      WeirdBooking lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "booking".
   * 
   *
   * @return ComplexBookingID ComplexBookingID to which the association "booking" is set.
   */
  public ComplexBookingID getBooking( ) {
    return booking;
  }

  /**
   * Method sets the association "booking".
   * 
   * 
   * @param pBooking ComplexBookingID to which the association "booking" should be set.
   */
  public void setBooking( ComplexBookingID pBooking ) {
    booking = pBooking;
  }

  /**
   * Method unsets the association "booking".
   * 
   */
  public final void unsetBooking( ) {
    booking = null;
  }

  /**
   * Method returns the association "additionalBookings".
   * 
   *
   * @return Collection All ComplexBookingID objects that belong to the association "additionalBookings". The method
   * never returns null and the returned collection is modifiable.
   */
  public List<ComplexBookingID> getAdditionalBookings( ) {
    // Return all ComplexBookingID objects directly without any protection against modification.
    return additionalBookings;
  }

  /**
   * Method adds the passed ComplexBookingID object to the association "additionalBookings".
   * 
   * 
   * @param pAdditionalBookings Object that should be added to the association "additionalBookings". The parameter must
   * not be null.
   */
  public void addToAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Add passed object to collection of associated ComplexBookingID objects.
    additionalBookings.add(pAdditionalBookings);
  }

  /**
   * Method adds all passed objects to the association "additionalBookings".
   * 
   * 
   * @param pAdditionalBookings Collection with all objects that should be added to the association
   * "additionalBookings". The parameter must not be null.
   */
  public void addToAdditionalBookings( Collection<ComplexBookingID> pAdditionalBookings ) {
    // Check parameter "pAdditionalBookings" for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Add all passed objects.
    for (ComplexBookingID lNextObject : pAdditionalBookings) {
      this.addToAdditionalBookings(lNextObject);
    }
  }

  /**
   * Method removes the passed ComplexBookingID object from the association "additionalBookings".
   * 
   * 
   * @param pAdditionalBookings Object that should be removed from the association "additionalBookings". The parameter
   * must not be null.
   */
  public void removeFromAdditionalBookings( ComplexBookingID pAdditionalBookings ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pAdditionalBookings, "pAdditionalBookings");
    // Remove passed object from collection of associated ComplexBookingID objects.
    additionalBookings.remove(pAdditionalBookings);
  }

  /**
   * Method removes all objects from the association "additionalBookings".
   * 
   */
  public void clearAdditionalBookings( ) {
    // Remove all objects from association "additionalBookings".
    additionalBookings.clear();
  }

  /**
   * Method returns the association "versionedObjectSoftLink".
   * 
   *
   * @return VersionedObjectSoftLink VersionedObjectSoftLink to which the association "versionedObjectSoftLink" is set.
   */
  public VersionedObjectSoftLink getVersionedObjectSoftLink( ) {
    return versionedObjectSoftLink;
  }

  /**
   * Method sets the association "versionedObjectSoftLink".
   * 
   * 
   * @param pVersionedObjectSoftLink VersionedObjectSoftLink to which the association "versionedObjectSoftLink" should
   * be set.
   */
  public void setVersionedObjectSoftLink( VersionedObjectSoftLink pVersionedObjectSoftLink ) {
    versionedObjectSoftLink = pVersionedObjectSoftLink;
  }

  /**
   * Method unsets the association "versionedObjectSoftLink".
   * 
   */
  public final void unsetVersionedObjectSoftLink( ) {
    versionedObjectSoftLink = null;
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
    lBuilder.append("booking: ");
    if (booking != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(booking.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("additionalBookings: ");
    if (additionalBookings != null) {
      lBuilder.append(additionalBookings.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (additionalBookings != null) {
      for (ComplexBookingID lNext : additionalBookings) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("versionedObjectSoftLink: ");
    if (versionedObjectSoftLink != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(versionedObjectSoftLink.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
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