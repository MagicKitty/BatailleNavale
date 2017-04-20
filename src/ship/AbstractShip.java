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

	public int getSize() {
		return 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void KillACell() {
		numberOfCellsAlive -= 1;
		
		if (numberOfCellsAlive == 0)
			isAlive = false;
	}
}
