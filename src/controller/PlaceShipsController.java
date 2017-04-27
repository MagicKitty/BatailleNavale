package controller;

import ship.ShipType;

public class PlaceShipsController {
	private ShipType addedType;
	
	public PlaceShipsController() {
		
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
}
