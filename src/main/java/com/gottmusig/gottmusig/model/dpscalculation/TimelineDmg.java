
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "mean",
    "mean_std_dev",
    "min",
    "max",
    "data"
})
@Getter
public class TimelineDmg implements Serializable
{

    @JsonProperty("mean")
    private Double mean;
    @JsonProperty("mean_std_dev")
    private Double meanStdDev;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("data")
    private List<Double> data = new ArrayList<Double>();
    private final static long serialVersionUID = -1878673793408278125L;

}
