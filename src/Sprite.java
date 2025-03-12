/**
 * 
 */

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Name: Kanav
 * Date: Dec. 2023
 * Description: This is the class containing the creation of
 * 				Images onto a JFrame
 * 				Inherits JComponent
 * Method List:
 * 			public Sprite() - default constructor
 * 			public Sprite(ImageIcon image) - Overloaded Constructor to take in imageicon
 * 			public Sprite(int x, int y, ImageIcon image) - Overloaded Constructor to take in x and y pos and imageicon
 * 			public void paint(Graphics g) - Override the paint method from JComponent
 * 			public int getXPos() - @return the x
 * 			public void setXPos(int x) - @param x the x to set
 * 			public int getYPos() - @return the y
 * 			public void setYPos(int y) - @param y the y to set
 * 			public int getImgWidth() - @return the imgWidth
 * 			public void setImgWidth(int imgWidth) - @param imgWidth the imgWidth to set
 *			public int getImgHeight() - @return the imgHeight
 * 			public void setImgHeight(int imgHeight) - @param imgHeight the imgHeight to set
 * 			public ImageIcon getImage() - @return the image
 * 			public void setImage(ImageIcon image) - @param image the image to set
 * 			public static void main(String[] args) - Main method for testing
 */
public class Sprite extends JComponent {

	/*
	 * Private Instance Data
	 */
	private int xPos, yPos, imgWidth, imgHeight;
	private ImageIcon image;


	/**
	 * Default Constructor
	 */
	public Sprite() {
		// initialize private data
		this.xPos = 0;
		this.xPos = 0;
		this.image = null;
	}

	/*
	 * Overloaded Constructor to take in imageicon
	 */
	public Sprite(ImageIcon image) {
		// initialize private data
		this.xPos = 0;
		this.yPos = 0;
		this.image = image;
		setImgWidth(image.getIconWidth());
		setImgHeight(image.getIconHeight());
	}

	/*
	 * Overloaded Constructor to take in x and y pos and imageicon
	 */
	public Sprite(int x, int y, ImageIcon image) {
		// initialize private data
		this.xPos = x;
		this.yPos = y;
		this.image = image;
		setImgWidth(image.getIconWidth());
		setImgHeight(image.getIconHeight());
	}

	/**
	 * Override the paint method from JComponent
	 */
	public void paint(Graphics g) {
		this.image.paintIcon(this, g, xPos, yPos);
	}

	/**
	 * @return the x
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * @param x the x to set
	 */
	public void setXPos(int x) {
		this.xPos = x;
	}

	/**
	 * @return the y
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * @param y the y to set
	 */
	public void setYPos(int y) {
		this.yPos = y;
	}

	/**
	 * @return the imgWidth
	 */
	public int getImgWidth() {
		return imgWidth;
	}

	/**
	 * @param imgWidth the imgWidth to set
	 */
	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	/**
	 * @return the imgHeight
	 */
	public int getImgHeight() {
		return imgHeight;
	}

	/**
	 * @param imgHeight the imgHeight to set
	 */
	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	/**
	 * @return the image
	 */
	public ImageIcon getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
		setImgWidth(image.getIconWidth());
		setImgHeight(image.getIconHeight());
	}

	/**
	 * @param args
	 * Main method for testing (Not needed for this)
	 */
	public static void main(String[] args) {
	}
}
