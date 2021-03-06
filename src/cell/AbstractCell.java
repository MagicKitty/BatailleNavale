package cell;

public abstract class AbstractCell {
	private int x;
	private int y;
	private Grid grid;
	protected boolean visibility;

	/**
	 * initializing a cell with the grid which has the cell, and the coordinates of the cell
	 * @param x
	 * @param y
	 * @param grid
	 */
	public AbstractCell(int x, int y, Grid grid){
		this.x = x;
		this.y = y;
		this.grid = grid;
		this.visibility = false;
	}
	
	/**
	 * @return abscissa of the cell
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return ordinate of the cell
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return the grid which has the cell
	 */
	public Grid getGrid() {
		return grid;
	}
	
	public void setVisibility(boolean visu){
		this.visibility = visu;
	}
	
	/**
	 * @return false if the hit is not valid
	 */
	public abstract boolean isValidHit();
	
	/**
	 * @return false if the other haven't discovered the cell yet
	 */
	public boolean isVisible(){
		return this.visibility;
	}
	
	/**
	 * hitting the cell with a damage
	 * @param damage the damage
	 */
	public abstract void hit(double damage);
	
	public abstract boolean isSea();
	public abstract boolean isShip();
	public abstract boolean isAlive();
	public abstract double getLife();
}