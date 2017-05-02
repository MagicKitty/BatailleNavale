package ship;

public class Battleship extends AbstractShip {
	
	private static int SIZE = 4;
	
	public Battleship() {
		super(true, SIZE, 0);
	}
	
	public Battleship(boolean alive, int numberOfBullets){
		super(alive, SIZE, numberOfBullets);
	}

	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "Battleship";
	}
}
