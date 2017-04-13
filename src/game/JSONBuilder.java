package game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.GameWindow;

public class JSONBuilder {
	private JSONObject obj;
	private JSONArray array;
	
	public JSONArray getArray() {
		return array;
	}

	public void setArray(JSONArray array) {
		this.array = array;
	}

	public JSONBuilder() {
		obj = new JSONObject();
		array = new JSONArray();
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

	public void addObject(String id, Object o) {
		try {
			obj.put(id, o);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateObject(String id, Object o) {
		obj.remove(id);
		try {
			obj.put(id, o);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

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
