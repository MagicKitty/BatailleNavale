package game;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONBuilder {
	JSONObject obj = new JSONObject();
	
	public void addString(String id, String s) {
		try {
			obj.put(id, s);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void changeString(String id, String s) {
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
	
	public void changeObject(String id, Object o) {
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
	
	public void changeArray(String id, JSONArray a) {
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
	
	public void changeInteger(String id, int i) {
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
}
