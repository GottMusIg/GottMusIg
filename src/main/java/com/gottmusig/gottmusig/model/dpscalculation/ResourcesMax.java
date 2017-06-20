
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
    "runic_power",
    "rune",
    "fury",
    "astral_power",
    "energy",
    "combo_points",
    "focus",
    "mana",
    "chi",
    "holy_power",
    "insanity",
    "maelstrom",
    "health",
    "soul_shard",
    "rage"
})
@Getter
public class ResourcesMax implements Serializable
{

    @JsonProperty("runic_power")
    private Double runicPower;
    @JsonProperty("rune")
    private Double rune;
    @JsonProperty("fury")
    private Double fury;
    @JsonProperty("astral_power")
    private Double astralPower;
    @JsonProperty("energy")
    private Double energy;
    @JsonProperty("combo_points")
    private Double comboPoints;
    @JsonProperty("focus")
    private Double focus;
    @JsonProperty("mana")
    private Double mana;
    @JsonProperty("chi")
    private Double chi;
    @JsonProperty("holy_power")
    private Double holyPower;
    @JsonProperty("insanity")
    private Double insanity;
    @JsonProperty("maelstrom")
    private Double maelstrom;
    @JsonProperty("health")
    private Double health;
    @JsonProperty("soul_shard")
    private Double soulShard;
    @JsonProperty("rage")
    private Double rage;
    private final static long serialVersionUID = -5346684975083966883L;

}
