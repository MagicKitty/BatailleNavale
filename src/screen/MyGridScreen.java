package screen;

import cell.AbstractCell;
import cell.Grid;
import controller.PlaceShipsController;
import game.AbstractGame;
import graphic.Coord2D;
import ship.ShipType;

public class MyGridScreen extends GridScreen {
	private AbstractGame  game;
	
	public MyGridScreen(AbstractGame g) {
		super(10, 10, "Ma grille");
		
		game = g;
		
		update();
	}
	
	public void update() {
		clearScreen();
		
		Grid grid = game.getHumanGrid();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				colorCell(i, j, grid.getCell(i, j).isSea() ? 0 : 3);
			}
		}
	}
}