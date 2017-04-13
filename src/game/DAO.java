package game;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DAO {
	private BattleshipGame bsg;
	
	public Game loadGame(String a) {
		return null;
	}
	
	public void saveGame(String a, AbstractGame ag) {
		JSONBuilder jb = new JSONBuilder();
		
		File f = new File(a);
		if(!f.exists() && !f.isDirectory()) { 
		    jb.addString("timePeriod", ag.getTimePeriod());
		    jb.addString("computerStrategy", ag.getComputerStrategy());
//		    jb.addInteger("numberOfSeaShots", );
		    
		    try{
		    	PrintWriter writer = new PrintWriter(a, "UTF-8");
		    	writer.println(jb.toString());
		    	writer.close();
		    } catch (IOException e) {
		    	
		    }
		} else if(f.exists() && !f.isDirectory()) {
			jb.updateString("timePeriod", ag.getTimePeriod());
		    jb.updateString("computerStrategy", ag.getComputerStrategy());
		    
		    try{
		    	PrintWriter writer = new PrintWriter(a, "UTF-8");
		    	writer.println(jb.toString());
		    	writer.close();
		    } catch (IOException e) {
		    	
		    }
		} else {
			System.out.println("Il s'agit d'un dossier !");
		}
	}
}