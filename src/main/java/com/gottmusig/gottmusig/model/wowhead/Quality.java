package com.gottmusig.gottmusig.model.wowhead;

public enum Quality {

	POOR(0),
	COMMON(1),
	UNCOMMON(2),
	RARE(3),
	EPIC(4),
	LEGENDARY(5),
	ARTIFACT(6);
	
	private final int id;
	public static final String paramQuality = "quality";
	

	Quality(int id){
		this.id = id;
	}
	
	public String getURLPart(){
		return paramQuality+":"+id+"/";
	}

	public static Quality findQualityByName(String quality){

		for(Quality slotQuality : Quality.values()){

			if(slotQuality.name().equalsIgnoreCase(quality)){
				return slotQuality;
			}

		}

		return  null; //TODO


	}
}
