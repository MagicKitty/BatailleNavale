package ship;

public class Submarine extends AbstractShip {
	
	private static int SIZE = 3;
	
	public Submarine() {
		super(true, SIZE, 0);
	}
	
	public Submarine(boolean alive, int numberOfBullets){
		super(alive, SIZE, numberOfBullets);
	}

	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "Submarine";
	}
}
