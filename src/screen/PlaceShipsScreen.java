package screen;

import controller.PlaceShipsController;
import graphic.Coord2D;
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
		
		if(carrier.getX() != -1) {
			if(carrier.getX() < 6) {
				colorCell(carrier.getX(), carrier.getY(), 1);
				for(int i = 1; i < 4; i++) colorCell(carrier.getX() + i, carrier.getY(), 5);
				colorCell(carrier.getX() + 4, carrier.getY(), 3);
			} else {
				for(int i = 0; i < 5; i++) if(carrier.getX() + i < 10) colorCell(carrier.getX() + i, carrier.getY(),-1);
			}
		}
		
		if(cruiser.getX() != -1) {
			if(cruiser.getX() < 7) {
				colorCell(cruiser.getX(), cruiser.getY(), 1);
				for(int i = 1; i < 3; i++) colorCell(cruiser.getX() + i, cruiser.getY(), 5);
				colorCell(cruiser.getX() + 3, cruiser.getY(), 3);
			} else {
				for(int i = 0; i < 4; i++) if(cruiser.getX() + i < 10) colorCell(cruiser.getX() + i, cruiser.getY(),-1);
			}
		}
		
		if(battleship.getX() != -1) {
			if(battleship.getX() < 9) {
				colorCell(battleship.getX(), battleship.getY(), 1);
				colorCell(battleship.getX() + 1, battleship.getY(), 3);
			} else {
				for(int i = 0; i < 2; i++) if(battleship.getX() + i < 10) colorCell(battleship.getX() + i, battleship.getY(),-1);
			}
		}
		
		if(submarine.getX() != -1) {
			if(submarine.getX() < 9) {
				colorCell(submarine.getX(), submarine.getY(), 1);
				colorCell(submarine.getX() + 1, submarine.getY(), 5);
				colorCell(submarine.getX() + 2, submarine.getY(), 3);
			} else {
				for(int i = 0; i < 3; i++) if(submarine.getX() + i < 10) colorCell(submarine.getX() + i, submarine.getY(), -1);
			}
		}
		
		if(destroyer.getX() != -1) {
			if(destroyer.getX() < 9) {
				colorCell(destroyer.getX(), destroyer.getY(), 1);
				colorCell(destroyer.getX() + 1, destroyer.getY(), 5);
				colorCell(destroyer.getX() + 2, destroyer.getY(), 3);
			} else {
				for(int i = 0; i < 3; i++) if(destroyer.getX() + i < 10) colorCell(destroyer.getX() + i, destroyer.getY(), -1);
			}
		}
	}
	
	private void updateScreen() {
		clearScreen();
		
		if(carrierPos.getX() != -1) {
			controller.setShipStatus(ShipType.CARRIER, true);
			
			colorCell(carrierPos.getX(), carrierPos.getY(), 1);
			for(int i = 1; i < 4; i++) colorCell(carrierPos.getX() + i, carrierPos.getY(), 5);
			colorCell(carrierPos.getX() + 4, carrierPos.getY(), 3);
		}
		
		if(cruiserPos.getX() != -1) {
			controller.setShipStatus(ShipType.CRUISER, true);
			
			colorCell(cruiserPos.getX(), cruiserPos.getY(), 1);
			for(int i = 1; i < 3; i++) colorCell(cruiserPos.getX() + i, cruiserPos.getY(), 5);
			colorCell(cruiserPos.getX() + 3, cruiserPos.getY(), 3);
		}
		
		if(battleshipPos.getX() != -1) {
			controller.setShipStatus(ShipType.BATTLESHIP, true);
			
			colorCell(battleshipPos.getX(), battleshipPos.getY(), 1);
			colorCell(battleshipPos.getX() + 1, battleshipPos.getY(), 3);
		}
		
		if(submarinePos.getX() != -1) {
			controller.setShipStatus(ShipType.SUBMARINE, true);
			
			colorCell(submarinePos.getX(), submarinePos.getY(), 1);
			colorCell(submarinePos.getX() + 1, submarinePos.getY(), 5);
			colorCell(submarinePos.getX() + 2, submarinePos.getY(), 3);
		}
		
		if(destroyerPos.getX() != -1) {
			controller.setShipStatus(ShipType.DESTROYER, true);
			
			colorCell(destroyerPos.getX(), destroyerPos.getY(), 1);
			colorCell(destroyerPos.getX() + 1, destroyerPos.getY(), 5);
			colorCell(destroyerPos.getX() + 2, destroyerPos.getY(), 3);
		}
	}
}
