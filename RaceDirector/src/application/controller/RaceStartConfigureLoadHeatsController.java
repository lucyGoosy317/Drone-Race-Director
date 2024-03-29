package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Heat;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
/**
 * RaceStartConfigureLoadHeatsController allows user to add/remove pilot to/from heat and updates display
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class RaceStartConfigureLoadHeatsController implements Initializable {


	@FXML
	private ComboBox<Pilots> pilotComboBox;

	@FXML
	private ComboBox<Heat> heatComboBox;
	
	 @FXML
	private Label currentHeatDisplay;

	ObservableList<Pilots> PilotList=FXCollections.observableArrayList(RaceModelOrganizer.getPilotGeneralPilotList());
    ObservableList<Heat> HeatList=FXCollections.observableArrayList(RaceModelOrganizer.getHeats());

    /**
     * Adds a pilot from heat>>RaceModelOrganizer>>Heat
     * updates the label of the current heat after pilot is entered>>RaceModelOrganizer
     * 
     * @param event
     */
    @FXML
    void addPilot(ActionEvent event) {
    	if(RaceModelOrganizer.checkPilotsAndHeats(pilotComboBox.getValue(), heatComboBox.getValue())==true) {
    	RaceModelOrganizer.loadPilotsIntoHeats(pilotComboBox.getValue(), heatComboBox.getValue());
    	
    	
    	currentHeatDisplay.setText(RaceModelOrganizer.displayCurrentHeat(heatComboBox.getValue()));
    	}
    }
    
    
    /**
     * Remove a pilot from heat>>RaceModelOrganizer>>Heat
     * updates the label of the current heat after a pilot is removed>>RaceModelOrganizer
     * @param event
     */
    @FXML
    void removePilot(ActionEvent event) {
    	if(RaceModelOrganizer.checkPilotsAndHeats(pilotComboBox.getValue(), heatComboBox.getValue())==true) {
    	RaceModelOrganizer.removePilotsFromHeats(pilotComboBox.getValue(), heatComboBox.getValue());
    	currentHeatDisplay.setText(RaceModelOrganizer.displayCurrentHeat(heatComboBox.getValue()));
    	}else {
    		
    	}
    }
    
    /**
     * will show the change the current heat list as the user selects the heat comboBox
     * 
     * @param event
     */
    @FXML
    void changeDisplay(ActionEvent event) {
    	
    	currentHeatDisplay.setText(RaceModelOrganizer.displayCurrentHeat(heatComboBox.getValue()));
    }
    
    /**
     * load to the race start menu
     * 
     * @param event
     */
    @FXML
    void loadHome(ActionEvent event) {

    	//load pilots into rounds
    	RaceModelOrganizer.loadHeatsIntoRounds();
    	
    	//load home
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
	public void initialize(URL location, ResourceBundle resources) {
		//setting the promot text and list of items that will be viewed inside the comboBoxes
		pilotComboBox.setPromptText("Select Pilot");
		pilotComboBox.setItems(PilotList);
		heatComboBox.setPromptText("Select Heat");
		heatComboBox.setItems(HeatList);
		
	}

}