package game;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DAO {
	@SuppressWarnings("unused")
	private BattleshipGame bsg;

	public Game loadGame(String a) {
		return null;
	}

	public void saveGame(String fileName, AbstractGame ag) {
		JSONBuilder jb = new JSONBuilder();

		File f = new File(fileName);
		if (!f.exists() && !f.isDirectory()) {
			jb.addString("gameType", ag.getGameType().toString());
			jb.addString("timePeriod", ag.getTimePeriod().toString());
			jb.addString("computerStrategy", ag.getComputerStrategy().toString());
			jb.addShips("human", ag.getHumanShips());
			jb.addShips("computer", ag.getComputerShips());
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