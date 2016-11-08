
package com.gottmusig.gottmusig.model.dpscalculation;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "charges",
    "duration",
    "name"
})
public class Cooldown {

    /**
     * 
     */
    @JsonProperty("charges")
    private Double charges;
    /**
     * 
     */
    @JsonProperty("duration")
    private Double duration;
    /**
     * 
     */
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The charges
     */
    @JsonProperty("charges")
    public Double getCharges() {
        return charges;
    }

    /**
     * 
     * @param charges
     *     The charges
     */
    @JsonProperty("charges")
    public void setCharges(Double charges) {
        this.charges = charges;
    }

    /**
     * 
     * @return
     *     The duration
     */
    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(charges).append(duration).append(name).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cooldown) == false) {
            return false;
        }
        Cooldown rhs = ((Cooldown) other);
        return new EqualsBuilder().append(charges, rhs.charges).append(duration, rhs.duration).append(name, rhs.name).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
