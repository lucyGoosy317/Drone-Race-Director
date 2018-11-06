package application.model;

import java.util.ArrayList;

/**
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class Heat  {
	
	public static ArrayList<Pilots>PilotsInHeat;
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
	 * @return will return heat name
	 */
	public String toString() {
		String ret="";
		ret=heatName;
		
		return ret;
	}
	
	

}
