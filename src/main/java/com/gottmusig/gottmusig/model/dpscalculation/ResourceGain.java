
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
    "runic_power",
    "rune",
    "fury",
    "astral_power",
    "energy",
    "combo_points",
    "mana",
    "focus",
    "chi",
    "holy_power",
    "maelstrom",
    "soul_shard",
    "rage",
        "health"
})
@Getter
public class ResourceGain implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("runic_power")
    private RunicPower runicPower;
    @JsonProperty("rune")
    private Rune rune;
    @JsonProperty("fury")
    private Fury fury;
    @JsonProperty("astral_power")
    private AstralPower astralPower;
    @JsonProperty("energy")
    private Energy energy;
    @JsonProperty("combo_points")
    private ComboPoints comboPoints;
    @JsonProperty("mana")
    private Mana mana;
    @JsonProperty("focus")
    private Focus focus;
    @JsonProperty("chi")
    private Chi chi;
    @JsonProperty("holy_power")
    private HolyPower holyPower;
    @JsonProperty("maelstrom")
    private Maelstrom maelstrom;
    @JsonProperty("soul_shard")
    private SoulShard soulShard;
    @JsonProperty("rage")
    private Rage rage;
    @JsonProperty("health")
    private Health health;
    private final static long serialVersionUID = 6286056212855205354L;

}
