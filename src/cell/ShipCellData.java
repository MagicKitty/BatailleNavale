package cell;

public class ShipCellData {
	
	int x, y;
	float life;
	
	public ShipCellData(int xCoord, int yCoord, float cellLife){
		x = xCoord;
		y = yCoord;
		life = cellLife;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public float getLife() {
		return life;
	}
		
}
