/*
 * Product Base Definitions
 * This component represents the Open API interface of the accounting service.
 *
 * The version of the OpenAPI document: 0.0.1
 * Contact: jeaf@anaptecs.de
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package openapitools.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import openapitools.model.ChildA;
import openapitools.model.ChildAA;
import openapitools.model.ChildB;
import openapitools.model.ChildBB;
import openapitools.model.ParentClass;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import openapitools.JSON;


/**
 * ChildAA
 * @deprecated
 */
@Deprecated
@JsonPropertyOrder({
  ChildAA.JSON_PROPERTY_CHILD_A_A_ATTRIBUTE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "objectType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = ChildA.class, name = "ChildA"),
  @JsonSubTypes.Type(value = ChildAA.class, name = "ChildAA"),
  @JsonSubTypes.Type(value = ChildB.class, name = "ChildB"),
  @JsonSubTypes.Type(value = ChildBB.class, name = "ChildBB"),
  @JsonSubTypes.Type(value = ParentClass.class, name = "ParentClass"),
})

public class ChildAA extends ChildA {
  public static final String JSON_PROPERTY_CHILD_A_A_ATTRIBUTE = "childAAAttribute";
  private Integer childAAAttribute;

  public ChildAA() { 
  }

  public ChildAA childAAAttribute(Integer childAAAttribute) {
    this.childAAAttribute = childAAAttribute;
    return this;
  }

   /**
   * Get childAAAttribute
   * @return childAAAttribute
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CHILD_A_A_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getChildAAAttribute() {
    return childAAAttribute;
  }


  @JsonProperty(JSON_PROPERTY_CHILD_A_A_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setChildAAAttribute(Integer childAAAttribute) {
    this.childAAAttribute = childAAAttribute;
  }


  /**
   * Return true if this ChildAA object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChildAA childAA = (ChildAA) o;
    return Objects.equals(this.childAAAttribute, childAA.childAAAttribute) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childAAAttribute, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChildAA {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    childAAAttribute: ").append(toIndentedString(childAAAttribute)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("ChildA", ChildA.class);
  mappings.put("ChildAA", ChildAA.class);
  mappings.put("ChildB", ChildB.class);
  mappings.put("ChildBB", ChildBB.class);
  mappings.put("ParentClass", ParentClass.class);
  mappings.put("ChildAA", ChildAA.class);
  JSON.registerDiscriminator(ChildAA.class, "objectType", mappings);
}
}
