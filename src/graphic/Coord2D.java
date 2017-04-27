package graphic;

public class Coord2D {
	private int x;
	private int y;
	
	public Coord2D(int px, int py) {
		setPosition(px, py);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setPosition(int px, int py) {
		x = px;
		y = py;
	}
	
	public Coord2D clone() {
		return new Coord2D(x, y);
	}
}
