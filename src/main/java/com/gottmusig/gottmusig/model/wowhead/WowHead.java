
package com.gottmusig.gottmusig.model.wowhead;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.extern.slf4j.Slf4j;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items"
})

@Slf4j
public class WowHead implements Serializable {

    @JsonProperty("items")
    private List<WowHeadItem> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("items")
    public List<WowHeadItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<WowHeadItem> items) {
        this.items = removeDoubleItems2(items);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    private List<WowHeadItem> removeDoubleItems(List<WowHeadItem> originalList){
        log.debug("Original item size: "+originalList.size());
        List<WowHeadItem> deduped = originalList.stream().distinct().collect(Collectors.toList());
        log.debug("New size :"+deduped.size());
        return deduped;
    }

    private List<WowHeadItem> removeDoubleItems2(List<WowHeadItem> items){

        return new ArrayList<WowHeadItem>(new LinkedHashSet<WowHeadItem>(items));

    }

}
