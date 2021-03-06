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

public class NewLoadScreen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	Button newGame, loadGame;
	JFileChooser fc;
	GameWindow window;

	public NewLoadScreen(GameWindow gm) {
		setBorder(BorderFactory.createTitledBorder("Partie"));
		setBackground(Color.ORANGE);
		setLayout(new GridBagLayout());
		
		window = gm;
		
		GridBagConstraints gbc = new GridBagConstraints();
		add(newGame = new Button("New Game", 10, 30, 10, 30, gbc, 0, 0), newGame.getGBC());
		add(loadGame = new Button("Load Game", 10, 28, 10, 28, gbc, 0, 1), loadGame.getGBC());
		
		newGame.addActionListener(this);
		loadGame.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == newGame) {
			window.setStatus(GameStatus.PERIOD);
		} else if (source == loadGame) {
			fc = new JFileChooser();
			fc.addChoosableFileFilter(new Filter());
			fc.setAcceptAllFileFilterUsed(false);
			int returnVal = fc.showOpenDialog(NewLoadScreen.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("Opening: "+file.getName() + System.lineSeparator());
                
                window.openFile(file.getName());
            } else {
            	System.out.println("Open command cancelled by user"+ System.lineSeparator());
            }
		}
	}
}
