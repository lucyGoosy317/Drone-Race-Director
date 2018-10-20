package application.model;

import java.util.ArrayList;

public class Heat {
	//this will contain the pilots inside the heat
	ArrayList<Pilots>pilotHeatList;
	String heatName;
	
	/**
	 * 
	 * @param heatName will accept a String value
	 */
	public Heat(String heatName) {
		this.heatName=heatName;
		pilotHeatList=new ArrayList<Pilots>();
	}

	//**********getters & Setter**************
	/**
	 * 
	 * @return will return pilotList
	 */
	public ArrayList<Pilots> getPilotHeatList() {
		return pilotHeatList;
	}

	/**
	 * 
	 * @param pilotHeatList will set pilotList
	 */
	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		this.pilotHeatList = pilotHeatList;
	}

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
	
	
	//************to String**********************
	/**
	 * @return will return all pilots inside heat
	 */
	public String toString() {
		String ret="";
		ret+=heatName+" :\n";
		//to view all the pilots inside the heat
		for(int i=0;i<pilotHeatList.size();i++) {
			ret+=pilotHeatList.get(i)+"\n";
		}
		return ret;
	}
	
	

}
