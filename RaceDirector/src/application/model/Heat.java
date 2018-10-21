package application.model;

import java.util.ArrayList;

public class Heat {
	
	public ArrayList<Pilots>PilotsInHeat;
	public String heatName;
	
	/**
	 * 
	 * @param heatName will accept a String value
	 */
	//*********Constructor********************
	
	public Heat(String heatName) {
		this.heatName=heatName;
		
	}

	
	
	
	
	//**********getters & Setter**************
	
	/**
	 * 
	 * @return will return String value of heatName
	 */
	public String getHeatName() {
		return heatName;
	}
	
	/**
	 * 
	 * @param heatName will accept a String object and set to heatName
	 */
	public void setHeatName(String heatName) {
		this.heatName = heatName;
	}
	
		
	//**************Methods*********************
	
	public void addPilotsToHeat(Pilots heatPilot) {
		PilotsInHeat.add(heatPilot);
		
	}
	
	
	
	
		
		
		
	
	
	//************to String**********************
	/**
	 * @return will return all pilots inside heat
	 */
	public String toString() {
		String ret="";
		ret+=heatName+" :\n";
		//to view all the pilots inside the heat
		for(int i=0;i<PilotsInHeat.size();i++) {
			ret+=PilotsInHeat.get(i).toString()+"\n";
		}
		return ret;
	}
	
	

}
