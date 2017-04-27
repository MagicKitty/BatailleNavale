package screen;

import controller.PlaceShipsController;
import graphic.Coord2D;

public class PlaceShipsScreen extends GridScreen {
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
				for(int i = 0; i < 5; i++) colorCell(carrier.getX() + i, carrier.getY(), 2);
			} else {
				for(int i = 0; i < 5; i++) if(carrier.getX() + i < 10) colorCell(carrier.getX() + i, carrier.getY(),-1);
			}
		}
		
		if(cruiser.getX() != -1) {
			if(cruiser.getX() < 7) {
				for(int i = 0; i < 4; i++) colorCell(cruiser.getX() + i, cruiser.getY(), 2);
			} else {
				for(int i = 0; i < 4; i++) if(cruiser.getX() + i < 10) colorCell(cruiser.getX() + i, cruiser.getY(),-1);
			}
		}
	}
	
	private void updateScreen() {
		clearScreen();
		
		if(carrierPos.getX() != -1) for(int i = 0; i < 5; i++) colorCell(carrierPos.getX() + i, carrierPos.getY(), 1);
		if(cruiserPos.getX() != -1) for(int i = 0; i < 4; i++) colorCell(cruiserPos.getX() + i, cruiserPos.getY(), 1);
	}
}
