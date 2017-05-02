package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	@SuppressWarnings("unused")
	private BattleshipGame bsg;

	public Game loadGame(String filename) {
		try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String period = reader.readLine();
		    System.out.println("DAO.java ligne 20 : "+period);
		    String strategy = reader.readLine();
		    System.out.println("DAO.java ligne 22 : "+strategy);
		    reader.close();
		  }
		  catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    System.exit(0);
		  }
		
//		if(period.equals(""))
		
		return null;
	}

	public void saveGame(String fileName, AbstractGame ag) {
		JSONBuilder jb = new JSONBuilder();

		File f = new File(fileName);
		if (!f.exists() && !f.isDirectory()) {
//			jb.addObject(ag.getComputerStrategy());
//			jb.addObject(ag.getTimePeriod());
			jb.addString("timePeriod", ag.getTimePeriod().toString());
			jb.addString("computerStrategy", ag.getComputerStrategy().toString());
			jb.addObject(ag.getMyGrid());
			jb.addObject(ag.getEnnemiGrid());
			for (int i = 0; i < ag.getAasComputer().size(); i++) {
				jb.addObject(ag.getAasComputer().get(i));
			}
			for (int i = 0; i < ag.getAasHuman().size(); i++) {
				jb.addObject(ag.getAasHuman().get(i));
			}
			try {
				PrintWriter writer = new PrintWriter(fileName, "UTF-8");
				writer.println(jb.toString());
				writer.close();
			} catch (IOException e) {

			}
		}
	}
}