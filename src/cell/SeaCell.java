package cell;

public class SeaCell extends AbstractCell {
	private boolean isHit;

	public SeaCell(int x, int y, Grid grid){
		super(x, y, grid);
		isHit = false;
	}
	
	public SeaCell(int x, int y, Grid grid, boolean hit){
		super(x, y, grid);
		isHit = hit;
	}
	
	@Override
	public boolean isValidHit() {
		//if the cell was already hit, the player cannot hit it anymore
		return (!isHit);
	}

	@Override
	public void hit(double a) {
		//it is a sea cell, no damage is done
		isHit = true;
		visibility = true;
		//+1 to the seashot counter
		getGrid().addSeaShot();
	}
	
	public boolean isShip() {
		return false;
	}
	
	public boolean isSea() {
		return true;
	}

	@Override
	public boolean isAlive() {
		return false;
	}
}