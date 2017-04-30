package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import graphic.ImageDB;
import screen.GridScreen;

public class CellPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private GridScreen grid;
	private Color defaultBackground;
	private int row, col;
	private Image image;

	public CellPane(int tailleBateau, GridScreen pGrid) {
		grid = pGrid;
		setStatus(0);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// defaultBackground = getBackground();
				setBackground(new Color(59, 89, 182));
				if (grid != null)
					grid.handleMouseOver(row, col);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(defaultBackground);
				if (grid != null)
					grid.handleMouseOut(row, col);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (grid != null)
					grid.handleClick(row, col);
			}
		});
	}

	public void setStatus(int n) {
		image = null;
		
		if (n == 0) {
			defaultBackground = new Color(0, 153, 204);
		} else if (n == 1) {
			image = ImageDB.getInstance().getBH();
		} else if (n == 2) {
			image = ImageDB.getInstance().getBU();
		} else if(n == 3) {
			image = ImageDB.getInstance().getFH();
		} else if(n == 4) {
			image = ImageDB.getInstance().getFU();
		} else if(n == 5) {
			image = ImageDB.getInstance().getMH();
		} else if(n == 6) {
			image = ImageDB.getInstance().getMU();
		} else if (n == -1) {
			defaultBackground = new Color(200, 0, 0);
		}
		setBackground(defaultBackground);
		this.repaint();
	}

	public void setPosition(int r, int c) {
		row = r;
		col = c;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(30, 30);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) g.drawImage(image, 0, 0, null);
	}
}
//Image front_up = imageBoatFrontHoriz.getScaledInstance(widthCell,heightCell, Image.SCALE_DEFAULT);