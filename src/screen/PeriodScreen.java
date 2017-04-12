package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Button;

public class PeriodScreen extends JPanel {
	public PeriodScreen() {
		setBorder(BorderFactory.createTitledBorder("Époque"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		Button moderne = new Button("Moderne XXè",10,30,10,30,gbc,0,0);
		Button renaissance = new Button("Renaissance XVè",10,17,10,16,gbc,0,1);
		
		add(moderne,moderne.getGBC());
	    add(renaissance,renaissance.getGBC());
	}
}