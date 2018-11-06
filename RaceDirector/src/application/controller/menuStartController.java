package application.controller;

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

    @FXML
    void handle(ActionEvent event) {


		Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStart.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Configure Race");
			Main.stage.show();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		raceOrganizer.loadChannels("data/channelList.csv");
	}

}
