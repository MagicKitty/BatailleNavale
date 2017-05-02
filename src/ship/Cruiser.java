package ship;

public class Cruiser extends AbstractShip {
	
	private static int SIZE = 3;
	
	public Cruiser() {
		super(true, SIZE, 0);
	}

	public Cruiser(boolean alive, int numberOfBullets){
		super(alive, SIZE, numberOfBullets);
	}
	
	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "Cruiser";
	}
}
