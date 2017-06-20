
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
    "chanceType",
    "stats",
    "sockets"
})
public class BonusChance {

    @JsonProperty("chanceType")
    private String chanceType;
    @JsonProperty("stats")
    private List<Stat> stats = null;
    @JsonProperty("sockets")
    private List<Socket> sockets = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("chanceType")
    public String getChanceType() {
        return chanceType;
    }

    @JsonProperty("chanceType")
    public void setChanceType(String chanceType) {
        this.chanceType = chanceType;
    }

    @JsonProperty("stats")
    public List<Stat> getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    @JsonProperty("sockets")
    public List<Socket> getSockets() {
        return sockets;
    }

    @JsonProperty("sockets")
    public void setSockets(List<Socket> sockets) {
        this.sockets = sockets;
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
