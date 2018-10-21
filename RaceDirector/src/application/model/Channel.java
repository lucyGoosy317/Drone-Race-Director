package application.model;

/**
 * 
 * @author Luziano Reyna vtk064
 *
 */


public class Channel {
	
	public String channelBand;
	public String channelFreq;
	
	
	/**
	 * 
	 * @param channelName will accept a String object and set to channelName
	 */
	public Channel(String channelBand, String channelFreq) {
		this.channelBand=channelBand;
		this.channelFreq=channelFreq;
		
		
	}

	/**
	 * 
	 * @return will return a String object of channelFreq
	 */
	public String getChannelFreq() {
		return channelFreq;
	}

	/**
	 * 
	 * @param channelFreq will accept String and set to channelFreq
	 */
	public void setChannelFreq(String channelFreq) {
		this.channelFreq = channelFreq;
	}


	/**
	 * 
	 * @return will return String channelName
	 */
	public String getChannelBand() {
		return channelBand;
	}

	
	/**
	 * 
	 * @param channelName will accept a String object and set to channelName
	 */
	public void setChannelBand(String channelName) {
		this.channelBand = channelName;
	}
	
	//only to view if channels are loading correctly
	/**
	 * @return will return channelName
	 */
	public String toString() {
		String ret="";
		
		ret=channelBand+" "+channelFreq+"\n";
		return ret;
	}

}
