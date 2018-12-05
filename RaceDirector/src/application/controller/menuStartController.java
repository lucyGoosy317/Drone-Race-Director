package application.controller;

/**
 * The menuStartController is the first view of the DroneRaceDirector application
 * and displays a Start button, an event when clicked displays more options.
 * 
 * @author Luziano Reyna vtk064
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.RaceModelOrganizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class menuStartController implements Initializable {

	 public  RaceModelOrganizer raceOrganizer=new RaceModelOrganizer();

	 /**
	  * Registers an event that displays "RaceStart.fxml" view
	  * 
	  * @param event
	  */
    @FXML
    void handle(ActionEvent event) {


		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStart.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setResizable(false);
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

    /**
     * Loads data "channelList.csv" for usage in the application
     * 
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		raceOrganizer.loadChannels("data/channelList.csv");
	}

}
