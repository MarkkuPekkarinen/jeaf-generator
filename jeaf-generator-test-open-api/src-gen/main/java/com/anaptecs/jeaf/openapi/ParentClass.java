/*
 * Product Base Definitions
 * This component represents the Open API interface of the accounting service. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: jeaf@anaptecs.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.anaptecs.jeaf.openapi;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * ParentClass
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = ChildAA.class, name = "ChildAA"),
  @JsonSubTypes.Type(value = ChildBB.class, name = "ChildBB"),
  @JsonSubTypes.Type(value = ChildB.class, name = "ChildB"),
  @JsonSubTypes.Type(value = ChildA.class, name = "ChildA"),
})

public class ParentClass {
  @JsonTypeId
  private String objectType = null;

  @JsonProperty("parentAttribute")
  private String parentAttribute = null;

  public ParentClass objectType(String objectType) {
    this.objectType = objectType;
    return this;
  }

   /**
   * Attribute is used as discriminator for inheritance between data types.
   * @return objectType
  **/
  @Schema(required = true, description = "Attribute is used as discriminator for inheritance between data types.")
  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public ParentClass parentAttribute(String parentAttribute) {
    this.parentAttribute = parentAttribute;
    return this;
  }

   /**
   * Get parentAttribute
   * @return parentAttribute
  **/
  @Schema(description = "")
  public String getParentAttribute() {
    return parentAttribute;
  }

  public void setParentAttribute(String parentAttribute) {
    this.parentAttribute = parentAttribute;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParentClass parentClass = (ParentClass) o;
    return Objects.equals(this.objectType, parentClass.objectType) &&
        Objects.equals(this.parentAttribute, parentClass.parentAttribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectType, parentAttribute);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParentClass {\n");
    
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    parentAttribute: ").append(toIndentedString(parentAttribute)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}