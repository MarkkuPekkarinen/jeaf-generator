/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package ch.voev.nova.inventory.api.masterdata;

import java.time.OffsetDateTime;
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

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Vehicle {
  /**
   * Constant for the name of attribute "validities".
   */
  public static final String VALIDITIES = "validities";

  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "lastModified".
   */
  public static final String LASTMODIFIED = "lastModified";

  /**
   * Constant for the name of attribute "vehicleNumber".
   */
  public static final String VEHICLENUMBER = "vehicleNumber";

  /**
   * Constant for the name of attribute "operatorRef".
   */
  public static final String OPERATORREF = "operatorRef";

  /**
   * 
   */
  private List<TemporalValidity> validities = new ArrayList<TemporalValidity>();

  /**
   * 
   */
  private String id;

  /**
   * 
   */
  private OffsetDateTime lastModified;

  /**
   * <br/>
   * <b>Example:</b> <code>565</code>
   */
  private int vehicleNumber;

  /**
   * <br/>
   * <b>Example:</b> <code>urn:sbb:1185:11</code>
   */
  private String operatorRef;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Vehicle( ) {
    validities = null;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Vehicle( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.validities != null) {
      validities.addAll(pBuilder.validities);
    }
    id = pBuilder.id;
    lastModified = pBuilder.lastModified;
    vehicleNumber = pBuilder.vehicleNumber;
    operatorRef = pBuilder.operatorRef;
  }

  /**
   * Class implements builder to create a new instance of class Vehicle. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private List<TemporalValidity> validities;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private OffsetDateTime lastModified;

    /**
     * 
     */
    private int vehicleNumber;

    /**
     * 
     */
    private String operatorRef;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Vehicle)} instead of private constructor to create new builder.
     */
    protected Builder( Vehicle pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        validities = pObject.validities;
        id = pObject.id;
        lastModified = pObject.lastModified;
        vehicleNumber = pObject.vehicleNumber;
        operatorRef = pObject.operatorRef;
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
     * @return {@link Builder} New builder that can be used to create new Vehicle objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Vehicle pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "validities".
     * 
     * @param pValidities Collection with objects to which the association should be set.
     */
    public Builder setValidities( List<TemporalValidity> pValidities ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pValidities != null) {
        validities = new ArrayList<TemporalValidity>(pValidities);
      }
      else {
        validities = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "id".
     * 
     * @param pId Value to which the attribute "id" should be set.
     */
    public Builder setId( String pId ) {
      // Assign value to attribute
      id = pId;
      return this;
    }

    /**
     * Method sets the attribute "lastModified".
     * 
     * @param pLastModified Value to which the attribute "lastModified" should be set.
     */
    public Builder setLastModified( OffsetDateTime pLastModified ) {
      // Assign value to attribute
      lastModified = pLastModified;
      return this;
    }

    /**
     * Method sets the attribute "vehicleNumber".
     * 
     * @param pVehicleNumber Value to which the attribute "vehicleNumber" should be set.
     */
    public Builder setVehicleNumber( int pVehicleNumber ) {
      // Assign value to attribute
      vehicleNumber = pVehicleNumber;
      return this;
    }

    /**
     * Method sets the attribute "operatorRef".
     * 
     * @param pOperatorRef Value to which the attribute "operatorRef" should be set.
     */
    public Builder setOperatorRef( String pOperatorRef ) {
      // Assign value to attribute
      operatorRef = pOperatorRef;
      return this;
    }

    /**
     * Method creates a new instance of class Vehicle. The object will be initialized with the values of the builder.
     * 
     * @return Vehicle Created object. The method never returns null.
     */
    public Vehicle build( ) {
      return new Vehicle(this);
    }

    /**
     * Method creates a new validated instance of class Vehicle. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return Vehicle Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public Vehicle buildValidated( ) throws ConstraintViolationException {
      Vehicle lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "validities".
   * 
   *
   * @return Collection All TemporalValidity objects that belong to the association "validities". The method never
   * returns null and the returned collection is unmodifiable.
   */
  public List<TemporalValidity> getValidities( ) {
    // Return all TemporalValidity objects as unmodifiable collection.
    return Collections.unmodifiableList(validities);
  }

  /**
   * Method sets the association "validities" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pValidities Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setValidities( List<TemporalValidity> pValidities ) {
    // Check of parameter is not required.
    // Remove all objects from association "validities".
    this.clearValidities();
    // If the association is null, removing all entries is sufficient.
    if (pValidities != null) {
      validities = new ArrayList<TemporalValidity>(pValidities);
    }
  }

  /**
   * Method adds the passed TemporalValidity object to the association "validities".
   * 
   * 
   * @param pValidities Object that should be added to the association "validities". The parameter must not be null.
   */
  public void addToValidities( TemporalValidity pValidities ) {
    // Check parameter "pValidities" for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Add passed object to collection of associated TemporalValidity objects.
    validities.add(pValidities);
  }

  /**
   * Method adds all passed objects to the association "validities".
   * 
   * 
   * @param pValidities Collection with all objects that should be added to the association "validities". The parameter
   * must not be null.
   */
  public void addToValidities( Collection<TemporalValidity> pValidities ) {
    // Check parameter "pValidities" for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Add all passed objects.
    for (TemporalValidity lNextObject : pValidities) {
      this.addToValidities(lNextObject);
    }
  }

  /**
   * Method removes the passed TemporalValidity object from the association "validities".
   * 
   * 
   * @param pValidities Object that should be removed from the association "validities". The parameter must not be null.
   */
  public void removeFromValidities( TemporalValidity pValidities ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pValidities, "pValidities");
    // Remove passed object from collection of associated TemporalValidity objects.
    validities.remove(pValidities);
  }

  /**
   * Method removes all objects from the association "validities".
   * 
   */
  public void clearValidities( ) {
    // Remove all objects from association "validities".
    Collection<TemporalValidity> lValidities = new HashSet<TemporalValidity>(validities);
    Iterator<TemporalValidity> lIterator = lValidities.iterator();
    while (lIterator.hasNext()) {
      this.removeFromValidities(lIterator.next());
    }
  }

  /**
   * Method returns the attribute "id".
   * 
   * 
   * @return String Value to which the attribute "id" is set.
   */
  public String getId( ) {
    return id;
  }

  /**
   * Method sets the attribute "id".
   * 
   * 
   * @param pId Value to which the attribute "id" should be set.
   */
  public void setId( String pId ) {
    // Assign value to attribute
    id = pId;
  }

  /**
   * Method returns the attribute "lastModified".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "lastModified" is set.
   */
  public OffsetDateTime getLastModified( ) {
    return lastModified;
  }

  /**
   * Method sets the attribute "lastModified".
   * 
   * 
   * @param pLastModified Value to which the attribute "lastModified" should be set.
   */
  public void setLastModified( OffsetDateTime pLastModified ) {
    // Assign value to attribute
    lastModified = pLastModified;
  }

  /**
   * Method returns the attribute "vehicleNumber".
   * 
   * 
   * @return int Value to which the attribute "vehicleNumber" is set.
   */
  public int getVehicleNumber( ) {
    return vehicleNumber;
  }

  /**
   * Method sets the attribute "vehicleNumber".
   * 
   * 
   * @param pVehicleNumber Value to which the attribute "vehicleNumber" should be set.
   */
  public void setVehicleNumber( int pVehicleNumber ) {
    // Assign value to attribute
    vehicleNumber = pVehicleNumber;
  }

  /**
   * Method returns the attribute "operatorRef".
   * 
   * 
   * @return String Value to which the attribute "operatorRef" is set.
   */
  public String getOperatorRef( ) {
    return operatorRef;
  }

  /**
   * Method sets the attribute "operatorRef".
   * 
   * 
   * @param pOperatorRef Value to which the attribute "operatorRef" should be set.
   */
  public void setOperatorRef( String pOperatorRef ) {
    // Assign value to attribute
    operatorRef = pOperatorRef;
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
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "id", "" + id));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "lastModified", "" + lastModified));
    lBuilder.append('\n');
    lBuilder.append(
        XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "vehicleNumber", "" + vehicleNumber));
    lBuilder.append('\n');
    lBuilder
        .append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "operatorRef", "" + operatorRef));
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