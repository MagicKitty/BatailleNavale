package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.GameType;
import screen.AlgorithmScreen;
import screen.GridScreen;
import screen.NewLoadScreen;
import screen.PeriodScreen;
import screen.ShotScreen;

public class GameWindow extends JFrame {
	private JPanel screen;
	private JPanel buttons;
	private JPanel boats;
	private JPanel informations;
	private GameType gt;
	
	public GameWindow() {
		super("Bataille Navale");
		
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
		if(screen != null) {
			remove(screen);
		}
		
		switch(s) {
			case NEW_LOAD:
				add(screen = new NewLoadScreen(this));
				break;
			case PERIOD:
				add(screen = new PeriodScreen(this, gt = new GameType()));
				break;
			case SHOT:
				add(screen = new ShotScreen(this, gt));
				break;
			case ALGORITHM:
				add(screen = new AlgorithmScreen(this, gt));
				break;
			case GRID:
				add(screen = new GridScreen(10, 10),BorderLayout.NORTH);
				add(buttons = new ButtonsPane(1,"Continue"),BorderLayout.SOUTH);
				add(boats = new BoatsPane(screen));
				break;
			case INGAME:
				System.out.println(gt);
				add(buttons = new ButtonsPane(3,"Quitter","Sauvegarder","Algorithme"),BorderLayout.NORTH);
				add(screen = new GridScreen(10, 10, "Ma grille"),BorderLayout.CENTER);
				add(screen = new GridScreen(10, 10, "Grille ennemie"),BorderLayout.SOUTH);
				add(informations = new CounterWT(0,0),BorderLayout.EAST);
				break;
		}
		
		validate();
		repaint();
	}
}
