package application.controller;
/**
 * @author Luziano Reyna vtk064
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Channel;
import application.model.Heat;
import application.model.Pilots;
import application.model.RaceModelOrganizer;
import application.model.Round;
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

public class RaceConfigureController  {

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

			root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigure.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Race Start Menu");
			Main.stage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// this allows rounds to be entered
	public void enterRounds(ActionEvent event) {

		// This will create the rounds, heats, and restrict pilots while
		// doing checks to ensure pilot entered a number
		if (RaceModelOrganizer.createRounds(roundEntryTextField.getText()) == true) {

			Parent root;
			try {

				root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigureHeats.fxml"));
				Main.stage.setScene(new Scene(root, 600, 600));
				Main.stage.setTitle("Heat Amounts");
				Main.stage.show();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	// this allows heats to be entered
	public void enterHeats(ActionEvent event) {

		// This will create the rounds, heats, and restrict pilots while
		// doing checks to ensure pilot entered a number
		if (RaceModelOrganizer.createHeats(heatsEntryTextField.getText()) == true) {

			Parent root;
			try {

				root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigureLoadHeats.fxml"));
				Main.stage.setScene(new Scene(root, 600, 600));
				Main.stage.setTitle("Load Pilots Amounts");
				Main.stage.show();
				


			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	

	

}
