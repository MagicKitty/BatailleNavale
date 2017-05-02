package ship;

public class Carrier extends AbstractShip {
	
	private static int SIZE = 5;
	
	public Carrier() {
		super(true, SIZE, 0);
	}

	public Carrier(boolean alive, int numberOfBullets){
		super(alive, SIZE, numberOfBullets);
	}
	
	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "Carrier";
	}
	
}
