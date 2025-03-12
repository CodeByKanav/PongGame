/**
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Name: Kanav
 * Date: Jan. 2024
 * Description: This class is the menu through which the user can pick the difficulty level
 * Method List:
 * 			public Menu() { - Default constructor for creating objects
 * 			public void actionPerformed(ActionEvent e) { - Method check which button is pressed
 * 			public static void main(String[] args) - Main Method for testing
 */
public class Menu extends JFrame implements ActionListener {

	// declares the variables
	private JButton easy, medium, hard, pongatron, back, help;
	private Sprite pongImg, difficulty;
	private java.net.URL PongGameImg = getClass().getResource("resources/PongGameImg.png");
	private java.net.URL DifficultyGif = getClass().getResource("resources/Difficulty.gif");

	/**
	 * Default constructor
	 */
	public Menu() {
		super("Menu"); // calls super
		
		// creates button for help
		help = new JButton("?");
		help.setBounds(10, 450, 50, 50);
		help.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		help.setVisible(true);
		help.addActionListener(this); // allows actionListener to see if pressed
		this.add(help);

		// creates button for MainMenu
		back = new JButton("Return to menu");
		back.setBounds(370, 390, 160, 50);
		back.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		back.setVisible(true);
		back.addActionListener(this); // allows actionListener to see if pressed
		this.add(back);
		
		// creates button for easy difficulty
		easy = new JButton("Easy");
		easy.setBounds(130, 260, 120, 50);
		easy.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		easy.setVisible(true);
		easy.addActionListener(this); // allows actionListener to see if pressed
		this.add(easy);

		// creates button for medium difficulty
		medium = new JButton("Medium");
		medium.setBounds(300, 260, 120, 50);
		medium.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		medium.setVisible(true);
		medium.addActionListener(this); // allows actionListener to see if pressed
		this.add(medium);

		// creates button for hard difficulty
		hard = new JButton("Hard");
		hard.setBounds(470, 260, 120, 50);
		hard.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		hard.setVisible(true);
		hard.addActionListener(this); // allows actionListener to see if pressed
		this.add(hard);

		// creates button for pongatron difficulty
		pongatron = new JButton("Pongatron");
		pongatron.setBounds(640, 260, 120, 50);
		pongatron.setFont(new Font("Default", Font.BOLD, 16)); // sets font
		pongatron.setVisible(true);
		pongatron.addActionListener(this); // allows actionListener to see if pressed
		this.add(pongatron);

		// adds the "Pong" image
		pongImg = new Sprite(new ImageIcon(PongGameImg));
		pongImg.setBounds(190, 10, 900, 550);
		this.add(pongImg);

		// adds the "Select difficulty" image
		difficulty = new Sprite(new ImageIcon(DifficultyGif));
		difficulty.setBounds(340, 210, 900, 550);
		this.add(difficulty);

		// settings for the frame
		this.getContentPane().setBackground(Color.black); 
		this.setSize(900,550);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // sets frame to the center
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
	 * Method to perform action based on each button clicked
	 */
	public void actionPerformed(ActionEvent e) {

		// if user clicks easy
		if (e.getSource() == easy) {
			new PongGame(0); // runs the main game based on difficulty
			this.dispose(); // disposes old frame
		}
		// if user clicks medium
		if (e.getSource() == medium) {
			new PongGame(1); // runs the main game based on difficulty
			this.dispose(); // disposes old frame
		}
		// if user clicks hard
		if (e.getSource() == hard) {
			new PongGame(2); // runs the main game based on difficulty
			this.dispose(); // disposes old frame
		}
		// if user clicks pongatron
		if (e.getSource() == pongatron) {
			new PongGame(3); // runs the main game based on difficulty
			this.dispose(); // disposes old frame
		}
		// if user clicks back
		if (e.getSource() == back) {
			//new MainMenu(); // takes user back to menu
			this.dispose(); // disposes old frame
		}
		// if user clicks help
		if (e.getSource() == help) { // shows the keybinds
			JOptionPane.showMessageDialog(this, "2 Player Keybinds:\n\nRed: Up = ' W ', Down = ' S '\n\nBlue: Up = ' I ', Down = ' K '"); // displays message
		}
	}

	/**
	 * Main method for testing
	 */
	public static void main(String[] args) {
		new Menu(); // calls the constructor
	}
}
