/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.jeaf.junit.core;

import javax.validation.ConstraintViolationException;

import com.anaptecs.jeaf.core.api.ServiceObject;
import com.anaptecs.jeaf.tools.api.validation.ValidationTools;
import com.anaptecs.jeaf.xfun.api.XFun;
import com.anaptecs.jeaf.xfun.api.XFunMessages;
import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class ComplexArrayServiceObject implements ServiceObject {
  /**
   * Default serial version uid.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constant for the name of attribute "classBs".
   */
  public static final String CLASSBS = "classBs";

  /**
   * 
   */
  private ClassB[] classBs;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected ComplexArrayServiceObject( ) {
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected ComplexArrayServiceObject( Builder pBuilder ) {
    // Ensure that builder is not null.
    Check.checkInvalidParameterNull(pBuilder, "pBuilder");
    // Read attribute values from builder.
    classBs = pBuilder.classBs;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new ComplexArrayServiceObject objects. The method
   * never returns null.
   */
  public static Builder builder( ComplexArrayServiceObject pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class ComplexArrayServiceObject. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private ClassB[] classBs;

    /**
     * Use {@link ComplexArrayServiceObject#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link ComplexArrayServiceObject#builder(ComplexArrayServiceObject)} instead of private constructor to create
     * new builder.
     */
    protected Builder( ComplexArrayServiceObject pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        classBs = pObject.classBs;
      }
    }

    /**
     * Method sets the attribute "classBs".
     * 
     * @param pClassBs Value to which the attribute "classBs" should be set.
     */
    public Builder setClassBs( ClassB[] pClassBs ) {
      // Assign value to attribute
      if (pClassBs != null) {
        classBs = new ClassB[pClassBs.length];
        System.arraycopy(pClassBs, 0, classBs, 0, pClassBs.length);
      }
      else {
        classBs = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class ComplexArrayServiceObject. The object will be initialized with the values
     * of the builder.
     * 
     * @return ComplexArrayServiceObject Created object. The method never returns null.
     */
    public ComplexArrayServiceObject build( ) {
      return new ComplexArrayServiceObject(this);
    }

    /**
     * Method creates a new validated instance of class ComplexArrayServiceObject. The object will be initialized with
     * the values of the builder and validated afterwards.
     * 
     * @return ComplexArrayServiceObject Created and validated object. The method never returns null.
     * @throws ConstraintViolationException in case that one or more validations for the created object failed.
     */
    public ComplexArrayServiceObject buildValidated( ) throws ConstraintViolationException {
      ComplexArrayServiceObject lPOJO = this.build();
      ValidationTools.getValidationTools().enforceObjectValidation(lPOJO);
      return lPOJO;
    }
  }

  /**
   * Method returns the attribute "classBs".
   * 
   * 
   * @return ClassB Value to which the attribute "classBs" is set.
   */
  public ClassB[] getClassBs( ) {
    ClassB[] lReturnValue;
    if (classBs != null) {
      lReturnValue = new ClassB[classBs.length];
      System.arraycopy(classBs, 0, lReturnValue, 0, classBs.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "classBs".
   * 
   * 
   * @param pClassBs Value to which the attribute "classBs" should be set.
   */
  public void setClassBs( ClassB[] pClassBs ) {
    // Assign value to attribute
    if (pClassBs != null) {
      classBs = new ClassB[pClassBs.length];
      System.arraycopy(pClassBs, 0, classBs, 0, pClassBs.length);
    }
    else {
      classBs = null;
    }
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
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