/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.openapi.base;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.Tools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class EnumTest implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "property".
   */
  public static final String PROPERTY = "property";

  /**
   * Constant for the name of attribute "enumRef".
   */
  public static final String ENUMREF = "enumRef";

  /**
   * <br/>
   * <b>Default Value:</b> <code>GREEN</code>
   */
  private ExtensibleEnum property;

  /**
   * 
   */
  private ExtensibleEnum enumRef;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected EnumTest( ) {
    // Nothing to do.
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected EnumTest( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    property = pBuilder.property;
    enumRef = pBuilder.enumRef;
  }

  /**
   * Class implements builder to create a new instance of class EnumTest. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ExtensibleEnum property = ExtensibleEnum.GREEN;

    /**
     * 
     */
    private ExtensibleEnum enumRef;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(EnumTest)} instead of private constructor to create new builder.
     */
    protected Builder( EnumTest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        property = pObject.property;
        enumRef = pObject.enumRef;
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
     * @return {@link Builder} New builder that can be used to create new EnumTest objects. The method never returns
     * null.
     */
    public static Builder newBuilder( EnumTest pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "property".
     * 
     * @param pProperty Value to which the attribute "property" should be set.
     */
    public Builder setProperty( ExtensibleEnum pProperty ) {
      // Assign value to attribute
      property = pProperty;
      return this;
    }

    /**
     * Method sets the association "enumRef".
     * 
     * @param pEnumRef ExtensibleEnum to which the association "enumRef" should be set.
     */
    public Builder setEnumRef( ExtensibleEnum pEnumRef ) {
      enumRef = pEnumRef;
      return this;
    }

    /**
     * Method creates a new instance of class EnumTest. The object will be initialized with the values of the builder.
     * 
     * @return EnumTest Created object. The method never returns null.
     */
    public EnumTest build( ) {
      return new EnumTest(this);
    }

    /**
     * Method creates a new validated instance of class EnumTest. The object will be initialized with the values of the
     * builder and validated afterwards.
     * 
     * @return EnumTest Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public EnumTest buildValidated( ) throws ConstraintViolationException {
      EnumTest lPOJO = this.build();
      Tools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "property".
   * 
   * 
   * @return ExtensibleEnum Value to which the attribute "property" is set.
   */
  public ExtensibleEnum getProperty( ) {
    return property;
  }

  /**
   * Method sets the attribute "property".
   * 
   * 
   * @param pProperty Value to which the attribute "property" should be set.
   */
  public void setProperty( ExtensibleEnum pProperty ) {
    // Assign value to attribute
    property = pProperty;
  }

  /**
   * Method returns the association "enumRef".
   * 
   *
   * @return ExtensibleEnum ExtensibleEnum to which the association "enumRef" is set.
   */
  public ExtensibleEnum getEnumRef( ) {
    return enumRef;
  }

  /**
   * Method sets the association "enumRef".
   * 
   * 
   * @param pEnumRef ExtensibleEnum to which the association "enumRef" should be set.
   */
  public void setEnumRef( ExtensibleEnum pEnumRef ) {
    enumRef = pEnumRef;
  }

  /**
   * Method unsets the association "enumRef".
   * 
   */
  public final void unsetEnumRef( ) {
    enumRef = null;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. the returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  protected StringBuilder toStringBuilder( ) {
    StringBuilder lBuilder = new StringBuilder(256);
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_INFO, this.getClass().getName()));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTES_SECTION));
    lBuilder.append('\n');
    lBuilder.append(XFun.getMessageRepository().getMessage(XFunMessages.OBJECT_ATTRIBUTE, "property", "" + property));
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