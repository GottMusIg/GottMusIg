
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
    "combo_points",
    "energy",
    "focus",
    "mana",
    "none",
    "chi",
    "holy_power",
    "insanity",
    "health",
    "maelstrom",
    "soul_shard",
    "rage"
})
@Getter
public class Gain implements Serializable
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
    @JsonProperty("combo_points")
    private ComboPoints comboPoints;
    @JsonProperty("energy")
    private Energy energy;
    @JsonProperty("focus")
    private Focus focus;
    @JsonProperty("mana")
    private Mana mana;
    @JsonProperty("none")
    private None none;
    @JsonProperty("chi")
    private Chi chi;
    @JsonProperty("holy_power")
    private HolyPower holyPower;
    @JsonProperty("insanity")
    private Insanity insanity;
    @JsonProperty("health")
    private Health health;
    @JsonProperty("maelstrom")
    private Maelstrom maelstrom;
    @JsonProperty("soul_shard")
    private SoulShard soulShard;
    @JsonProperty("rage")
    private Rage rage;
    private final static long serialVersionUID = -4596887837080403257L;

}
