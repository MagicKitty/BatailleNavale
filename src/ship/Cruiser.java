package ship;

public class Cruiser extends AbstractShip {
	public Cruiser() {
		super();
	}

	@Override
	public int getSize() {
		return 3;
	}

	@Override
	public String getName() {
		return "Cruiser";
	}
}
