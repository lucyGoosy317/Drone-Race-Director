package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class endRaceController implements Initializable {

    @FXML
    private Button saveResults;

    @FXML
    private Label pilotFinalResult;
    
    @FXML
    void save(ActionEvent event) {
    	//TODO utilize the the showsavedialog to save to any location
    	
    	//**************save Method***********
    	RaceModelOrganizer.save(pilotFinalResult.getText());
    	

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		pilotFinalResult.setText(RaceModelOrganizer.displayAllPilots());
		
	}

}

