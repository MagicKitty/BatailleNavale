package cell;

import ship.AbstractShip;

public class ShipCell extends AbstractCell {

	private double life;
	private AbstractShip as;
	private boolean visible;

	public ShipCell(int x, int y, Grid grid, AbstractShip ship){
		super(x, y, grid);
		as = ship;
		life = 1;
		visible = false;
	}
	
	public ShipCell(int x, int y, Grid grid, AbstractShip ship, double l){
		super(x, y, grid);
		as = ship;
		life = l;
		visible = false;
	}
	
	public double getLife() {
		return life;
	}
	
	public boolean isValidHit() {
		//if cell's life is below 0, the cell is dead and the player cannot hit it anymore
		if (life <= 0)
			return false;
		else
			return true;
	}

	@Override
	public void hit(double a) {
		//processing the hit
		double damage = a - as.getDefense();
		life -= damage;
		
		//checking if the player killed a cell
		if (life <= 0)
			as.KillACell();
		
		//+1 to the shipshot counter
		getGrid().addShipShot();
		
		if (!visible)
			visible = true;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
}
