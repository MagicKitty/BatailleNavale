package main;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MainActionsController;
import controller.PlaceShipsController;
import game.AbstractGame;
import game.AdvancedGame;
import game.DAO;
import game.StandardGame;
import player.StrategyType;
import screen.AlgorithmScreen;
import screen.EnemyGridScreen;
import screen.GameType;
import screen.GridScreen;
import screen.MyGridScreen;
import screen.NewLoadScreen;
import screen.PeriodScreen;
import screen.PlaceShipsScreen;
import screen.ShotScreen;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel newLoadScreen, periodScreen, shotScreen, algorithmScreen, placeGridScreen, placeButtonsScreen;
	private JPanel boatsScreen, igButtonsScreen, myGridScreen, enemyGridScreen, informationsScreen;
	
	private PlaceShipsController placeShipsController;
	private MainActionsController mainActionsController;
	private GameType gt;
	private GameStatus status;
	
	private AbstractGame game;
	
	public GameWindow() {
		super("Bataille Navale");
		
		status = GameStatus.START;
		
		this.setLayout(new BorderLayout());
		
		gt = new GameType();
		
		setSize(500,550);

		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setStatus(GameStatus.NEW_LOAD);
		setVisible(true);
		
		mainActionsController = new MainActionsController(this);
	}
	
	public void save() {
		if(game != null) {
			String s = JOptionPane.showInputDialog("Nom du fichier");
			if(s != null) {
				if(!s.substring(s.length() - 3).equals(".bn")) s += ".bn";
				game.save(s);
			}
		}
	}
	
	public void openFile(String filename) {
		game = (new DAO()).loadGame(filename);
		setStatus(GameStatus.INGAME);
	}
	
	public void update() {
		switch(status) {
			case GRID:
				((BoatsPane) boatsScreen).update();
				break;
			case INGAME:
				((EnemyGridScreen) enemyGridScreen).update();
				((MyGridScreen) myGridScreen).update();
				((CounterWT) informationsScreen).update();
				break;
			default:
				break;
		}
	}
	
	public void setStatus(GameStatus s) {
		switch(status) {
			case NEW_LOAD:
				remove(newLoadScreen);
				break;
			case PERIOD:
				remove(periodScreen);
				break;
			case SHOT:
				remove(shotScreen);
				break;
			case ALGORITHM:
				remove(algorithmScreen);
				break;
			case GRID:
				remove(placeGridScreen);
				remove(placeButtonsScreen);
				remove(boatsScreen);
				break;
			case INGAME:
				remove(igButtonsScreen);
				remove(myGridScreen);
				remove(enemyGridScreen);
				remove(informationsScreen);
				break;
		default:
			break;
		}
		
		switch(s) {
			case NEW_LOAD:
				add(newLoadScreen != null ? newLoadScreen : (newLoadScreen = new NewLoadScreen(this)));
				break;
			case PERIOD:
				add(periodScreen != null ? periodScreen : (periodScreen = new PeriodScreen(this, gt = new GameType())));
				break;
			case SHOT:
				add(shotScreen != null ? shotScreen : (shotScreen = new ShotScreen(this, gt)));
				break;
			case ALGORITHM:
				add(algorithmScreen != null ? algorithmScreen : (algorithmScreen = new AlgorithmScreen(this, gt)));
				break;
			case GRID:
				if(game == null) {
					if(gt.getShot().equals("normal")) {
						game = new StandardGame(gt.getPeriod(), gt.getAlgorithm());
					} else {
						game = new AdvancedGame(gt.getPeriod(), gt.getAlgorithm());
					}
					game.placeComputerShips();
				}
				if(placeShipsController == null) placeShipsController = new PlaceShipsController(this);
				
				add(placeGridScreen != null ? placeGridScreen : (placeGridScreen = new PlaceShipsScreen(placeShipsController)),BorderLayout.NORTH);
				add(placeButtonsScreen != null ? placeButtonsScreen : (placeButtonsScreen = new ButtonsPane(placeShipsController, "Continue")), BorderLayout.SOUTH);
				add(boatsScreen != null ? boatsScreen : (boatsScreen = new BoatsPane(placeShipsController)));
				break;
			case INGAME:				
				add(igButtonsScreen != null ? igButtonsScreen : (igButtonsScreen = new ButtonsPane(mainActionsController, "Quitter","Sauvegarder","Algorithme")),BorderLayout.NORTH);
				add(myGridScreen != null ? myGridScreen : (myGridScreen = new MyGridScreen(game, placeShipsController)),BorderLayout.CENTER);
				add(enemyGridScreen != null ? enemyGridScreen : (enemyGridScreen = new EnemyGridScreen(game, this)),BorderLayout.SOUTH);
				add(informationsScreen != null ? informationsScreen : (informationsScreen = new CounterWT(game)),BorderLayout.EAST);
				break;
			default:
				break;
		}
		
		status = s;
		
		validate();
		repaint();
	}
	
	public AbstractGame getGame() { return game; }
}
