package application.controller;

/**
 * Uploads pilot with designated band choose by user 
 * into data list, entering pilot into the race.
 * 
 * @author Luziano Reyna vtk064
 * @author james k williams (mft520)
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
    
    
/**
 * Returns user back t main menu, "RaceStart.fxml" view
 * 
 * @param event
 */
    @FXML
    void loadHome(ActionEvent event) {

    	Parent root;
		try {

			root = FXMLLoader.load(getClass().getResource("../view/RaceStart.fxml"));
			Main.stage.setScene(new Scene(root, 600, 600));
			Main.stage.setTitle("Race Start Menu");
			Main.stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   
  /**
   * Uploads list of designated frequencies from selected BandA
   * 
   * @param event
   */
    @FXML
    void bandAFillComboBox(ActionEvent event) {
    	bandARadioButton.setToggleGroup(group);
    	bandARadioButton.setSelected(true);
    	bandARadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandA);
    }
    
    /**
     * Uploads list of designated frequencies from selected BandB
     * 
     * @param event
     */
    @FXML
    void bandBFillComboBox(ActionEvent event) {
    	bandBRadioButton.setToggleGroup(group);
    	bandBRadioButton.setSelected(true);
    	bandBRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandB);
    }

    /**
     * Uploads list of designated frequencies from selected BandE
     * 
     * @param event
     */
    @FXML
    void bandEFillComboBox(ActionEvent event) {
    	bandERadioButton.setToggleGroup(group);
    	bandERadioButton.setSelected(true);
    	bandERadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandE);
    }

    /**
     * Uploads list of designated frequencies from selected BandF
     * 
     * @param event
     */
    @FXML
    void bandFFillComboBox(ActionEvent event) {
    	bandFRadioButton.setToggleGroup(group);
    	bandFRadioButton.setSelected(true);
    	bandFRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandF);
    }

    /**
     * Uploads list of designated frequencies from selected BandR
     * 
     * @param event
     */
    @FXML
    void bandRFillComboBox(ActionEvent event) {
    	bandRRadioButton.setToggleGroup(group);
    	bandRRadioButton.setSelected(true);
    	bandRRadioButton.requestFocus();
    	ChannelsComboBox.setItems(BandR);
    }


/**
 * Initializes ChannelsComboBox in order to be populated with frequency 
 * upon band selection
 * 
 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChannelsComboBox.setPromptText("Select Frequency");
		
	}

/**
 * Registers event that prompt user for pilot name and channel selection
 * displays error message to user if not completed
 */
	@Override
	public void handle(Event event) {
		String pilotName=pilotNameTextField.getText();
		Channel selectedChannel=ChannelsComboBox.getValue();
		
		if(pilotName.isEmpty() && selectedChannel==null) {
			JOptionPane.showMessageDialog(null,"Please enter a pilot and chanel");

		}else if(pilotName.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Please enter a Pilot");

		}else if(selectedChannel==null) {
			JOptionPane.showMessageDialog(null,"Please selected a Channel");

		}else {
			RaceModelOrganizer.createNewPilot(pilotName, selectedChannel);
		
		}
	}

	
}
