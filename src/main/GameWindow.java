package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.*;

public class GameWindow extends JFrame {
	private JPanel screen;
	private GameType gt;
	
	public GameWindow() {
		super("Bataille Navale");
		
		gt = new GameType();
		
		setSize(500, 500);

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
				System.out.println(gt);
				add(screen = new GridScreen(10, 10));
				break;
		}
		
		validate();
		repaint();
	}
}
