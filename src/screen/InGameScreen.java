package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import main.Button;
import main.CellPane;

public class InGameScreen extends JPanel {
	public InGameScreen(int a,int b) {
		setBorder(BorderFactory.createTitledBorder("Placer bateaux"));
		setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPane cellPane = new CellPane(1);
                cellPane.setBorder(new MatteBorder(1, 1, row < a-1 ? 0 : 1, col < b-1 ? 0 : 1, Color.GRAY));
                add(cellPane, gbc);
            }
        }
    }
}
