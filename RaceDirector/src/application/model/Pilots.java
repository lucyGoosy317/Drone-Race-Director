package application.model;

public class Pilots {
	
	public String pilotName;
	public Channel pilotChannel;
	public int pilotScore;
	
	
	
	//Constructor
	public Pilots(String pilotName, Channel pilotChannel, int pilotScore) {
		this.pilotName=pilotName;
		this.pilotChannel=pilotChannel;
		this.pilotScore=pilotScore;
		
	}


	//getters & setters
	public String getPilotName() {
		return pilotName;
	}



	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}



	public Channel getPilotChannel() {
		return pilotChannel;
	}



	public void setPilotChannel(Channel pilotChannel) {
		this.pilotChannel = pilotChannel;
	}



	public int getPilotScore() {
		return pilotScore;
	}



	public void setPilotScore(int pilotScore) {
		this.pilotScore = pilotScore;
	}
	
	//toString
	public String toString() {
		String ret="";
		
		
		ret="Pilot Name: "+pilotName+"\n"+ "Pilot Channel: "+pilotChannel.toString()+"\n"+"Pilot Score: "+pilotScore
				+"\n";
		return ret;
	}
	

}
