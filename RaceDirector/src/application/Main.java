package application;

/**
 * @author Luziano Reyna/vtk064
 * @author add your names here
 * 
 * 
 * Task:
 * -Create Score class inside Model(Name:Edgard)
 * -Update pilot with an arrayList of Scores , allowing pliot
 * to have scores for each round which will be updated.
 * 
 * -Write Heat controller , which will update the labels with the pilots, and channels. Uitilize
 * already made model classes.
 * embedded (Name:            )
 * 
 * -//TODO Create endScoreController, updated score as needed, create a save method
 * inside raceOrganizer save score for pilot, do not overwrite, file will be reread to collect
 * scores, will be displayed from round to round // Create Score fxml, no skin needed, just link
 * (Name:   Edgard Borrego  )
 *  
 *  -Update RaceOrganizer with an addUpScore Method, method will itirate through a pilots
 *  score arrayList and add the values together, result   will be assigned to a label
 *  
 * -Create raceOffController, conect raceoff  controller componets to
 * a functional level to display data as needed, raceOff fxml (Name:     )
 * 
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
			Parent root = FXMLLoader.load(getClass().getResource("view/RaceStart.fxml"));
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