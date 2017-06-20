package com.gottmusig.gottmusig.model.dpscalculation;

public enum SimcCommands {

	//DEFAULT

	COPY("copy="),
	ID("id="),
	BONUS_ID("bonus_id="),
	ARMORY("armory="),
	RESULT("json2="),
	SEPERATOR(","),

	SIMULATE_RAID(""),
	SIMULATE_PLAYER("calculate_scale_factors=0"),
	COMPARE_ITEMS(
			"iterations=500"
					+ "fight_style=\"Patchwerk\" "
					+ "max_time=\"300\" "
					+ "calculate_scale_factors=\"0\" "
					+ "scale_only=\"stamina,strength,intellect,agility,crit,mastery,vers,haste\" "
					+ "single_actor_batch=\"1\" "
					+ "report_details=\"0\" "
					+ "fixed_time=\"1\"");

	private String command;
	
	SimcCommands(String command) {
		this.command = command;
	}

	public String getCommand(){
		return command;
	}

}
