package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.PlaceShipsController;
import screen.GameType;
import screen.AlgorithmScreen;
import screen.GridScreen;
import screen.NewLoadScreen;
import screen.PeriodScreen;
import screen.ShotScreen;

public class GameWindow extends JFrame {	
	private JPanel newLoadScreen, periodScreen, shotScreen, algorithmScreen, placeGridScreen, placeButtonsScreen;
	private JPanel boatsScreen, igButtonsScreen, myGridScreen, enemyGridScreen, informationsScreen;
	
	private PlaceShipsController placeShipsController;
	private GameType gt;
	private GameStatus status;
	
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
		}
		
		s=status.INGAME;
		
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
				if(placeShipsController == null) placeShipsController = new PlaceShipsController();
				
				add(placeGridScreen != null ? placeGridScreen : (placeGridScreen = new GridScreen(10, 10, null)),BorderLayout.NORTH);
				add(placeButtonsScreen != null ? placeButtonsScreen : (placeButtonsScreen = new ButtonsPane(1,"Continue")), BorderLayout.SOUTH);
				add(boatsScreen != null ? boatsScreen : (boatsScreen = new BoatsPane(placeShipsController)));
				break;
			case INGAME:
				System.out.println(gt);
				add(igButtonsScreen != null ? igButtonsScreen : (igButtonsScreen = new ButtonsPane(3,"Quitter","Sauvegarder","Algorithme")),BorderLayout.NORTH);
				add(myGridScreen != null ? myGridScreen : (myGridScreen = new GridScreen(10, 10, "Ma grille")),BorderLayout.CENTER);
				add(enemyGridScreen != null ? enemyGridScreen : (enemyGridScreen = new GridScreen(10, 10, "Grille ennemie")),BorderLayout.SOUTH);
				add(informationsScreen != null ? informationsScreen : (informationsScreen = new CounterWT(0,0)),BorderLayout.EAST);
				break;
		}
		
		status = s;
		
		validate();
		repaint();
	}
}
