
package com.gottmusig.gottmusig.model.blizzard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gottmusig.gottmusig.gateway.WowHeadDatabaseGateway;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "disenchantingSkillRank",
    "description",
    "name",
    "icon",
    "stackable",
    "allowableClasses",
    "allowableRaces",
    "itemBind",
    "bonusStats",
    "itemSpells",
    "buyPrice",
    "itemClass",
    "itemSubClass",
    "containerSlots",
    "inventoryType",
    "equippable",
    "itemLevel",
    "itemSet",
    "maxCount",
    "maxDurability",
    "minFactionId",
    "minReputation",
    "quality",
    "sellPrice",
    "requiredSkill",
    "requiredLevel",
    "requiredSkillRank",
    "itemSource",
    "baseArmor",
    "hasSockets",
    "isAuctionable",
    "armor",
    "displayInfoId",
    "nameDescription",
    "nameDescriptionColor",
    "upgradable",
    "heroicTooltip",
    "context",
    "bonusLists",
    "availableContexts",
    "bonusSummary",
    "artifactId"
})

@Slf4j
@EqualsAndHashCode(of={"name","context"})
public class BlizzardItem {
	
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("disenchantingSkillRank")
    private Integer disenchantingSkillRank;
    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("stackable")
    private Integer stackable;
    @JsonProperty("allowableClasses")
    private List<Integer> allowableClasses = null;
    @JsonProperty("allowableRaces")
    private List<Integer> allowableRaces = null;
    @JsonProperty("itemBind")
    private Integer itemBind;
    @JsonProperty("bonusStats")
    private List<BonusStat> bonusStats = null;
    @JsonProperty("itemSpells")
    private List<Object> itemSpells = null;
    @JsonProperty("buyPrice")
    private Integer buyPrice;
    @JsonProperty("itemClass")
    private Integer itemClass;
    @JsonProperty("itemSubClass")
    private Integer itemSubClass;
    @JsonProperty("containerSlots")
    private Integer containerSlots;
    @JsonProperty("inventoryType")
    private Integer inventoryType;
    @JsonProperty("equippable")
    private Boolean equippable;
    @JsonProperty("itemLevel")
    private Integer itemLevel;
    @JsonProperty("itemSet")
    private ItemSet itemSet;
    @JsonProperty("maxCount")
    private Integer maxCount;
    @JsonProperty("maxDurability")
    private Integer maxDurability;
    @JsonProperty("minFactionId")
    private Integer minFactionId;
    @JsonProperty("minReputation")
    private Integer minReputation;
    @JsonProperty("quality")
    private Integer quality;
    @JsonProperty("sellPrice")
    private Integer sellPrice;
    @JsonProperty("requiredSkill")
    private Integer requiredSkill;
    @JsonProperty("requiredLevel")
    private Integer requiredLevel;
    @JsonProperty("requiredSkillRank")
    private Integer requiredSkillRank;
    @JsonProperty("itemSource")
    private ItemSource itemSource;
    @JsonProperty("baseArmor")
    private Integer baseArmor;
    @JsonProperty("hasSockets")
    private Boolean hasSockets;
    @JsonProperty("isAuctionable")
    private Boolean isAuctionable;
    @JsonProperty("armor")
    private Integer armor;
    @JsonProperty("displayInfoId")
    private Integer displayInfoId;
    @JsonProperty("nameDescription")
    private String nameDescription;
    @JsonProperty("nameDescriptionColor")
    private String nameDescriptionColor;
    @JsonProperty("upgradable")
    private Boolean upgradable;
    @JsonProperty("heroicTooltip")
    private Boolean heroicTooltip;
    @JsonProperty("context")
    private String context;
    @JsonProperty("bonusLists")
    private List<Integer> bonusLists = null;
    @JsonProperty("availableContexts")
    private List<String> availableContexts = null;
    @JsonProperty("bonusSummary")
    private BonusSummary bonusSummary;
    @JsonProperty("artifactId")
    private Integer artifactId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("disenchantingSkillRank")
    public Integer getDisenchantingSkillRank() {
        return disenchantingSkillRank;
    }

