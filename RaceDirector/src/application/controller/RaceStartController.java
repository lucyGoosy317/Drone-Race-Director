package application.controller;
/**
 * RaceStart class shows main menu to user and allows him four options; load pilots (from data file, 
 * enter pilots (directly), configure race (set up channels, heat, rounds), start race (begins race)
 * 
 * @author Luziano Reyna vtk064
 */

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

import application.Main;

import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    
   

    
   
  
    
/**
 * Opens local file so user can upload data file
 * 
 * @param event
 */
    @FXML
    void loadPilotsScene(ActionEvent event) {
    
    	FileChooser fileChooser=new FileChooser();
		    fileChooser.setTitle("Open Resource File");
		    //fileChooser.showOpenDialog(Main.stage);
		    File file= fileChooser.showOpenDialog(Main.stage);
		    if(file==null) {
				JOptionPane.showMessageDialog(null, "No Pilots Have been loaded");

		    }else {
		    RaceModelOrganizer.loadFileFromDesktop(file);
		   // JOptionPane.showMessageDialog(null, "Your Pilots have been Loaded");
		    }
    }

   
/**
 * Registers event adding pilots entered into race
 * 
 * @param event
 */
    @FXML
    void enterPilotsScene(ActionEvent event) {
    	

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/EnterPilots.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setResizable(false);
			Main.stage.setTitle("Enter Pilots");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

    
/**
 * Registers event that takes user to Configure Race in RaceStartConfigureRounds.fxml (view)
 * 
 * @param event
 */
    @FXML
    void configureRaceScene(ActionEvent event) {
    	

		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigureRounds.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setResizable(false);
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

/**
 * Registers event that takes user to Round Menu in RoundView.fxml (view)
 * 
 * @param event
 */
    @FXML
    void startRaceScene(ActionEvent event) {
    	
    	//RaceModelOrganizer.currentRound();
    	if(RaceModelOrganizer.checkRounds()==true) {
    	
    	Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RoundView.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Round Menu");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	}else {
    		
    	}
    	
    	
    }

	
	

    

}

