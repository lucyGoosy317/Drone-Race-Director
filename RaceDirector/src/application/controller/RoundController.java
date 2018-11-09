package application.controller;

/**
 * @author Luziano Reyna vtk064
 * 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RoundController implements Initializable  {

    @FXML
    private Button nextRoundButton;

    @FXML
    private Button startRoundButton;

    @FXML
    private Label heatDisplayLabel;

    @FXML
    private Label roundUpdaterLabel;

    @FXML
    private Button previousRoundButton;

    @FXML
    private Button homeButton;

 	//This is not really a scene change, more of an update with the previous data on it
    @FXML
    void previousRoundScene(ActionEvent event) {

    	heatDisplayLabel.requestFocus();
    	heatDisplayLabel.setText(RaceModelOrganizer.previousRound());
    	roundUpdaterLabel.setText(RaceModelOrganizer.roundLabelUpdater());
    }
//This is a scene change and will go into the Heats 1 by 1
    @FXML
    void startRoundScene(ActionEvent event) {

    	Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/HeatView.fxml"));
			Main.stage.setScene(new Scene(root, 600, 800));
			Main.stage.setTitle("Heat");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	
    }

    //This is not a scene change, more of an updated for the next round
    @FXML
    void nextRoundUpdateScene(ActionEvent event) {

    	heatDisplayLabel.requestFocus();
    	heatDisplayLabel.setText(RaceModelOrganizer.nextRound());
    	roundUpdaterLabel.setText(RaceModelOrganizer.roundLabelUpdater());
    	
    }

    //Load home Scene
    @FXML
    void loadHome(ActionEvent event) {

    	Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStart.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Race Start Menu");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	
    }

   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		roundUpdaterLabel.setText(RaceModelOrganizer.roundLabelUpdater());
		heatDisplayLabel.setText(RaceModelOrganizer.currentRound());
		
	}

} 

