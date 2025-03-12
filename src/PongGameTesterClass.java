/**
 * 
 */
import javax.swing.JOptionPane;

/**
 * Name: Kanav
 * Date: Jan. 2024
 * Description: This class tests the "PongGame.java" UI class
 * Method List:
 * 			public static void main(String[] args) - Main Method for testing
 */
public class PongGameTesterClass {

	/**
	 * Main method for testing
	 */
	public static void main(String[] args) {
		// create UI class
		PongGame frame = new PongGame(0);

		// call start game method and test it
		frame.reset();

		// prompts the results
		JOptionPane.showMessageDialog(null, "Clicking 'OK'\nResets all the objects to orignal place after a brief pause (3 seconds), while keeping the score");

		// call start game method and test it (again)
		frame.reset();

		// prompts the results
		JOptionPane.showMessageDialog(null, "Reset method works as it should, resetting everything back to the original spots");

		// closes the program
		System.exit(0);
	}
}
