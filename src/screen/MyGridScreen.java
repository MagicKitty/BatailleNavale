package screen;

import cell.Grid;
import controller.PlaceShipsController;
import game.AbstractGame;
import graphic.Coord2D;
import ship.ShipType;

public class MyGridScreen extends GridScreen {
	private PlaceShipsController  controller;
	
	public MyGridScreen(PlaceShipsController ctrl) {
		super(10, 10, "Ma grille");
		
		controller = ctrl;
		
		update();
	}
	
	public void update() {
		clearScreen();
		
		drawShip(controller.getShipPosition(ShipType.CARRIER), controller.getShipOrientation(ShipType.CARRIER), 5);
		drawShip(controller.getShipPosition(ShipType.CRUISER), controller.getShipOrientation(ShipType.CRUISER), 4);
		drawShip(controller.getShipPosition(ShipType.BATTLESHIP), controller.getShipOrientation(ShipType.BATTLESHIP), 2);
		drawShip(controller.getShipPosition(ShipType.SUBMARINE), controller.getShipOrientation(ShipType.SUBMARINE), 3);
		drawShip(controller.getShipPosition(ShipType.DESTROYER), controller.getShipOrientation(ShipType.DESTROYER), 3);
	}
}