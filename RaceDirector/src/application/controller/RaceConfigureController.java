package application.controller;
/**
 * @author Luziano Reyna vtk064
 */

import java.io.IOException;

import application.Main;
import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RaceConfigureController {

	@FXML
	private Button homeButton;

	@FXML
	private TextField roundEntryTextField;

	@FXML
	private TextField pilotEntryTextField;

	@FXML
	private TextField heatsEntryTextField;

	public String roundEntry;
	public String heatsEntry;
	public String pilotEntry;
	public RaceModelOrganizer raceModel= new RaceModelOrganizer();
	/**
	public RaceConfigureController(String roundEntry,String heatsEntry,String pilotEntry) {
		this.roundEntry=roundEntry;
		this.heatsEntry=heatsEntry;
		this.pilotEntry=pilotEntry;
	}
	
	//***************Getters & Setters*******************
	public String getRoundEntry() {
		return roundEntry;
	}

	public void setRoundEntry(String roundEntry) {
		this.roundEntry = roundEntry;
	}

	public String getHeatsEntry() {
		return heatsEntry;
	}

	public void setHeatsEntry(String heatsEntry) {
		this.heatsEntry = heatsEntry;
	}

	public String getPilotEntry() {
		return pilotEntry;
	}

	public void setPilotEntry(String pilotEntry) {
		this.pilotEntry = pilotEntry;
	}

	**/
	
	
	//**************************Methods********************************
	@FXML
	public void roundEntryTextField(ActionEvent event) {
		
		String roundEntry=roundEntryTextField.getText();
		this.roundEntry=roundEntry;
		raceModel.createRounds(this.roundEntry);
	}

	@FXML
	public void heatsEntryTextField(ActionEvent event) {
		String heatsEntry=heatsEntryTextField.getText();
		this.heatsEntry=heatsEntry;
		raceModel.createHeats(this.heatsEntry);
	}

	@FXML
	public void pilotEntryTextField(ActionEvent event) {
		String pilotEntry=heatsEntryTextField.getText();
		this.pilotEntry=pilotEntry;
		raceModel.createRounds(this.pilotEntry);
	}

	@FXML
	void loadHome(ActionEvent event) {

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStart.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Race Start Menu");
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
