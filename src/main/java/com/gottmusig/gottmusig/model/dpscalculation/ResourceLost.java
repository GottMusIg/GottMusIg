
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
public class ResourceLost implements Serializable
{

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
    @JsonProperty("focus")
    private Focus focus;
    @JsonProperty("mana")
    private Mana mana;
    @JsonProperty("chi")
    private Chi chi;
    @JsonProperty("holy_power")
    private HolyPower holyPower;
    @JsonProperty("insanity")
    private Insanity insanity;
    @JsonProperty("maelstrom")
    private Maelstrom maelstrom;
    @JsonProperty("health")
    private Health health;
    @JsonProperty("soul_shard")
    private SoulShard soulShard;
    @JsonProperty("rage")
    private Rage rage;
    private final static long serialVersionUID = 6817523780270828331L;

}
