package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class NewLoadChoix extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button newGame;
	Button loadGame;
	JFileChooser fc;
	static private final String newline = "\n";

	public NewLoadChoix() {
		this.setBorder(BorderFactory.createTitledBorder("Partie"));
		this.setBackground(Color.ORANGE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		newGame = new Button("New Game", 10, 30, 10, 30, gbc, 0, 0);
		newGame.addActionListener(this);
		this.add(newGame, newGame.getGBC());
		loadGame = new Button("Load Game", 10, 28, 10, 28, gbc, 0, 1);
		loadGame.addActionListener(this);
		this.add(loadGame, loadGame.getGBC());
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == newGame) {
			
		} else if (source == loadGame) {
			fc = new JFileChooser();
			fc.addChoosableFileFilter(new Filter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(NewLoadChoix.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("Opening: "+file.getName()+newline);
            } else {
            	System.out.println("Open command cancelled by user"+newline);
            }
		}
	}
}
