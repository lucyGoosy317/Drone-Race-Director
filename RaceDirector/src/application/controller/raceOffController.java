package application.controller;

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

public class raceOffController implements Initializable{

    @FXML
    private ComboBox<Pilots> pilotSelectionComboBox1;

    @FXML
    private ComboBox<Pilots> pilotSelectionComboBox2;

    @FXML
    private Label pilotHeat;

    @FXML
    private Label pilotsDisplay;

    @FXML
    private Button endResultsButton;

    @FXML
    private Button swapButton;
    
    ObservableList<Pilots> PilotList=FXCollections.observableArrayList(RaceModelOrganizer.getPilotGeneralPilotList());

    @FXML
    void swapPilots(ActionEvent event) {
    	RaceModelOrganizer.swapPilots(pilotSelectionComboBox1.getValue(), pilotSelectionComboBox2.getValue());
    	pilotsDisplay.setText(RaceModelOrganizer.displayAllPilots());
    }

    @FXML
    void goToEndResults(ActionEvent event) {

    	Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/endRaceView.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("End Of Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pilotSelectionComboBox1.setPromptText("Swap Pilot");
		pilotSelectionComboBox1.setItems(PilotList);
		pilotSelectionComboBox1.setPromptText("Swap Pilot");
		pilotSelectionComboBox2.setItems(PilotList);
		pilotsDisplay.setText(RaceModelOrganizer.displayAllPilots());
		
		
	}

}
