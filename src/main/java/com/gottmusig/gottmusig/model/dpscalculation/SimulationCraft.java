
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
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
    "version",
    "ptr_enabled",
    "beta_enabled",
    "build_date",
    "build_time",
    "git_revision",
    "sim"
})
@Getter
public class SimulationCraft implements Serializable
{

    @JsonProperty("version")
    private String version;
    @JsonProperty("ptr_enabled")
    private Integer ptrEnabled;
    @JsonProperty("beta_enabled")
    private Integer betaEnabled;
    @JsonProperty("build_date")
    private String buildDate;
    @JsonProperty("build_time")
    private String buildTime;
    @JsonProperty("git_revision")
    private String gitRevision;
    @JsonProperty("sim")
    private Sim sim;
    private final static long serialVersionUID = 8833734967808221722L;

}
