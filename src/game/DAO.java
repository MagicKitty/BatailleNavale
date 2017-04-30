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
			jb.addString("timePeriod", ag.getTimePeriod().toString());
			jb.addString("computerStrategy", ag.getComputerStrategy().toString());
			jb.addObject(ag.getMyGrid());
			jb.addObject(ag.getEnnemiGrid());
			/* A re-adapter
			ArrayList<AbstractShip> aas = new ArrayList<>();
			for (int i = 0; i < aas.size(); i++) {
				jb.addObject(ag.getAas().get(i));
			}
			*/
			try {
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
				writer.println(jb.toString());
				writer.close();
			} catch (IOException e) {

			}
		}
	}
}