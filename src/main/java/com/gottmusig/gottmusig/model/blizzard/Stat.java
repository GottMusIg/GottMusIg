
package com.gottmusig.gottmusig.model.blizzard;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "statId",
    "delta"
})
public class Stat {

    @JsonProperty("statId")
    private String statId;
    @JsonProperty("delta")
    private Integer delta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("statId")
    public String getStatId() {
        return statId;
    }

    @JsonProperty("statId")
    public void setStatId(String statId) {
        this.statId = statId;
    }

    @JsonProperty("delta")
    public Integer getDelta() {
        return delta;
    }

    @JsonProperty("delta")
    public void setDelta(Integer delta) {
        this.delta = delta;
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
