package game;

import java.util.ArrayList;

import cell.Grid;
import graphic.Coord2D;
import period.IShipFactory;
import player.IPlayer;
import ship.AbstractShip;

public abstract class AbstractGame {
	private String timePeriod;
	private String computerStrategy;
	private BattleshipGame bg;
	private IPlayer humain;
	private IPlayer computer;
	private Grid myGrid;
	private Grid ennemiGrid;
	private IShipFactory sf;
	private ArrayList<AbstractShip> aas = new ArrayList<>(5);
	
	public void play() {
		
	}
	
	public String getGameType() {
		return null;
	}
	
	public String getTimePeriod() {
		return null;
	}
	
	public String getComputerStrategy() {
		return null;
	}
	
	public void setComputerStrategy() {
		
	}
	
	public void addShip(String a, Coord2D c) {
		
	}
}
