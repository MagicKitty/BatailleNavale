package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import game.GameType;
import main.Button;
import main.Filter;
import main.GameStatus;
import main.GameWindow;

public class PeriodScreen extends JPanel implements ActionListener {
	private GameType _gt;
	private GameWindow _gw;
	private Button moderne, renaissance;
	
	public PeriodScreen(GameWindow gw, GameType gt) {
		_gt = gt;
		_gw = gw;
		
		setBorder(BorderFactory.createTitledBorder("Époque"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		add(moderne = new Button("Moderne XXè",10,30,10,30,gbc,0,0),moderne.getGBC());
	    add(renaissance = new Button("Renaissance XVè",10,17,10,16,gbc,0,1),renaissance.getGBC());
	    
	    moderne.addActionListener(this);
	    renaissance.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == moderne) {
			_gt.setPeriod("moderne");
			_gw.setStatus(GameStatus.SHOT);
		} else if(source == renaissance) {
			_gt.setPeriod("renaissance");
			_gw.setStatus(GameStatus.SHOT);
		}
	}
}