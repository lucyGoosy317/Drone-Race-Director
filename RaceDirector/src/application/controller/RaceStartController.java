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

public class RaceStartController implements Initializable {

    @FXML
    private Button configureRaceButton;

    @FXML
    private Button enterPilotsButton;

    @FXML
    private Button loadPilotsButton;
    
   

    
   
    public  RaceModelOrganizer raceOrganizer=new RaceModelOrganizer();
    

    @FXML
    void loadPilotsScene(ActionEvent event) {

    	
		FileChooser fileChooser=new FileChooser();
		    fileChooser.setTitle("Open Resource File");
		    //fileChooser.showOpenDialog(Main.stage);
		    File file= fileChooser.showOpenDialog(Main.stage);
		    raceOrganizer.loadFileFromDesktop(file);
		    JOptionPane.showMessageDialog(null, "Your Pilots have been Loaded");
    	
    	
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

			root = FXMLLoader.load(getClass().getResource("../view/RaceStartConfigure.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }



	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		raceOrganizer.loadChannels("data/channelList.csv");
		
	}

    

}

