package application.model;

/**
 * Represents a Channel for pilots to be assigned during races. Channels
 * have have a unique band, number, and frequency
 * 
 * @author Luziano Reyna vtk064
 * @author James K Williams (mft520)
 *
 */


public class Channel {
	
	public String channelBand;
	public String channelFreq;
	public String channelNumber;
	
	
	/**
	 * 
	 * @param channelName will accept a String object and set to channelName
	 */
	public Channel(String channelBand,String channelNumber, String channelFreq) {
		this.channelBand=channelBand;
		this.channelFreq=channelFreq;
		this.channelNumber=channelNumber;
		
		
	}

	
	
	
	/**
	 * Returns channelNumber 
	 * 
	 * @return
	 */
	public String getChannelNumber() {
		return channelNumber;
	}




/**
 * Sets channelNumber
 * 
 * @param channelNumber
 */
	public void setChannelNumber(String channelNumber) {
		this.channelNumber = channelNumber;
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
		String ret=channelBand+channelNumber+" "+channelFreq;
		
		
		return ret;
	}

}
