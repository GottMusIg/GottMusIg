
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
    "attack_power",
    "spell_crit",
    "attack_crit",
    "spell_haste",
    "attack_haste",
    "spell_speed",
    "attack_speed",
    "mastery_value",
    "damage_versatility",
    "heal_versatility",
    "mitigation_versatility",
    "speed",
    "armor",
    "dodge",
    "parry",
    "spell_power",
    "manareg_per_second",
    "block",
        "attack_crit",
    "spell_haste",
    "attack_haste",
    "spell_speed",
    "attack_speed",
    "speed",
    "armor",
    "dodge",
    "parry",
    "block"
})
@Getter
public class Stats implements Serializable
{

    @JsonProperty("attack_power")
    private Double attackPower;
    @JsonProperty("spell_crit")
    private Double spellCrit;
    @JsonProperty("attack_crit")
    private Double attackCrit;
    @JsonProperty("spell_haste")
    private Double spellHaste;
    @JsonProperty("attack_haste")
    private Double attackHaste;
    @JsonProperty("spell_speed")
    private Double spellSpeed;
    @JsonProperty("attack_speed")
    private Double attackSpeed;
    @JsonProperty("mastery_value")
    private Double masteryValue;
    @JsonProperty("damage_versatility")
    private Double damageVersatility;
    @JsonProperty("heal_versatility")
    private Double healVersatility;
    @JsonProperty("mitigation_versatility")
    private Double mitigationVersatility;
    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("armor")
    private Double armor;
    @JsonProperty("dodge")
    private Double dodge;
    @JsonProperty("parry")
    private Double parry;
    @JsonProperty("spell_power")
    private Double spellPower;
    @JsonProperty("manareg_per_second")
    private Double manaregPerSecond;
    @JsonProperty("block")
    private Double block;
    private final static long serialVersionUID = 5576229480643073563L;
}
