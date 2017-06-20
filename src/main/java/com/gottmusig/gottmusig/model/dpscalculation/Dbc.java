
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
    "Live",
    "PTR",
    "version_used"
})
@Getter
public class Dbc implements Serializable
{

    @JsonProperty("Live")
    private Live live;
    @JsonProperty("PTR")
    private PTR pTR;
    @JsonProperty("version_used")
    private String versionUsed;
    private final static long serialVersionUID = 3050523292210624847L;

}
