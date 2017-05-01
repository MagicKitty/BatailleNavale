package graphic;

import com.sun.javafx.scene.traversal.Direction;

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
	
	public Coord2D getNeighbor(Direction dir){
		int nX = x;
		int nY = y;
		
		switch (dir){
		case LEFT:
			nX--;
			break;
		case DOWN:
			nY--;
			break;
		case RIGHT:
			nX++;
			break;
		case UP:
			nY++;
			break;
		}
		
		return new Coord2D(nX, nY);
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Coord2D c = (Coord2D) o;
		if (c.x == this.x && c.y == this.y)
			return true;
		else
			return false;
	}
}
