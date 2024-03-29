package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * RaceModelOrganizer allows the user to organize the race, designating channels to pilots, entering
 * pilots into heats and entering number of rounds in the race.
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
	private static int heatNum;
	private static int helperNum;
	private static int helperNum2;
	
	
/**
 * Constructor creates RaceModeOrganizer object with list of channle, list 
 * of pilots and list of heat.
 * 
 */
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
		heatNum=0;
		helperNum=0;
		helperNum2=0;

	}

	// ************Getters & Setter**************
/**
 * Returns pilot list
 * 
 * @return
 */
	public static ArrayList<Pilots> getPilotHeatList() {
		return pilotGeneralPilotList;
	}

	/**
	 * Returns Heat
	 * 
	 * @return
	 */
	public static ArrayList<Heat> getHeats() {
		return heats;
	}
	
/**
 * Sets Heat to List of Heat
 * 
 * @param heats
 */
	public static void setHeats(ArrayList<Heat> heats) {
		RaceModelOrganizer.heats = heats;
	}

	/**
	 * Returns rounds
	 * 
	 * @return
	 */
	public static ArrayList<Round> getRounds() {
		return rounds;
	}

	/**
	 * Sets rounds to List of Round
	 * 
	 * @param rounds
	 */
	public static void setRounds(ArrayList<Round> rounds) {
		RaceModelOrganizer.rounds = rounds;
	}
