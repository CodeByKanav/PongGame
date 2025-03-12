import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

/**
 * Name: Kanav
 * Date: Jan. 2024
 * Description: This class is responsible for the ball object in the game
 * Method List:
 * 			public Ball(int x, int y) { - Default constructor for initializing all variables
 * 			public void setyVel(int yVel) { - Setter method to set the yVel
 * 			public void setxVel(int xVel) { - Setter method to set the xVel
 * 			public int getyVel() { - getter method to get yVel
 * 			public int getxVel() { - getter method to get xVel
 * 			public int getIntSpeed() { - getter method to get IntSpeed
 * 			public void setIntSpeed(int speed) { - setter method to set IntSpeed
 * 			public static void main(String[] args) { - Main method for testing
 * 
 */

public class Ball extends Sprite {
	
	// declares all variables
	int xVel, yVel, speed;
	private java.net.URL ball = getClass().getResource("resources/Ball1.png");


	/**
	 * Default constructor responsible for object
	 */
	public Ball(int x, int y) {
		super(x, y, new ImageIcon());

		setImage(new ImageIcon(ball));
		
		xVel = 0;
		yVel = 0;
		speed = 0;
	}
	
	/*
	 * Method to set yVel
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/*
	 * Method to set xVel
	 */
	public void setxVel(int xVel) {
		this.xVel = xVel;
	}
	
	/*
	 * Method to get yVel
	 */
	public int getyVel() {
		return this.yVel;
	}
	
	/*
	 * Method to get xVel
	 */
	public int getxVel() {
		return this.xVel;
	}
	
	/*
	 * Method to get IntSpeed
	 */
	public int getIntSpeed() {
		return this.speed;
	}
	
	/*
	 * Method to set IntSpeed
	 */
	public void setIntSpeed(int speed) {
		this.speed = speed;
	}
	
	/*
	 * Main method for testing
	 */
	public static void main(String[] args) {

		// create ball object
		Ball ball = new Ball(0, 0);
		
		// create a JFrame
		JFrame frame = new JFrame();
		
		// JFrame settings
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		// add ball to frame
		frame.add(ball);
	}
}
