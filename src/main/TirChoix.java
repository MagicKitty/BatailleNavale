package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TirChoix extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TirChoix() {
		this.setBorder(BorderFactory.createTitledBorder("Tir"));
		this.setBackground(Color.ORANGE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Button moderne = new Button("Normal",10,30,10,30,gbc,0);
		this.add(moderne,moderne.getGBC());
		Button renaissance = new Button("Décidable",10,20,10,20,gbc,1);
	    this.add(renaissance,renaissance.getGBC());
	}
}
