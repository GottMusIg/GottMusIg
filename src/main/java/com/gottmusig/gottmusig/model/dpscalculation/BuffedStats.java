
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
    "attribute",
    "resources",
    "stats"
})
@Getter
public class BuffedStats implements Serializable
{

    @JsonProperty("attribute")
    private Attribute attribute;
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("stats")
    private Stats stats;

    private final static long serialVersionUID = 2469428624733401805L;

}
