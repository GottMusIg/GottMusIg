
package com.gottmusig.gottmusig.model.blizzard;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastModified",
    "name",
    "realm",
    "battlegroup",
    "class",
    "race",
    "gender",
    "level",
    "achievementPoints",
    "thumbnail",
    "calcClass",
    "faction",
    "totalHonorableKills"
})
public class WowChar {

    @JsonProperty("lastModified")
    private Long lastModified;
    @JsonProperty("name")
    private String name;
    @JsonProperty("realm")
    private String realm;
    @JsonProperty("battlegroup")
    private String battlegroup;
    @JsonProperty("class")
    private Integer _class;
    @JsonProperty("race")
    private Integer race;
    @JsonProperty("gender")
    private Integer gender;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("achievementPoints")
    private Integer achievementPoints;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("calcClass")
    private String calcClass;
    @JsonProperty("faction")
    private Integer faction;
    @JsonProperty("totalHonorableKills")
    private Integer totalHonorableKills;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lastModified")
    public Long getLastModified() {
        return lastModified;
    }

    @JsonProperty("lastModified")
    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("realm")
    public String getRealm() {
        return realm;
    }

    @JsonProperty("realm")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    @JsonProperty("battlegroup")
    public String getBattlegroup() {
        return battlegroup;
    }

    @JsonProperty("battlegroup")
    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    @JsonProperty("class")
    public Integer getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(Integer _class) {
        this._class = _class;
    }

    @JsonProperty("race")
    public Integer getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(Integer race) {
        this.race = race;
    }

    @JsonProperty("gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("achievementPoints")
    public Integer getAchievementPoints() {
        return achievementPoints;
    }

    @JsonProperty("achievementPoints")
    public void setAchievementPoints(Integer achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("calcClass")
    public String getCalcClass() {
        return calcClass;
    }

    @JsonProperty("calcClass")
    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }

    @JsonProperty("faction")
    public Integer getFaction() {
        return faction;
    }

    @JsonProperty("faction")
    public void setFaction(Integer faction) {
        this.faction = faction;
    }

    @JsonProperty("totalHonorableKills")
    public Integer getTotalHonorableKills() {
        return totalHonorableKills;
    }

    @JsonProperty("totalHonorableKills")
    public void setTotalHonorableKills(Integer totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
