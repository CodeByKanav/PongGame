/**
 * 
 */

import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Name: Kanav
 * Date: Jan. 2024
 * Description: This class is responsible for the paddles, that the player uses
 * Method List:
 * 			public Paddles(int x, int y, int paddle) { - Default constructor for creating the objects
 * 			public void keyTyped(KeyEvent e) {} - Not in use
 * 			public void KeyPressed(KeyEvent e) { - Method to check if any key is being pressed
 * 			public void KeyReleased(KeyEvent e) { - Method to check if any pressed key is released
 * 			public int getyVel() { - getter method to get yVel
 * 			public void setyVel(int yVel) { - setter method to set yVel
 * 			public static void main(String[] args) { - Main method for testing
 */
public class Paddles extends Sprite {

	// declares variables
	int yVel, paddle;
	private java.net.URL paddle1 = getClass().getResource("resources/Paddle1.png");
	private java.net.URL paddle2 = getClass().getResource("resources/Paddle2.png");

	/**
	 * Default constructor
	 */
	public Paddles(int x, int y, int paddle) {
		// picks paddle based on sides
		if (paddle == 1) {
			setImage(new ImageIcon(paddle1));
		}
		// picks paddle based on sides
		else if (paddle == 2) {
			setImage(new ImageIcon(paddle2));
		}

		// Initializes the variables
		this.yVel = 0;
		this.paddle = paddle;
	}

	/*
	 * Method not in use
	 */
	public void keyTyped(KeyEvent e) {}

	/*
	 * Method to check if key is pressed
	 */
	public void KeyPressed(KeyEvent e) {
		// switch case to check which user needs to move
		switch(paddle) {
		case 1: { // if red team
			if (e.getKeyCode() == KeyEvent.VK_W) { // checks if the input is from the right key
				setyVel(-7); // changes velocity based on key pressed
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) { // checks if the input is from the right key
				setyVel(7); // changes velocity based on key pressed
			}
			break; // breaks
		}
		case 2: { // blue team
			if (e.getKeyCode() == KeyEvent.VK_I) { // checks if the input is from the right key
				setyVel(-7); // changes velocity based on key pressed
			}
			else if (e.getKeyCode() == KeyEvent.VK_K) { // checks if the input is from the right key
				setyVel(7); // changes velocity based on key pressed
			}
			break; // breaks
		}
		}
	}

	/*
	 * Method to check if key is released
	 */
	public void KeyReleased(KeyEvent e) {
		// switch case to check which user needs to move
		switch(paddle) {
		case 1: { // if red team
			if (e.getKeyCode() == KeyEvent.VK_W) { // checks if the input is from the right key
				if (getyVel()==-7) { // checks if the right key was being pressed
					setyVel(0); // sets the velocity to 0 to make paddles stop
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) { // checks if the input is from the right key
				if (getyVel()==7) { // checks if the right key was being pressed
					setyVel(0); // sets the velocity to 0 to make paddles stop
				}
			}
			break; // breaks
		}
		case 2: { // if blue team
			if (e.getKeyCode() == KeyEvent.VK_I) { // checks if the input is from the right key
				if (getyVel()==-7) { // checks if the right key was being pressed
					setyVel(0); // sets the velocity to 0 to make paddles stop
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_K) { // checks if the input is from the right key
				if (getyVel()==7) { // checks if the right key was being pressed
					setyVel(0); // sets the velocity to 0 to make paddles stop
				}
			}
			break; // breaks
		}
		}

	}

	/*
	 * Method to get yVel
	 */
	public int getyVel() {
		return this.yVel;
	}

	/*
	 * Method to set yVel
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	/*
	 * Main method for testing
	 */
	public static void main(String[] args) {

		// create paddle object
		Paddles paddleRed = new Paddles(0, 0, 1);
		
		// create a JFrame
		JFrame frame = new JFrame();
		
		// JFrame settings
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		// add paddle to frame
		frame.add(paddleRed);
	}
}
