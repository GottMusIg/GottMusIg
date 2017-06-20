
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
    "debug",
    "max_time",
    "expected_iteration_time",
    "vary_combat_length",
    "iterations",
    "target_error",
    "threads",
    "seed",
    "single_actor_batch",
    "queue_lag",
    "queue_lag_stddev",
    "gcd_lag",
    "gcd_lag_stddev",
    "channel_lag",
    "channel_lag_stddev",
    "queue_gcd_reduction",
    "strict_gcd_queue",
    "confidence",
    "confidence_estimator",
    "world_lag",
    "world_lag_stddev",
    "travel_variance",
    "default_skill",
    "reaction_time",
    "regen_periodicity",
    "ignite_sampling_delta",
    "fixed_time",
    "optimize_expressions",
    "optimal_raid",
    "log",
    "debug_each",
    "auto_ready_trigger",
    "stat_cache",
    "max_aoe_enemies",
    "show_etmi",
    "tmi_window_global",
    "tmi_bin_size",
    "enemy_death_pct",
    "challenge_mode",
    "timewalk",
    "pvp_crit",
    "rng",
    "deterministic",
    "average_range",
    "average_gauss",
    "fight_style",
    "default_aura_delay",
    "default_aura_delay_stddev",
    "dbc"
})
@Getter
public class Options implements Serializable
{

    @JsonProperty("debug")
    private Boolean debug;
    @JsonProperty("max_time")
    private Double maxTime;
    @JsonProperty("expected_iteration_time")
    private Double expectedIterationTime;
    @JsonProperty("vary_combat_length")
    private Double varyCombatLength;
    @JsonProperty("iterations")
    private Integer iterations;
    @JsonProperty("target_error")
    private Double targetError;
    @JsonProperty("threads")
    private Integer threads;
    @JsonProperty("seed")
    private Double seed;
    @JsonProperty("single_actor_batch")
    private Boolean singleActorBatch;
    @JsonProperty("queue_lag")
    private Double queueLag;
    @JsonProperty("queue_lag_stddev")
    private Double queueLagStddev;
    @JsonProperty("gcd_lag")
    private Double gcdLag;
    @JsonProperty("gcd_lag_stddev")
    private Double gcdLagStddev;
    @JsonProperty("channel_lag")
    private Double channelLag;
    @JsonProperty("channel_lag_stddev")
    private Double channelLagStddev;
    @JsonProperty("queue_gcd_reduction")
    private Double queueGcdReduction;
    @JsonProperty("strict_gcd_queue")
    private Integer strictGcdQueue;
    @JsonProperty("confidence")
    private Double confidence;
    @JsonProperty("confidence_estimator")
    private Double confidenceEstimator;
    @JsonProperty("world_lag")
    private Double worldLag;
    @JsonProperty("world_lag_stddev")
    private Double worldLagStddev;
    @JsonProperty("travel_variance")
    private Double travelVariance;
    @JsonProperty("default_skill")
    private Double defaultSkill;
    @JsonProperty("reaction_time")
    private Double reactionTime;
    @JsonProperty("regen_periodicity")
    private Double regenPeriodicity;
    @JsonProperty("ignite_sampling_delta")
    private Double igniteSamplingDelta;
    @JsonProperty("fixed_time")
    private Boolean fixedTime;
    @JsonProperty("optimize_expressions")
    private Boolean optimizeExpressions;
    @JsonProperty("optimal_raid")
    private Integer optimalRaid;
    @JsonProperty("log")
    private Integer log;
    @JsonProperty("debug_each")
    private Integer debugEach;
    @JsonProperty("auto_ready_trigger")
    private Integer autoReadyTrigger;
    @JsonProperty("stat_cache")
    private Integer statCache;
    @JsonProperty("max_aoe_enemies")
    private Integer maxAoeEnemies;
    @JsonProperty("show_etmi")
    private Boolean showEtmi;
    @JsonProperty("tmi_window_global")
    private Double tmiWindowGlobal;
    @JsonProperty("tmi_bin_size")
    private Double tmiBinSize;
    @JsonProperty("enemy_death_pct")
    private Double enemyDeathPct;
    @JsonProperty("challenge_mode")
    private Boolean challengeMode;
    @JsonProperty("timewalk")
    private Integer timewalk;
    @JsonProperty("pvp_crit")
    private Boolean pvpCrit;
    @JsonProperty("rng")
    private Rng rng;
    @JsonProperty("deterministic")
    private Integer deterministic;
    @JsonProperty("average_range")
    private Integer averageRange;
    @JsonProperty("average_gauss")
    private Integer averageGauss;
    @JsonProperty("fight_style")
    private String fightStyle;
    @JsonProperty("default_aura_delay")
    private Double defaultAuraDelay;
    @JsonProperty("default_aura_delay_stddev")
    private Double defaultAuraDelayStddev;
    @JsonProperty("dbc")
    private Dbc dbc;
    private final static long serialVersionUID = -5332417615632338648L;

}
