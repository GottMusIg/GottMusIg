package com.gottmusig.gottmusig.model.wowhead;

import com.gottmusig.gottmusig.model.blizzard.WowChar;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Classes {
		
	WARRIOR(1),
	PALADIN(2),
	HUNTER(3),
	ROGUE(4),
	PRIEST(5),
	DEATH_KNIGHT(6),
	SHAMAN(7),
	MAGE(8),
	WARLOCK(9),
	MONK(10),
	DRUID(11),
	DEMON_HUNTER(12);
	
	
	private final int id;
	public static final String paramClass = "class";
	
	
	Classes(int id){
		this.id = id;
	}
	
	public String getURLPart(){
		return paramClass+":"+id+"/";
	}
	
	public int getID(){
		return id;
	}

	public static Classes getClassIdFor(WowChar wowChar){
		
		int id = wowChar.getClass_();
		
		for(Classes WoWclass : Classes.values()){
			if((WoWclass.getID()) == id){
				log.debug("Found class with id= "+id);
				return WoWclass;
			}
		}
		return null; //TODO
	}
	
	public static Classes findClassByName(String name){
		for(Classes wowClasse : Classes.values()){
			if(wowClasse.name().equalsIgnoreCase(name)){
				return wowClasse;
			}
		}
		return null; //TODO
	}

	public static Classes findClassById(int id){
		for(Classes wowClasse : Classes.values()){
			if(wowClasse.getID() == id){
				return wowClasse;
			}
		}
		return null; //TODO
	}

}
