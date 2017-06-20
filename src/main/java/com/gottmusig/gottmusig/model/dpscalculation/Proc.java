
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
    "name",
    "interval",
    "count"
})
@Getter
public class Proc implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("interval")
    private Double interval;
    @JsonProperty("count")
    private Double count;
    private final static long serialVersionUID = -4938851903934849597L;

}
