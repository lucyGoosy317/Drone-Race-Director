package application.controller;

/**
 * The endRaceController Class saves final race results to data file
 * 
 * @author Luziano Reyna vtk064
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class endRaceController implements Initializable {

    @FXML
    private Button saveResults;

    @FXML
    private Label pilotFinalResult;
    
    @FXML
    private TextArea resultsTextArea;
    
    
    /**
     * Save event to file 
     * 
     * @param event
     */
    @FXML
    void save(ActionEvent event) {
    	FileChooser fileChooser= new FileChooser();
    	
    	//Set extension filter
    	FileChooser.ExtensionFilter extFilter= new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    	FileChooser.ExtensionFilter extFilter2= new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
    	fileChooser.getExtensionFilters().add(extFilter);
    	fileChooser.getExtensionFilters().add(extFilter2);
    	
    	File file= fileChooser.showSaveDialog(Main.stage);
    	
    	if(file !=null) {
    		saveFile(resultsTextArea.getText(),file);
    		}
    	
    	}
    
    
    
    
    
    	//**************save Method***********
    	//RaceModelOrganizer.save(pilotFinalResult.getText());
    	

    
    /**
     * Save content to file
     * 
     * @param content
     * @param file
     */
    private void saveFile(String content, File file) {
    	try {
    		FileWriter fileWriter;
    		
    		fileWriter=new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * 
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//pilotFinalResult.setText(RaceModelOrganizer.displayAllPilots());
		resultsTextArea.setText(RaceModelOrganizer.displayAllPilots());
		
	}

}

