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

public class RaceStartConfigureLoadHeatsController implements Initializable {


	@FXML
	private ComboBox<Pilots> pilotComboBox;

	@FXML
	private ComboBox<Heat> heatComboBox;

	ObservableList<Pilots> PilotList=FXCollections.observableArrayList(RaceModelOrganizer.getPilotGeneralPilotList());
    ObservableList<Heat> HeatList=FXCollections.observableArrayList(RaceModelOrganizer.getHeats());

    @FXML
    void addPilot(ActionEvent event) {

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		pilotComboBox.setPromptText("Select Pilot");
		pilotComboBox.setItems(PilotList);
		System.out.println(RaceModelOrganizer.getPilotGeneralPilotList());
		heatComboBox.setPromptText("Select Heat");
		heatComboBox.setItems(HeatList);
		
	}

}