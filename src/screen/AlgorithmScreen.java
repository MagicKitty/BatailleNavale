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

public class AlgorithmScreen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private GameWindow _gw;
	private GameType _gt;
	private Button aleatoire, croix;
	
	public AlgorithmScreen(GameWindow gw, GameType gt) {
		_gt = gt;
		_gw = gw;
		
		setBorder(BorderFactory.createTitledBorder("Algorithme"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		add(aleatoire = new Button("Aléatoire",10,18,10,18,gbc,0,0), aleatoire.getGBC());
		add(croix = new Button("Croix",10,33,10,33,gbc,0,1), croix.getGBC());
		
		aleatoire.addActionListener(this);
		croix.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == aleatoire) {
			_gt.setAlgorithm("aleatoire");
			_gw.setStatus(GameStatus.GRID);
		} else if(source == croix) {
			_gt.setAlgorithm("croix");
			_gw.setStatus(GameStatus.GRID);
		}
	}
}
