package controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.GameStatus;
import main.GameWindow;
import ship.ShipType;

public class PlaceShipsController implements ButtonController {
	private GameWindow gamewindow;
	private ShipType addedType;
	private boolean carrierReady, cruiserReady, battleshipReady, destroyerReady, submarineReady;
	
	public PlaceShipsController(GameWindow gw) {
		gamewindow = gw;
		carrierReady = cruiserReady = battleshipReady = destroyerReady = submarineReady = false;
		addedType = ShipType.CARRIER;
	}
	
	public ShipType getAddedType() {
		return addedType;
	}
	
	public void chooseCarrier() {
		addedType = ShipType.CARRIER;
	}
	
	public void chooseCruiser() {
		addedType = ShipType.CRUISER;
	}
	
	public void chooseBattleship() {
		addedType = ShipType.BATTLESHIP;
	}
	
	public void chooseDestroyer() {
		addedType = ShipType.DESTROYER;
	}
	
	public void chooseSubmarine() {
		addedType = ShipType.SUBMARINE;
	}
	
	public boolean isReady() {
		return carrierReady && cruiserReady && battleshipReady && destroyerReady && submarineReady;
	}
	
	public void setShipStatus(ShipType ship, boolean status) {
		switch(ship) {
			case CARRIER: carrierReady = status; break;
			case CRUISER: cruiserReady = status; break;
			case BATTLESHIP: battleshipReady = status; break;
			case DESTROYER: destroyerReady = status; break;
			case SUBMARINE: submarineReady = status; break;
		}
	}
	
	public boolean getShipStatus(ShipType ship) {
		boolean status = false;
		switch(ship) {
			case CARRIER: status = carrierReady; break;
			case CRUISER: status = cruiserReady; break;
			case BATTLESHIP: status = battleshipReady; break;
			case DESTROYER: status = destroyerReady; break;
			case SUBMARINE: status = submarineReady; break;
		}
		return status;
	}
	
	@Override
	public void handleButton(Object s) {
		if(s instanceof JButton && ((JButton) s).getText() == "Continue") {
			if(isReady()) {
				gamewindow.setStatus(GameStatus.INGAME);
			} else {
				JOptionPane.showMessageDialog(null, "Vous devez placer vos cinq bateaux !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
