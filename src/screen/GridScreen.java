package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import main.Button;
import main.CellPane;

public class GridScreen extends JPanel {
	CellPane cellPane;
	
	public GridScreen(int a, int b, String title) {
		if(title != null) setBorder(BorderFactory.createTitledBorder(title));
		
		setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < a; row++) {
            for (int col = 0; col < b; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
        		cellPane = new CellPane(1);
                cellPane.setBorder(new MatteBorder(1, 1, row < a-1 ? 0 : 1, col < b-1 ? 0 : 1, Color.GRAY));
                add(cellPane, gbc);
            }
        }
    }
}
