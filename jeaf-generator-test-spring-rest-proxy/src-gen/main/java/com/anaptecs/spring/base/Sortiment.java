/*
 * anaptecs GmbH, Ricarda-Huch-Str. 71, 72760 Reutlingen, Germany
 * 
 * Copyright 2004 - 2019. All rights reserved.
 */
package com.anaptecs.spring.base;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author JEAF Generator
 * @version JEAF Release 1.4.x
 */
public class Sortiment {
  /**
   * Constant for the name of attribute "products".
   */
  public static final String PRODUCTS = "products";

  /**
   * 
   */
  private Set<Product> products = new HashSet<Product>();

  /**
   * Attribute is required for correct handling of bidirectional associations in case of deserialization.
   */
  private transient boolean productsBackReferenceInitialized;

  /**
   * Default constructor is only intended to be used for deserialization as many frameworks required that. For "normal"
   * object creation builder should be used instead.
   */
  protected Sortiment( ) {
    // Nothing to do.
    // Bidirectional back reference is not yet set up correctly
    productsBackReferenceInitialized = false;
  }

  /**
   * Initialize object using the passed builder.
   * 
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Sortiment( Builder pBuilder ) {
    // Read attribute values from builder.
    if (pBuilder.products != null) {
      products.addAll(pBuilder.products);
    }
    // Bidirectional back reference is set up correctly as a builder is used.
    productsBackReferenceInitialized = true;
  }

  /**
   * Class implements builder to create a new instance of class Sortiment. As the class has read only attributes or
   * associations instances can not be created directly. Instead this builder class has to be used.
   */
  public static class Builder {
    /**
     * 
     */
    private Set<Product> products;

    /**
     * Use {@link #newBuilder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link #newBuilder(Sortiment)} instead of private constructor to create new builder.
     */
    protected Builder( Sortiment pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        products = pObject.products;
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
     * @return {@link Builder} New builder that can be used to create new Sortiment objects. The method never returns
     * null.
     */
    public static Builder newBuilder( Sortiment pObject ) {
      return new Builder(pObject);
    }

    /**
     * Method sets the association "products".
     * 
     * @param pProducts Collection with objects to which the association should be set.
     */
    public Builder setProducts( Set<Product> pProducts ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pProducts != null) {
        products = new HashSet<Product>(pProducts);
      }
      else {
        products = null;
      }
      return this;
    }

    /**
     * Method creates a new instance of class Sortiment. The object will be initialized with the values of the builder.
     * 
     * @return Sortiment Created object. The method never returns null.
     */
    public Sortiment build( ) {
      return new Sortiment(this);
    }
  }

  /**
   * Method returns the association "products".
   * 
   *
   * @return Collection All Product objects that belong to the association "products". The method never returns null and
   * the returned collection is unmodifiable.
   */
  public Set<Product> getProducts( ) {
    // Due to restrictions in JSON serialization / deserialization bi-directional associations need a special handling
    // after an object was deserialized.
    if (productsBackReferenceInitialized == false) {
      productsBackReferenceInitialized = true;
      for (Product lNext : products) {
        lNext.addToSortiments((Sortiment) this);
      }
    }
    // Return all Product objects as unmodifiable collection.
    return Collections.unmodifiableSet(products);
  }

  /**
   * Method sets the association "products" to the passed collection. All objects that formerly were part of the
   * association will be removed from it.
   * 
   * 
   * @param pProducts Collection with objects to which the association should be set. The parameter must not be null.
   */
  void setProducts( Set<Product> pProducts ) {
    // Check of parameter is not required.
    // Remove all objects from association "products".
    this.clearProducts();
    // If the association is null, removing all entries is sufficient.
    if (pProducts != null) {
      products = new HashSet<Product>(pProducts);
    }
  }

  /**
   * Method adds the passed Product object to the association "products".
   * 
   * 
   * @param pProducts Object that should be added to the association "products". The parameter must not be null.
   */
  public void addToProducts( Product pProducts ) {
    // Add passed object to collection of associated Product objects.
    products.add(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts != null && pProducts.getSortiments().contains(this) == false) {
      pProducts.addToSortiments((Sortiment) this);
    }
  }

  /**
   * Method adds all passed objects to the association "products".
   * 
   * 
   * @param pProducts Collection with all objects that should be added to the association "products". The parameter must
   * not be null.
   */
  public void addToProducts( Collection<Product> pProducts ) {
    // Add all passed objects.
    for (Product lNextObject : pProducts) {
      this.addToProducts(lNextObject);
    }
  }

  /**
   * Method removes the passed Product object from the association "products".
   * 
   * 
   * @param pProducts Object that should be removed from the association "products". The parameter must not be null.
   */
  public void removeFromProducts( Product pProducts ) {
    // Remove passed object from collection of associated Product objects.
    products.remove(pProducts);
    // The association is set in both directions because within the UML model it is defined to be bidirectional.
    // In case that one side will be removed from the association the other side will also be removed.
    if (pProducts.getSortiments().contains(this) == true) {
      pProducts.removeFromSortiments((Sortiment) this);
    }
  }

  /**
   * Method removes all objects from the association "products".
   * 
   */
  public void clearProducts( ) {
    // Remove all objects from association "products".
    Collection<Product> lProducts = new HashSet<Product>(products);
    Iterator<Product> lIterator = lProducts.iterator();
    while (lIterator.hasNext()) {
      this.removeFromProducts(lIterator.next());
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
    lBuilder.append(this.getClass().getName());
    lBuilder.append('\n');
    lBuilder.append("Attributes:");
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