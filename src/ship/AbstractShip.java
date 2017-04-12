package ship;

import java.util.ArrayList;

import cell.ShipCell;

public abstract class AbstractShip {
	private String name;
	private boolean isAlive;
	private int numberOfCellsAlive;
	private int numberOfBullets;
	private ArrayList<ShipCell> asc = new ArrayList<>();
	private IBehaviorDefensive bd;
	private IBehaviorOffensive bo;
	
	public AbstractShip(String n) {
		name = n;
	}
	
	public int getSize() {
		return 0;
	}
	
	public String getName() {
		return name;
	}
}
