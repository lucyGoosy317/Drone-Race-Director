package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RaceModelOrganizer {
	ArrayList<Round> rounds;
	// this will contain the pilots inside the heat
	ArrayList<Pilots> pilotHeatList;
	ArrayList<Channel> channelListBandA;
	ArrayList<Channel> channelListBandB;
	ArrayList<Channel> channelListBandE;
	ArrayList<Channel> channelListBandF;
	ArrayList<Channel> channelListBandR;

	public RaceModelOrganizer() {
		rounds = new ArrayList<Round>();
		pilotHeatList = new ArrayList<Pilots>();
		channelListBandA = new ArrayList<Channel>();
		channelListBandB = new ArrayList<Channel>();
		channelListBandE = new ArrayList<Channel>();
		channelListBandF = new ArrayList<Channel>();
		channelListBandR = new ArrayList<Channel>();

	}

	/************Getters & Setter**************
	
	 /**
	 * 
	 * @return will return pilotList
	 */
	public ArrayList<Pilots> getPilotHeatList() {
		return pilotHeatList;
	}

	/**
	 * 
	 * @param pilotHeatList
	 *            will set pilotList
	 */
	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		this.pilotHeatList = pilotHeatList;
	}

	
	
	//******************Methods*******************
	/**
	 * load channel?
	 */
	public void loadChannels(String channelFileName) {
		String fileName = channelFileName;
		File file = new File(fileName);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				// place band/channels into their own arraylist
				Channel channel = null;
				if (tokens[0].contains("A")) {
					channel = new Channel(tokens[0], tokens[1]);
					channelListBandA.add(channel);
				} else if (tokens[0].contains("B")) {
					channel = new Channel(tokens[0], tokens[1]);
					channelListBandB.add(channel);
				} else if (tokens[0].contains("E")) {
					channel = new Channel(tokens[0], tokens[1]);
					channelListBandE.add(channel);
				} else if (tokens[0].contains("F")) {
					channel = new Channel(tokens[0], tokens[1]);
					channelListBandF.add(channel);
				} else if (tokens[0].contains("R")) {
					channel = new Channel(tokens[0], tokens[1]);
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
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.next();
				String[] tokens = line.split(",");
				Pilots pilot = null;
				Channel channel = null;
				channel = new Channel(tokens[1], tokens[2]);
				pilot = new Pilots(tokens[0], channel, tokens[3]);
				pilotHeatList.add(pilot);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addRounds(Round newRound) {
		rounds.add(newRound);
		
	}
	
	
	
	//******************toString*******************
	public String toString() {
		String ret="";
		for(int i=0;i<rounds.size();i++) {
			ret+=rounds.get(i).toString();
		}
		
		return ret;
	}
	
	
	
	
	
	
	}
