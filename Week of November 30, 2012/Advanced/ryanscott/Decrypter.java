package com.xnux;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Decrypter {

	/** Only use images encrypted with Steganographer.java */
	public static final String IMAGE_LOC = "REPLACEME/cat.png";
	/** You will have to know the length of the hidden message, or this will not work */
	public static final int HIDDEN_MSG_LEN = 14;

	private static boolean[][] mHiddenPxls;
	private static BufferedImage mImg;

	public static void main(String[] args) {
		BufferedImage testImage = openImage(IMAGE_LOC);

		if(testImage != null) {
			mImg = testImage;
		} else {
			System.out.println("Error: image not available.");
			System.exit(1);
		}
		
		mHiddenPxls = getHiddenPixels(mImg, HIDDEN_MSG_LEN);
		System.out.println(getHiddenMessage(mImg, mHiddenPxls));
	}

	private static BufferedImage openImage(String imageLoc) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imageLoc));
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}

	/** Uses the same algorithm as in Steganographer.java */
	private static boolean[][] getHiddenPixels(BufferedImage imgPxls, int hiddenMsgLen) {
		boolean[][] hiddenPxls = new boolean[imgPxls.getWidth()][imgPxls.getHeight()];
		int area = imgPxls.getWidth()*imgPxls.getHeight();
		int xInc = (int) (area/hiddenMsgLen);
		int yInc;
		int xPxl = 0, yPxl = 0;

		for(boolean[] row : hiddenPxls) {
			Arrays.fill(row, false);
		}

		while(yPxl < imgPxls.getHeight()) {
			hiddenPxls[xPxl][yPxl] = true;
			xPxl += xInc;
			if(xPxl >= imgPxls.getWidth()) {
				yInc = (int) (xPxl/imgPxls.getWidth());
				xPxl = xPxl % imgPxls.getWidth();
				yPxl += yInc;
			}
		}

		return hiddenPxls;
	}

	/** The converse of hideMessage() in Steganographer.java. This takes an
	 * encrypted image and finds the character value represented by the color
	 * in each "hidden pixel".
	 */
	private static String getHiddenMessage(BufferedImage image, boolean[][] hiddenPxls) {
		String hiddenMsg = "";
		int x = 0, y = 0, strIndex = 0;
		
		while(y < image.getHeight() & strIndex < HIDDEN_MSG_LEN) {			
			if(hiddenPxls[x][y]) {
				int pixelRgb = image.getRGB(x, y);
				strIndex++;
				hiddenMsg += (char) colorToVal(pixelRgb);
			}
			x++;
			if (x >= image.getWidth()) {
				x = 0;
				y++;
			}
		}
		return hiddenMsg;
	}
	
	private static int colorToVal(int color) {
		return (color >>> 16) & 0xFF;
	}

}
