package com.gottmusig.gottmusig.model.blizzard;

public enum BlizzardParams {
	
	PROTOCOL("https://"),
	BASE_URL(".api.battle.net/wow"),
	DEFAULT_REGION("eu"),
	ITEM_PARA("item"),
	CHAR_PARAM("character"),
	API_KEY("4wcyh4e4m52gg5rs9tquqzjgt4p29ax2");
	
	
	private String param;
	
	private BlizzardParams(String param) {
		this.param = param;
	}
	
	public String getParam(){
		return param;
	}
	
	
	public static String getBaseUrlFor(String region){
		return PROTOCOL.getParam()+region+BASE_URL.getParam();
		
		
		
	}
	

}
