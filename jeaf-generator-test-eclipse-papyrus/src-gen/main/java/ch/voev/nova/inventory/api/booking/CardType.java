package ch.voev.nova.inventory.api.booking;

import com.anaptecs.jeaf.xfun.api.checks.Check;

/**
 * 
 */
public final class CardType {
  public static enum CardTypeType {
    /**
     * 
     */
    REDUCTION_CARD,
    /**
     * 
     */
    LOYALTY_CARD,
    /**
     * 
     */
    CHIP_CARD,
    /**
     * 
     */
    PASS,
    /**
     * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
     * interface.
     */
    UNKNOWN;
  }

  /**
   * 
   */
  public static final CardType REDUCTION_CARD = new CardType(CardTypeType.REDUCTION_CARD);

  /**
   * 
   */
  public static final CardType LOYALTY_CARD = new CardType(CardTypeType.LOYALTY_CARD);

  /**
   * 
   */
  public static final CardType CHIP_CARD = new CardType(CardTypeType.CHIP_CARD);

  /**
   * 
   */
  public static final CardType PASS = new CardType(CardTypeType.PASS);

  /**
   * Literal of the enumeration that is represented by this instance.
   */
  private CardTypeType literal;

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
  public static CardType valueOf( String pLiteralName ) {
    CardType lEnum;
    try {
      CardTypeType lEnumValue = Enum.valueOf(CardTypeType.class, pLiteralName);
      switch (lEnumValue) {
        case REDUCTION_CARD:
          lEnum = REDUCTION_CARD;
          break;
        case LOYALTY_CARD:
          lEnum = LOYALTY_CARD;
          break;
        case CHIP_CARD:
          lEnum = CHIP_CARD;
          break;
        case PASS:
          lEnum = PASS;
          break;
        default:
          lEnum = new CardType(lEnumValue);
      }
    }
    catch (IllegalArgumentException e) {
      lEnum = new CardType(pLiteralName);
    }
    return lEnum;
  }

  /**
   * Initialize object from real enumeration literal
   * 
   * @param pLiteral Enumeration literal that should be used to initialize the extensible enumeration. The parameter
   * must not be null.
   */
  public CardType( CardTypeType pLiteral ) {
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
   * @see CardType#isUnknownLiteral()
   */
  public CardType( String pLiteralName ) {
    try {
      literal = Enum.valueOf(CardTypeType.class, pLiteralName);
      unknownLiteralName = null;
    }
    // Literal is unknown
    catch (IllegalArgumentException e) {
      literal = CardTypeType.UNKNOWN;
      unknownLiteralName = pLiteralName;
    }
  }

  /**
   * Method returns the literal that is represented by this object.
   * 
   * @return {@link CardType} Literal that is represented by this object. The method never returns null.
   */
  public CardTypeType getLiteral( ) {
    return literal;
  }

  /**
   * Method checks if the represented literal is actually unknown or not.
   * 
   * @return boolean Method returns true if this object represents an unknown literal.
   */
  public boolean isUnknownLiteral( ) {
    return literal == CardTypeType.UNKNOWN;
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
        CardType lEnum = (CardType) pObject;
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