package application.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Luziano Reyna vtk064
 *
 */
public class Heat  {
	
	public ArrayList<Pilots>PilotsInHeat;
	public String heatName;
	
	/**
	 * 
	 * @param heatName will accept a String value
	 */
	//*********Constructor********************
	
	public Heat(String heatName) {
		this.heatName=heatName;
		PilotsInHeat=new ArrayList<Pilots>();
		
	}

	
	
	
	
	//**********getters & Setter**************
	
	/**
	 * 
	 * @return will return String value of heatName
	 */
	public String getHeatName() {
		return heatName;
	}
	
	/**
	 * 
	 * @param heatName will accept a String object and set to heatName
	 */
	public void setHeatName(String heatName) {
		this.heatName = heatName;
	}
	
		
	//**************Methods*********************
	//will add a pilot into a heat
	public void addPilotsToHeat(Pilots heatPilot) {
		//check to see if the pilot is already inside a heat
		if(PilotsInHeat.contains(heatPilot)) {
			//alert the user if the pilot is in the heat
			JOptionPane.showMessageDialog(null,heatPilot.getPilotName()+"Is already in"+heatName);
		}else {
			//if the pilot is not in the heat then add pilot to heat
			PilotsInHeat.add(heatPilot);
			//alert the user that the pilot was loaded into the heat
			JOptionPane.showMessageDialog(null,heatPilot.getPilotName()+" Has been added to"+heatName);
		}
	}

	
	//will remove a pilot from a heat
	public void removePilotsFromHeat(Pilots heatPilot) {
		//check to see if pilot is in heat
		if(PilotsInHeat.contains(heatPilot)) {
			//if the pilot is in the heat remove them
			PilotsInHeat.remove(heatPilot);
			//alert the user that the pilot has been removed from that heat
			JOptionPane.showMessageDialog(null,heatPilot.getPilotName()+" has been removed from "+heatName);
		}else {
			//if the pilot is not in the heat, alert the user that the pilot is not in the heat
			JOptionPane.showMessageDialog(null,heatPilot.getPilotName()+" is not in "+heatName);
		}
		
	}
	
	//
	public String returnPilotsOfHeat() {
		String ret=heatName+":"+"\n";
		for(int i=0;i<PilotsInHeat.size();i++) {
			ret+=PilotsInHeat.get(i)+" Round Score:"+ PilotsInHeat.get(i).getPilotsScore() +"\n";
		}
		
		return ret;
	}
	
		
		
		
	
	
	//************to String**********************
	/**
	 * @return will return heat name
	 */
	public String toString() {
		String ret="";
		ret=heatName;
		
		return ret;
	}
	
	

}
