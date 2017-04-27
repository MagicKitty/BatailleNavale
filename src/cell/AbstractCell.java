package cell;

public abstract class AbstractCell {
	private int x;
	private int y;
	private Grid grid;

	public AbstractCell(int x, int y, Grid grid){
		this.x = x;
		this.y = y;
		this.grid = grid;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public abstract boolean isValidHit();
	
	public abstract boolean isVisible();
	
	public abstract void hit(double a);
}