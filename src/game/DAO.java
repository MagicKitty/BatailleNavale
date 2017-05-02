package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cell.ShipCellData;
import graphic.Coord2D;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import period.Period;
import player.ComputerPlayer;
import player.PlayerType;
import player.StrategyType;
import ship.Orientation;
import ship.ShipType;

public class DAO {
	@SuppressWarnings("unused")
	private BattleshipGame bsg;
	private AbstractGame abstractGame;
	
	public DAO(){
		abstractGame = null;
	}

	public AbstractGame loadGame(String filename) {
		abstractGame = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			JSONObject jObject = new JSONObject(reader.readLine());
			
			GameType game = GameType.valueOf(jObject.getString("gameType"));
			Period period = Period.valueOf(jObject.getString("timePeriod"));
			StrategyType strategy = StrategyType.valueOf(jObject.getString("computerStrategy"));
		
			if (game == GameType.STANDARD)
				abstractGame = new StandardGame(period, strategy);
			else 
				abstractGame = new AdvancedGame(period, strategy);
			
			setShips(jObject.getJSONObject("human"), PlayerType.HUMAN);
			setShips(jObject.getJSONObject("computer"), PlayerType.COMPUTER);
			
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			System.exit(0);
		}

		return abstractGame;
	}

	private void setShips(JSONObject jsonObject, PlayerType player) {
		for (ShipType type : ShipType.values()){
			try {
				JSONObject shipObject = jsonObject.getJSONObject(type.toString());
				boolean alive = jsonObject.getBoolean("alive");
				int x = shipObject.getInt("x");
				int y = shipObject.getInt("y");
				int numbBullets = shipObject.getInt("numberOfBullets");
				Orientation ori = Orientation.valueOf(shipObject.getString("orientation"));
				ShipCellData[] scd = getShipCellsData(shipObject);
					
				abstractGame.addShip(type, numbBullets, new Coord2D(x, y), ori, player, scd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		JSONArray fow = new JSONArray();
		
		try {
			fow = jsonObject.getJSONArray("fogOfWar");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		abstractGame.applyVisiblityArray(getVisibilityArray(fow), player);
	}

	private boolean[][] getVisibilityArray(JSONArray fowArray) {
		boolean[][] fow2D = null;
		
		for (int x = 0; x < 10; x++)
			for (int y = 0; y < 10; y++)
				try {
					fow2D[x][y] = fowArray.getJSONObject(x*y).getBoolean("visibility");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		return fow2D;
	}

	private ShipCellData[] getShipCellsData(JSONObject shipObject) {
		JSONArray jArray = new JSONArray();
		ShipCellData[] scd = null;
		
		try {
			jArray = shipObject.getJSONArray("cells");
			for (int i = 0; i < jArray.length(); i++){
				JSONObject obj = jArray.getJSONObject(i);
				ShipCellData shipCellData = new ShipCellData(obj.getInt("x"), obj.getInt("y"), (float) obj.getDouble("life"));
				scd[i] = shipCellData;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scd;
	}

	public void saveGame(String fileName, AbstractGame ag) {
		JSONBuilder jb = new JSONBuilder();

		File f = new File(fileName);
		if (!f.exists() && !f.isDirectory()) {
			jb.addString("gameType", ag.getGameType().toString());
			jb.addString("timePeriod", ag.getTimePeriod().toString());
			jb.addString("computerStrategy", ag.getComputerStrategy().toString());
			jb.addPlayerInfo("human", ag.getHumanShips(), ag.getHumanGrid());
			jb.addPlayerInfo("computer", ag.getComputerShips(), ag.getComputerGrid());
			try {
				System.out.println(jb.toString());
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
				writer.println(jb.toString());
				writer.close();
			} catch (IOException e) {

			}
		}
	}

}