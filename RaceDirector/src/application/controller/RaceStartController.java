package application.controller;
/**
 * @author Luziano Reyna vtk064
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;

import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class RaceStartController  {

    @FXML
    private Button configureRaceButton;

    @FXML
    private Button enterPilotsButton;

    @FXML
    private Button loadPilotsButton;
    
    @FXML
    private Button startRaceButton;
    
   

    
   
  
    

    @FXML
    void loadPilotsScene(ActionEvent event) {
    
    	
		FileChooser fileChooser=new FileChooser();
		    fileChooser.setTitle("Open Resource File");
		    //fileChooser.showOpenDialog(Main.stage);
		    File file= fileChooser.showOpenDialog(Main.stage);
		    RaceModelOrganizer.loadFileFromDesktop(file);
		   // JOptionPane.showMessageDialog(null, "Your Pilots have been Loaded");
    	
    	
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
			
			e.printStackTrace();
		}

    }

    

    @FXML
    void configureRaceScene(ActionEvent event) {
    	

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigureRounds.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }


    @FXML
    void startRaceScene(ActionEvent event) {
    	//TODO maybe
    	//TODO once the director hits the race start button pilots shoud be loaded 
    	//into each round into each heat and only the amount according to the restricted 
    	//
    	//TODO each time the user clicks start round, round count in 

    	//TODO load pilots into heats
    	
    	

    	
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

