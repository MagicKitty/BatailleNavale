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
				
				game.addShipDefault(ShipType.CARRIER, carrierPos, Orientation.HORIZONTAL, PlayerType.HUMAN);
				game.addShipDefault(ShipType.CRUISER, cruiserPos, Orientation.HORIZONTAL, PlayerType.HUMAN);
				game.addShipDefault(ShipType.BATTLESHIP, battleshipPos, Orientation.HORIZONTAL, PlayerType.HUMAN);
				game.addShipDefault(ShipType.DESTROYER, destroyerPos, Orientation.HORIZONTAL, PlayerType.HUMAN);
				game.addShipDefault(ShipType.SUBMARINE, submarinePos, Orientation.HORIZONTAL, PlayerType.HUMAN);
				
				gamewindow.setStatus(GameStatus.INGAME);
			} else {
				JOptionPane.showMessageDialog(null, "Vous devez placer vos cinq bateaux !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
