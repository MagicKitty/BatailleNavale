package cell;

public abstract class AbstractCell {
	private int x;
	private int y;

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isValid() {
		return false;
	}
	
	public void hit(int a) {
		
	}
}