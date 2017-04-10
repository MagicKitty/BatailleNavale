package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class EpoqueChoix extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EpoqueChoix() {
		this.setBorder(BorderFactory.createTitledBorder("Époque"));
		this.setBackground(Color.ORANGE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Button moderne = new Button("Moderne XXè",10,30,10,30,gbc,0);
		this.add(moderne,moderne.getGBC());
		Button renaissance = new Button("Renaissance XVè",10,17,10,16,gbc,1);
	    this.add(renaissance,renaissance.getGBC());
	}
}
