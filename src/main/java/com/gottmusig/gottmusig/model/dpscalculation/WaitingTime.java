
package com.gottmusig.gottmusig.model.dpscalculation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "max",
    "mean",
    "min",
    "name",
    "sum"
})

@EqualsAndHashCode
@Getter
@ToString
public class WaitingTime {

    
    @JsonProperty("count")
    private Double count;
    
    @JsonProperty("max")
    private Double max;
    
    @JsonProperty("mean")
    private Double mean;
    
    @JsonProperty("min")
    private Double min;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("sum")
    private Double sum;
  
}