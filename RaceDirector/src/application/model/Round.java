package application.model;

import java.util.ArrayList;

public class Round {
	
	
	public ArrayList<Heat>heat;
	public String roundName;
	
	//************Constructor*******************
	public Round(String roundName) {
		this.roundName=roundName;
		heat=new ArrayList<Heat>();
		
	}

	
	//***********getters & Setter***************
	
	public ArrayList<Heat> getHeat() {
		return heat;
	}

	public void setHeat(ArrayList<Heat> heat) {
		this.heat = heat;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	
	
	//**************methods**********************
	public void addHeats(Heat newHeat) {
		heat.add(newHeat);
	}
	public void createNewHeat(String numberOfHeats) {
		int numOfHeats=Integer.parseInt(numberOfHeats);
		int heatCount=1;
		for(int i=0;i<numOfHeats;i++) {
			Heat newHeat=new Heat("Heat:"+heatCount);
			heatCount++;
			heat.add(newHeat);
			
			
		}
	}
	
	
	//*************toString**********************
	public String toString() {
		String ret="";
		for(int i=0;i<heat.size();i++) {
			ret+=roundName+"\n"+heat.toString()+"\n"+"************************************";
		}
		return ret;
	}

	
	
	
	

}
