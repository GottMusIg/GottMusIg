
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

        "min",
        "max",
        "mean",
        "mean_std_dev",
        "sum",
        "actual",
        "overflow",
        "count",
        "data"
})
@Getter
public class HolyPower implements Serializable
{

    @JsonProperty("mean_std_dev")
    private Double meanStdDev;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("data")
    private List<Double> data = new ArrayList<Double>();
    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("mean")
    private Double mean;
    @JsonProperty("actual")
    private Double actual;
    @JsonProperty("overflow")
    private Double overflow;
    @JsonProperty("count")
    private Double count;


}
