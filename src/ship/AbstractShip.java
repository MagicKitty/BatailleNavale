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
	
	public boolean isAlive() {
		return isAlive;
	}

	public int getNumberOfCellsAlive() {
		return numberOfCellsAlive;
	}

	public int getNumberOfBullets() {
		return numberOfBullets;
	}

	public ArrayList<ShipCell> getAsc() {
		return asc;
	}

	public IBehaviorDefensive getBd() {
		return bd;
	}

	public IBehaviorOffensive getBo() {
		return bo;
	}

	
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
