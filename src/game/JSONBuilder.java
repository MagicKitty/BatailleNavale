package game;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cell.AbstractCell;
import cell.Grid;
import cell.ShipCell;
import ship.AbstractShip;

public class JSONBuilder {
	private JSONObject obj;

	public JSONBuilder() {
		obj = new JSONObject();
	}

	public void addString(String id, String s) {
		try {
			obj.put(id, s);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void updateString(String id, String s) {
		obj.remove(id);
		try {
			obj.put(id, s);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void addObject(Object o) {
		String className = o.getClass().getName();
		try {
			if (className.equals("Grid")) {
				obj.append(className, ((Grid) o).getNumberOfSeaShots());
				obj.append(className, ((Grid) o).getNumberOfShipShots());
				AbstractCell[][] cell2D = ((Grid) o).getCells2D();
				for (int x = 0; x < 10; x++) {
					for (int y = 0; y < 10; y++) {
						obj.append(className, cell2D[x][y].getX());
						obj.append(className, cell2D[x][y].getY());
					}
				}
			} else if (className.equals("AbstractShip")) {
				obj.append(className, ((AbstractShip) o).getName());
				obj.append(className, ((AbstractShip) o).isAlive());
				obj.append(className, ((AbstractShip) o).getNumberOfCellsAlive());
				obj.append(className, ((AbstractShip) o).getNumberOfBullets());
				ArrayList<ShipCell> asc = new ArrayList<>();
				asc = ((AbstractShip) o).getAsc();
				for (int i = 0; i < asc.size(); i++) {
					obj.append(className, asc.get(i).getLife());
				}
			} else {
				System.out.println("unknown object");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void updateObject(String id, Object o) {
	// obj.remove(id);
	// try {
	// obj.put(id, o);
	// } catch (JSONException e) {
	// e.printStackTrace();
	// }
	// }

	public void addArray(String id, JSONArray a) {
		try {
			obj.put(id, a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateArray(String id, JSONArray a) {
		obj.remove(id);
		try {
			obj.put(id, a);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void addInteger(String id, int i) {
		try {
			obj.put(id, i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateInteger(String id, int i) {
		obj.remove(id);
		try {
			obj.put(id, i);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void removeObject(String id) throws JSONException {
		obj.remove(id);
	}

	public String toString() {
		return obj.toString();
	}
}
