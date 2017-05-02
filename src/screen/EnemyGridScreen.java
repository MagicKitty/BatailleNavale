package screen;

import cell.*;
import game.*;
import graphic.Coord2D;
import main.GameWindow;

public class EnemyGridScreen extends GridScreen {
	private AbstractGame game;
	private GameWindow window;
	
	public EnemyGridScreen(AbstractGame g, GameWindow gw) {
		super(10, 10, "Grille ennemie");
		
		game = g;
		window = gw;
		update();
	}
	
	public void update() {
		clearScreen(-2);
		
		Grid grid = game.getComputerGrid();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				AbstractCell c = grid.getCell(i, j);
				colorCell(i, j, c.isVisible() ? (c.isSea() ? 0 : 3) : -2);
			}
		}
	}
	
	public void handleClick(int row, int col) {
		AbstractCell cell = game.getComputerGrid().getCell(col, row);
		
		if(cell != null && cell.isValidHit()) {
			game.play(new Coord2D(col, row));
			window.update();
		}
	}
	
	public void handleMouseOver(int row, int col) {
		AbstractCell cell = game.getComputerGrid().getCell(col, row);
		if(cell != null && !cell.isValidHit()) {
			colorCell(col, row, -1);
		}
	}
	
	public void handleMouseOut(int row, int col) {
		AbstractCell cell = game.getComputerGrid().getCell(col, row);
		if(cell != null) {
			colorCell(col, row, cell.isVisible() ? (cell.isSea() ? 0 : 3) : -2);
		}
	}
}
