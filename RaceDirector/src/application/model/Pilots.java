package application.model;

import java.util.ArrayList;

/**
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class Pilots {
	
	public String pilotName;
	public Channel pilotChannel;
	//will change once score class is created
	public static ArrayList<String> pilotsScore;
	public int Total; 
	
	
	
	//**************Constructor**************
	/**
	 * 
	 * @param pilotName will accept an String value 
	 * @param pilotChannel will accept an Channel object
	 * @param pilotScore will accept an int value
	 */
	public Pilots(String pilotName, Channel pilotChannel) {
		this.pilotName=pilotName;
		this.pilotChannel=pilotChannel;
		//place holder for each round of scores
		pilotsScore=new ArrayList<String>();
		//can be used to add all scores of pilot and stored
		Total=0;
		
		
	}


	//***********getters & setters**************
	
	/**
	 * 
	 * @return will return string object of pilotName
	 */
	public String getPilotName() {
		return pilotName;
	}


	public int getTotal() {
		return Total;
	}


	public void setTotal(int total) {
		Total = total;
	}


	/**
	 * 
	 * @param pilotName will accept String object as param and set pilotName
	 */
	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}



	/**
	 * 
	 * @return will return Channel Object of pilotChannel
	 */
	public Channel getPilotChannel() {
		return pilotChannel;
	}



	/**
	 * 
	 * @param pilotChannel will accept Channel Object and will set Pilot Channel
	 */
	public void setPilotChannel(Channel pilotChannel) {
		this.pilotChannel = pilotChannel;
	}

 //TODO change String to Score once Score is create
	public ArrayList<String> getPilotsScore() {
		return pilotsScore;
	}

//TODO change String to Score once Score is create
	public void setPilotsScore(ArrayList<String> pilotsScore) {
		Pilots.pilotsScore = pilotsScore;
	}


	/**
	 * @return will show pilotName,channel,score of pilot
	 * toString only to view if pilots are loading correctly
	 */
	public String toString() {
		String ret="";
		
	//pilot Score is toString here, loop through them to get each value
		ret=pilotName+" "+pilotChannel.toString();
		return ret;
	}
	

}
