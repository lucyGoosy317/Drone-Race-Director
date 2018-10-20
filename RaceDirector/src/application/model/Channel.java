package application.model;



public class Channel {
	
	public String channelName;
	
	
	/**
	 * 
	 * @param channelName will accept a String object and set to channelName
	 */
	public Channel(String channelName) {
		this.channelName=channelName;
		
	}


	/**
	 * 
	 * @return will return String channelName
	 */
	public String getChannelName() {
		return channelName;
	}

	
	/**
	 * 
	 * @param channelName will accept a String object and set to channelName
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	//only to view if channels are loading correctly
	/**
	 * @return will return channelName
	 */
	public String toString() {
		String ret="";
		
		ret=channelName+"\n";
		return ret;
	}

}
