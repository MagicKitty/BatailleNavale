package ship;

public class Destroyer extends AbstractShip {
	
	private static int SIZE = 2;
	
	public Destroyer() {
		super(true, SIZE, 0);
	}

	public Destroyer(boolean alive, int numberOfBullets){
		super(alive, SIZE, numberOfBullets);
	}
	
	@Override
	public int getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "Destroyer";
	}
}
