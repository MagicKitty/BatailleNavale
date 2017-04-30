package period;

import ship.Battleship;
import ship.Carrier;
import ship.ConstantBehaviorDefensive;
import ship.ConstantBehaviorOffensive;
import ship.Cruiser;
import ship.Destroyer;
import ship.IBehaviorDefensive;
import ship.IBehaviorOffensive;
import ship.Submarine;

public class RenaissanceShipFactory implements IShipFactory {
	
	@Override
	public Carrier createCarrier() {
		Carrier carrier = new Carrier();
		carrier.setAttack(new ConstantBehaviorOffensive(3));
		carrier.setDefense(new ConstantBehaviorDefensive(5));
		return carrier;
	}

	@Override
	public Battleship createBattleship() {
		Battleship battleship = new Battleship();

		battleship.setAttack(new ConstantBehaviorOffensive(3));
		battleship.setDefense(new ConstantBehaviorDefensive(4));

		return battleship;
	}

	@Override
	public Cruiser createCruiser() {
		Cruiser cruiser = new Cruiser();
		cruiser.setAttack(new ConstantBehaviorOffensive(2));
		cruiser.setDefense(new ConstantBehaviorDefensive(3));

		return cruiser;
	}

	@Override
	public Submarine createSubmarine() {
		Submarine submarine = new Submarine();
	
		submarine.setAttack(new ConstantBehaviorOffensive(1));
		submarine.setDefense(new ConstantBehaviorDefensive(2));

		return submarine;
	}

	@Override
	public Destroyer createDestroyer() {
		Destroyer destroyer = new Destroyer();
		
		destroyer.setAttack(new ConstantBehaviorOffensive(1));
		destroyer.setDefense(new ConstantBehaviorDefensive(1));
		return destroyer;
	}
}