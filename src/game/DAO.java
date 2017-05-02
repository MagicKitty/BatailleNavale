package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import period.Period;
import player.ComputerPlayer;
import player.StrategyType;

public class DAO {
	@SuppressWarnings("unused")
	private BattleshipGame bsg;

	public AbstractGame loadGame(String filename) {
		AbstractGame abstractGame = null;
		
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
			
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			System.exit(0);
		}

		return abstractGame;
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