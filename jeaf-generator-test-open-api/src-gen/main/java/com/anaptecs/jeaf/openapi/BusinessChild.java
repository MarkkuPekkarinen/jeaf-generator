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
import com.anaptecs.jeaf.openapi.BusinessParent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * BusinessChild
 */


public class BusinessChild extends BusinessParent {
  @JsonProperty("childAttribute")
  private String childAttribute = null;

  public BusinessChild childAttribute(String childAttribute) {
    this.childAttribute = childAttribute;
    return this;
  }

   /**
   * Get childAttribute
   * @return childAttribute
  **/
  @Schema(required = true, description = "")
  public String getChildAttribute() {
    return childAttribute;
  }

  public void setChildAttribute(String childAttribute) {
    this.childAttribute = childAttribute;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessChild businessChild = (BusinessChild) o;
    return Objects.equals(this.childAttribute, businessChild.childAttribute) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childAttribute, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessChild {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    childAttribute: ").append(toIndentedString(childAttribute)).append("\n");
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
