/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BidirectA implements Serializable {
  /**
   * Default serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "transientBs".
   */
  public static final String TRANSIENTBS = "transientBs";

  /**
   * Constant for the name of attribute "parent".
   */
  public static final String PARENT = "parent";

  /**
   * Constant for the name of attribute "transientChild".
   */
  public static final String TRANSIENTCHILD = "transientChild";

  /**
   * 
   */
  private transient Set<BidirectB> transientBs = new HashSet<BidirectB>();

  /**
   * 
   */
  private BidirectA parent;

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean parentBackReferenceInitialized;

  /**
   * 
   */
  private transient BidirectA transientChild;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected BidirectA( ) {
    // Nothing to do.
    // Bidirectional back reference is not yet set up correctly
    parentBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected BidirectA( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    if (pBuilder.transientBs != null) {
      transientBs.addAll(pBuilder.transientBs);
    }
    parent = pBuilder.parent;
    // Bidirectional back reference is set up correctly as a builder is used.
    parentBackReferenceInitialized = true;
    transientChild = pBuilder.transientChild;
  }

  /**
   * Class implements builder to create a new instance of class BidirectA. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<BidirectB> transientBs;

    /**
     * 
     */
    private BidirectA parent;

    /**
     * 
     */
    private BidirectA transientChild;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(BidirectA)} instead of private constructor to create new builder.
     */
    protected Builder( BidirectA pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        transientBs = pObject.transientBs;
        parent = pObject.parent;
        transientChild = pObject.transientChild;
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
     * @return {@link Builder} New builder that can be used to create new BidirectA objects. The method never returns
     * null.
     */
    public static Builder newBuilder( BidirectA pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "transientBs".
     * 
     * @param pTransientBs Collection with objects to which the association should be set.
     */
    public Builder setTransientBs( Set<BidirectB> pTransientBs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTransientBs != null) {
        transientBs = new HashSet<BidirectB>(pTransientBs);
      }
      else {
        transientBs = null;
      }
      return this;
    }

    /**
     * Method sets the association "parent".
     * 
     * @param pParent BidirectA to which the association "parent" should be set.
     */
    public Builder setParent( BidirectA pParent ) {
      parent = pParent;
      return this;
    }

    /**
     * Method sets the association "transientChild".
     * 
     * @param pTransientChild BidirectA to which the association "transientChild" should be set.
     */
    public Builder setTransientChild( BidirectA pTransientChild ) {
      transientChild = pTransientChild;
      return this;
    }

    /**
     * Method creates a new instance of class BidirectA. The object will be initialized with the values of the builder.
     * 
     * @return BidirectA Created object. The method never returns null.
     */
    public BidirectA build( ) {
      return new BidirectA(this);
    }

    /**
     * Method creates a new validated instance of class BidirectA. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return BidirectA Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public BidirectA buildValidated( ) throws ConstraintViolationException {
      BidirectA lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the association "transientBs".
   * 
   *
   * @return Collection All BidirectB objects that belong to the association "transientBs". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<BidirectB> getTransientBs( ) {
    // Return all BidirectB objects as unmodifiable collection.
    return Collections.unmodifiableSet(transientBs);
  }

  /**
   * Method sets the association "transientBs" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pTransientBs Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setTransientBs( Set<BidirectB> pTransientBs ) {
    // Check of parameter is not required.
    // Remove all objects from association "transientBs".
    this.clearTransientBs();
    // If the association is null, removing all entries is sufficient.
    if (pTransientBs != null) {
      transientBs = new HashSet<BidirectB>(pTransientBs);
    }
  }

  /**
   * Method adds the passed BidirectB object to the association "transientBs".
   * 
   * 
   * @param pTransientBs Object that should be added to the association "transientBs". The parameter must not be null.
   */
  public void addToTransientBs( BidirectB pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Since this is not a many-to-many association the association to which the passed object belongs, has to
    // be released.
    pTransientBs.unsetA();
    // Add passed object to collection of associated BidirectB objects.
    transientBs.add(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientBs != null && this.equals(pTransientBs.getA()) == false) {
      pTransientBs.setA((BidirectA) this);
    }
  }

  /**
   * Method adds all passed objects to the association "transientBs".
   * 
   * 
   * @param pTransientBs Collection with all objects that should be added to the association "transientBs". The
   * parameter must not be null.
   */
  public void addToTransientBs( Collection<BidirectB> pTransientBs ) {
    // Check parameter "pTransientBs" for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Add all passed objects.
    for (BidirectB lNextObject : pTransientBs) {
      this.addToTransientBs(lNextObject);
    }
  }

  /**
   * Method removes the passed BidirectB object from the association "transientBs".
   * 
   * 
   * @param pTransientBs Object that should be removed from the association "transientBs". The parameter must not be
   * null.
   */
  public void removeFromTransientBs( BidirectB pTransientBs ) {
    // Check parameter for invalid value null.
    Check.checkInvalidParameterNull(pTransientBs, "pTransientBs");
    // Remove passed object from collection of associated BidirectB objects.
    transientBs.remove(pTransientBs);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (this.equals(pTransientBs.getA()) == true) {
      pTransientBs.unsetA();
    }
  }

  /**
   * Method removes all objects from the association "transientBs".
   * 
   */
  public void clearTransientBs( ) {
    // Remove all objects from association "transientBs".
    Collection<BidirectB> lTransientBs = new HashSet<BidirectB>(transientBs);
    Iterator<BidirectB> lIterator = lTransientBs.iterator();
    while (lIterator.hasNext()) {
      this.removeFromTransientBs(lIterator.next());
    }
  }

  /**
   * Method returns the association "parent".
   * 
   *
   * @return BidirectA BidirectA to which the association "parent" is set.
   */
  public BidirectA getParent( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (parentBackReferenceInitialized == false) {
      parentBackReferenceInitialized = true;
      parent.setTransientChild((BidirectA) this);
    }
    return parent;
  }

  /**
   * Method sets the association "parent".
   * 
   * 
   * @param pParent BidirectA to which the association "parent" should be set.
   */
  public void setParent( BidirectA pParent ) {
    // Release already referenced object before setting a new association.
    if (parent != null) {
      parent.unsetTransientChild();
    }
    parent = pParent;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pParent != null && this.equals(pParent.getTransientChild()) == false) {
      pParent.setTransientChild((BidirectA) this);
    }
  }

  /**
   * Method unsets the association "parent".
   * 
   */
  public final void unsetParent( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectA lBidirectA = parent;
    parent = null;
    if (lBidirectA != null && this.equals(lBidirectA.getTransientChild()) == true) {
      lBidirectA.unsetTransientChild();
    }
  }

  /**
   * Method returns the association "transientChild".
   * 
   *
   * @return BidirectA BidirectA to which the association "transientChild" is set.
   */
  public BidirectA getTransientChild( ) {
    return transientChild;
  }

  /**
   * Method sets the association "transientChild".
   * 
   * 
   * @param pTransientChild BidirectA to which the association "transientChild" should be set.
   */
  public void setTransientChild( BidirectA pTransientChild ) {
    // Release already referenced object before setting a new association.
    if (transientChild != null) {
      transientChild.unsetParent();
    }
    transientChild = pTransientChild;
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pTransientChild != null && this.equals(pTransientChild.getParent()) == false) {
      pTransientChild.setParent((BidirectA) this);
    }
  }

  /**
   * Method unsets the association "transientChild".
   * 
   */
  public final void unsetTransientChild( ) {
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    BidirectA lBidirectA = transientChild;
    transientChild = null;
    if (lBidirectA != null && this.equals(lBidirectA.getParent()) == true) {
      lBidirectA.unsetParent();
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