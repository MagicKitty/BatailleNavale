package ship;

public class Destroyer extends AbstractShip {
	public Destroyer() {
		super();
	}

	@Override
	public int getSize() {
		return 2;
	}

	@Override
	public String getName() {
		return "Destroyer";
	}
}
