package application.model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Heat {
	//this will contain the pilots inside the heat
	ArrayList<Pilots>pilotHeatList;
	ArrayList<Channel>channelListBandA;
	ArrayList<Channel>channelListBandB;
	ArrayList<Channel>channelListBandE;
	ArrayList<Channel>channelListBandF;
	ArrayList<Channel>channelListBandR;
	
	String heatName;
	
	/**
	 * 
	 * @param heatName will accept a String value
	 */
	public Heat(String heatName) {
		this.heatName=heatName;
		pilotHeatList=new ArrayList<Pilots>();
		channelListBandA=new ArrayList<Channel>();
		channelListBandB=new ArrayList<Channel>();
		channelListBandE=new ArrayList<Channel>();
		channelListBandF=new ArrayList<Channel>();
		channelListBandR=new ArrayList<Channel>();
	}

	//**********getters & Setter**************
	/**
	 * 
	 * @return will return pilotList
	 */
	public ArrayList<Pilots> getPilotHeatList() {
		return pilotHeatList;
	}

	/**
	 * 
	 * @param pilotHeatList will set pilotList
	 */
	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		this.pilotHeatList = pilotHeatList;
	}

	/**
	 * 
	 * @return will return String value of heatName
	 */
	public String getHeatName() {
		return heatName;
	}
	
	/**
	 * 
	 * @param heatName will accept a String object and set to heatName
	 */
	public void setHeatName(String heatName) {
		this.heatName = heatName;
	}
	/**
	 * load channel?
	 */
	public void loadChannels(String channelFileName) {
		String fileName=channelFileName;
		File file=new File(fileName);
		try {
			Scanner scan=new Scanner(file);
			while(scan.hasNext()) {
				String line=scan.nextLine();
				String[]tokens=line.split(",");
				//place band/channels into their own arraylist
				Channel channel=null;
				if(tokens[0].contains("A")) {
					channel=new Channel(tokens[0],tokens[1]);
					channelListBandA.add(channel);
				}else if(tokens[0].contains("B")) {
					channel=new Channel(tokens[0],tokens[1]);
					channelListBandB.add(channel);
				}else if(tokens[0].contains("E")) {
					channel=new Channel(tokens[0],tokens[1]);
					channelListBandE.add(channel);
				}else if(tokens[0].contains("F")) {
					channel=new Channel(tokens[0],tokens[1]);
					channelListBandF.add(channel);
				}else if(tokens[0].contains("R")) {
					channel=new Channel(tokens[0],tokens[1]);
					channelListBandR.add(channel);
				}
				
				
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * load from desktop?
	 */
	public void loadFileFromDesktop(File file) {
		
		try {
			Scanner scan=new Scanner(file);
			while(scan.hasNext()) {
				String line=scan.next();
				String[]tokens=line.split(",");
				Pilots pilot=null;
				Channel channel=null;
				channel=new Channel(tokens[1],tokens[2]);
				pilot=new Pilots(tokens[0],channel,tokens[3]);
				pilotHeatList.add(pilot);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
	
	//************to String**********************
	/**
	 * @return will return all pilots inside heat
	 */
	public String toString() {
		String ret="";
		ret+=heatName+" :\n";
		//to view all the pilots inside the heat
		for(int i=0;i<pilotHeatList.size();i++) {
			ret+=pilotHeatList.get(i)+"\n";
		}
		return ret;
	}
	
	

}
