package screen;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import graphic.Coord2D;
import main.CellPane;
import ship.Orientation;

public class GridScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private LinkedList<CellPane> cells;
	
	public GridScreen(int width, int height, String title) {
		if(title != null) setBorder(BorderFactory.createTitledBorder(title));
		
		cells = new LinkedList<CellPane>();
		
		setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                
        		CellPane cellPane = new CellPane(1, this);
                cellPane.setBorder(new MatteBorder(1, 1, row < width - 1 ? 0 : 1, col < height -1 ? 0 : 1, Color.GRAY));
                cellPane.setPosition(row,  col);
                cells.add(cellPane);
                add(cellPane, gbc);
            }
        }
    }
	
	public boolean drawShip(Coord2D coord, Orientation orientation, int size) {
		boolean res = true;
		if(coord.getX() < 0 || coord.getY() < 0) return false;
		
		int startX = coord.getX(), startY = coord.getY(), ptr = 0;
		int endX = Math.min(startX + (orientation == Orientation.HORIZONTAL ? size : 0), 9);
		int endY = Math.min(startY + (orientation == Orientation.VERTICAL ? size : 0), 9);
		
		int A = 1, B = 3, C = 5;
		if(orientation == Orientation.VERTICAL) {
			A = 4;
			B = 2;
			C = 6;
		}
		
		if(startX + (orientation == Orientation.HORIZONTAL ? size : 0) > 10
			|| startY + (orientation == Orientation.VERTICAL ? size : 0) > 10) {
			A = B = C = -1;
			res = false;
		}
		
		for(int x = startX; x <= endX; x++) {
			for(int y = startY; y <= endY; y++) {
				if(ptr < size) colorCell(x, y, (ptr == 0 ? A : (ptr == size - 1 ? B : C)));
				ptr++;
			}
		}
		
		return res;
	}
	
	public void handleMouseOver(int row, int col) {
		
	}
	
	public void handleMouseOut(int row, int col) {
			
	}
	
	public void handleClick(int row, int col) {
		
	}
	
	public void clearScreen() {
		clearScreen(0);
	}
	
	public void clearScreen(int color) {
		for(CellPane c : cells) {
			c.setStatus(color);
		}
	}
	
	public void colorCell(int col, int row, int color) {
		for(CellPane c : cells) {
			if(c.getRow() == row && c.getCol() == col) {
				c.setStatus(color);
				break;
			}
		}
	}
}
