package ship;

public class Carrier extends AbstractShip {
	public Carrier() {
		super();
	}

	@Override
	public int getSize() {
		return 5;
	}

	@Override
	public String getName() {
		return "Carrier";
	}
	
}
