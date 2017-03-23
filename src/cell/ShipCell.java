package cell;

import ship.AbstractShip;

public class ShipCell extends AbstractCell {
	private double life;
	private AbstractShip as;
	
	public boolean isValidHit() {
		return false;
	}
}
