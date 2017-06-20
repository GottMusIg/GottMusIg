
package com.gottmusig.gottmusig.model.blizzard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultBonusLists",
    "chanceBonusLists",
    "bonusChances"
})
public class BonusSummary {

    @JsonProperty("defaultBonusLists")
    private List<Integer> defaultBonusLists = null;
    @JsonProperty("chanceBonusLists")
    private List<Integer> chanceBonusLists = null;
    @JsonProperty("bonusChances")
    private List<BonusChance> bonusChances = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("defaultBonusLists")
    public List<Integer> getDefaultBonusLists() {
        return defaultBonusLists;
    }

    @JsonProperty("defaultBonusLists")
    public void setDefaultBonusLists(List<Integer> defaultBonusLists) {
        this.defaultBonusLists = defaultBonusLists;
    }

    @JsonProperty("chanceBonusLists")
    public List<Integer> getChanceBonusLists() {
        return chanceBonusLists;
    }

    @JsonProperty("chanceBonusLists")
    public void setChanceBonusLists(List<Integer> chanceBonusLists) {
        this.chanceBonusLists = chanceBonusLists;
    }

    @JsonProperty("bonusChances")
    public List<BonusChance> getBonusChances() {
        return bonusChances;
    }

    @JsonProperty("bonusChances")
    public void setBonusChances(List<BonusChance> bonusChances) {
        this.bonusChances = bonusChances;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