/**
 * Returns pilot list
 * 
 * @return
 */
	public static ArrayList<Pilots> getPilotGeneralPilotList() {
		return pilotGeneralPilotList;
	}

	/**
	 * Sets pilot to list of Pilot
	 * 
	 * @param pilotGeneralPilotList
	 */
	public static void setPilotGeneralPilotList(ArrayList<Pilots> pilotGeneralPilotList) {
		RaceModelOrganizer.pilotGeneralPilotList = pilotGeneralPilotList;
	}

	/**
	 * Returns channel List BandA
	 * 
	 * @return
	 */
	public static ArrayList<Channel> getChannelListBandA() {
		return channelListBandA;
	}

	/**
	 * Sets channel List BandA to list of Channel
	 * 
	 * @param channelListBandA
	 */
	public static void setChannelListBandA(ArrayList<Channel> channelListBandA) {
		RaceModelOrganizer.channelListBandA = channelListBandA;
	}

	/**
	 * Returns channel List BandB
	 * 
	 * @return
	 */
	public static ArrayList<Channel> getChannelListBandB() {
		return channelListBandB;
	}
	
	/**
	 * Sets channel List BandB to list of Channel
	 * 
	 * @param channelListBandB
	 */
	public static void setChannelListBandB(ArrayList<Channel> channelListBandB) {
		RaceModelOrganizer.channelListBandB = channelListBandB;
	}
	
	/**
	 * Returns channel List BandE
	 * 
	 * @return
	 */
	public static ArrayList<Channel> getChannelListBandE() {
		return channelListBandE;
	}

	/**
	 * Sets channel List BandE to list of Channel
	 * 
	 * @param channelListBandE
	 */
	public static void setChannelListBandE(ArrayList<Channel> channelListBandE) {
		RaceModelOrganizer.channelListBandE = channelListBandE;
	}

	/**
	 * Returns channel List BandF
	 * 
	 * @return
	 */
	public static ArrayList<Channel> getChannelListBandF() {
		return channelListBandF;
	}

	/**
	 * Sets channel List BandF to list of Channel
	 * 
	 * @param channelListBandF
	 */
	public static void setChannelListBandF(ArrayList<Channel> channelListBandF) {
		RaceModelOrganizer.channelListBandF = channelListBandF;
	}

	/**
	 * Returns channel List BandR
	 * 
	 * @return
	 */
	public static ArrayList<Channel> getChannelListBandR() {
		return channelListBandR;
	}

	/**
	 * Sets channel List BandR to list of Channel
	 * 
	 * @param channelListBandR
	 */
	public static void setChannelListBandR(ArrayList<Channel> channelListBandR) {
		RaceModelOrganizer.channelListBandR = channelListBandR;
	}

	/**
	 * Return new Heat
	 * 
	 * @return
	 */
	public Round getNewHeat() {
		return newHeat;
	}

	/**
	 * Set new Heat
	 * 
	 * @param newHeat
	 */
	public void setNewHeat(Round newHeat) {
		this.newHeat = newHeat;
	}

	/**
	 * Return number of Pilots per Heat 
	 * 
	 * @return
	 */
	public static int getNumberOfPilotsPerHeat() {
		return numberOfPilotsPerHeat;
	}

	/**
	 * Set number of Pilots per Heat
	 * 
	 * @param numberOfPilotsPerHeat
	 */
	public static void setNumberOfPilotsPerHeat(int numberOfPilotsPerHeat) {
		RaceModelOrganizer.numberOfPilotsPerHeat = numberOfPilotsPerHeat;
	}

	/**
	 * Set pilot heat list to List of Pilots
	 * 
	 * @param pilotHeatList
	 */
	public void setPilotHeatList(ArrayList<Pilots> pilotHeatList) {
		RaceModelOrganizer.pilotGeneralPilotList = pilotHeatList;
	}

	/**
	 * Return number of rounds
	 * 
	 * @return
	 */
	public int getRoundNumber() {
		return roundNumber;
	}

	/**
	 * Set number of rounds
	 * 
	 * @param roundNumber
	 */
	public void setRoundNumber(int roundNumber) {
		RaceModelOrganizer.roundNumber = roundNumber;
	}

	/**
	 * Return number of Heat
	 * 
	 * @return
	 */
	public int getHeatNumber() {
		return heatNumber;
	}

	/**
	 * Set number of Heat
	 * 
	 * @param heatNumber
	 */
	public void setHeatNumber(int heatNumber) {
		RaceModelOrganizer.heatNumber = heatNumber;
	}

	// ******************Methods*******************

	/**
	 * Loading channels from the given .csv file, Which is being initialized in
	 * menuStartController
	 * MenuStartController
	 * 
	 * @param channelFileName
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

	
	/**
	 * Load pilots from .csv File in custom format, user must see read me to utilize
	 * this feature RaceStartController
	 * 
	 * @param file
	 */
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

	/**
	 * Adds more rounds to race
	 * 
	 * @param newRound
	 */
	public void addRounds(Round newRound) {
		rounds.add(newRound);

	}

	/**
	 * Creates Rounds inside the Race Configure wizard RaceConfigureController
	 * 
	 * @param numberOfRounds
	 * @return
	 */
	public static boolean createRounds(String numberOfRounds) {
		boolean check = false;
		// remove all rounds if configured is accessed again
		rounds.removeAll(rounds);
		
		// create the Round
		try {
			//check to see if number entered was a negative number
			if(Integer.parseInt(numberOfRounds)>0) {
			int numOfRounds = Integer.parseInt(numberOfRounds);
			int roundCount = 1;
			for (int i = 0; i < numOfRounds; i++) {
				Round newRound = new Round("Round:" + roundCount);
				roundCount++;
				rounds.add(newRound);
				check = true;
			}
				
			}else {
				JOptionPane.showMessageDialog(null,"Please enter a round Number greater than 0");

			}
			
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null,
					numberOfRounds + ":" + "Is not a numerical value \n Please enter a numerical value");
			check = false;
		}

		return check;
	}

	/**
	 * Creates Heats inside the Race Configure wizard RaceConfigureController
	 * 
	 * @param numberOfHeats
	 * @return
	 */
	public static boolean createHeats(String numberOfHeats) {
		boolean check = false;
		// Remove all heats if accessed again by the user
		heats.removeAll(heats);
		heatNumber=0;
		try {
			if(Integer.parseInt(numberOfHeats)>0) {
			int heatNum = Integer.parseInt(numberOfHeats);
			int heatCount = 1;
			// insert Heats into all rounds
			for (int i = 0; i < heatNum; i++) {
				Heat newHeat = new Heat("Heat:" + heatCount);
				heats.add(newHeat);
				heatCount++;
				heatNumber++;
				check = true;
			}
			}else {
				JOptionPane.showMessageDialog(null,"Please enter a number greater than 0");

			}
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null,
					numberOfHeats + ":" + "Is not a numerical value \n Please enter a numerical value");
			check = false;
		}

		return check;

	}

	/**
	 * Pilots will be select and the heat, then user will enter button. Will accept 
	 * a pilot object and heat object and load into all round RaceStartConfigureLoadHeats
	 *  
	 * @param selectedPilot
	 * @param selectedHeat
	 */
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
			//assign the size of pilots in heat score arraylist
			for(int l=0;l<roundNumber;l++) {
				selectedPilot.pilotsScore.add(0);
			}
			//assign the size of every the pilots array list
			for(int i=0;i<pilotGeneralPilotList.size();i++) {
				for(int j=0;j<roundNumber;j++) {
					pilotGeneralPilotList.get(i).pilotsScore.add(0);	
				}
				
			}
			selectedHeat.addPilotsToHeat(selectedPilot);
				
		}else {
			JOptionPane.showMessageDialog(null,selectedPilot.getPilotName()+" is already in another Heat");
		}
		
		
	}
	
	/** Pilots will be select and the heat, then user will enter button. Will accept
	 * a pilot object and heat object and remove from all rounds RaceStartConfigureLoadHeats
	 * 
	 * @param selectedPilot
	 * @param selectedHeat
	 */
	public static void removePilotsFromHeats(Pilots selectedPilot, Heat selectedHeat) {
		//remove the pilot with the select heat given from the ComboBox
		selectedHeat.removePilotsFromHeat(selectedPilot);
		
		
	}
	
	/**
	 * check to enterPilots
	 * 
	 * @param selectedPilot
	 * @param selectedHeat
	 * @return
	 */
	public static boolean checkPilotsAndHeats(Pilots selectedPilot, Heat selectedHeat) {
		boolean check=false;
		if(selectedPilot==null && selectedHeat==null) {
			JOptionPane.showMessageDialog(null,"Select a pilot and heat");
			check=false;
		}else if(selectedPilot==null) {
			JOptionPane.showMessageDialog(null,"Select a Pilot");
			check=false;
		}else if(selectedHeat==null) {
			JOptionPane.showMessageDialog(null,"Please selected a Heat");
			check=false;
		}else {
			check=true;
		}
		return check;

	}
	
	/**
	 * method that will allow a new pilot to be created from 
	 * This method is a general the enter pilot controller which 
	 * then will add the pilot to the general pilot array list
	 * 
	 * @param pilotName
	 * @param pilotChannel
	 */
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

	/**
	 * Displays the first heat of the current round HeatController
	 * 
	 * @return
	 */
	public static String displayFirstHeat() {
		String currentHeat="";
		int tempHeatNum=heatNumber;
		
		tempHeatNum=(tempHeatNum-tempHeatNum);
		heatNum=tempHeatNum;
		for(int i=0;i<rounds.get(roundNumber).heat.get(tempHeatNum).PilotsInHeat.size();i++) {
			currentHeat+=rounds.get(roundNumber).heat.get(tempHeatNum).PilotsInHeat.get(i).pilotChannel.toString()+" "+
					rounds.get(roundNumber).heat.get(tempHeatNum).PilotsInHeat.get(i).pilotName+"\n"+"\n";
		}
		
		heatNum++;
		return currentHeat;
		
	}
	
	/**
	 * Display the next heat and stop if the value is higher than heat size HeatController
	 * 
	 */
	public static String nextHeat() {
		String nextHeat="";
		
		if(heatNum==heatNumber) {
			heatNum--;
			
			JOptionPane.showMessageDialog(null,"This is the last Heat of"+rounds.get(roundNumber).roundName);
			for(int i=0;i<rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.size();i++) {
				nextHeat+=rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.get(i).pilotChannel.toString()+" "+
						rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.get(i).pilotName+"\n"+"\n";
			}
			//heatComboBoxDisplay();

		}else {
			for(int i=0;i<rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.size();i++) {
				nextHeat+=rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.get(i).pilotChannel.toString()+" "+
						rounds.get(roundNumber).heat.get(heatNum).PilotsInHeat.get(i).pilotName+"\n"+"\n";
			}
			//heatComboBoxDisplay();
			helperNum=heatNum;
			heatNum++;
			helperNum2++;
			System.out.println(heatNum);
		}
		
		return nextHeat;
		
	}
	
	
	
	/**
	 * Displays the current pilots inside the comboBox to allow user to select a 
	 * pilot from the heat HeatController 
	 * 
	 * @return
	 */
	public static ArrayList<Pilots> heatComboBoxDisplay() {
		ArrayList <Pilots> tempArrayListHeat = new ArrayList<Pilots>();
		System.out.println("Heat num is: "+heatNum);
		int tempNum=heatNum-1;
		
		
		if(heatNum==heatNumber-1) {
			
			tempArrayListHeat=rounds.get(roundNumber).heat.get(helperNum).PilotsInHeat;
			
			
		}else {
			tempArrayListHeat=rounds.get(roundNumber).heat.get(tempNum).PilotsInHeat;
			
			
		}
		
		return tempArrayListHeat;
	}
	
	/**
	 * Displays the current heat inside the heat display label Heat Controller
	 * 
	 * @return
	 */
	public static String heatLabelDisplayChanger() {
		String labelChanger="";
		System.out.println("Heat num is: "+heatNum);
	
		if(heatNum==heatNumber) {
			labelChanger=rounds.get(roundNumber).heat.get(heatNum-1).heatName;
			
		}else {
			labelChanger=rounds.get(roundNumber).heat.get(heatNum).heatName;
		}
		return labelChanger;
	}
	
	/**
	 * Saves the current score for selected Pilots
	 * 
	 * @param selectedPilot
	 * @param score
	 */
	public static void saveCurrentScore(Pilots selectedPilot,String score) {
		int pilotScore=Integer.parseInt(score);
		//first assign score to currentScore to this pilot
		//System.out.println("Round Number is: "+roundNumber + "The current selected pilot score size is: "+selectedPilot.pilotsScore.size());
		//save the score in the correct spot for the round
		
				selectedPilot.pilotsScore.add(roundNumber, pilotScore);
				selectedPilot.Total=selectedPilot.Total+pilotScore;
				JOptionPane.showMessageDialog(null, "Score: "+pilotScore+ " added for "+selectedPilot.pilotName);
				//System.out.println(selectedPilot.pilotName+"Total Score: "+selectedPilot.Total);
				sortPilots();
		//selectedPilot.pilotsScore.add(pilotScore);
		//System.out.println(selectedPilot.pilotsScore.toString());
		
		
	}
	
	/**
	 * Removes score for selected pilots
	 * 
	 * @param selectedPilot
	 * @param score
	 */
	public static void removeScore(Pilots selectedPilot, String score) {
		int pilotScore=Integer.parseInt(score);
		//show the current score
		
		System.out.println(pilotScore);
		for(int i=0;i<selectedPilot.pilotsScore.size();i++) {
			//show the score to be compared
		
			int tempNum=selectedPilot.pilotsScore.get(i);
			//System.out.println("current score in index: "+tempNum +"Score given from user to be removed: "+pilotScore);
			if(pilotScore==selectedPilot.pilotsScore.get(i)) {
				
				JOptionPane.showMessageDialog(null, selectedPilot.pilotsScore.get(i)+" was removed from "+selectedPilot.pilotName);
				//System.out.println("Selected pilot score removed was: "+selectedPilot.pilotsScore.get(i));
				selectedPilot.Total=selectedPilot.Total-selectedPilot.pilotsScore.get(i);
				selectedPilot.pilotsScore.remove(i);
				//System.out.println(selectedPilot.pilotName+"Total Score: "+selectedPilot.Total);
				
				
			}
		}
	}
	/**
	 * Checks pilot score
	 * 
	 * @param selectedPilot
	 * @param score
	 * @return
	 */
	public static boolean checkPilotAndScore(Pilots selectedPilot, String score) {
		boolean check=false;
		
		if(selectedPilot==null && score.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Select a pilot and score");
			check=false;
		}else if(selectedPilot==null) {
			JOptionPane.showMessageDialog(null,"Select a Pilot");
			check=false;
		}else if(score.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Please enter a score");
			check=false;
		}else {
			check=true;
		}
		
		return check;
	}
	
	
	
	/**
	 * Will zero out heatNum and helperNum HeatController
	 */
	public static void zeroOutNum() {
		heatNum=0;
		helperNum=0;
		helperNum2=0;
	}
	
	
	/**
	 * This method will be called several times to show the current round's heat roundController
	 * 
	 * @param roundNumber
	 * @return
	 */
	public static String displayRoundHeat(int roundNumber) {
		
		String currentRound=rounds.get(roundNumber).roundName+"\n";
		for(int i=0;i<rounds.get(roundNumber).heat.size();i++) {
			Heat tempHeat=rounds.get(roundNumber).heat.get(i);
			currentRound+=tempHeat.returnPilotsOfHeat()+"\n";
			
			
		}
		
		
		return currentRound;
	}
	
	/**
	 * Changes back to the previous round roundController
	 * 
	 * @return
	 */
	public static String previousRound() {
		String previousRound="";
		
		
		if(roundNumber<=0) {
			JOptionPane.showMessageDialog(null,"This is the first round");
			previousRound=displayRoundHeat(roundNumber);
			
		}else {
			roundNumber--;
			previousRound=displayRoundHeat(roundNumber);
			
			
		}
		
		return previousRound;
	}

	/**
	 * Changes back to the next round
	 * roundController
	 * 
	 * @return
	 */
	public static String nextRound() {
		String nextRound="";
		
		if(roundNumber==rounds.size()-1) {
			JOptionPane.showMessageDialog(null,"This is the last Round");
			nextRound=displayRoundHeat(roundNumber);
		}else {
			roundNumber++;
			nextRound=displayRoundHeat(roundNumber);
			
		}
	
		return nextRound;
		
		
	}

	
	/**
	 * Updates the label of RoundController to show the user which round they are on roundController
	 * @return
	 */
	public static String roundLabelUpdater() {
		int tempRoundNumber=roundNumber+1;
		String tempRoundLabelUpdate="Round: "+tempRoundNumber;
		
		return tempRoundLabelUpdate;
	}
	
	
	/**
	 * Will be used to initalize the first round inside the round Controller
	 * which will show the most current round, even if the user goes home roundController
	 * 
	 * @return
	 */
	public static String currentRound() {
		String currentRound=displayRoundHeat(roundNumber);
		
		return currentRound;
	}
	
	
	/**
	 * Loads heats into the rounds after the user has assigned their pilots to the heats
	 * RaceStartConfigureLoadHeatsController
	 * 
	 */
	public static void loadHeatsIntoRounds() {
		
		for(int i=0;i<rounds.size();i++) { //go through the round get round
			
			for(int l=0;l<heats.size();l++) {
				rounds.get(i).removeHeat(heats.get(l));
				rounds.get(i).addHeats(heats.get(l));
				
				
			}
			//look at the pilots inside each round, inside each heat
			for(int k=0;k<rounds.get(i).heat.size();k++){
				for(int j=0;j<rounds.get(i).heat.get(k).PilotsInHeat.size();j++) {
					
					
				}
				
				
				
				
			}
			
		
		}
		
		
	}
	
	/**
	 * This Method will be used during enter pilots to update the label to show the current heat
	 * RaceStartConfigureLoadHeatsController
	 * 
	 * @param selectedHeat
	 * @return
	 */
	public static String displayCurrentHeat(Heat selectedHeat) {
			String ret=selectedHeat.getHeatName()+":"+"\n";
			for(int i=0;i<selectedHeat.PilotsInHeat.size();i++) {
				ret+="\n"+selectedHeat.PilotsInHeat.get(i).toString()+"\n";
			}
			
			return ret;
		}
	
	
	/**
	 * Swap Pilot Places
	 * 
	 * @param selectedPilot1
	 * @param selectedPilot2
	 */
	public static void swapPilots(Pilots selectedPilot1, Pilots selectedPilot2) {
		int indexForSelectedPilot1=0;
		int indexForSelectedPilot2=0;
		//get the index positions
		for(int i=0;i<pilotGeneralPilotList.size();i++) {
			if(pilotGeneralPilotList.get(i).equals(selectedPilot1)) {
				indexForSelectedPilot1=i;
			}else if(pilotGeneralPilotList.get(i).equals(selectedPilot2)) {
				indexForSelectedPilot2=i;
			}
		}
		Collections.swap(pilotGeneralPilotList, indexForSelectedPilot1, indexForSelectedPilot2);
		
		
	}
	
	/**
	 * Displays all pilots and their score
	 * 
	 * @return
	 */
	public static String displayAllPilots() {
		String Pilots="";
		for(int i=0;i<pilotGeneralPilotList.size();i++) {
			Pilots+=(i+1)+" "+ pilotGeneralPilotList.get(i).getPilotName()+ " Total Score: "+pilotGeneralPilotList.get(i).getTotal() +"\n";
		}
		
		
		return Pilots;
	}
	
	/**
	 * Check to see if any pilots have same score which means a race off is necessary to determine
	 * rank
	 * 
	 * @return
	 */
	public static boolean checkRaceOffs() {
		boolean check=false;
		//boolean flag=true;
		//while(flag)
		//{
			//flag=true;
			for(int i=0;i<pilotGeneralPilotList.size()-1;i++) {
				if(pilotGeneralPilotList.get(i).getTotal()==pilotGeneralPilotList.get(i+1).getTotal()){
					Pilots tempPilot1=pilotGeneralPilotList.get(i);
					Pilots tempPilot2=pilotGeneralPilotList.get(i+1);
					
					System.out.println(tempPilot1.pilotName+ " is racing of with "+ tempPilot2.pilotName+"\n");
					//flag=false;
					check=true;
				}else {
					
			}
			
		}
		
		return check;
	}
	
	
	/**
	 * This Method will be called to Sort the pilots in Round Controller, 
	 * when the user wants to end the race
	 * 
	 */
	public static void sortPilots() {
		int i;
		
		boolean flag=true;
		
		while(flag)
		{
			flag=false;
			for(i=0;i<pilotGeneralPilotList.size()-1;i++) {
				if(pilotGeneralPilotList.get(i).getTotal()<pilotGeneralPilotList.get(i+1).getTotal()){
					Pilots tempPilot1=pilotGeneralPilotList.get(i);
					Pilots tempPilot2=pilotGeneralPilotList.get(i+1);
					//the swap
					pilotGeneralPilotList.remove(tempPilot1);
					pilotGeneralPilotList.remove(tempPilot2);
					pilotGeneralPilotList.add(i,tempPilot2);
					pilotGeneralPilotList.add(i+1,tempPilot1);
					flag=true;
					
				}
			}
		}
		for(int k=0;k<pilotGeneralPilotList.size();k++) {
			System.out.println((k+1)+" "+pilotGeneralPilotList.get(k).getPilotName()+" Total score "+pilotGeneralPilotList.get(k).getTotal());
		}
		System.out.println();
		
		
	}
	
	
	/**
	 * Checks to see if rounds are empty
	 * 
	 * @return
	 */
	public static boolean checkRounds() {
		boolean check=false;
		if(rounds.isEmpty()) {
			JOptionPane.showMessageDialog(null,"You must use the add some round before starting the race");
			check=false;
		}else {
			check=true;
		}
		
		
		
		
		return check;
	}

	
	//************************************Save method used in end ********************************************************
	/**
	 * Saves the pilots score to data file
	 * 
	 * @param pilotResults
	 */
	public static void save(String pilotResults) {
		String userFile="data/results.csv";
		
			
			try {
				FileWriter fileWriter= new FileWriter(userFile,false);
				BufferedWriter bufferWriter= new BufferedWriter(fileWriter);
				PrintWriter printWriter= new PrintWriter(bufferWriter);
				
				Scanner scan= new Scanner(pilotResults);
				while(scan.hasNext()) {
					String line=scan.nextLine();
					String[] tokens=line.split(" ");
					printWriter.println(tokens[0]+","+tokens[1]+","+tokens[4]);
					
				}
				
				//fileWriter.write(userFile);
				printWriter.close();
				scan.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
	}
	
	
	//**********************************************************************
	
	// ******************toString*******************
	public String toString() {
		
		String ret = "";
		for (int i = 0; i < rounds.size(); i++) {
		
			ret += rounds.get(i).heat.iterator().toString();
		}

		return ret;
	}

}
