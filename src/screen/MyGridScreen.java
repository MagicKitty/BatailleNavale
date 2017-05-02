package screen;

import cell.Grid;
import controller.PlaceShipsController;
import game.AbstractGame;
import game.AdvancedGame;
import player.PlayerType;
import ship.ShipType;

public class MyGridScreen extends GridScreen {
	private AbstractGame  game;
	private PlaceShipsController controller;
	
	public MyGridScreen(AbstractGame g, PlaceShipsController c) {
		super(10, 10, "Ma grille");
		
		game = g;
		controller = c;
		
		update();
	}
	
	public void handleClick(int row, int col) {
		ShipType ship = controller.getShipOn(row, col);
		if(ship != null && game instanceof AdvancedGame) {
			((AdvancedGame) game).setSelectedShip(ship, PlayerType.HUMAN);
			System.out.println("Bateau séléctionné : " + ship);
		}
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