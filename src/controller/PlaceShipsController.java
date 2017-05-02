package controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import game.AbstractGame;
import graphic.Coord2D;
import main.GameStatus;
import main.GameWindow;
import player.PlayerType;
import ship.Orientation;
import ship.ShipType;

public class PlaceShipsController implements ButtonController {
	private GameWindow gamewindow;
	private ShipType addedType;
	private boolean carrierReady, cruiserReady, battleshipReady, destroyerReady, submarineReady;
	private Coord2D carrierPos, cruiserPos, battleshipPos, destroyerPos, submarinePos;
	private Orientation carrierOri, cruiserOri, battleshipOri, destroyerOri, submarineOri;
	
	public PlaceShipsController(GameWindow gw) {
		gamewindow = gw;
		carrierReady = cruiserReady = battleshipReady = destroyerReady = submarineReady = false;
		carrierOri = cruiserOri = battleshipOri = destroyerOri = submarineOri = Orientation.HORIZONTAL;
		addedType = ShipType.CARRIER;
	}
	
	public ShipType getAddedType() {
		return addedType;
	}
	
	public void chooseCarrier() {
		if(addedType == ShipType.CARRIER) {
			if(carrierOri == Orientation.HORIZONTAL) carrierOri = Orientation.VERTICAL;
			else carrierOri = Orientation.HORIZONTAL;
		}
		addedType = ShipType.CARRIER;
	}
	
	public void chooseCruiser() {
		if(addedType == ShipType.CRUISER) {
			if(cruiserOri == Orientation.HORIZONTAL) cruiserOri = Orientation.VERTICAL;
			else cruiserOri = Orientation.HORIZONTAL;
		}
		addedType = ShipType.CRUISER;
	}
	
	public void chooseBattleship() {
		if(addedType == ShipType.BATTLESHIP) {
			if(battleshipOri == Orientation.HORIZONTAL) battleshipOri = Orientation.VERTICAL;
			else battleshipOri = Orientation.HORIZONTAL;
		}
		addedType = ShipType.BATTLESHIP;
	}
	
	public void chooseDestroyer() {
		if(addedType == ShipType.DESTROYER) {
			if(destroyerOri == Orientation.HORIZONTAL) destroyerOri = Orientation.VERTICAL;
			else destroyerOri = Orientation.HORIZONTAL;
		}
		addedType = ShipType.DESTROYER;
	}
	
	public void chooseSubmarine() {
		if(addedType == ShipType.SUBMARINE) {
			if(submarineOri == Orientation.HORIZONTAL) submarineOri = Orientation.VERTICAL;
			else submarineOri = Orientation.HORIZONTAL;
		}
		addedType = ShipType.SUBMARINE;
	}
	
	public boolean isReady() {
		return carrierReady && cruiserReady && battleshipReady && destroyerReady && submarineReady;
	}
	
	public Orientation getShipOrientation(ShipType ship) {
		Orientation ori = null;
		switch(ship) {
			case CARRIER: ori = carrierOri; break;
			case CRUISER: ori = cruiserOri; break;
			case BATTLESHIP: ori = battleshipOri; break;
			case DESTROYER: ori = destroyerOri; break;
			case SUBMARINE: ori = submarineOri; break;
		}
		return ori;
	}
	
	public void setShipOrientation(ShipType ship, Orientation orientation) {
		switch(ship) {
			case CARRIER: carrierOri = orientation; break;
			case CRUISER: cruiserOri = orientation; break;
			case BATTLESHIP: battleshipOri = orientation; break;
			case DESTROYER: destroyerOri = orientation; break;
			case SUBMARINE: submarineOri = orientation; break;
		}
	}
	
	public void setShipPosition(ShipType ship, Coord2D position) {
		switch(ship) {
			case CARRIER: carrierPos = position; carrierReady = true; break;
			case CRUISER: cruiserPos = position; cruiserReady = true; break;
			case BATTLESHIP: battleshipPos = position; battleshipReady = true; break;
			case DESTROYER: destroyerPos = position; destroyerReady = true; break;
			case SUBMARINE: submarinePos = position; submarineReady = true; break;
		}
	}
	
	public Coord2D getShipPosition(ShipType ship) {
		Coord2D position = null;
		switch(ship) {
			case CARRIER: position = carrierPos; break;
			case CRUISER: position = cruiserPos; break;
			case BATTLESHIP: position = battleshipPos; break;
			case DESTROYER: position = destroyerPos; break;
			case SUBMARINE: position = submarinePos; break;
		}
		return position;
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
				AbstractGame game = gamewindow.getGame();
				
				game.addShipDefault(ShipType.CARRIER, carrierPos, carrierOri, PlayerType.HUMAN);
				game.addShipDefault(ShipType.CRUISER, cruiserPos, cruiserOri, PlayerType.HUMAN);
				game.addShipDefault(ShipType.BATTLESHIP, battleshipPos, battleshipOri, PlayerType.HUMAN);
				game.addShipDefault(ShipType.DESTROYER, destroyerPos, destroyerOri, PlayerType.HUMAN);
				game.addShipDefault(ShipType.SUBMARINE, submarinePos, submarineOri, PlayerType.HUMAN);
				
				gamewindow.setStatus(GameStatus.INGAME);
			} else {
				JOptionPane.showMessageDialog(null, "Vous devez placer vos cinq bateaux !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
