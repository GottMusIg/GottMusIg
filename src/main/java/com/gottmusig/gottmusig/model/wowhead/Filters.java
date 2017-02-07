package com.gottmusig.gottmusig.model.wowhead;

public enum Filters {

	CAN_BE_EQUIPPED_YES(195,1,0),
	RACE_SPECIFIC(152,0);
	
	private final int param1;
	private int param2;
	private final int param3;
	
	public static final String FILTER_PARAM = "?filter=";
	
	Filters(int param1, int param2, int param3){
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}
	
	Filters(int param1, int param3){
		this.param1 = param1;
		this.param3 = param3;
		//param 2 wird gesetzt wenn der Race_Specific filter gebraucht wird
	}
	
	public Filters setClass(Classes wowClass){
		if(this.equals(RACE_SPECIFIC)){
			this.param2 = wowClass.getID();
		}
		return this;
	}
	
	public String getUrlPart(){
		return buildUrl(param1, param2, param3);
	}
	
	public int getParam1(){
		return param1;
	}
	
	public int getParam2(){
		return param2;
	}
	
	public int getParam3(){
		return param3;
	}
	
	
	public static String mergeFiltersWith(Filters... filters){
		String param1 = "";
		String param2 = "";
		String param3 = "";
		
		for(Filters filter : filters){
			param1+=filter.getParam1()+":";
			param2+=filter.getParam2()+":";
			param3+=filter.getParam3()+":";
		}
		return buildUrl(param1, param2, param3);
	}
	
	private static String buildUrl(String param1, String param2, String param3){
		return FILTER_PARAM+param1+";"+param2+";"+param3;
	}
	
	private static String buildUrl(int param1, int param2, int param3){
		return buildUrl(""+param1,""+param2, ""+param3);
	}
}
