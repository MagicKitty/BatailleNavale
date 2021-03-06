package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Button;
import main.GameStatus;
import main.GameWindow;
import period.Period;

public class PeriodScreen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
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
			_gt.setPeriod(Period.MODERN);
			_gw.setStatus(GameStatus.SHOT);
		} else if(source == renaissance) {
			_gt.setPeriod(Period.RENAISSANCE);
			_gw.setStatus(GameStatus.SHOT);
		}
	}
}