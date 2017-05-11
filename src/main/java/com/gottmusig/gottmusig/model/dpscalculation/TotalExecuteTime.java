
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sum",
    "count",
    "mean"
})
@Getter
@Setter
public class TotalExecuteTime implements Serializable
{

    @JsonProperty("sum")
    private Double sum;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("mean")
    private Double mean;
    private final static long serialVersionUID = 3423061649325835601L;

}
