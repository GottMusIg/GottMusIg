package com.gottmusig.gottmusig.model.wowhead;

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

}
