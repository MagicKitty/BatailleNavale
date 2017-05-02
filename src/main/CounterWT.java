package main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.AbstractGame;

/**
 * Water Touched Counter panel
 */
public class CounterWT extends JPanel {
	private static final long serialVersionUID = 1L;
	{
        setOpaque(false);
    }
	
	private JLabel water, touched;
	private AbstractGame game;
	
	public CounterWT(AbstractGame g) {
		super();
		setLayout(new BorderLayout());
		game = g;
		
		add(water = new JLabel(" ", JLabel.CENTER), BorderLayout.NORTH);
		add(touched = new JLabel(" ", JLabel.CENTER), BorderLayout.CENTER);
		
		update();
	}
	
	public void update() {
		water.setText("Eau : " + game.getHumanGrid().getNumberOfSeaShots());
		touched.setText("Touché : " + game.getHumanGrid().getNumberOfShipShots());
	}
}
