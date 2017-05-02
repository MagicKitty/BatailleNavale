package cell;

import game.AbstractGame;
import graphic.Coord2D;
import ship.AbstractShip;

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

	public int getNumberOfShipShots() {
		return numberOfShipShots;
	}

	public AbstractCell[][] getCells2D() {
		return Cells2D;
	}

	public AbstractCell getCell(int x, int y){
		return Cells2D[x][y];
	}
	
	public AbstractCell getCell(Coord2D c){
		int x = c.getX();
		int y = c.getY();
		
		return Cells2D[x][y];
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
		
		if (x < 0 || y < 0 || x > 9 || y > 9)
			return false;
		
		return Cells2D[x][y].isValidHit();
	}
	
	public boolean isVisible(Coord2D c) {
		int x = c.getX();
		int y = c.getY();
		
		return Cells2D[x][y].isVisible();
	}
	
	public void hit(Coord2D c, double damage) {
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < 10; x++){
			for (int y = 0; y < 10; y++){
				sb.append("[");
				if (getCell(x, y) instanceof ShipCell)
					sb.append("X");
				else
					sb.append("_");
				sb.append("]");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}