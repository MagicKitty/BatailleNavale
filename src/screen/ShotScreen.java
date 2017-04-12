package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Button;

public class ShotScreen extends JPanel {
	public ShotScreen() {
		setBorder(BorderFactory.createTitledBorder("Tir"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		Button moderne = new Button("Normal",10,30,10,30,gbc,0,0);
		Button renaissance = new Button("Décidable",10,20,10,20,gbc,0,1);
	    
		add(moderne,moderne.getGBC());
		add(renaissance,renaissance.getGBC());
	}
}
