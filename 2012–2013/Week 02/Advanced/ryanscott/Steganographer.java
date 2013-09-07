package com.xnux;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Steganographer {

	/** Preferably a cat picture */
	public static final String IMAGE_LOC = "REPLACEME/cat.png";
	/** I have only tested PNG images. JPG images will not work because the JPG
	 * format compresses the image after it is edited, causing the colors to
	 * change and distorting the encrypted message.
	 */
	public static final String IMAGE_EXT = "png";

	private static String mHiddenMsg;
	private static boolean[][] mHiddenPxls;
	private static BufferedImage mImg;

	/**
	 * This uses a command-line argument as the hidden message. If you wanted
	 * to test this, you could compile it with "javac Steganographer.java" and
	 * then run "java Steganographer <your_hidden_msg>" using Bash.
	 */
	public static void main(String[] args) {
		mHiddenMsg = args[0];
		BufferedImage testImage = openImage(IMAGE_LOC);

		if(testImage != null) {
			mImg = testImage;
		} else {
			System.out.println("Error: image not available.");
			System.exit(1);
		}
		if(mHiddenMsg.length() > mImg.getWidth()*mImg.getHeight()) {
			System.out.println("Your message is too long to be encrypted in this image");
			System.exit(1);
		} else if (mHiddenMsg == null || mHiddenMsg.length() == 0) {
			System.out.println("Error: nothing to encrypt.");
			System.exit(1);
		}

		mHiddenPxls = getHiddenPixels(mImg, mHiddenMsg);
		hideMessage(mImg, mHiddenMsg, mHiddenPxls);
		saveImage(mImg, IMAGE_EXT, IMAGE_LOC);
		System.out.println("Message encrypted.");
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

	private static void saveImage(BufferedImage bi, String imageExt, String imageLoc) {
		try {
			File ofile = new File(imageLoc);
			ImageIO.write(bi, imageExt, ofile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Uses a really simple algorithm to find out which pixels in an image
	 * (i.e., a pixel array) should be used to hide information.
	 */
	private static boolean[][] getHiddenPixels(BufferedImage imgPxls, String hiddenMsg) {
		boolean[][] hiddenPxls = new boolean[imgPxls.getWidth()][imgPxls.getHeight()];
		int area = imgPxls.getWidth()*imgPxls.getHeight();
		int xInc = (int) (area/hiddenMsg.length());
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

	/** Finds each "hidden pixel" in the image and sets the pixel to a new color
	 * that is unique to the character in the hidden message being encrypted.
	 */
	private static void hideMessage(BufferedImage image, String hiddenMsg, boolean[][] hiddenPxls) {
		int x = 0, y = 0, strIndex = 0;
		while(y < image.getHeight() && strIndex < hiddenMsg.length()) {
			if(hiddenPxls[x][y]) {
				int charVal = hiddenMsg.charAt(strIndex);
				strIndex++;
				image.setRGB(x, y, rgbToColor(charVal, charVal, charVal));
			}
			x++;
			if (x >= image.getWidth()) {
				x = 0;
				y++;
			}
		}
	}
	
	/** I don't pretend to know how this works, but this turns RGB values into a
	 * form that the BufferedImage class can use to set pixel colors.
	 */
	private static int rgbToColor(int red, int green, int blue) {
		return (255 << 24) | (red << 16) | (green << 8) | blue;
	}
	
}