    @JsonProperty("disenchantingSkillRank")
    public void setDisenchantingSkillRank(Integer disenchantingSkillRank) {
        this.disenchantingSkillRank = disenchantingSkillRank;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("stackable")
    public Integer getStackable() {
        return stackable;
    }

    @JsonProperty("stackable")
    public void setStackable(Integer stackable) {
        this.stackable = stackable;
    }

    @JsonProperty("allowableClasses")
    public List<Integer> getAllowableClasses() {
        return allowableClasses;
    }
   
    @JsonProperty("allowableClasses")
    public void setAllowableClasses(List<Integer> allowableClasses) {
        this.allowableClasses = allowableClasses;
    }
    
    @JsonProperty("allowableRaces")
    public List<Integer> getAllowableRaces() {
    return allowableRaces;
    }

    @JsonProperty("allowableRaces")
    public void setAllowableRaces(List<Integer> allowableRaces) {
    this.allowableRaces = allowableRaces;
    }
    
    @JsonProperty("itemBind")
    public Integer getItemBind() {
        return itemBind;
    }

    @JsonProperty("itemBind")
    public void setItemBind(Integer itemBind) {
        this.itemBind = itemBind;
    }

    @JsonProperty("bonusStats")
    public List<BonusStat> getBonusStats() {
        return bonusStats;
    }

    @JsonProperty("bonusStats")
    public void setBonusStats(List<BonusStat> bonusStats) {
        this.bonusStats = bonusStats;
    }

    @JsonProperty("itemSpells")
    public List<Object> getItemSpells() {
        return itemSpells;
    }

    @JsonProperty("itemSpells")
    public void setItemSpells(List<Object> itemSpells) {
        this.itemSpells = itemSpells;
    }

    @JsonProperty("buyPrice")
    public Integer getBuyPrice() {
        return buyPrice;
    }

    @JsonProperty("buyPrice")
    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    @JsonProperty("itemClass")
    public Integer getItemClass() {
        return itemClass;
    }

    @JsonProperty("itemClass")
    public void setItemClass(Integer itemClass) {
        this.itemClass = itemClass;
    }

    @JsonProperty("itemSubClass")
    public Integer getItemSubClass() {
        return itemSubClass;
    }

    @JsonProperty("itemSubClass")
    public void setItemSubClass(Integer itemSubClass) {
        this.itemSubClass = itemSubClass;
    }

    @JsonProperty("containerSlots")
    public Integer getContainerSlots() {
        return containerSlots;
    }

    @JsonProperty("containerSlots")
    public void setContainerSlots(Integer containerSlots) {
        this.containerSlots = containerSlots;
    }

    @JsonProperty("inventoryType")
    public Integer getInventoryType() {
        return inventoryType;
    }

    @JsonProperty("inventoryType")
    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }

    @JsonProperty("equippable")
    public Boolean getEquippable() {
        return equippable;
    }

    @JsonProperty("equippable")
    public void setEquippable(Boolean equippable) {
        this.equippable = equippable;
    }

    @JsonProperty("itemLevel")
    public Integer getItemLevel() {
        return itemLevel;
    }

    @JsonProperty("itemLevel")
    public void setItemLevel(Integer itemLevel) {
        this.itemLevel = itemLevel;
    }

    @JsonProperty("itemSet")
    public ItemSet getItemSet() {
        return itemSet;
    }

    @JsonProperty("itemSet")
    public void setItemSet(ItemSet itemSet) {
        this.itemSet = itemSet;
    }

    @JsonProperty("maxCount")
    public Integer getMaxCount() {
        return maxCount;
    }

    @JsonProperty("maxCount")
    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    @JsonProperty("maxDurability")
    public Integer getMaxDurability() {
        return maxDurability;
    }

    @JsonProperty("maxDurability")
    public void setMaxDurability(Integer maxDurability) {
        this.maxDurability = maxDurability;
    }

    @JsonProperty("minFactionId")
    public Integer getMinFactionId() {
        return minFactionId;
    }

    @JsonProperty("minFactionId")
    public void setMinFactionId(Integer minFactionId) {
        this.minFactionId = minFactionId;
    }

    @JsonProperty("minReputation")
    public Integer getMinReputation() {
        return minReputation;
    }

    @JsonProperty("minReputation")
    public void setMinReputation(Integer minReputation) {
        this.minReputation = minReputation;
    }

    @JsonProperty("quality")
    public Integer getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @JsonProperty("sellPrice")
    public Integer getSellPrice() {
        return sellPrice;
    }

    @JsonProperty("sellPrice")
    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    @JsonProperty("requiredSkill")
    public Integer getRequiredSkill() {
        return requiredSkill;
    }

