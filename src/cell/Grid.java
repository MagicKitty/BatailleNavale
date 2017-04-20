package cell;

import java.util.ArrayList;

import ship.AbstractShip;
import game.AbstractGame;
import graphic.Coord2D;

public class Grid {
	private AbstractGame ag;
	private int numberOfSeaShots;
	private int numberOfShipShots;
	private AbstractCell[][] Cells2D;

	public Grid(AbstractGame game){
		ag = game;
		numberOfSeaShots = 0;
		numberOfShipShots = 0;
		
		Cells2D = new AbstractCell[10][10];
		
		for (int x = 0; x < 10; x++)
			for (int y = 0; y < 10; y++)
				Cells2D[x][y] = new SeaCell(x, y, this);
	}
	
	public Grid(AbstractGame game, int noSeaS, int noShipS){
		ag = game;
		numberOfSeaShots = noSeaS;
		numberOfShipShots = noShipS;
		
		Cells2D = new AbstractCell[10][10];
		
		for (int x = 0; x < 10; x++)
			for (int y = 0; y < 10; y++)
				Cells2D[x][y] = new SeaCell(x, y, this, false);
	}
	
	public AbstractGame getAg() {
		return ag;
	}

	public int getNumberOfSeaShots() {
		return numberOfSeaShots;
	}

	public int getShipShots() {
		return numberOfShipShots;
	}

	public AbstractCell[][] getCells2D() {
		return Cells2D;
	}

	
	public void addSeaShot(){
		numberOfSeaShots++;
	}
	
	public void addShipShot() {
		numberOfShipShots++;
	}
	
	public boolean isValidHit(Coord2D c) {
		int x = c.getX();
		int y = c.getY();
		
		return Cells2D[x][y].isValidHit();
	}
	
	public void hit(Coord2D c, int damage) {
		int x = c.getX();
		int y = c.getY();
		
		Cells2D[x][y].hit(damage);
	}
	
	public void addSeaCell(int x, int y, boolean hit){
		Cells2D[x][y] = new SeaCell(x, y, this, hit);
	}
	
	public void addDefaultSeaCell(int x, int y){
		addSeaCell(x, y, false);
	}
	
	public void addShipCell(int x, int y, double life, AbstractShip ship){
		Cells2D[x][y] = new ShipCell(x, y, this, ship, life);
	}
	
	public void addDefaultShipCell(int x, int y, AbstractShip ship){
		addShipCell(x, y, 1, ship);
	}
}