package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public final class PRMNeedType {
  public static enum PRMNeedTypeType {
    /**
     * 
     */
    NEED_PRM_SUPPORT,
    /**
     * 
     */
    WHEELCHAIR,
    /**
     * 
     */
    ACCOMPANYING_DOG,
    /**
     * 
     */
    COMPANION_SEAT,
    /**
     * 
     */
    COMPANION,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final PRMNeedType NEED_PRM_SUPPORT = new PRMNeedType(PRMNeedTypeType.NEED_PRM_SUPPORT);

  /**
   * 
   */
  public static final PRMNeedType WHEELCHAIR = new PRMNeedType(PRMNeedTypeType.WHEELCHAIR);

  /**
   * 
   */
  public static final PRMNeedType ACCOMPANYING_DOG = new PRMNeedType(PRMNeedTypeType.ACCOMPANYING_DOG);

  /**
   * 
   */
  public static final PRMNeedType COMPANION_SEAT = new PRMNeedType(PRMNeedTypeType.COMPANION_SEAT);

  /**
   * 
   */
  public static final PRMNeedType COMPANION = new PRMNeedType(PRMNeedTypeType.COMPANION);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private PRMNeedTypeType literal;

  /**
   * In case that the literal is unknown then also it's actual name is still available as
   * <code>unknownLiteralName</code>
   */
  private String unknownLiteralName;

  /**
   * Method returns extensible enumeration based on the passed name. If the literal name is unknown then an instance
   * representing "unknown" will be returned.
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   * @return
   */
  public static PRMNeedType valueOf( String pLiteralName ) {
    PRMNeedType lEnum;
    try {
      PRMNeedTypeType lEnumValue = Enum.valueOf(PRMNeedTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case NEED_PRM_SUPPORT:
          lEnum = NEED_PRM_SUPPORT;
          break;
        case WHEELCHAIR:
          lEnum = WHEELCHAIR;
          break;
        case ACCOMPANYING_DOG:
          lEnum = ACCOMPANYING_DOG;
          break;
        case COMPANION_SEAT:
          lEnum = COMPANION_SEAT;
          break;
        case COMPANION:
          lEnum = COMPANION;
          break;
        default:
          lEnum = new PRMNeedType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new PRMNeedType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public PRMNeedType( PRMNeedTypeType pLiteral ) {
    Check.checkInvalidParameterNull(pLiteral, "pLiteral");
    literal = pLiteral;
    unknownLiteralName = null;
  }

  /**
   * Initialize object using the name of the literal.
   * 
   * @param pLiteralName Literal name that should be used to initialize the extensible enumeration. If the parameter is
   * null or has an unknown literal name then a "unknown" version will be created.
   * 
   * @see PRMNeedType#isUnknownLiteral()
   */
  public PRMNeedType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(PRMNeedTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = PRMNeedTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link PRMNeedType} Literal that is represented by this object. The method never returns null.
   */
  public PRMNeedTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == PRMNeedTypeType.UNKNOWN;
  }

  /**
   * Method returns the actual name of the unknown literal
   * 
   * @return {@link String} Name of the unknown literal or null in case that the literal is known.
   */
  public String getUnknownLiteralName( ) {
    return unknownLiteralName;
  }

  /**
   * {@link Object#hashCode()}
   */
  @Override
  public int hashCode( ) {
    int lHashCode;
    if (this.isUnknownLiteral() == true) {
      lHashCode = unknownLiteralName.hashCode();
    }
    else {
      lHashCode = literal.hashCode();
    }
    return lHashCode;
  }

  /**
   * {@link Object#equals(Object)}
   */
  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (pObject != null) {
      if (this == pObject) {
        lEquals = true;
      }
      // Passed object is of same type
      else if (this.getClass() == pObject.getClass()) {
        PRMNeedType lEnum = (PRMNeedType) pObject;
        // Compare if unknown literal is the same
        if (this.isUnknownLiteral() && lEnum.isUnknownLiteral()) {
          if (this.unknownLiteralName != null) {
            lEquals = this.unknownLiteralName.equals(lEnum.unknownLiteralName);
          }
          else if (lEnum.unknownLiteralName == null) {
            lEquals = true;
          }
          else {
            lEquals = false;
          }
        }
        // Compare based on literals
        else {
          lEquals = this.literal == lEnum.literal;
        }
      }
      // Passed object is of different type
      else {
        lEquals = false;
      }
    }
    // Passed object is null.
    else {
      lEquals = false;
    }
    return lEquals;
  }
}