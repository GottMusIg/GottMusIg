
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
    "build_level",
    "wow_version"
})
@Getter
public class Live implements Serializable
{

    @JsonProperty("build_level")
    private Integer buildLevel;
    @JsonProperty("wow_version")
    private String wowVersion;
    private final static long serialVersionUID = -727028113106656259L;

}
