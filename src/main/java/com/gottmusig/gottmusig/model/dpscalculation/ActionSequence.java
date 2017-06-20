
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "time",
    "name",
    "target",
    "buffs",
    "resources",
    "resourcesmax",
    "wait"
})
@Getter
public class ActionSequence implements Serializable
{

    @JsonProperty("time")
    private Double time;
    @JsonProperty("name")
    private String name;
    @JsonProperty("target")
    private String target;
    @JsonProperty("buffs")
    private List<Buff> buffs = new ArrayList<Buff>();
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("resourcesmax")
    private ResourcesMax resourcesMax;
    @JsonProperty("wait")
    private Double wait;

    private final static long serialVersionUID = -5750680667149081696L;
}
