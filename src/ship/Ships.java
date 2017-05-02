package ship;

import java.util.ArrayList;

public class Ships {

	private ArrayList<AbstractShip> chips;
	
	public Ships(){
		chips = new ArrayList<>(5);
		
		for (int i = 0; i < 5; i++)
			chips.add(i, null);
	}
	
	public AbstractShip getShip(ShipType type){
		switch(type){
		case CARRIER:
			return chips.get(0);
		case BATTLESHIP:
			return chips.get(1);
		case CRUISER:
			return chips.get(2);
		case SUBMARINE:
			return chips.get(3);
		case DESTROYER:
			return chips.get(4);
		default:
			return null;
		}
	}
	
	public void setShip(ShipType type, AbstractShip ship){	
		switch(type){
		case CARRIER:
			chips.set(0, ship);
		case BATTLESHIP:
			chips.set(1, ship);
		case CRUISER:
			chips.set(2, ship);
		case SUBMARINE:
			chips.set(3, ship);
		case DESTROYER:
			chips.set(4, ship);
		}
	}
}
