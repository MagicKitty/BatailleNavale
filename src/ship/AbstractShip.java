package ship;

import java.util.ArrayList;

import cell.ShipCell;
import graphic.Coord2D;

public abstract class AbstractShip {
	private boolean isAlive;
	private int numberOfCellsAlive;
	private int numberOfBullets;
	private ArrayList<ShipCell> asc = new ArrayList<>();
	private IBehaviorDefensive bd;
	private IBehaviorOffensive bo;
	private int x, y;
	private Orientation ori;

	public AbstractShip() {
		isAlive = true;
		numberOfCellsAlive = 0;
		numberOfBullets = 0;
		bd = null;
		bo = null;
		x = y = 0;
		ori = null;
	}
	
	public AbstractShip(boolean alive, int nbCellsAlive, int nbBullets){
		isAlive = alive;
		numberOfBullets = nbBullets;
		numberOfCellsAlive = nbCellsAlive;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setPosition(Coord2D c){
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public Coord2D getPosition(){
		return new Coord2D(x, y);
	}

	public void setOrientation(Orientation o){
		ori = o;
	}
	
	public Orientation getOrientation(){
		return ori;
	}
	
	public int getNumberOfCellsAlive() {
		return numberOfCellsAlive;
	}

	public int getNumberOfBullets() {
		return numberOfBullets;
	}
	
	public void setNumberOfBullets(int newNumberBullets) {
		numberOfBullets = newNumberBullets;
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

	public void setDefense(IBehaviorDefensive iBehaviorDefensive) {
		bd=iBehaviorDefensive;
	}

	public void setAttack(IBehaviorOffensive iBehaviorOffensive){
		bo=iBehaviorOffensive;
	}

	public void addShipCell(ShipCell cell){
		asc.add(cell);
	}
	
	public abstract int getSize();

	public abstract String getName();

	public void KillACell() {
		numberOfCellsAlive -= 1;

		if (numberOfCellsAlive == 0)
			isAlive = false;
	}
}
