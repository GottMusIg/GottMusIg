package com.gottmusig.gottmusig.model.wowhead;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Slot {
	
	HEAD(1, "head="),
	NECK(2, "neck="),
	SHOULDER(3, "shoulders="),
	SHIRT(4),
	CHEST(5, "chest="),
	WAIST(6, "waist="),
	LEGS(7, "legs="),
	FEET(8, "feet="),
	WRIST(9),
	HANDS(10, "hands="),
	FINGER(11, "finger1=", "finger2="),
	TRINKET(12, "trinket1=", "trinket2="),
	ONE_HAND(13),
	SHIELD(14),
	RANGED(15),
	BACK(16, "back="),
	TWO_HAND(17, "main_hand="),
	BAG(18),
	TABARD(19),
	MAIN_HAND(21),
	OFF_HAND(22),
	HELD_IN_OFF_HAND(23),
	PROJECTILE(24),
	THROWN(25),
	RELIC(28);

	private final int id;
	private final List<String> simcCommands = new ArrayList<>();
	public static final String paramSlot = "slot";
	

	private Slot(int id, String... simcCommands){
		this.id = id;
		this.simcCommands.addAll(Arrays.asList(simcCommands));
	}
	

	public int getId(){
		return id;
	}
	
	public List<String> getSimcCommands(){
		return simcCommands;
	}
	
	public String getURLPart(){
		return paramSlot+":"+id+"/";
	}
	
	public static List<String> getSimcCommandFor(String requestedSlot) throws Exception{
		
		Slot slot = findSlotByName(requestedSlot);
		return slot.getSimcCommands();
	}
	
	
	public static Slot findSlotByName(String requestedSlot) throws Exception{
		for(Slot slot : Slot.values()){
			if(slot.name().equalsIgnoreCase(requestedSlot)){
				return slot;
			}
		}
		throw new Exception(); //TODO
	}

	public static Slot findSlotById (int requestedSlot) throws Exception{
		for(Slot slot : Slot.values()){
			if(slot.getId() == requestedSlot){
				return slot;
			}
		}
		throw new Exception(); //TODO
	}

}
