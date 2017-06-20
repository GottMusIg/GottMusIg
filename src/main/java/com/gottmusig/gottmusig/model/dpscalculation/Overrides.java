
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
    "mortal_wounds",
    "bleeding",
    "bloodlust",
    "bloodlust_percent",
    "bloodlust_time"
})
@Getter
public class Overrides implements Serializable
{

    @JsonProperty("mortal_wounds")
    private Integer mortalWounds;
    @JsonProperty("bleeding")
    private Integer bleeding;
    @JsonProperty("bloodlust")
    private Integer bloodlust;
    @JsonProperty("bloodlust_percent")
    private Integer bloodlustPercent;
    @JsonProperty("bloodlust_time")
    private Double bloodlustTime;
    private final static long serialVersionUID = -5213963085009840499L;

}
