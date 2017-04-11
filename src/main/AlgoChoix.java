package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AlgoChoix extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlgoChoix() {
		this.setBorder(BorderFactory.createTitledBorder("Algorithme"));
		this.setBackground(Color.ORANGE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Button moderne = new Button("Aléatoire",10,18,10,18,gbc,0,0);
		this.add(moderne,moderne.getGBC());
		Button renaissance = new Button("Croix",10,33,10,33,gbc,0,1);
	    this.add(renaissance,renaissance.getGBC());
	}
}
