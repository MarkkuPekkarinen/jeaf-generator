/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.anaptecs.spring.base.BookingID;
import com.anaptecs.spring.base.DoubleCode;
import com.anaptecs.spring.base.IntegerCodeType;
import com.anaptecs.spring.base.LongCode;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class DataTypesQueryBean {
  /**
   * Constant for the name of attribute "longCodes".
   */
  public static final String LONGCODES = "longCodes";

  /**
   * Constant for the name of attribute "codes".
   */
  public static final String CODES = "codes";

  /**
   * Constant for the name of attribute "doubleCodes".
   */
  public static final String DOUBLECODES = "doubleCodes";

  /**
   * Constant for the name of attribute "bookingIDs".
   */
  public static final String BOOKINGIDS = "bookingIDs";

  /**
   * Constant for the name of attribute "bookingIDsArray".
   */
  public static final String BOOKINGIDSARRAY = "bookingIDsArray";

  /**
   * Constant for the name of attribute "offsetDateTime".
   */
  public static final String OFFSETDATETIME = "offsetDateTime";

  /**
   * Constant for the name of attribute "offsetTime".
   */
  public static final String OFFSETTIME = "offsetTime";

  /**
   * Constant for the name of attribute "localDateTime".
   */
  public static final String LOCALDATETIME = "localDateTime";

  /**
   * Constant for the name of attribute "localTime".
   */
  public static final String LOCALTIME = "localTime";

  /**
   * Constant for the name of attribute "timestamps".
   */
  public static final String TIMESTAMPS = "timestamps";

  /**
   * Constant for the name of attribute "times".
   */
  public static final String TIMES = "times";

  /**
   * Constant for the name of attribute "startTimestamps".
   */
  public static final String STARTTIMESTAMPS = "startTimestamps";

  /**
   * 
   */
  private LongCode[] longCodes;

  /**
   * 
   */
  private IntegerCodeType[] codes;

  /**
   * 
   */
  private Set<DoubleCode> doubleCodes;

  /**
   * 
   */
  private Set<BookingID> bookingIDs;

  /**
   * 
   */
  private BookingID[] bookingIDsArray;

  /**
   * 
   */
  private OffsetDateTime offsetDateTime;

  /**
   * 
   */
  private OffsetTime offsetTime;

  /**
   * 
   */
  private LocalDateTime localDateTime;

  /**
   * 
   */
  private LocalTime localTime;

  /**
   * 
   */
  private List<LocalDateTime> timestamps;

  /**
   * 
   */
  private Set<OffsetTime> times;

  /**
   * 
   */
  private OffsetDateTime[] startTimestamps;

  /**
   * Default constructor is only intended to be used for deserialization by tools like Jackson for JSON. For "normal"
   * object creation builder should be used instead.
   */
  public DataTypesQueryBean( ) {
    doubleCodes = new HashSet<DoubleCode>();
    bookingIDs = new HashSet<BookingID>();
    timestamps = new ArrayList<LocalDateTime>();
    times = new HashSet<OffsetTime>();
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DataTypesQueryBean( Builder pBuilder ) {
    // Read attribute values from builder.
    longCodes = pBuilder.longCodes;
    codes = pBuilder.codes;
    if (pBuilder.doubleCodes != null) {
      doubleCodes = pBuilder.doubleCodes;
    }
    else {
      doubleCodes = new HashSet<DoubleCode>();
    }
    if (pBuilder.bookingIDs != null) {
      bookingIDs = pBuilder.bookingIDs;
    }
    else {
      bookingIDs = new HashSet<BookingID>();
    }
    bookingIDsArray = pBuilder.bookingIDsArray;
    offsetDateTime = pBuilder.offsetDateTime;
    offsetTime = pBuilder.offsetTime;
    localDateTime = pBuilder.localDateTime;
    localTime = pBuilder.localTime;
    if (pBuilder.timestamps != null) {
      timestamps = pBuilder.timestamps;
    }
    else {
      timestamps = new ArrayList<LocalDateTime>();
    }
    if (pBuilder.times != null) {
      times = pBuilder.times;
    }
    else {
      times = new HashSet<OffsetTime>();
    }
    startTimestamps = pBuilder.startTimestamps;
  }

  /**
   * Method returns a new builder.
   * 
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Method creates a new builder and initialize it with the data from the passed object.
   * 
   * @param pObject Object that should be used to initialize the builder. The parameter may be null.
   * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects. The method never
   * returns null.
   */
  public static Builder builder( DataTypesQueryBean pObject ) {
    return new Builder(pObject);
  }

  /**
   * Class implements builder to create a new instance of class DataTypesQueryBean. As the class has read only
   * attributes or associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private LongCode[] longCodes;

    /**
     * 
     */
    private IntegerCodeType[] codes;

    /**
     * 
     */
    private Set<DoubleCode> doubleCodes;

    /**
     * 
     */
    private Set<BookingID> bookingIDs;

    /**
     * 
     */
    private BookingID[] bookingIDsArray;

    /**
     * 
     */
    private OffsetDateTime offsetDateTime;

    /**
     * 
     */
    private OffsetTime offsetTime;

    /**
     * 
     */
    private LocalDateTime localDateTime;

    /**
     * 
     */
    private LocalTime localTime;

    /**
     * 
     */
    private List<LocalDateTime> timestamps;

    /**
     * 
     */
    private Set<OffsetTime> times;

    /**
     * 
     */
    private OffsetDateTime[] startTimestamps;

    /**
     * Use {@link DataTypesQueryBean#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DataTypesQueryBean#builder(DataTypesQueryBean)} instead of private constructor to create new builder.
     */
    protected Builder( DataTypesQueryBean pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        longCodes = pObject.longCodes;
        codes = pObject.codes;
        doubleCodes = pObject.doubleCodes;
        bookingIDs = pObject.bookingIDs;
        bookingIDsArray = pObject.bookingIDsArray;
        offsetDateTime = pObject.offsetDateTime;
        offsetTime = pObject.offsetTime;
        localDateTime = pObject.localDateTime;
        localTime = pObject.localTime;
        timestamps = pObject.timestamps;
        times = pObject.times;
        startTimestamps = pObject.startTimestamps;
      }
    }

    /**
     * Method returns a new builder.
     * 
     * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects.
     */
    public static Builder newBuilder( ) {
      return new Builder();
    }

    /**
     * Method creates a new builder and initialize it with the data from the passed object.
     * 
     * @param pObject Object that should be used to initialize the builder. The parameter may be null.
     * @return {@link Builder} New builder that can be used to create new DataTypesQueryBean objects. The method never
     * returns null.
     */
    public static Builder newBuilder( DataTypesQueryBean pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the attribute "longCodes".
     * 
     * @param pLongCodes Value to which the attribute "longCodes" should be set.
     */
    public Builder setLongCodes( LongCode[] pLongCodes ) {
      // Assign value to attribute
      if (pLongCodes != null) {
        longCodes = new LongCode[pLongCodes.length];
        System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
      }
      else {
        longCodes = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "codes".
     * 
     * @param pCodes Value to which the attribute "codes" should be set.
     */
    public Builder setCodes( IntegerCodeType[] pCodes ) {
      // Assign value to attribute
      if (pCodes != null) {
        codes = new IntegerCodeType[pCodes.length];
        System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
      }
      else {
        codes = null;
      }
      return this;
    }

    /**
     * Method sets the association "doubleCodes".
     * 
     * @param pDoubleCodes Collection with objects to which the association should be set.
     */
    public Builder setDoubleCodes( Set<DoubleCode> pDoubleCodes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pDoubleCodes != null) {
        doubleCodes = new HashSet<DoubleCode>(pDoubleCodes);
      }
      else {
        doubleCodes = null;
      }
      return this;
    }

    /**
     * Method sets the association "bookingIDs".
     * 
     * @param pBookingIDs Collection with objects to which the association should be set.
     */
    public Builder setBookingIDs( Set<BookingID> pBookingIDs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pBookingIDs != null) {
        bookingIDs = new HashSet<BookingID>(pBookingIDs);
      }
      else {
        bookingIDs = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "bookingIDsArray".
     * 
     * @param pBookingIDsArray Value to which the attribute "bookingIDsArray" should be set.
     */
    public Builder setBookingIDsArray( BookingID[] pBookingIDsArray ) {
      // Assign value to attribute
      if (pBookingIDsArray != null) {
        bookingIDsArray = new BookingID[pBookingIDsArray.length];
        System.arraycopy(pBookingIDsArray, 0, bookingIDsArray, 0, pBookingIDsArray.length);
      }
      else {
        bookingIDsArray = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "offsetDateTime".
     * 
     * @param pOffsetDateTime Value to which the attribute "offsetDateTime" should be set.
     */
    public Builder setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
      // Assign value to attribute
      offsetDateTime = pOffsetDateTime;
      return this;
    }

    /**
     * Method sets the association "offsetTime".
     * 
     * @param pOffsetTime OffsetTime to which the association "offsetTime" should be set.
     */
    public Builder setOffsetTime( OffsetTime pOffsetTime ) {
      offsetTime = pOffsetTime;
      return this;
    }

    /**
     * Method sets the attribute "localDateTime".
     * 
     * @param pLocalDateTime Value to which the attribute "localDateTime" should be set.
     */
    public Builder setLocalDateTime( LocalDateTime pLocalDateTime ) {
      // Assign value to attribute
      localDateTime = pLocalDateTime;
      return this;
    }

    /**
     * Method sets the attribute "localTime".
     * 
     * @param pLocalTime Value to which the attribute "localTime" should be set.
     */
    public Builder setLocalTime( LocalTime pLocalTime ) {
      // Assign value to attribute
      localTime = pLocalTime;
      return this;
    }

    /**
     * Method sets the association "timestamps".
     * 
     * @param pTimestamps Collection with objects to which the association should be set.
     */
    public Builder setTimestamps( List<LocalDateTime> pTimestamps ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTimestamps != null) {
        timestamps = new ArrayList<LocalDateTime>(pTimestamps);
      }
      else {
        timestamps = null;
      }
      return this;
    }

    /**
     * Method sets the association "times".
     * 
     * @param pTimes Collection with objects to which the association should be set.
     */
    public Builder setTimes( Set<OffsetTime> pTimes ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTimes != null) {
        times = new HashSet<OffsetTime>(pTimes);
      }
      else {
        times = null;
      }
      return this;
    }

    /**
     * Method sets the attribute "startTimestamps".
     * 
     * @param pStartTimestamps Value to which the attribute "startTimestamps" should be set.
     */
    public Builder setStartTimestamps( OffsetDateTime[] pStartTimestamps ) {
      // Assign value to attribute
      if (pStartTimestamps != null) {
        startTimestamps = new OffsetDateTime[pStartTimestamps.length];
        System.arraycopy(pStartTimestamps, 0, startTimestamps, 0, pStartTimestamps.length);
      }
      else {
        startTimestamps = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class DataTypesQueryBean. The object will be initialized with the values of the
     * builder.
     * 
     * @return DataTypesQueryBean Created object. The method never returns null.
     */
    public DataTypesQueryBean build( ) {
      return new DataTypesQueryBean(this);
    }
  }

  /**
   * Method returns the attribute "longCodes".
   * 
   * 
   * @return LongCode Value to which the attribute "longCodes" is set.
   */
  public LongCode[] getLongCodes( ) {
    LongCode[] lReturnValue;
    if (longCodes != null) {
      lReturnValue = new LongCode[longCodes.length];
      System.arraycopy(longCodes, 0, lReturnValue, 0, longCodes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "longCodes".
   * 
   * 
   * @param pLongCodes Value to which the attribute "longCodes" should be set.
   */
  public void setLongCodes( LongCode[] pLongCodes ) {
    // Assign value to attribute
    if (pLongCodes != null) {
      longCodes = new LongCode[pLongCodes.length];
      System.arraycopy(pLongCodes, 0, longCodes, 0, pLongCodes.length);
    }
    else {
      longCodes = null;
    }
  }

  /**
   * Method returns the attribute "codes".
   * 
   * 
   * @return IntegerCodeType Value to which the attribute "codes" is set.
   */
  public IntegerCodeType[] getCodes( ) {
    IntegerCodeType[] lReturnValue;
    if (codes != null) {
      lReturnValue = new IntegerCodeType[codes.length];
      System.arraycopy(codes, 0, lReturnValue, 0, codes.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "codes".
   * 
   * 
   * @param pCodes Value to which the attribute "codes" should be set.
   */
  public void setCodes( IntegerCodeType[] pCodes ) {
    // Assign value to attribute
    if (pCodes != null) {
      codes = new IntegerCodeType[pCodes.length];
      System.arraycopy(pCodes, 0, codes, 0, pCodes.length);
    }
    else {
      codes = null;
    }
  }

  /**
   * Method returns the association "doubleCodes".
   * 
   *
   * @return Collection All DoubleCode objects that belong to the association "doubleCodes". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public Set<DoubleCode> getDoubleCodes( ) {
    // Return all DoubleCode objects as unmodifiable collection.
    return Collections.unmodifiableSet(doubleCodes);
  }

  /**
   * Method adds the passed DoubleCode object to the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Object that should be added to the association "doubleCodes". The parameter must not be null.
   */
  public void addToDoubleCodes( DoubleCode pDoubleCodes ) {
    // Add passed object to collection of associated DoubleCode objects.
    doubleCodes.add(pDoubleCodes);
  }

  /**
   * Method adds all passed objects to the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Collection with all objects that should be added to the association "doubleCodes". The
   * parameter must not be null.
   */
  public void addToDoubleCodes( Collection<DoubleCode> pDoubleCodes ) {
    // Add all passed objects.
    for (DoubleCode lNextObject : pDoubleCodes) {
      this.addToDoubleCodes(lNextObject);
    }
  }

  /**
   * Method removes the passed DoubleCode object from the association "doubleCodes".
   * 
   * 
   * @param pDoubleCodes Object that should be removed from the association "doubleCodes". The parameter must not be
   * null.
   */
  public void removeFromDoubleCodes( DoubleCode pDoubleCodes ) {
    // Remove passed object from collection of associated DoubleCode objects.
    doubleCodes.remove(pDoubleCodes);
  }

  /**
   * Method removes all objects from the association "doubleCodes".
   * 
   */
  public void clearDoubleCodes( ) {
    // Remove all objects from association "doubleCodes".
    doubleCodes.clear();
  }

  /**
   * Method returns the association "bookingIDs".
   * 
   *
   * @return Collection All BookingID objects that belong to the association "bookingIDs". The method never returns null
   * and the returned collection is unmodifiable.
   */
  public Set<BookingID> getBookingIDs( ) {
    // Return all BookingID objects as unmodifiable collection.
    return Collections.unmodifiableSet(bookingIDs);
  }

  /**
   * Method adds the passed BookingID object to the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Object that should be added to the association "bookingIDs". The parameter must not be null.
   */
  public void addToBookingIDs( BookingID pBookingIDs ) {
    // Add passed object to collection of associated BookingID objects.
    bookingIDs.add(pBookingIDs);
  }

  /**
   * Method adds all passed objects to the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Collection with all objects that should be added to the association "bookingIDs". The parameter
   * must not be null.
   */
  public void addToBookingIDs( Collection<BookingID> pBookingIDs ) {
    // Add all passed objects.
    for (BookingID lNextObject : pBookingIDs) {
      this.addToBookingIDs(lNextObject);
    }
  }

  /**
   * Method removes the passed BookingID object from the association "bookingIDs".
   * 
   * 
   * @param pBookingIDs Object that should be removed from the association "bookingIDs". The parameter must not be null.
   */
  public void removeFromBookingIDs( BookingID pBookingIDs ) {
    // Remove passed object from collection of associated BookingID objects.
    bookingIDs.remove(pBookingIDs);
  }

  /**
   * Method removes all objects from the association "bookingIDs".
   * 
   */
  public void clearBookingIDs( ) {
    // Remove all objects from association "bookingIDs".
    bookingIDs.clear();
  }

  /**
   * Method returns the attribute "bookingIDsArray".
   * 
   * 
   * @return BookingID Value to which the attribute "bookingIDsArray" is set.
   */
  public BookingID[] getBookingIDsArray( ) {
    BookingID[] lReturnValue;
    if (bookingIDsArray != null) {
      lReturnValue = new BookingID[bookingIDsArray.length];
      System.arraycopy(bookingIDsArray, 0, lReturnValue, 0, bookingIDsArray.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "bookingIDsArray".
   * 
   * 
   * @param pBookingIDsArray Value to which the attribute "bookingIDsArray" should be set.
   */
  public void setBookingIDsArray( BookingID[] pBookingIDsArray ) {
    // Assign value to attribute
    if (pBookingIDsArray != null) {
      bookingIDsArray = new BookingID[pBookingIDsArray.length];
      System.arraycopy(pBookingIDsArray, 0, bookingIDsArray, 0, pBookingIDsArray.length);
    }
    else {
      bookingIDsArray = null;
    }
  }

  /**
   * Method returns the attribute "offsetDateTime".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "offsetDateTime" is set.
   */
  public OffsetDateTime getOffsetDateTime( ) {
    return offsetDateTime;
  }

  /**
   * Method sets the attribute "offsetDateTime".
   * 
   * 
   * @param pOffsetDateTime Value to which the attribute "offsetDateTime" should be set.
   */
  public void setOffsetDateTime( OffsetDateTime pOffsetDateTime ) {
    // Assign value to attribute
    offsetDateTime = pOffsetDateTime;
  }

  /**
   * Method returns the association "offsetTime".
   * 
   *
   * @return OffsetTime OffsetTime to which the association "offsetTime" is set.
   */
  public OffsetTime getOffsetTime( ) {
    return offsetTime;
  }

  /**
   * Method sets the association "offsetTime".
   * 
   * 
   * @param pOffsetTime OffsetTime to which the association "offsetTime" should be set.
   */
  public void setOffsetTime( OffsetTime pOffsetTime ) {
    offsetTime = pOffsetTime;
  }

  /**
   * Method unsets the association "offsetTime".
   * 
   */
  public final void unsetOffsetTime( ) {
    offsetTime = null;
  }

  /**
   * Method returns the attribute "localDateTime".
   * 
   * 
   * @return LocalDateTime Value to which the attribute "localDateTime" is set.
   */
  public LocalDateTime getLocalDateTime( ) {
    return localDateTime;
  }

  /**
   * Method sets the attribute "localDateTime".
   * 
   * 
   * @param pLocalDateTime Value to which the attribute "localDateTime" should be set.
   */
  public void setLocalDateTime( LocalDateTime pLocalDateTime ) {
    // Assign value to attribute
    localDateTime = pLocalDateTime;
  }

  /**
   * Method returns the attribute "localTime".
   * 
   * 
   * @return LocalTime Value to which the attribute "localTime" is set.
   */
  public LocalTime getLocalTime( ) {
    return localTime;
  }

  /**
   * Method sets the attribute "localTime".
   * 
   * 
   * @param pLocalTime Value to which the attribute "localTime" should be set.
   */
  public void setLocalTime( LocalTime pLocalTime ) {
    // Assign value to attribute
    localTime = pLocalTime;
  }

  /**
   * Method returns the association "timestamps".
   * 
   *
   * @return Collection All LocalDateTime objects that belong to the association "timestamps". The method never returns
   * null and the returned collection is unmodifiable.
   */
  public List<LocalDateTime> getTimestamps( ) {
    // Return all LocalDateTime objects as unmodifiable collection.
    return Collections.unmodifiableList(timestamps);
  }

  /**
   * Method adds the passed LocalDateTime object to the association "timestamps".
   * 
   * 
   * @param pTimestamps Object that should be added to the association "timestamps". The parameter must not be null.
   */
  public void addToTimestamps( LocalDateTime pTimestamps ) {
    // Add passed object to collection of associated LocalDateTime objects.
    timestamps.add(pTimestamps);
  }

  /**
   * Method adds all passed objects to the association "timestamps".
   * 
   * 
   * @param pTimestamps Collection with all objects that should be added to the association "timestamps". The parameter
   * must not be null.
   */
  public void addToTimestamps( Collection<LocalDateTime> pTimestamps ) {
    // Add all passed objects.
    for (LocalDateTime lNextObject : pTimestamps) {
      this.addToTimestamps(lNextObject);
    }
  }

  /**
   * Method removes the passed LocalDateTime object from the association "timestamps".
   * 
   * 
   * @param pTimestamps Object that should be removed from the association "timestamps". The parameter must not be null.
   */
  public void removeFromTimestamps( LocalDateTime pTimestamps ) {
    // Remove passed object from collection of associated LocalDateTime objects.
    timestamps.remove(pTimestamps);
  }

  /**
   * Method removes all objects from the association "timestamps".
   * 
   */
  public void clearTimestamps( ) {
    // Remove all objects from association "timestamps".
    timestamps.clear();
  }

  /**
   * Method returns the association "times".
   * 
   *
   * @return Collection All OffsetTime objects that belong to the association "times". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<OffsetTime> getTimes( ) {
    // Return all OffsetTime objects as unmodifiable collection.
    return Collections.unmodifiableSet(times);
  }

  /**
   * Method adds the passed OffsetTime object to the association "times".
   * 
   * 
   * @param pTimes Object that should be added to the association "times". The parameter must not be null.
   */
  public void addToTimes( OffsetTime pTimes ) {
    // Add passed object to collection of associated OffsetTime objects.
    times.add(pTimes);
  }

  /**
   * Method adds all passed objects to the association "times".
   * 
   * 
   * @param pTimes Collection with all objects that should be added to the association "times". The parameter must not
   * be null.
   */
  public void addToTimes( Collection<OffsetTime> pTimes ) {
    // Add all passed objects.
    for (OffsetTime lNextObject : pTimes) {
      this.addToTimes(lNextObject);
    }
  }

  /**
   * Method removes the passed OffsetTime object from the association "times".
   * 
   * 
   * @param pTimes Object that should be removed from the association "times". The parameter must not be null.
   */
  public void removeFromTimes( OffsetTime pTimes ) {
    // Remove passed object from collection of associated OffsetTime objects.
    times.remove(pTimes);
  }

  /**
   * Method removes all objects from the association "times".
   * 
   */
  public void clearTimes( ) {
    // Remove all objects from association "times".
    times.clear();
  }

  /**
   * Method returns the attribute "startTimestamps".
   * 
   * 
   * @return OffsetDateTime Value to which the attribute "startTimestamps" is set.
   */
  public OffsetDateTime[] getStartTimestamps( ) {
    OffsetDateTime[] lReturnValue;
    if (startTimestamps != null) {
      lReturnValue = new OffsetDateTime[startTimestamps.length];
      System.arraycopy(startTimestamps, 0, lReturnValue, 0, startTimestamps.length);
    }
    else {
      lReturnValue = null;
    }
    return lReturnValue;
  }

  /**
   * Method sets the attribute "startTimestamps".
   * 
   * 
   * @param pStartTimestamps Value to which the attribute "startTimestamps" should be set.
   */
  public void setStartTimestamps( OffsetDateTime[] pStartTimestamps ) {
    // Assign value to attribute
    if (pStartTimestamps != null) {
      startTimestamps = new OffsetDateTime[pStartTimestamps.length];
      System.arraycopy(pStartTimestamps, 0, startTimestamps, 0, pStartTimestamps.length);
    }
    else {
      startTimestamps = null;
    }
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
    lBuilder.append("longCodes: ");
    if (longCodes != null) {
      lBuilder.append(Arrays.toString(longCodes));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("codes: ");
    if (codes != null) {
      lBuilder.append(Arrays.toString(codes));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("doubleCodes: ");
    if (doubleCodes != null) {
      lBuilder.append(doubleCodes.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (doubleCodes != null) {
      for (DoubleCode lNext : doubleCodes) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("bookingIDs: ");
    if (bookingIDs != null) {
      lBuilder.append(bookingIDs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (bookingIDs != null) {
      for (BookingID lNext : bookingIDs) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("bookingIDsArray: ");
    if (bookingIDsArray != null) {
      lBuilder.append(Arrays.toString(bookingIDsArray));
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("offsetDateTime: ");
    lBuilder.append(offsetDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("offsetTime: ");
    lBuilder.append(offsetTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localDateTime: ");
    lBuilder.append(localDateTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("localTime: ");
    lBuilder.append(localTime);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("timestamps: ");
    if (timestamps != null) {
      lBuilder.append(timestamps.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (timestamps != null) {
      for (LocalDateTime lNext : timestamps) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("times: ");
    if (times != null) {
      lBuilder.append(times.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (times != null) {
      for (OffsetTime lNext : times) {
        lBuilder.append(pIndent + "    ");
        lBuilder.append(lNext.toString());
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("startTimestamps: ");
    if (startTimestamps != null) {
      lBuilder.append(Arrays.toString(startTimestamps));
    }
    else {
      lBuilder.append(" null");
    }
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