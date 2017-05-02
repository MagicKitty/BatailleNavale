package screen;

import com.sun.java.swing.plaf.windows.resources.windows;

import controller.PlaceShipsController;
import graphic.Coord2D;
import ship.Orientation;
import ship.ShipType;

public class PlaceShipsScreen extends GridScreen {
	private static final long serialVersionUID = 1L;
	private PlaceShipsController controller;
	private Coord2D carrierPos, cruiserPos, battleshipPos, submarinePos, destroyerPos;
	
	public PlaceShipsScreen(PlaceShipsController ctrl) {
		super(10, 10, "Placez vos bateaux");
		
		controller = ctrl;
		
		carrierPos = new Coord2D(-1, -1);
		cruiserPos = new Coord2D(-1, -1);
		battleshipPos = new Coord2D(-1, -1);
		submarinePos = new Coord2D(-1, -1);
		destroyerPos = new Coord2D(-1, -1);
	}
	
	public void handleClick(int row, int col) {
		Coord2D pos = new Coord2D(col, row);
		switch(controller.getAddedType()) {
			case CARRIER:
				if(drawShip(pos, controller.getShipOrientation(controller.getAddedType()), 5)) {
					carrierPos.setPosition(col, row);
				}
				break;
			case CRUISER:
				if(drawShip(pos, controller.getShipOrientation(controller.getAddedType()), 4)) {
					cruiserPos.setPosition(col, row);
				}
				break;
			case BATTLESHIP:
				if(drawShip(pos, controller.getShipOrientation(controller.getAddedType()), 2)) {
					battleshipPos.setPosition(col, row);
				}
				break;
			case SUBMARINE:
				if(drawShip(pos, controller.getShipOrientation(controller.getAddedType()), 3)) {
					submarinePos.setPosition(col, row);
				}
				break;
			case DESTROYER:
				if(drawShip(pos, controller.getShipOrientation(controller.getAddedType()), 3)) {
					destroyerPos.setPosition(col, row);
				}
				break;
		}
		
		updateScreen();
		controller.update();
	}
	
	public void handleMouseOver(int row, int col) {
		Coord2D carrier = carrierPos.clone();
		Coord2D cruiser = cruiserPos.clone();
		Coord2D battleship = battleshipPos.clone();
		Coord2D submarine = submarinePos.clone();
		Coord2D destroyer = destroyerPos.clone();
		
		switch(controller.getAddedType()) {
			case CARRIER:
				carrier.setPosition(col, row);
				break;
			case CRUISER:
				cruiser.setPosition(col, row);
				break;
			case BATTLESHIP:
				battleship.setPosition(col, row);
				break;
			case SUBMARINE:
				submarine.setPosition(col, row);
				break;
			case DESTROYER:
				destroyer.setPosition(col, row);
				break;
		}
		
		updateScreen();
		
		drawShip(carrier, controller.getShipOrientation(ShipType.CARRIER), 5);
		drawShip(cruiser, controller.getShipOrientation(ShipType.CRUISER), 4);
		drawShip(battleship, controller.getShipOrientation(ShipType.BATTLESHIP), 2);
		drawShip(submarine, controller.getShipOrientation(ShipType.SUBMARINE), 3);
		drawShip(destroyer, controller.getShipOrientation(ShipType.DESTROYER), 3);
	}
	
	private void updateScreen() {
		clearScreen();
		
		if(carrierPos.getX() != -1) {
			controller.setShipPosition(ShipType.CARRIER, carrierPos);
			
			drawShip(carrierPos, controller.getShipOrientation(ShipType.CARRIER), 5);
		}
		
		if(cruiserPos.getX() != -1) {
			controller.setShipPosition(ShipType.CRUISER, cruiserPos);
			
			drawShip(cruiserPos, controller.getShipOrientation(ShipType.CRUISER), 4);
		}
		
		if(battleshipPos.getX() != -1) {
			controller.setShipPosition(ShipType.BATTLESHIP, battleshipPos);
			
			drawShip(battleshipPos, controller.getShipOrientation(ShipType.BATTLESHIP), 2);
		}
		
		if(submarinePos.getX() != -1) {
			controller.setShipPosition(ShipType.SUBMARINE, submarinePos);
			
			drawShip(submarinePos, controller.getShipOrientation(ShipType.SUBMARINE), 3);
		}
		
		if(destroyerPos.getX() != -1) {
			controller.setShipPosition(ShipType.DESTROYER, destroyerPos);
			
			drawShip(destroyerPos, controller.getShipOrientation(ShipType.DESTROYER), 3);
		}
	}
}
