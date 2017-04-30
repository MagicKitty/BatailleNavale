package graphic;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDB {
	private static ImageDB instance = new ImageDB();
	public static ImageDB getInstance() { return ImageDB.instance; }
	
	private Image bh, bu, fh, fu, mh, mu;
	
	private ImageDB() {
		Image bhI, buI, fhI, fuI, mhI, muI;
		int cellSize = 30;
		
		try {
			bhI = ImageIO.read(getClass().getResource("../images/bottom_horiz.png"));
			buI = ImageIO.read(getClass().getResource("../images/bottom_up.png"));
			fhI = ImageIO.read(getClass().getResource("../images/front_horiz.png"));
			fuI = ImageIO.read(getClass().getResource("../images/front_up.png"));
			mhI = ImageIO.read(getClass().getResource("../images/middle_horiz.png"));
			muI = ImageIO.read(getClass().getResource("../images/middle_up.png"));
			
			if (bhI != null) bh = bhI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
			if (buI != null) bu = buI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
			if (fhI != null) fh = fhI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
			if (fuI != null) fu = fuI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
			if (mhI != null) mh = mhI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
			if (muI != null) mu = muI.getScaledInstance(cellSize, cellSize, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getBH() { return bh; }
	public Image getBU() { return bu; }
	public Image getMH() { return mh; }
	public Image getMU() { return mu; }
	public Image getFH() { return fh; }
	public Image getFU() { return fu; }
}
