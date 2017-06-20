package com.gottmusig.gottmusig.model.dpscalculation;

import com.gottmusig.gottmusig.model.wowhead.ClassSpec;
import com.gottmusig.gottmusig.model.wowhead.Classes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SimulationCraftInputs {

	private String region;
	private String server;
	private String user;
	private SimcCommands commandType;
	@Builder.Default
	private String commandString="";

	private Classes clazz;
	private ClassSpec spec;

	public void addCommand(String command){
		this.commandString+=" "+command;
	}


	public String getCommandString(){
		return commandType.getCommand() + " " +  commandString;
	}

	public boolean simulateActualRaid(){
		if(commandType.equals(SimcCommands.SIMULATE_RAID)){
			return true;
		}
		return false;
	}

	public boolean simulateAndCompareItems(){
		if(commandType.equals(SimcCommands.COMPARE_ITEMS)){
			return true;
		}
		return false;
	}

	public boolean simulatePlayer(){
		if(commandType.equals(SimcCommands.SIMULATE_PLAYER)){
			return true;
		}
		return false;
	}
}
