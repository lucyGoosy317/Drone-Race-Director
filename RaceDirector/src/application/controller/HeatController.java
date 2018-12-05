package application.controller;
/**
 * Control current Heat, allows user to start timer for race, save score, remove score, and continue to 
 * next Heat
 * 
 * @author Luziano Reyna vtk064
 * 
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import application.Main;
import application.model.Pilots;
import application.model.RaceModelOrganizer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class HeatController implements Initializable  {

	
	private final int TIME_LIMIT = 120;
	
	private int seconds = TIME_LIMIT;
	
	private Timeline timeline;

 
    @FXML
    private Button startTimerButton;
    
    @FXML
    private Label timerLabel;
    
    @FXML
    private Label heatDisplayLabel;

    @FXML
    private Button saveScoresButton;
    
    @FXML
    private Button removeScore;

    @FXML
    private Button nextHeatButton;

    @FXML
    private ComboBox<Pilots> pilotSelectionComboBox;

    @FXML
    private Label pilotHeat;
    @FXML
    private TextField pilotScoreEntry;
    
    @FXML
    private Button roundMenuButton;
    ObservableList<Pilots> PilotList;
    
    
    /**
     * Saves score of pilots in heat
     * 
     * @param event
     */
    @FXML
    void saveScores(ActionEvent event) {
    	//TODO create a saveCurrentScores, that will set the selected pilot in this
    	//heat, currentScore to what value is entered and then add the score to the gen
    	//array list
    	if(RaceModelOrganizer.checkPilotAndScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText())==true) {
    	RaceModelOrganizer.saveCurrentScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText());
    	}else {
    		
    	}
    }
    
    /**
     * Removes score from selected pilot
     * 
     * @param event
     */
    @FXML
    void removeScore(ActionEvent event) {
    	if(RaceModelOrganizer.checkPilotAndScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText())==true) {

    	RaceModelOrganizer.removeScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText());
    	}else {
    		
    	}
    }

    /**
     * Change to the next head inside the current round
     * 
     * @param event
     */
    @FXML
    void nextHeatUpdatedScene(ActionEvent event) {
    	
    	heatDisplayLabel.setText(RaceModelOrganizer.heatLabelDisplayChanger());	
    	pilotHeat.setText(RaceModelOrganizer.nextHeat());
    	pilotSelectionComboBox.setItems(FXCollections.observableArrayList(RaceModelOrganizer.heatComboBoxDisplay()));
    	timeline.stop();
    	timerLabel.setText("");
    	
    	
    }
/**
 * Starts timer for race, so user can keep track of pilots laps within time span
 * 
 * @param event
 */
    @FXML
    void startTimer(ActionEvent event) {
    	
    	
    	if( timeline != null)
    		timeline.stop();
    	
    	seconds = TIME_LIMIT;
    	
    	
    	String timeStr; 
    	
		int min = seconds / 60;
		int scnds = seconds % 60;
		
		timeStr = min + ":" + scnds;
    	
    	timerLabel.setText( timeStr );
    	
    	timeline = new Timeline();
    	
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	
    	timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler() 
    	{

			@Override
			public void handle(Event event) {
				
				String timeStr;
				
				seconds--;
				
				int min = seconds / 60;
				int scnds = seconds % 60;
				
				if( scnds < 10)
					timeStr = min + ":0" + scnds;
					timeStr = min + ":" + scnds;
				
				timerLabel.setText( timeStr );
				
				if(seconds <= 0)
				{
					timeline.stop();
					JOptionPane.showMessageDialog(null, "Times up!!");
				}
			};
    		
    	}));
    	
    	
    	timeline.playFromStart();

    }
    
    
    /**
     * Return to the round Menu
     * 
     * @param event
     */
    @FXML
    void returnToRoundMenu(ActionEvent event) {

    	RaceModelOrganizer.currentRound();
    	RaceModelOrganizer.zeroOutNum();
    	
    	Parent root;
		try {
			
			root = FXMLLoader.load(getClass().getResource("../view/RoundView.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Round Menu");
			Main.stage.show();
			timeline.stop();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }

    /**
     * show the current heat, pilots inside heat, pilots in current heat to be selected
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		heatDisplayLabel.setText(RaceModelOrganizer.heatLabelDisplayChanger());// change the display label to the current heat number
				
		pilotHeat.setText(RaceModelOrganizer.displayFirstHeat());//change the pilot head display label to the current heat
		pilotSelectionComboBox.setItems(FXCollections.observableArrayList(RaceModelOrganizer.heatComboBoxDisplay()));
		
	}
    
}
