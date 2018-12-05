package application.model;

import java.util.ArrayList;

/**
 * Represents a Pilot that can be uploaded into heats
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class Pilots {
	
	public String pilotName;
	public Channel pilotChannel;
	public int pilotPlace;
	public int currentScore;
	//will change once score class is created
	public ArrayList<Integer> pilotsScore;
	public int Total; 
	
	
	
	//**************Constructor**************
	/**
	 * Constructor that creates pilot object
	 * 
	 * @param pilotName will accept an String value 
	 * @param pilotChannel will accept an Channel object
	 * @param pilotScore will accept an int value
	 */
	public Pilots(String pilotName, Channel pilotChannel) {
		this.pilotName=pilotName;
		this.pilotChannel=pilotChannel;
		//place holder for each round of scores
		pilotsScore=new ArrayList<Integer>();
		//can be used to add all scores of pilot and stored
		pilotPlace=0;
		currentScore=0;
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

/**
 * Returns currentScore for pilot
 * 
 * @return
 */
	public int getCurrentScore() {
		return currentScore;
	}

/**
 * Sets currentScore for pilot
 * 
 * @param currentScore
 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

/**
 * Returns pilotPlace for pilot
 * 
 * @return
 */
	public int getPilotPlace() {
		return pilotPlace;
	}

/**
 * Sets pilotPlace for pilot
 * 
 * @param pilotPlace
 */
	public void setPilotPlace(int pilotPlace) {
		this.pilotPlace = pilotPlace;
	}

/**
 * Returns score total for pilot
 * 
 * @return
 */
	public int getTotal() {
		return Total;
	}

/**
 * Sets score total for pilot
 * 
 * @param total
 */
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

/**
 * Returns pilot's score from collection
 * 
 * @return
 */
	public ArrayList<Integer> getPilotsScore() {
		return pilotsScore;
	}

/**
 * Sets pilot's score to collection
 * 
 * @param pilotsScore
 */
	public void setPilotsScore(ArrayList<Integer> pilotsScore) {
		this.pilotsScore = pilotsScore;
	}


	/**
	 * @return will show pilotName,channel,score of pilot
	 * toString only to view if pilots are loading correctly
	 */
	public String toString() {
		String ret=pilotName+" "+pilotChannel.toString()+"\n";
		
	
		
		return ret;
	}
	

}
