package ship;

public class Submarine extends AbstractShip {
	public Submarine() {
		super();
	}

	@Override
	public int getSize() {
		return 3;
	}

	@Override
	public String getName() {
		return "Submarine";
	}
}
