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

import main.Button;
import main.Filter;
import main.GameStatus;
import main.GameWindow;

public class ShotScreen extends JPanel implements ActionListener {
	private Button normal, decidable;
	private GameWindow _gw;
	private GameType _gt;
	
	public ShotScreen(GameWindow gw, GameType gt) {
		_gw = gw;
		_gt = gt;
		
		setBorder(BorderFactory.createTitledBorder("Tir"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		add(normal = new Button("Normal",10,30,10,30,gbc,0,0), normal.getGBC());
		add(decidable = new Button("Décidable",10,20,10,20,gbc,0,1), decidable.getGBC());
		
		normal.addActionListener(this);
		decidable.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == normal) {
			_gt.setShot("normal");
			_gw.setStatus(GameStatus.ALGORITHM);
		} else if (source == decidable) {
			_gt.setShot("decidable");
			_gw.setStatus(GameStatus.ALGORITHM);
		}
	}
}
