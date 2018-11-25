package application.controller;

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
import javafx.stage.FileChooser;

public class endRaceController implements Initializable {

    @FXML
    private Button saveResults;

    @FXML
    private Label pilotFinalResult;
    
    
    
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
    		saveFile(pilotFinalResult.getText(),file);
    		}
    	
    	}
    	//**************save Method***********
    	//RaceModelOrganizer.save(pilotFinalResult.getText());
    	

    
    
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		pilotFinalResult.setText(RaceModelOrganizer.displayAllPilots());
		
	}

}

