
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "strength",
    "agility",
    "stamina",
    "intellect",
    "spirit"
})
@Getter
public class Attribute implements Serializable
{

    @JsonProperty("strength")
    private Double strength;
    @JsonProperty("agility")
    private Double agility;
    @JsonProperty("stamina")
    private Double stamina;
    @JsonProperty("intellect")
    private Double intellect;
    @JsonProperty("spirit")
    private Double spirit;

    private final static long serialVersionUID = 3673984915754824704L;

}
