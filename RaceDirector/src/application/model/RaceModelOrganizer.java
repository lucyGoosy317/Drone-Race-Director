package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class RaceModelOrganizer  {
	static ArrayList<Round> rounds;
	// this will contain the pilots inside the heat
	static ArrayList<Pilots> pilotGeneralPilotList;
	static ArrayList<Channel> channelListBandA;
	static ArrayList<Channel> channelListBandB;
	static ArrayList<Channel> channelListBandE;
	static ArrayList<Channel> channelListBandF;
	static ArrayList<Channel> channelListBandR;
	private Round newHeat = null;
	static int numberOfPilotsPerHeat;
	private static int roundNumber;
	private static int heatNumber;

	public RaceModelOrganizer() {
		rounds = new ArrayList<Round>();
		pilotGeneralPilotList = new ArrayList<Pilots>();
		channelListBandA = new ArrayList<Channel>();
		channelListBandB = new ArrayList<Channel>();
		channelListBandE = new ArrayList<Channel>();
		channelListBandF = new ArrayList<Channel>();
		channelListBandR = new ArrayList<Channel>();
		numberOfPilotsPerHeat=1;
		roundNumber=0;
		heatNumber=0;

	}

	
	
	
	/************Getters & Setter**************
	
	
	
	
	
	
	
	
	 /**
	 * 
	 * @return will return pilotList
	 */
	public ArrayList<Pilots> getPilotHeatList() {
		return pilotGeneralPilotList;
	}

	public static ArrayList<Round> getRounds() {
		return rounds;
	}

	public static void setRounds(ArrayList<Round> rounds) {
		RaceModelOrganizer.rounds = rounds;
	}

	public static ArrayList<Pilots> getPilotGeneralPilotList() {
		return pilotGeneralPilotList;
	}

	public static void setPilotGeneralPilotList(ArrayList<Pilots> pilotGeneralPilotList) {
		RaceModelOrganizer.pilotGeneralPilotList = pilotGeneralPilotList;
	}

	public static ArrayList<Channel> getChannelListBandA() {
		return channelListBandA;
	}

	public static void setChannelListBandA(ArrayList<Channel> channelListBandA) {
		RaceModelOrganizer.channelListBandA = channelListBandA;
	}

	public static ArrayList<Channel> getChannelListBandB() {
		return channelListBandB;
	}

	public static void setChannelListBandB(ArrayList<Channel> channelListBandB) {
		RaceModelOrganizer.channelListBandB = channelListBandB;
	}

	public static ArrayList<Channel> getChannelListBandE() {
		return channelListBandE;
	}

	public static void setChannelListBandE(ArrayList<Channel> channelListBandE) {
		RaceModelOrganizer.channelListBandE = channelListBandE;
	}

	public static ArrayList<Channel> getChannelListBandF() {
		return channelListBandF;
	}

	public static void setChannelListBandF(ArrayList<Channel> channelListBandF) {
		RaceModelOrganizer.channelListBandF = channelListBandF;
	}

	public static ArrayList<Channel> getChannelListBandR() {
		return channelListBandR;
	}

	public static void setChannelListBandR(ArrayList<Channel> channelListBandR) {
		RaceModelOrganizer.channelListBandR = channelListBandR;
	}

	public Round getNewHeat() {
		return newHeat;
	}

	public void setNewHeat(Round newHeat) {
		this.newHeat = newHeat;
	}

	public static int getNumberOfPilotsPerHeat() {
		return numberOfPilotsPerHeat;
	}

	public static void setNumberOfPilotsPerHeat(int numberOfPilotsPerHeat) {
		RaceModelOrganizer.numberOfPilotsPerHeat = numberOfPilotsPerHeat;
	}

	/**
	 * 
	 * @param pilotHeatList
	 *            will set pilotList
	 */
	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		RaceModelOrganizer.pilotGeneralPilotList = pilotHeatList;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	public int getHeatNumber() {
		return heatNumber;
	}

	public void setHeatNumber(int heatNumber) {
		this.heatNumber = heatNumber;
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
				pilot = new Pilots(tokens[0], channel);
				pilotGeneralPilotList.add(pilot);
				JOptionPane.showMessageDialog(null,"Pilots have been loaded");
			}
			scan.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addRounds(Round newRound) {
		rounds.add(newRound);
		
	}
	
	public static boolean createRounds(String numberOfRounds) {
		boolean check=false;
		try {
		int numOfRounds=Integer.parseInt(numberOfRounds);
		int roundCount=1;
		for(int i=0;i<numOfRounds;i++) {
			Round newRound=new Round("Round:"+roundCount);
			roundCount++;
			rounds.add(newRound);
			check=true;
		}
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, numberOfRounds+":"+"Is not a numerical value \n Please enter a numerical value");
			check=false;
		}
	
	return check;
	}
	//****left off here
	public static boolean createHeats(String numberOfHeats) {
		boolean check=false;
		
		try {
			heatNumber=Integer.parseInt(numberOfHeats);
		//insert Heats into all rounds
		for(int i=0;i<rounds.size();i++) {
			//go into rounds and insert heats
			for(int l=0;l<heatNumber;l++) {
				Heat newHeat=null;
				//remove and old heats
				newHeat=new Heat("Heat:"+heatNumber);
				rounds.get(i).heat.add(newHeat);
				heatNumber++;
			}
			check=true;
		}
	}catch(NumberFormatException e) {
		
		JOptionPane.showMessageDialog(null, numberOfHeats+":"+"Is not a numerical value \n Please enter a numerical value");
		check=false;
	}
			
		
			return check;
	
	}

	//Restrict number of pilots to heat
	public static boolean  restrictPilotsPerHeat(String restrictNumber) {
		boolean check= false;
		try {
		numberOfPilotsPerHeat=Integer.parseInt(restrictNumber);
		check=true;
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, restrictNumber+":"+"Is not a numerical value \n Please enter a numerical value");
			check=false;
		}
		
		return check;
		
	}
	
	//change back to the previous round
	public static String previousRound() {
		roundNumber--;
		
		return rounds.get( roundNumber).toString(); 
	}
	
	//change back to the next round
	public static void nextRound() {
		
	}
	
	public static void loadPilotsIntoHeats() {
		//go through the rounds
		for(int i=0;i<rounds.size();i++) {
			//get go through the number of heats in the first round
			for(int l=0;l<heatNumber;l++) {
				//load based off the restricted number
				for(int o=0;o<numberOfPilotsPerHeat;o++) {
					rounds.get(i).heat.get(l);
				}
			}
			
		}
	}
	
	
	
	
	/**
	 * 
	 * @param pilotName will take in a String value and enter a new pilot
	 * @param pilotChannel will take in a channel value to create a new Pilot object
	 * This method is a general method that will allow a new pilot to be created from 
	 * the enter pilot controller which then will add the pilot to the general pilot array list
	 */
	public static void createNewPilot(String pilotName, Channel pilotChannel) {
		Pilots newPilot=new Pilots(pilotName,pilotChannel);
		pilotGeneralPilotList.add(newPilot);
		JOptionPane.showMessageDialog(null,"New Pilot has been added");
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
