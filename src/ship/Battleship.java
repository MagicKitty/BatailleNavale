package ship;

public class Battleship extends AbstractShip {
	public Battleship() {
		super();
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public String getName() {
		return "Battleship";
	}
}
