
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    "resources",
    "resources_max",
    "buffs"
})

@Getter
public class ActionSequencePrecombat implements Serializable
{

    @JsonProperty("time")
    private Double time;
    @JsonProperty("name")
    private String name;
    @JsonProperty("target")
    private String target;
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("resources_max")
    private ResourcesMax resourcesMax;
    @JsonProperty("buffs")
    private List<Buff> buffs = new ArrayList<Buff>();

    private final static long serialVersionUID = -2589645672424329440L;

}
