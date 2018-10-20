package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RaceStartController {

    @FXML
    private Button configureRaceButton;

    @FXML
    private Button enterPilotsButton;

    @FXML
    private Button loadPilotsButton;

   

    

    @FXML
    void loadPilotsScene(ActionEvent event) {

    	//load scene of load pilots

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/loadPilots.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Load Pilots");
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }

   

    @FXML
    void enterPilotsScene(ActionEvent event) {
    	

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/EnterPilots.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Enter Pilots");
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    

    @FXML
    void configureRaceScene(ActionEvent event) {
    	

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigure.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    

}

