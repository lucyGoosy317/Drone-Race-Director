package application.model;

public class Pilots {
	
	public String pilotName;
	public Channel pilotChannel;
	public String pilotScore;
	
	
	
	//**************Constructor**************
	/**
	 * 
	 * @param pilotName will accept an String value 
	 * @param pilotChannel will accept an Channel object
	 * @param pilotScore will accept an int value
	 */
	public Pilots(String pilotName, Channel pilotChannel, String pilotScore) {
		this.pilotName=pilotName;
		this.pilotChannel=pilotChannel;
		this.pilotScore=pilotScore;
		
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
	 * 
	 * @return will return int object of pilotScore
	 */
	public String getPilotScore() {
		return pilotScore;
	}



	/**
	 * 
	 * @param pilotScore accept int as param and will set pilotScore
	 */
	public void setPilotScore(String pilotScore) {
		this.pilotScore = pilotScore;
	}
	
	
	/**
	 * @return will show pilotName,channel,score of pilot
	 * toString only to view if pilots are loading correctly
	 */
	public String toString() {
		String ret="";
		
		
		ret="Pilot Name: "+pilotName+"\n"+ "Pilot Channel: "+pilotChannel.toString()+"\n"+"Pilot Score: "+pilotScore
				+"\n";
		return ret;
	}
	

}
