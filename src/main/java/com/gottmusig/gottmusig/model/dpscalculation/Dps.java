
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
    "sum",
    "count",
    "mean",
    "min",
    "max",
    "variance",
    "std_dev",
    "mean_variance",
    "mean_std_dev"
})
@Getter
public class Dps implements Serializable
{

    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("mean")
    private Double mean;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("variance")
    private Double variance;
    @JsonProperty("std_dev")
    private Double stdDev;
    @JsonProperty("mean_variance")
    private Double meanVariance;
    @JsonProperty("mean_std_dev")
    private Double meanStdDev;
    private final static long serialVersionUID = -2058827626850107389L;

}
