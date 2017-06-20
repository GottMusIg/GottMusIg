
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
    "actual_amount",
    "avg_actual_amount",
    "total_amount",
    "fight_actual_amount",
    "fight_total_amount",
    "overkill_pct",
    "count",
    "pct"
})
@Getter
public class Crit implements Serializable
{

    @JsonProperty("actual_amount")
    private ActualAmount actualAmount;
    @JsonProperty("avg_actual_amount")
    private AvgActualAmount avgActualAmount;
    @JsonProperty("total_amount")
    private TotalAmount totalAmount;
    @JsonProperty("fight_actual_amount")
    private FightActualAmount fightActualAmount;
    @JsonProperty("fight_total_amount")
    private FightTotalAmount fightTotalAmount;
    @JsonProperty("overkill_pct")
    private OverkillPct overkillPct;
    @JsonProperty("count")
    private Count count;
    @JsonProperty("pct")
    private Double pct;
    private final static long serialVersionUID = -4595858610068171732L;

}
