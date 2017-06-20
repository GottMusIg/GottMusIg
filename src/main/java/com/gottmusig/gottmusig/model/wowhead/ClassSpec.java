package com.gottmusig.gottmusig.model.wowhead;

import static com.gottmusig.gottmusig.model.wowhead.Classes.DEATH_KNIGHT;
import static com.gottmusig.gottmusig.model.wowhead.Classes.DEMON_HUNTER;
import static com.gottmusig.gottmusig.model.wowhead.Classes.DRUID;
import static com.gottmusig.gottmusig.model.wowhead.Classes.HUNTER;
import static com.gottmusig.gottmusig.model.wowhead.Classes.MAGE;
import static com.gottmusig.gottmusig.model.wowhead.Classes.MONK;
import static com.gottmusig.gottmusig.model.wowhead.Classes.PALADIN;
import static com.gottmusig.gottmusig.model.wowhead.Classes.PRIEST;
import static com.gottmusig.gottmusig.model.wowhead.Classes.ROGUE;
import static com.gottmusig.gottmusig.model.wowhead.Classes.SHAMAN;
import static com.gottmusig.gottmusig.model.wowhead.Classes.WARLOCK;
import static com.gottmusig.gottmusig.model.wowhead.Classes.WARRIOR;
import java.util.ArrayList;
import java.util.List;

public enum ClassSpec {

	DEATH_KNIGHT_ANY(DEATH_KNIGHT),
	DEATH_KNIGHT_BLOOD(DEATH_KNIGHT, 250),
	DEATH_KNIGHT_FROST(DEATH_KNIGHT, 251),
	DEATH_KNIGHT_UNHOLY(DEATH_KNIGHT, 252),
	
	DEMON_HUNTER_ANY(DEMON_HUNTER),
	DEAMON_HUNTER_HAVOC(DEMON_HUNTER, 577),
	DEAMON_HUNTER_VENEGEANCE(DEMON_HUNTER, 581),
	
	DRUIDE_ANY(DRUID),
	DRUIDE_BALANCE(DRUID, 102),
	DRUIDE_FERAL(DRUID,103),
	DRUIDE_GUARDIAN(DRUID,104),
	DRUIDE_RESTORATION(DRUID,105),
	
	HUNTER_ANY(HUNTER),
	HUNTER_BEAST_MASTERY(HUNTER, 253),
	HUNTER_MARKSMANSHIP(HUNTER, 254),
	HUNTER_SURVIVAL(HUNTER, 255),
	
	MAGE_ANY(MAGE),
	MAGE_ARCANE(MAGE, 62),
	MAGE_FIRE(MAGE, 63),
	MAGE_FROST(MAGE, 64),

	MONK_ANY(MONK),
	MONK_BREWMASTER(MONK, 268),
	MONK_WINDWALKER(MONK, 269),
	MONK_MISTWEAVER(MONK, 270),
	
	PALADIN_ANY(PALADIN),
	PLALADIN_HOLY(PALADIN, 65),
	PALADIN_PROTECTION(PALADIN, 66),
	PALADIN_RETRIBUTION(PALADIN, 70),
	
	PRIEST_ANY(Classes.PRIEST),
	PRIEST_DISCIPLINE(PRIEST, 256),
	PRIEST_HOLY(PRIEST, 257),
	PRIEST_SHADOW(PRIEST, 258),
	
	ROUGE_ANY(ROGUE),
	ROUGE_ASSASSINATION(ROGUE, 259),
	ROUGE_OUTLAW(ROGUE, 260),
	ROUGE_SUBTLETY(ROGUE, 261),
	
	SHAMAN_ANY(SHAMAN),
	SHAMAN_ELEMENTAL(SHAMAN, 262),
	SHAMAN_ENHANCEMENT(SHAMAN, 263),
	SHAMAN_RESTORATION(SHAMAN, 264),
	
	WARLOCK_ANY(WARLOCK),
	WARLOCK_AFFLICTION(WARLOCK, 265),
	WARLOCK_DEMONOLOGY(WARLOCK, 266),
	WARLOCK_RESTORATION(WARLOCK, 267),
	
	WARRIOR_ANY(WARRIOR),
	WARRIOR_ARMS(WARRIOR, 71),
	WARRIOR_FURY(WARRIOR, 72),
	WARRIOR_PROTECTION(WARRIOR, 73);

	private int id;
	private Classes clazz;

	ClassSpec(Classes clazz, int id){
		this.clazz = clazz;
		this.id = id;
	}

	ClassSpec(Classes wowClass){
		this.id = wowClass.getID();
	}

	public Filters getFilter(){
		Filters specFilter = Filters.LOOT_SPECIALIZATION;
		Filters.LOOT_SPECIALIZATION.setSpec(this);
		return specFilter;
	}
	
	public int getId(){
		return id;
	}

	public Classes getClazz(){
		return clazz;
	}

	public static List<ClassSpec> getSpecBy(Classes clazz){

		List<ClassSpec> specs = new ArrayList<>();

		for(ClassSpec spec : ClassSpec.values()){
			if(clazz.equals(spec.getClazz())){
				specs.add(spec);
			}
		}
		return specs;
	}
	
}
