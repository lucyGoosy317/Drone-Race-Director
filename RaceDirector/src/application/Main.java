package application;

/**
 * @author Luziano Reyna/vtk064
 * @author add your names here
 * 
 * 
 * Tasks:
 * (task will be removed once completed, ill be working top-down till finished, please alert me if you are working on 
 * anything via chat)
 * 
 * RoundController:
 * TODO Write previousRound inside RaceOrganizer, that will return String value of The 
 * previous round info given from rounds arrayList. if the user tries to go below
 * the given number of rounds inside RaceOrganizer, produce an alert 
 * TODO Write updateRoundLabel, which will return the 
 * integer value of the last round and update the label
 * TODO Write nextRound inside RaceOrganizer, that will return String value of the next round info given from the rounds arrayList
 * if the user tries to go further than highest value of rounds, produce an alert
 * 
 * HeatController:
 * TODO Write heatInfoUpdate inside RaceOrganizer, that get the first heat from the heats arrayList, populate the grid with the heat's pilot data
 * TODO Write addScores inside RaceOrganizer, which will take given scores that were entered inside the text values, go through the heat list, and
 * add the current score to the pilot's score array list.
 * TODO Write timerStarter inside RaceOrganizer, which will update the value of the label timer inside HeatController.
 *  
 * TODO Create addUpScore, which will return the String value of pilots inside the pilots generally arraylist, first add the pilot
 * score inside the pilots score array list and give the sum to the pilot's value of total. Once that is completed sort the general
 * array list by score.
 *
 *
 *  RaceOffScoreController
 * TODO Create RaceOff FXML which will display the pilot general list and their scores
 * TODO Create RaceOff FXML which will call addUpScore, 
 * 
 * EndScoreController
 * TODO Create endScoreController, Will be used for EndScore FXML, Will have TextView type a that will display the pilots
 * and their score. Use save method to save the general list to a .csv file// Create Score fxml, no skin needed, just link
 * (Name:   Edgard Borrego  )
 * TODO Create endScore FXML which will show the general list of pilots with pilots total Score to be displayed, sort the
 * pilots according to score.
 */
	
import javafx.application.Application;

/*
Eaze Drone Director
Rounds>pilots>heats>Channel assignment>Race timer>Score
Overview Of Program:
1.This program will allow race directors the ease
2.To Create the number of rounds first.
3.Input the number of pilots and then their names
4.The heats will then be generated randomly equally to 4 pilots or less depending on the number
5.Race begins,Round 1, Heat 1 will go first and a timer of 2 minutes will be implaced.
Once the 2 minutes is up the score will be enter for each pilot of that heat and will update the
score board. This process repeat until all heats are completed with in the round, and all rounds are
completed.
6.Once all Rounds are completed, the Score board will be up to date and raceoff will be take place
7.Once all raceoff are completed the final score will be set

Screen Display:
Start Screen


 */



import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;

		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/MenuStart.fxml"));
			primaryStage.setScene(new Scene(root, 600, 600));
			stage.setTitle("Race Start Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param args will take in array of strings
	 */
	public static void main(String[] args) {
		launch(args);
	}
}