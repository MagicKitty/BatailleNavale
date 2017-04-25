package ship;

import java.util.ArrayList;

import cell.ShipCell;

public abstract class AbstractShip {
	private boolean isAlive;
	private int numberOfCellsAlive;
	private int numberOfBullets;
	private ArrayList<ShipCell> asc = new ArrayList<>();
	private IBehaviorDefensive bd;
	private IBehaviorOffensive bo;
	
	public AbstractShip() {
	}
	
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

	public double getDefense() {
		return bd.getDefense();
	}

	public double getAttack() {
		return bo.getAttack();
	}

	public abstract int getSize();
	
	public abstract String getName();
	
	public void KillACell() {
		numberOfCellsAlive -= 1;
		
		if (numberOfCellsAlive == 0)
			isAlive = false;
	}
}
