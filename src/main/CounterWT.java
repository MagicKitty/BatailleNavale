package main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Water Touched Counter panel
 */
public class CounterWT extends JPanel {
	{
        setOpaque(false);
    }
	
	private JLabel water, touched;
	
	public CounterWT(int waterValue, int touchedValue) {
		super();
		setLayout(new BorderLayout());
		
		add(water = new JLabel(" ", JLabel.CENTER), BorderLayout.NORTH);
		add(touched = new JLabel(" ", JLabel.CENTER), BorderLayout.CENTER);
		
		updateValue(waterValue, touchedValue);
	}
	
	public void updateValue(int waterValue, int touchedValue) {
		water.setText("Eau : " + waterValue);
		touched.setText("Touché : " + touchedValue);
	}
}
