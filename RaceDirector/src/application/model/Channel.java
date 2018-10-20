package application.model;



public class Channel {
	
	public String channelName;
	
	
	
	public Channel(String channelName) {
		this.channelName=channelName;
		
	}



	public String getChannelName() {
		return channelName;
	}



	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	
	public String toString() {
		String ret="";
		
		ret=channelName+"\n";
		return ret;
	}

}
