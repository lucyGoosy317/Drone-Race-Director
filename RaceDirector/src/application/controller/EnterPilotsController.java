package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Channel;
import application.model.RaceModelOrganizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EnterPilotsController implements Initializable{

    @FXML
    private Button enterPilotButton;


    @FXML
    private ComboBox<Channel> ChannelEComboBox;
    
    @FXML
    private ComboBox<Channel> ChannelFComboBox;

    @FXML
    private ComboBox<Channel> ChannelRComboBox;

    @FXML
    private ComboBox<Channel> ChannelAComboBox;

    @FXML
    private ComboBox<Channel> ChannelBComboBox;
    
    @FXML
    private Button homeButton;

    @FXML
    private TextField pilotNameTextField;
    
    ObservableList<Channel> BandA=FXCollections.observableArrayList(RaceModelOrganizer.getChannelListBandA());
    ObservableList<Channel> BandB=FXCollections.observableArrayList(RaceModelOrganizer.getChannelListBandB());
    ObservableList<Channel> BandE=FXCollections.observableArrayList(RaceModelOrganizer.getChannelListBandE());
    ObservableList<Channel> BandF=FXCollections.observableArrayList(RaceModelOrganizer.getChannelListBandF());
    ObservableList<Channel> BandR=FXCollections.observableArrayList(RaceModelOrganizer.getChannelListBandR());
    
    private String PilotName;

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

    @FXML
    void getPilotNameTextField(ActionEvent event) {
    	PilotName=pilotNameTextField.getText();

    }

    @FXML
    void channelAComboFillMe(ActionEvent event) {

    }

    @FXML
    void channelBComboFillMe(ActionEvent event) {

    }

    @FXML
    void channelEComboFillMe(ActionEvent event) {

    }

    @FXML
    void channelFComboFillMe(ActionEvent event) {

    }

    @FXML
    void channelRComboFillMe(ActionEvent event) {

    }

    @FXML
    void getEnterPilotData(ActionEvent event) {
    	
 

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChannelAComboBox.setPromptText("Select Freq");
		ChannelAComboBox.setItems(BandA);
		
		ChannelBComboBox.setItems(BandB);
		ChannelBComboBox.setPromptText("Select Freq");
		
		ChannelEComboBox.setItems(BandE);
		ChannelEComboBox.setPromptText("Select Freq");
		
		ChannelFComboBox.setItems(BandF);
		ChannelFComboBox.setPromptText("Select Freq");
		
		ChannelRComboBox.setItems(BandR);
		ChannelRComboBox.setPromptText("Select Freq");
	}

}
