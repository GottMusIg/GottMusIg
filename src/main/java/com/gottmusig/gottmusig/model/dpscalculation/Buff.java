
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
	"spell",
    "start_count",
    "uptime",
    "benefit",
    "spell",
    "source",
    "refresh_count",
    "interval",
    "trigger",
    "overflow_stacks",
    "overflow_total",
    "default_value",
    "expire_count",
    "item",
    "cooldown",
        "stacks"
})
@Getter
public class Buff implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("start_count")
    private Double startCount;
    @JsonProperty("uptime")
    private Double uptime;
    @JsonProperty("benefit")
    private Double benefit;
    @JsonProperty("spell")
    private Integer spell;
    @JsonProperty("source")
    private String source;
    @JsonProperty("refresh_count")
    private Double refreshCount;
    @JsonProperty("interval")
    private Double interval;
    @JsonProperty("trigger")
    private Double trigger;
    @JsonProperty("overflow_stacks")
    private Double overflowStacks;
    @JsonProperty("overflow_total")
    private Double overflowTotal;
    @JsonProperty("default_value")
    private Double defaultValue;
    @JsonProperty("expire_count")
    private Double expireCount;
    @JsonProperty("item")
    private Item item;
    @JsonProperty("cooldown")
    private Cooldown cooldown;
    @JsonProperty("stacks")
    private Integer stacks;

    private final static long serialVersionUID = -5629442365183160388L;

}
