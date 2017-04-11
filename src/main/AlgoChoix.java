package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AlgoChoix extends JPanel {
	public AlgoChoix() {
		setBorder(BorderFactory.createTitledBorder("Algorithme"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		Button moderne = new Button("Aléatoire",10,18,10,18,gbc,0,0);
		Button renaissance = new Button("Croix",10,33,10,33,gbc,0,1);
	    
		add(moderne,moderne.getGBC());
		add(renaissance,renaissance.getGBC());
	}
}
