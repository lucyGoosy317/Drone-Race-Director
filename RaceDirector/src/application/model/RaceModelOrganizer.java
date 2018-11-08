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
public class RaceModelOrganizer {
	static ArrayList<Round> rounds;
	static ArrayList<Heat> heats;
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
		heats = new ArrayList<Heat>();
		numberOfPilotsPerHeat = 1;
		roundNumber = 0;
		heatNumber = 0;

	}

	// ************Getters & Setter**************

	public static ArrayList<Pilots> getPilotHeatList() {
		return pilotGeneralPilotList;
	}

	public static ArrayList<Heat> getHeats() {
		return heats;
	}

	public static void setHeats(ArrayList<Heat> heats) {
		RaceModelOrganizer.heats = heats;
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

	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		RaceModelOrganizer.pilotGeneralPilotList = pilotHeatList;
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		RaceModelOrganizer.roundNumber = roundNumber;
	}

	public int getHeatNumber() {
		return heatNumber;
	}

	public void setHeatNumber(int heatNumber) {
		RaceModelOrganizer.heatNumber = heatNumber;
	}

	// ******************Methods*******************

	
	// Loading channels from the given .csv file, Which is being initialized in
	// menuStartController>>MenuStartController
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
					channel = new Channel(tokens[0], tokens[1],tokens[2]);
					channelListBandA.add(channel);
				} else if (tokens[0].contains("B")) {
					channel = new Channel(tokens[0], tokens[1],tokens[2]);
					channelListBandB.add(channel);
				} else if (tokens[0].contains("E")) {
					channel = new Channel(tokens[0], tokens[1],tokens[2]);
					channelListBandE.add(channel);
				} else if (tokens[0].contains("F")) {
					channel = new Channel(tokens[0], tokens[1],tokens[2]);
					channelListBandF.add(channel);
				} else if (tokens[0].contains("R")) {
					channel = new Channel(tokens[0], tokens[1],tokens[2]);
					channelListBandR.add(channel);
				}

			}
			scan.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	// Load pilots from .csv File in custom format, user must see read me to utilize
	// this feature>>RaceStartController
	public static void loadFileFromDesktop(File file) {

		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String line = scan.next();
				String[] tokens = line.split(",");
				Pilots pilot = null;
				Channel channel = null;
				channel = new Channel(tokens[1], tokens[2],tokens[3]);
				//run the createNewPilot to ensure there are not duplicate pilots being loaded
				createNewPilot(tokens[0],channel);

			}
			JOptionPane.showMessageDialog(null, "Pilots have been loaded");
			scan.close();
		} catch (FileNotFoundException e) {

			JOptionPane.showMessageDialog(null, "No pilots have been loaded");
			// e.printStackTrace();
		}
	}

	// add more rounds
	public void addRounds(Round newRound) {
		rounds.add(newRound);

	}

	// Creating Rounds inside the Race Configure wizard>>RaceConfigureController
	public static boolean createRounds(String numberOfRounds) {
		boolean check = false;
		// remove all rounds if configured is accessed again
		rounds.removeAll(rounds);
		// create the Round
		try {
			int numOfRounds = Integer.parseInt(numberOfRounds);
			int roundCount = 1;
			for (int i = 0; i < numOfRounds; i++) {
				Round newRound = new Round("Round:" + roundCount);
				roundCount++;
				rounds.add(newRound);
				check = true;
			}
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null,
					numberOfRounds + ":" + "Is not a numerical value \n Please enter a numerical value");
			check = false;
		}

		return check;
	}

	// Creating Heats inside the Race Configure wizard>>RaceConfigureController
	public static boolean createHeats(String numberOfHeats) {
		boolean check = false;
		// Remove all heats if accessed again by the user
		heats.removeAll(heats);
		try {
			int heatNumber = Integer.parseInt(numberOfHeats);
			int heatCount = 1;
			// insert Heats into all rounds
			for (int i = 0; i < heatNumber; i++) {
				Heat newHeat = new Heat("Heat:" + heatCount);
				heats.add(newHeat);
				heatCount++;

				check = true;
			}
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null,
					numberOfHeats + ":" + "Is not a numerical value \n Please enter a numerical value");
			check = false;
		}

		return check;

	}

	// Pilots will be select and the heat, then user will enter button. Will accept
	// a pilot object and heat object and load
	// into all rounds>>RaceStartConfigureLoadHeats
	public static void loadPilotsIntoHeats(Pilots selectedPilot, Heat selectedHeat) {
		// add the pilot with the selected heat given from the ComboBox
		boolean check=false;
		//check to see if pilot already exist in another heat
		for(int i=0;i<heats.size();i++) {
			if(heats.get(i).PilotsInHeat.contains(selectedPilot)) {
				
				check=false;
					break;
			}else {
				check=true;
				
			}
		}
		//conduct check to either allow a pilot to be added or to alert the user that the pilot has already been entered 
		//into another heat
		if(check==true) {
			selectedHeat.addPilotsToHeat(selectedPilot);
				
		}else {
			JOptionPane.showMessageDialog(null,selectedPilot.getPilotName()+" is already in another Heat");
		}
		
		
	}
	
	// Pilots will be select and the heat, then user will enter button. Will accept
	// a pilot object and heat object and remove
	// from all rounds>>RaceStartConfigureLoadHeats
	public static void removePilotsFromHeats(Pilots selectedPilot, Heat selectedHeat) {
		//remove the pilot with the select heat given from the ComboBox
		selectedHeat.removePilotsFromHeat(selectedPilot);
		
	}
	
	
	
	//This method is a general method that will allow a new
	//pilot to be created from the enter pilot controller which
	//then will add the pilot to the general pilot array list
	public static void createNewPilot(String pilotName, Channel pilotChannel) {
		Pilots newPilot = null;
		newPilot = new Pilots(pilotName, pilotChannel);
		//load Pilot scores to ensure the pilot only has 3 spaces for 3 scores to be added
		for(int i=0;i<rounds.size();i++) {
			newPilot.pilotsScore.add(0);
		}
		boolean check=false;
		//check to see if pilot already exist from being loaded into the pilot G list
		for(int i=0;i<pilotGeneralPilotList.size();i++) {
			if(pilotGeneralPilotList.get(i).getPilotName().equals(newPilot.pilotName)) {
				check=true;
				break;
			}else {
				check=false;

				
			}
		}
		//if So alert the user, if not add the pilot to the list
		if(check==true) {
			JOptionPane.showMessageDialog(null,pilotName+" already is already entered on the roster");
		}else {
			pilotGeneralPilotList.add(newPilot);

			JOptionPane.showMessageDialog(null,pilotName+" has been added on the roster");
	
		}
			}

	
	public static String displayCurrentHeat(Heat selectedHeat) {
		String ret=selectedHeat.getHeatName()+":"+"\n";
		for(int i=0;i<selectedHeat.PilotsInHeat.size();i++) {
			ret+="\n"+selectedHeat.PilotsInHeat.get(i).toString()+"\n";
		}
		
		return ret;
	}
	
	//********Methods to be used in round controller*************
	public static String currentRound() {
		String currentRound="";
		//Round tempRound=rounds.get(roundNumber);
		for(int i=0;i<=roundNumber;i++) {
			currentRound+=rounds.get(i).roundName+"\n";
			for(int l=0;l<rounds.get(i).heat.size();l++) {
				Heat tempHeat=rounds.get(i).heat.get(l);
				currentRound+=tempHeat.returnPilotsOfHeat()+"\n";
				
			}
			System.out.println(currentRound);
		}
	
		
		return currentRound;
	}
	
	
	// change back to the previous round
	public static String previousRound() {
		String previousRound="";
		//roundNumber--;
		//Round tempArray=rounds.get(roundNumber);
		//test to see what should be displayed
		//System.out.println(tempArray.heat.toString());
		int tempint=rounds.size();
		System.out.println(roundNumber);
		if(roundNumber<0) {
			JOptionPane.showMessageDialog(null,"This is the first round");
			
		}else {
			for(int i=0;i<=roundNumber;i++) {
				previousRound+=rounds.get(i).roundName+"\n";
				for(int l=0;l<rounds.get(i).heat.size();l++) {
					Heat tempHeat=rounds.get(i).heat.get(l);
					previousRound+=tempHeat.returnPilotsOfHeat()+"\n";
					
				}
				System.out.println(previousRound);
				
			}
			roundNumber--;
		}
		
		return previousRound;
	}

	// change back to the next round
	public static String nextRound() {
		String nextRound="";
		System.out.println(roundNumber);
		//Round tempArray=rounds.get(roundNumber);
		//test to see what should be displayed
		//System.out.println(tempArray.heat.toString());
		if(roundNumber>rounds.size()) {
			JOptionPane.showMessageDialog(null,"This is the last Round");
			
		}else {
			for(int i=0;i<=roundNumber;i++) {
				nextRound+=rounds.get(i).roundName+"\n";
				for(int l=0;l<rounds.get(i).heat.size();l++) {
					Heat tempHeat=rounds.get(i).heat.get(l);
					nextRound+=tempHeat.returnPilotsOfHeat()+"\n";
					
				}
				System.out.println(nextRound);
			}
			roundNumber++;
		}
	
		return nextRound;
		
		
	}

	public static String roundLabelUpdater() {
		int tempRoundNumber=roundNumber+1;
		String tempRoundLabelUpdate="Round: "+tempRoundNumber;
		
		return tempRoundLabelUpdate;
	}
	
	
	//************************************************
	
	
	
	
	//TODO left off here incorrect output to string is messed up
	//Loaded the pilot heats into each round
	public static void loadHeatsIntoRounds() {
		
		for(int i=0;i<rounds.size();i++) { //go through the round get round
			//System.out.println(rounds.get(i).roundName+" is being loaded "+"\n");
			for(int l=0;l<heats.size();l++) {
				rounds.get(i).removeHeat(heats.get(l));
				rounds.get(i).addHeats(heats.get(l));
				//System.out.println(heats.get(l).heatName+" Was added to "+rounds.get(i).roundName+"\n");
				
			}
			//look at the pilots inside each round, inside each heat
			for(int k=0;k<rounds.get(i).heat.size();k++){
				for(int j=0;j<rounds.get(i).heat.get(k).PilotsInHeat.size();j++) {

					//System.out.println(rounds.get(i).roundName+"\n" //get the round name
				//+rounds.get(i).heat.get(k).heatName+"\n" //get the heat name
				//+rounds.get(i).heat.get(k).PilotsInHeat.get(j).pilotName+"\n"); //get the pilots inside that heat
					
				}
				
				
				
				
			}
			
		
		}
		
		
	}
	
	// ******************toString*******************
	public String toString() {
		
		String ret = "";
		for (int i = 0; i < rounds.size(); i++) {
		
			ret += rounds.get(i).heat.iterator().toString();
		}

		return ret;
	}

}
