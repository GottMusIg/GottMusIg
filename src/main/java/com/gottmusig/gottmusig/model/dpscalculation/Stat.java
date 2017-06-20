
package com.gottmusig.gottmusig.model.dpscalculation;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "name",
    "type",
    "num_executes",
    "school",
    "total_execute_time",
    "portion_aps",
    "portion_apse",
    "portion_amount",
    "actual_amount",
    "total_amount",
    "total_intervals",
    "num_direct_results",
    "direct_results",
    "resource_gain",
    "num_ticks",
    "num_tick_results",
    "total_tick_time",
    "tick_results",
    "num_refreshes"
})
@Getter
public class Stat implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("num_executes")
    private NumExecutes numExecutes;
    @JsonProperty("school")
    private String school;
    @JsonProperty("total_execute_time")
    private TotalExecuteTime totalExecuteTime;
    @JsonProperty("portion_aps")
    private PortionAps portionAps;
    @JsonProperty("portion_apse")
    private PortionApse portionApse;
    @JsonProperty("portion_amount")
    private Double portionAmount;
    @JsonProperty("actual_amount")
    private ActualAmount actualAmount;
    @JsonProperty("total_amount")
    private TotalAmount totalAmount;
    @JsonProperty("total_intervals")
    private TotalIntervals totalIntervals;
    @JsonProperty("num_direct_results")
    private NumDirectResults numDirectResults;
    @JsonProperty("direct_results")
    private DirectResults directResults;
    @JsonProperty("resource_gain")
    private ResourceGain resourceGain;
    @JsonProperty("num_ticks")
    private NumTicks numTicks;
    @JsonProperty("num_tick_results")
    private NumTickResults numTickResults;
    @JsonProperty("total_tick_time")
    private TotalTickTime totalTickTime;
    @JsonProperty("tick_results")
    private TickResults tickResults;
    @JsonProperty("num_refreshes")
    private NumRefreshes numRefreshes;
    private final static long serialVersionUID = 8821516441731253390L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("num_executes")
    public NumExecutes getNumExecutes() {
        return numExecutes;
    }

    @JsonProperty("num_executes")
    public void setNumExecutes(NumExecutes numExecutes) {
        this.numExecutes = numExecutes;
    }

    @JsonProperty("school")
    public String getSchool() {
        return school;
    }

    @JsonProperty("school")
    public void setSchool(String school) {
        this.school = school;
    }

    @JsonProperty("total_execute_time")
    public TotalExecuteTime getTotalExecuteTime() {
        return totalExecuteTime;
    }

    @JsonProperty("total_execute_time")
    public void setTotalExecuteTime(TotalExecuteTime totalExecuteTime) {
        this.totalExecuteTime = totalExecuteTime;
    }

    @JsonProperty("portion_aps")
    public PortionAps getPortionAps() {
        return portionAps;
    }

    @JsonProperty("portion_aps")
    public void setPortionAps(PortionAps portionAps) {
        this.portionAps = portionAps;
    }

    @JsonProperty("portion_apse")
    public PortionApse getPortionApse() {
        return portionApse;
    }

    @JsonProperty("portion_apse")
    public void setPortionApse(PortionApse portionApse) {
        this.portionApse = portionApse;
    }

    @JsonProperty("portion_amount")
    public Double getPortionAmount() {
        return portionAmount;
    }

    @JsonProperty("portion_amount")
    public void setPortionAmount(Double portionAmount) {
        this.portionAmount = portionAmount;
    }

    @JsonProperty("actual_amount")
    public ActualAmount getActualAmount() {
        return actualAmount;
    }

    @JsonProperty("actual_amount")
    public void setActualAmount(ActualAmount actualAmount) {
        this.actualAmount = actualAmount;
    }

    @JsonProperty("total_amount")
    public TotalAmount getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("total_amount")
    public void setTotalAmount(TotalAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("total_intervals")
    public TotalIntervals getTotalIntervals() {
        return totalIntervals;
    }

    @JsonProperty("total_intervals")
    public void setTotalIntervals(TotalIntervals totalIntervals) {
        this.totalIntervals = totalIntervals;
    }

    @JsonProperty("num_direct_results")
    public NumDirectResults getNumDirectResults() {
        return numDirectResults;
    }

    @JsonProperty("num_direct_results")
    public void setNumDirectResults(NumDirectResults numDirectResults) {
        this.numDirectResults = numDirectResults;
    }

    @JsonProperty("direct_results")
    public DirectResults getDirectResults() {
        return directResults;
    }

    @JsonProperty("direct_results")
    public void setDirectResults(DirectResults directResults) {
        this.directResults = directResults;
    }

    @JsonProperty("resource_gain")
    public ResourceGain getResourceGain() {
        return resourceGain;
    }

    @JsonProperty("resource_gain")
    public void setResourceGain(ResourceGain resourceGain) {
        this.resourceGain = resourceGain;
    }

    @JsonProperty("num_ticks")
    public NumTicks getNumTicks() {
        return numTicks;
    }

    @JsonProperty("num_ticks")
    public void setNumTicks(NumTicks numTicks) {
        this.numTicks = numTicks;
    }

    @JsonProperty("num_tick_results")
    public NumTickResults getNumTickResults() {
        return numTickResults;
    }

    @JsonProperty("num_tick_results")
    public void setNumTickResults(NumTickResults numTickResults) {
        this.numTickResults = numTickResults;
    }

    @JsonProperty("total_tick_time")
    public TotalTickTime getTotalTickTime() {
        return totalTickTime;
    }

    @JsonProperty("total_tick_time")
    public void setTotalTickTime(TotalTickTime totalTickTime) {
        this.totalTickTime = totalTickTime;
    }

    @JsonProperty("tick_results")
    public TickResults getTickResults() {
        return tickResults;
    }

    @JsonProperty("tick_results")
    public void setTickResults(TickResults tickResults) {
        this.tickResults = tickResults;
    }

    @JsonProperty("num_refreshes")
    public NumRefreshes getNumRefreshes() {
        return numRefreshes;
    }

    @JsonProperty("num_refreshes")
    public void setNumRefreshes(NumRefreshes numRefreshes) {
        this.numRefreshes = numRefreshes;
    }

}
