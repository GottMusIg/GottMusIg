
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
    "name",
    "race",
    "role",
    "specialization",
    "level",
    "party",
    "ready_type",
    "bugs",
    "scale_player",
    "potion_used",
    "timeofday",
    "death_pct",
    "height",
    "combat_reach",
    "invert_scaling",
    "reaction_offset",
    "reaction_mean",
    "reaction_stddev",
    "reaction_nu",
    "world_lag",
    "brain_lag",
    "brain_lag_stddev",
    "world_lag_override",
    "world_lag_stddev_override",
    "dbc",
    "collected_data",
    "buffs",
    "procs",
    "gains",
    "stats"
})
@Getter
public class Target implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("race")
    private String race;
    @JsonProperty("role")
    private String role;
    @JsonProperty("specialization")
    private String specialization;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("party")
    private Integer party;
    @JsonProperty("ready_type")
    private Integer readyType;
    @JsonProperty("bugs")
    private Boolean bugs;
    @JsonProperty("scale_player")
    private Boolean scalePlayer;
    @JsonProperty("potion_used")
    private Boolean potionUsed;
    @JsonProperty("timeofday")
    private String timeofday;
    @JsonProperty("death_pct")
    private Double deathPct;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("combat_reach")
    private Double combatReach;
    @JsonProperty("invert_scaling")
    private Integer invertScaling;
    @JsonProperty("reaction_offset")
    private Double reactionOffset;
    @JsonProperty("reaction_mean")
    private Double reactionMean;
    @JsonProperty("reaction_stddev")
    private Double reactionStddev;
    @JsonProperty("reaction_nu")
    private Double reactionNu;
    @JsonProperty("world_lag")
    private Double worldLag;
    @JsonProperty("brain_lag")
    private Double brainLag;
    @JsonProperty("brain_lag_stddev")
    private Double brainLagStddev;
    @JsonProperty("world_lag_override")
    private Boolean worldLagOverride;
    @JsonProperty("world_lag_stddev_override")
    private Boolean worldLagStddevOverride;
    @JsonProperty("dbc")
    private Dbc dbc;
    @JsonProperty("collected_data")
    private CollectedData collectedData;
    @JsonProperty("buffs")
    private List<Buff> buffs = new ArrayList<Buff>();
    @JsonProperty("procs")
    private List<Object> procs = new ArrayList<Object>();
    @JsonProperty("gains")
    private List<Object> gains = new ArrayList<Object>();
    @JsonProperty("stats")
    private List<Object> stats = new ArrayList<Object>();
    private final static long serialVersionUID = 9032639319856079932L;

}
