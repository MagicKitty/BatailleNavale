package period;

import ship.Battleship;
import ship.Carrier;
import ship.Cruiser;
import ship.Destroyer;
import ship.IBehaviorDefensive;
import ship.IBehaviorOffensive;
import ship.Submarine;

public class FutureShipFactory implements IShipFactory {

	public Carrier createCarrier() {
		Carrier carrier = new Carrier();
		carrier.setAttack(new IBehaviorOffensive() {

			@Override
			public double getAttack() {
				// TODO Auto-generated method stub
				return 3;
			}
		});
		carrier.setDefense(new IBehaviorDefensive() {

			@Override
			public double getDefense() {
				// TODO Auto-generated method stub
				return 5;
			}
		});
		return carrier;
	}

	@Override
	public Battleship createBattleship() {
		Battleship battleship = new Battleship();

		battleship.setAttack(new IBehaviorOffensive() {

			@Override
			public double getAttack() {
				// TODO Auto-generated method stub
				return 3;
			}
		});
		battleship.setDefense(new IBehaviorDefensive() {

			@Override
			public double getDefense() {
				// TODO Auto-generated method stub
				return 4;
			}
		});

		return battleship;
	}

	@Override
	public Cruiser createCruiser() {
		Cruiser cruiser = new Cruiser();
		cruiser.setAttack(new IBehaviorOffensive() {

			@Override
			public double getAttack() {
				// TODO Auto-generated method stub
				return 2;
			}
		});
		cruiser.setDefense(new IBehaviorDefensive() {

			@Override
			public double getDefense() {
				// TODO Auto-generated method stub
				return 3;
			}
		});

		return cruiser;
	}

	@Override
	public Submarine createSubmarine() {
		Submarine submarine = new Submarine();

		submarine.setAttack(new IBehaviorOffensive() {

			@Override
			public double getAttack() {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		submarine.setDefense(new IBehaviorDefensive() {

			@Override
			public double getDefense() {
				// TODO Auto-generated method stub
				return 2;
			}
		});

		return submarine;
	}

	@Override
	public Destroyer createDestroyer() {
		Destroyer destroyer = new Destroyer();

		destroyer.setAttack(new IBehaviorOffensive() {

			@Override
			public double getAttack() {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		destroyer.setDefense(new IBehaviorDefensive() {

			@Override
			public double getDefense() {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		return destroyer;
	}

}