    @JsonProperty("requiredSkill")
    public void setRequiredSkill(Integer requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    @JsonProperty("requiredLevel")
    public Integer getRequiredLevel() {
        return requiredLevel;
    }

    @JsonProperty("requiredLevel")
    public void setRequiredLevel(Integer requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @JsonProperty("requiredSkillRank")
    public Integer getRequiredSkillRank() {
        return requiredSkillRank;
    }

    @JsonProperty("requiredSkillRank")
    public void setRequiredSkillRank(Integer requiredSkillRank) {
        this.requiredSkillRank = requiredSkillRank;
    }

    @JsonProperty("itemSource")
    public ItemSource getItemSource() {
        return itemSource;
    }

    @JsonProperty("itemSource")
    public void setItemSource(ItemSource itemSource) {
        this.itemSource = itemSource;
    }

    @JsonProperty("baseArmor")
    public Integer getBaseArmor() {
        return baseArmor;
    }

    @JsonProperty("baseArmor")
    public void setBaseArmor(Integer baseArmor) {
        this.baseArmor = baseArmor;
    }

    @JsonProperty("hasSockets")
    public Boolean getHasSockets() {
        return hasSockets;
    }

    @JsonProperty("hasSockets")
    public void setHasSockets(Boolean hasSockets) {
        this.hasSockets = hasSockets;
    }

    @JsonProperty("isAuctionable")
    public Boolean getIsAuctionable() {
        return isAuctionable;
    }

    @JsonProperty("isAuctionable")
    public void setIsAuctionable(Boolean isAuctionable) {
        this.isAuctionable = isAuctionable;
    }

    @JsonProperty("armor")
    public Integer getArmor() {
        return armor;
    }

    @JsonProperty("armor")
    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    @JsonProperty("displayInfoId")
    public Integer getDisplayInfoId() {
        return displayInfoId;
    }

    @JsonProperty("displayInfoId")
    public void setDisplayInfoId(Integer displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    @JsonProperty("nameDescription")
    public String getNameDescription() {
        return nameDescription;
    }

    @JsonProperty("nameDescription")
    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    @JsonProperty("nameDescriptionColor")
    public String getNameDescriptionColor() {
        return nameDescriptionColor;
    }

    @JsonProperty("nameDescriptionColor")
    public void setNameDescriptionColor(String nameDescriptionColor) {
        this.nameDescriptionColor = nameDescriptionColor;
    }

    @JsonProperty("upgradable")
    public Boolean getUpgradable() {
        return upgradable;
    }

    @JsonProperty("upgradable")
    public void setUpgradable(Boolean upgradable) {
        this.upgradable = upgradable;
    }

    @JsonProperty("heroicTooltip")
    public Boolean getHeroicTooltip() {
        return heroicTooltip;
    }

    @JsonProperty("heroicTooltip")
    public void setHeroicTooltip(Boolean heroicTooltip) {
        this.heroicTooltip = heroicTooltip;
    }

    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("bonusLists")
    public List<Integer> getBonusLists() {
        return bonusLists;
    }

    @JsonProperty("bonusLists")
    public void setBonusLists(List<Integer> bonusLists) {
        this.bonusLists = bonusLists;
    }

    @JsonProperty("availableContexts")
    public List<String> getAvailableContexts() {
        return availableContexts;
    }

    @JsonProperty("availableContexts")
    public void setAvailableContexts(List<String> availableContexts) {
        this.availableContexts = availableContexts;
    }

    @JsonProperty("bonusSummary")
    public BonusSummary getBonusSummary() {
        return bonusSummary;
    }

    @JsonProperty("bonusSummary")
    public void setBonusSummary(BonusSummary bonusSummary) {
        this.bonusSummary = bonusSummary;
    }

    @JsonProperty("artifactId")
    public Integer getArtifactId() {
        return artifactId;
    }

    @JsonProperty("artifactId")
    public void setArtifactId(Integer artifactId) {
        this.artifactId = artifactId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
       
    public String getWowHeadToolTipLink(){
    	String url =  WowHeadDatabaseGateway.BASE_URL+"item="+this.id;
    	
    	if(this.bonusLists != null && !this.bonusLists.isEmpty()){
    		url += "&bonus="+bonusLists.get(0);
    	}
    	return url; 	
    }
}
