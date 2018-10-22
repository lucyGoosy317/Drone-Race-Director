package application.controller;
/**
 * @author Luziano Reyna vtk064
 * 
 */


import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HeatController {


    @FXML
    private Label channel8Label;

    @FXML
    private Label name2Label;

    @FXML
    private Label channel6Label;

    @FXML
    private Button startTimerButton;

    @FXML
    private Label secondsLabel;

    @FXML
    private Label channel3Label;

    @FXML
    private Label name3Label;

    @FXML
    private Label minuteLabel;

    @FXML
    private Label heatDisplayLabel;

    @FXML
    private Label score6Label;

    @FXML
    private Label name6Label;

    @FXML
    private Label score3Label;

    @FXML
    private Label name4Label;

    @FXML
    private Label name7Label;

    @FXML
    private Label name1Label;

    @FXML
    private Label channel7Label;

    @FXML
    private Label score5Label;

    @FXML
    private Label channel4Label;

    @FXML
    private Button saveScoresButton;

    @FXML
    private Label score2Label;

    @FXML
    private Button nextHeatButton;

    @FXML
    private Label score7Label;

    @FXML
    private Label channell1Label;

    @FXML
    private Label score1Label;

    @FXML
    private Label score4Label;
    
    @FXML
    private Button roundMenuButton;
    
    @FXML
    void saveScores(ActionEvent event) {

    }

    @FXML
    void nextHeatUpdatedScene(ActionEvent event) {

    }

    @FXML
    void startTimer(ActionEvent event) {

    }
    
    @FXML
    void returnToRoundMenu(ActionEvent event) {

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
    
}
