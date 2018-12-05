package application.model;

import java.util.ArrayList;
/**
 * Represents a Round that holds designated amount of heats
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class Round {
	
	
	public  ArrayList<Heat>heat;
	public String roundName;
	
	
	//************Constructor*******************
	public Round(String roundName) {
		this.roundName=roundName;
		heat=new ArrayList<Heat>();
		
	}

	
	//***********getters & Setter***************
	/**
	 * Returns heats
	 * 
	 * @return
	 */
	public ArrayList<Heat> getHeat() {
		return heat;
	}
/**
 * Sets heats
 * 
 * @param heat
 */
	public  void setHeat(ArrayList<Heat> heat) {
		this.heat = heat;
	}
/**
 * Returns round name
 * 
 * @return
 */
	public String getRoundName() {
		return roundName;
	}
/**
 * Sets round name
 * 
 * @param roundName
 */
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	
	
	//**************methods**********************
	/**
	 * Adds Heat to collection
	 * 
	 * @param newHeat
	 */
	public void addHeats(Heat newHeat) {
		heat.add(newHeat);
	}
	/**
	 * Removes Heat from collection
	 * 
	 * @param oldHeat
	 */
	public void removeHeat(Heat oldHeat) {
		heat.remove(oldHeat);
	}
	
	/**
	 * Returns number of Heats
	 * 
	 * @param numberOfHeats
	 */
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
	/**
	 * Returns round name and heat string representation
	 * 
	 * @return
	 */
	public String toString() {
		String ret="";
		for(int i=0;i<heat.size();i++) {
			ret+=roundName+"\n"+heat.toString()+"\n"+"************************************"+"\n";
		}
		return ret;
	}

	
	
	
	

}
