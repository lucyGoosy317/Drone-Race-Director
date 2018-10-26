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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EnterPilotsController  implements Initializable, EventHandler<Event>{

    @FXML
    private Button enterPilotButton;

    @FXML
    private RadioButton bandERadioButton;
 

    @FXML
    private RadioButton bandRRadioButton;

    @FXML
    private RadioButton bandFRadioButton;

    @FXML
    private RadioButton bandARadioButton;

    @FXML
    private ComboBox<Channel> ChannelsComboBox;

    @FXML
    private RadioButton bandBRadioButton;
    //toggling thru the radio buttons
    @FXML
    final ToggleGroup group= new ToggleGroup();
    
    
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
    void bandAFillComboBox(ActionEvent event) {
    	bandARadioButton.setToggleGroup(group);
    	bandARadioButton.setSelected(true);
    	bandARadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandA);
    }

    @FXML
    void bandBFillComboBox(ActionEvent event) {
    	bandBRadioButton.setToggleGroup(group);
    	bandBRadioButton.setSelected(true);
    	bandBRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandB);
    }

    @FXML
    void bandEFillComboBox(ActionEvent event) {
    	bandERadioButton.setToggleGroup(group);
    	bandERadioButton.setSelected(true);
    	bandERadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandE);
    }

    @FXML
    void bandFFillComboBox(ActionEvent event) {
    	bandFRadioButton.setToggleGroup(group);
    	bandFRadioButton.setSelected(true);
    	bandFRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandF);
    }

    @FXML
    void bandRFillComboBox(ActionEvent event) {
    	bandRRadioButton.setToggleGroup(group);
    	bandRRadioButton.setSelected(true);
    	bandRRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandR);
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChannelsComboBox.setPromptText("Select Frequency");
		
	}


	@Override
	public void handle(Event event) {
		String pilotName=pilotNameTextField.getText();
		Channel selectedChannel=ChannelsComboBox.getValue();
		RaceModelOrganizer.createNewPilot(pilotName, selectedChannel);
		
	}

	
}
