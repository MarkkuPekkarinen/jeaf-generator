/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 *
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.List;
import java.util.Objects;

public class POI extends Stop {
  /**
   * Constant for the name of attribute "description".
   */
  public static final String DESCRIPTION = "description";

  private String description;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  protected POI( ) {
  }

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected POI( Builder pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    description = pBuilder.description;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new POI objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   *
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new POI objects. The method never returns null.
   */
  public static Builder builder( POI pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class <code>POI</code>.
   */
  public static class Builder extends Stop.Builder {
    private String description;

    /**
     * Use {@link POI#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
      super();
    }

    /**
     * Use {@link POI#builder(POI)} instead of private constructor to create new builder.
     */
    protected Builder( POI pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        description = pObject.description;
      }
    }

    /**
     * Method sets attribute {@link #name}.<br/>
     *
     * @param pName Value to which {@link #name} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setName( String pName ) {
      // Call super class implementation.
      super.setName(pName);
      return this;
    }

    /**
     * Method sets association {@link #links}.<br/>
     *
     * @param pLinks Collection to which {@link #links} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @Override
    public Builder setLinks( List<LinkObject> pLinks ) {
      // Call super class implementation.
      super.setLinks(pLinks);
      return this;
    }

    /**
     * Method sets attribute {@link #description}.<br/>
     *
     * @param pDescription Value to which {@link #description} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    public Builder setDescription( String pDescription ) {
      // Assign value to attribute
      description = pDescription;
      return this;
    }

    /**
     * Method creates a new instance of class POI. The object will be initialized with the values of the builder.
     *
     * @return POI Created object. The method never returns null.
     */
    public POI build( ) {
      return new POI(this);
    }
  }

  /**
   * Method returns attribute {@link #description}.<br/>
   *
   * @return {@link String} Value to which {@link #description} is set.
   */
  public String getDescription( ) {
    return description;
  }

  /**
   * Method sets attribute {@link #description}.<br/>
   *
   * @param pDescription Value to which {@link #description} should be set.
   */
  public void setDescription( String pDescription ) {
    // Assign value to attribute
    description = pDescription;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + Objects.hashCode(description);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      POI lOther = (POI) pObject;
      lEquals = Objects.equals(description, lOther.description);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("description: ");
    lBuilder.append(description);
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