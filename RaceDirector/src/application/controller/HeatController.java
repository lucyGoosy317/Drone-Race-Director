package application.controller;
/**
 * @author Luziano Reyna vtk064
 * 
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Pilots;
import application.model.RaceModelOrganizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HeatController implements Initializable  {


 
    @FXML
    private Button startTimerButton;

    @FXML
    private Label secondsLabel;

    @FXML
    private Label minuteLabel;

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
