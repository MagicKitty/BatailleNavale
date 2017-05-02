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
		switch(controller.getAddedType()) {
			case CARRIER:
				carrierPos.setPosition(col, row);
				break;
			case CRUISER:
				cruiserPos.setPosition(col, row);
				break;
			case BATTLESHIP:
				battleshipPos.setPosition(col, row);
				break;
			case SUBMARINE:
				submarinePos.setPosition(col, row);
				break;
			case DESTROYER:
				destroyerPos.setPosition(col, row);
				break;
		}
		
		updateScreen();
		controller.update();
	}
	
	public void drawShip(Coord2D coord, Orientation orientation, int size) {
		if(coord.getX() < 0 || coord.getY() < 0) return;
		
		int startX = coord.getX(), startY = coord.getY(), ptr = 0;
		int endX = Math.min(startX + (orientation == Orientation.HORIZONTAL ? size : 0), 9);
		int endY = Math.min(startY + (orientation == Orientation.VERTICAL ? size : 0), 9);
		
		int A = 1, B = 3, C = 5;
		if(orientation == Orientation.VERTICAL) {
			A = 4;
			B = 2;
			C = 6;
		}
		
		for(int x = startX; x <= endX; x++) {
			for(int y = startY; y <= endY; y++) {
				if(ptr < size) colorCell(x, y, (ptr == 0 ? A : (ptr == size - 1 ? B : C)));
				ptr++;
			}
		}
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
