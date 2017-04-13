package cell;

import java.util.ArrayList;

import game.AbstractGame;
import graphic.Coord2D;

public class Grid {
	private AbstractGame ag;
	private int numberOfSeaShots;
	private int shipShots;
	private ArrayList<AbstractCell> aac = new ArrayList<AbstractCell>();

	public AbstractGame getAg() {
		return ag;
	}

	public int getNumberOfSeaShots() {
		return numberOfSeaShots;
	}

	public int getShipShots() {
		return shipShots;
	}

	public ArrayList<AbstractCell> getAac() {
		return aac;
	}

	
	public void addSeaShot(){
		
	}
	
	public void addShipShot() {
		
	}
	
	public boolean isValidHit(Coord2D c) {
		return false;
	}
	
	public void hit(Coord2D c, int x) {
		
	}
}