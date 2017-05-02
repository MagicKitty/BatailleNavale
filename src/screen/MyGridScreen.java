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
		
		Coord2D carrierPos = controller.getShipPosition(ShipType.CARRIER);
		Coord2D cruiserPos = controller.getShipPosition(ShipType.CRUISER);
		Coord2D battleshipPos = controller.getShipPosition(ShipType.BATTLESHIP);
		Coord2D submarinePos = controller.getShipPosition(ShipType.SUBMARINE);
		Coord2D destroyerPos = controller.getShipPosition(ShipType.DESTROYER);
		
		if(carrierPos.getX() != -1) {
			colorCell(carrierPos.getX(), carrierPos.getY(), 1);
			for(int i = 1; i < 4; i++) colorCell(carrierPos.getX() + i, carrierPos.getY(), 5);
			colorCell(carrierPos.getX() + 4, carrierPos.getY(), 3);
		}
		
		if(cruiserPos.getX() != -1) {
			colorCell(cruiserPos.getX(), cruiserPos.getY(), 1);
			for(int i = 1; i < 3; i++) colorCell(cruiserPos.getX() + i, cruiserPos.getY(), 5);
			colorCell(cruiserPos.getX() + 3, cruiserPos.getY(), 3);
		}
		
		if(battleshipPos.getX() != -1) {
			colorCell(battleshipPos.getX(), battleshipPos.getY(), 1);
			colorCell(battleshipPos.getX() + 1, battleshipPos.getY(), 3);
		}
		
		if(submarinePos.getX() != -1) {
			colorCell(submarinePos.getX(), submarinePos.getY(), 1);
			colorCell(submarinePos.getX() + 1, submarinePos.getY(), 5);
			colorCell(submarinePos.getX() + 2, submarinePos.getY(), 3);
		}
		
		if(destroyerPos.getX() != -1) {
			colorCell(destroyerPos.getX(), destroyerPos.getY(), 1);
			colorCell(destroyerPos.getX() + 1, destroyerPos.getY(), 5);
			colorCell(destroyerPos.getX() + 2, destroyerPos.getY(), 3);
		}
	}
}