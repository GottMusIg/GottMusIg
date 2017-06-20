
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
    "fight_length",
    "waiting_time",
    "executed_foreground_actions",
    "dmg",
    "compound_dmg",
    "timeline_dmg",
    "dps",
    "dpse",
    "resource_lost",
    "combat_end_resource",
    "resource_timelines",
    "action_sequence_precombat",
    "action_sequence",
    "buffed_stats"
})
@Getter
public class CollectedData implements Serializable
{

    @JsonProperty("fight_length")
    private FightLength fightLength;
    @JsonProperty("waiting_time")
    private WaitingTime waitingTime;
    @JsonProperty("executed_foreground_actions")
    private ExecutedForegroundActions executedForegroundActions;
    @JsonProperty("dmg")
    private Dmg dmg;
    @JsonProperty("compound_dmg")
    private CompoundDmg compoundDmg;
    @JsonProperty("timeline_dmg")
    private TimelineDmg timelineDmg;
    @JsonProperty("dps")
    private Dps dps;
    @JsonProperty("dpse")
    private Dpse dpse;
    @JsonProperty("resource_lost")
    private ResourceLost resourceLost;
    @JsonProperty("combat_end_resource")
    private CombatEndResource combatEndResource;
    @JsonProperty("resource_timelines")
    private ResourceTimelines resourceTimelines;
    @JsonProperty("action_sequence_precombat")
    private List<ActionSequencePrecombat> actionSequencePrecombat = new ArrayList<ActionSequencePrecombat>();
    @JsonProperty("action_sequence")
    private List<ActionSequence> actionSequence = new ArrayList<ActionSequence>();
    @JsonProperty("buffed_stats")
    private BuffedStats buffedStats;

    private final static long serialVersionUID = 1867009271870568175L;

}
