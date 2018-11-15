package application.controller;
/**
 * @author Luziano Reyna vtk064
 * 
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

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
    
    @FXML
    void saveScores(ActionEvent event) {
    	//TODO create a saveCurrentScores, that will set the selected pilot in this
    	//heat, currentScore to what value is entered and then add the score to the gen
    	//array list
    	RaceModelOrganizer.saveCurrentScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText());
    }
    
    @FXML
    void removeScore(ActionEvent event) {
    	RaceModelOrganizer.removeScore(pilotSelectionComboBox.getValue(), pilotScoreEntry.getText());
    }

    //Change to the next head inside the current round
    @FXML
    void nextHeatUpdatedScene(ActionEvent event) {
    	
    	heatDisplayLabel.setText(RaceModelOrganizer.heatLabelDisplayChanger());	
    	pilotHeat.setText(RaceModelOrganizer.nextHeat());
    	pilotSelectionComboBox.setItems(FXCollections.observableArrayList(RaceModelOrganizer.heatComboBoxDisplay()));
    	
    	
    }

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
    
    
    //Return to the round Menu
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

		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }

    //show the current heat, pilots inside heat, pilots in current heat to be selected
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		heatDisplayLabel.setText(RaceModelOrganizer.heatLabelDisplayChanger());// change the display label to the current heat number
				
		pilotHeat.setText(RaceModelOrganizer.displayFirstHeat());//change the pilot head display label to the current heat
		pilotSelectionComboBox.setItems(FXCollections.observableArrayList(RaceModelOrganizer.heatComboBoxDisplay()));
		
	}
    
}
