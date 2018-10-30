package application.controller;
/**
 * @author Luziano Reyna vtk064
 */

import java.io.IOException;

import application.Main;
import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class RaceConfigureController implements EventHandler<Event> {

	@FXML
	private Button homeButton;

	@FXML
	private TextField roundEntryTextField;

	@FXML
	private TextField pilotEntryTextField;

	@FXML
	private TextField heatsEntryTextField;

	@FXML
	private Label roundDisplayLabel;

	@FXML
	private Label pilotsDisplayLabel;

	@FXML
	private Label heatDisplayLabel;



	// **************************Methods********************************

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

	//this handles the enter button
	@Override
	public void handle(Event event) {
		
		// This will create the rounds, heats, and restrict pilots while 
		//doing checks to ensure pilot entered a number
		if(RaceModelOrganizer.createRounds(roundEntryTextField.getText())==true) {
			if(RaceModelOrganizer.createHeats(heatsEntryTextField.getText())==true) {
				if(RaceModelOrganizer.restrictPilotsPerHeat(pilotEntryTextField.getText())==true) {
					roundDisplayLabel.setText(roundEntryTextField.getText());
					heatDisplayLabel.setText(heatsEntryTextField.getText());
					pilotsDisplayLabel.setText(pilotEntryTextField.getText());
					
				}
			}
		}
	

	}

}
