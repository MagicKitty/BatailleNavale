package cell;

import java.util.ArrayList;

import game.AbstractGame;
import graphic.Coord2D;

public class Grid {
	private AbstractGame ag;
	private int numberOfSeaShots;
	private int shipShots;
	private ArrayList<AbstractCell> aac = new ArrayList<AbstractCell>();
	
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