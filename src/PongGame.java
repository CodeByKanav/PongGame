/**
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Name: Kanav
 * Date: Jan. 2024
 * Description: This program is a game called "Pong", it is a 2 player game which can be enjoyed with different
 * 				difficulties, the way this game is played is when the ball collides with the paddles it will bounce
 * 				to the opponents side. As the game progresses, the ball gets faster, the first player to get 3 points
 * 				wins the game.
 * Method List:
 * 			public PongGame(int speed) { - Default constructor, with initial speed as parameter
 * 			public void reset() { - Reset method to send all objects to the initial start spot, and restarts the game
 * 			public void keyTyped(KeyEvent e) {} - Not in use
 * 			public void keyPressed(KeyEvent e) { - Method to check if any key is being pressed
 * 			public void keyReleased(KeyEvent e) { - Method to check if any pressed key is released
 * 			public void actionPerformed(ActionEvent e) { - Method to perform all the movements for the objects
 * 			public static void main(String[] args) - Main Method for testing
 */
public class PongGame extends JFrame implements ActionListener, KeyListener {
	
	// declares all the variables
	private Paddles paddle1, paddle2;
	private Ball ball;
	private Timer movement;
	private int p1Score, p2Score, rounds;
	private Rectangle r1, r2, r3;
	private Sprite line;
	private JLabel s1, s2, w1;
	private JButton btnRestart, btnLobby;
	private java.net.URL LinePng = getClass().getResource("resources/LinePng.png");


	/**
	 * Default constructor
	 */
	public PongGame(int speed) {
		super("Pong Game"); // calls the super
		
		// Initializes the score
		p1Score = 0;
		p2Score = 0;
		
		// initializes the # of rounds
		rounds = 3;
		
		// creates the restart button
		btnRestart = new JButton("Restart");
		btnRestart.setBounds(320, 370, 90, 50);
		btnRestart.setFont(new Font("Default", Font.BOLD, 16)); // sets a font
		btnRestart.setVisible(false); // does not show unless game ends
		btnRestart.addActionListener(this); // action listener to see input
		this.add(btnRestart); // adds to the frame
		
		// creates the Menu button
		btnLobby = new JButton("Menu");
		btnLobby.setBounds(460, 370, 90, 50);
		btnLobby.setFont(new Font("Default", Font.BOLD, 16)); // sets a font
		btnLobby.setVisible(false); // does not show unless game ends
		btnLobby.addActionListener(this); // action listener to see input
		this.add(btnLobby); // adds to the frame
		
		// creates a JLabel for scoreboard
		s1 = new JLabel(p1Score + "");
		s1.setFont(new Font("Default", Font.BOLD, 80)); // sets a font
		s1.setBounds(370, 0, 100, 100);
		s1.setForeground(Color.WHITE); // changes color to white
		this.add(s1); // adds to the frame
		
		// creates a JLabel for scoreboard
		s2 = new JLabel(p2Score + "");
		s2.setFont(new Font("Default", Font.BOLD, 80)); // sets a font
		s2.setBounds(460, 0, 100, 100);
		s2.setForeground(Color.WHITE); // changes color to white
		this.add(s2); // adds to the frame
		
		// creates a JLabel to display the winner
		w1 = new JLabel("");
		w1.setFont(new Font("Default", Font.BOLD, 80)); // sets a font
		w1.setBounds(250, 0, 500, 500);
		w1.setForeground(Color.WHITE); // changes color to white
		w1.setVisible(false); // does not show unless game ends
		this.add(w1);  // adds to the frame
		
		// creates paddles for player one
		paddle1 = new Paddles(0, 200, 1);
		paddle1.setBounds(0, 0, 20, 550);
		this.add(paddle1);
		paddle1.setYPos(200);
		
		// creates paddles for player two
		paddle2 = new Paddles(0, 200, 2);
		paddle2.setXPos(885 - paddle2.getImgWidth()); // putting the paddle on the right side wall
		paddle2.setBounds(0, 0, 900, 550);
		this.add(paddle2);
		paddle2.setYPos(200);
		
		// creates the ball
		ball = new Ball(0, 0);
		ball.setXPos(450 - (ball.getImgWidth())); // setting balls xPos to the middle
		ball.setYPos((int) (Math.random()*480)); // randomizes the balls y location
		ball.setyVel((int) (Math.random()*2)); // randomizes if ball will go up or down
		ball.setxVel((int) (Math.random()*2)); // randomizes if the ball will go left or right
		
		// sets the initial speed based the difficulty
		ball.setIntSpeed(speed);
		
		// if randomizer picks 0 for y
		if (ball.getyVel() == 0) {
			ball.setyVel(2 + speed);
		}
		else {
			ball.setyVel(-2 - speed);
		}
		
		// if randomizer picks 0 for x
		if (ball.getxVel() == 0) {
			ball.setxVel(2 + speed);
		}
		else {
			ball.setxVel(-2 - speed);
		}
		
		// set bounds for the ball
		ball.setBounds(0, 0, 900, 550);
		this.add(ball); // adds to the frame
		
		// creates the middle line dividing the two sides
		line = new Sprite(new ImageIcon(LinePng));
		line.setBounds(-10, 0, 900, 550);
		this.add(line); // adds to the frame
		
		// all the frame settings
		this.getContentPane().setBackground(Color.DARK_GRAY); 
		this.setSize(900,550);
		this.setLayout(null);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setLocationRelativeTo(null); // sets frame to the center
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// creates a timer for the movements
		movement = new Timer(1, this);
		movement.addActionListener(this);
		movement.setInitialDelay(2000); // sets a delay to start after 2 seconds
		movement.start();
	}
	
	/*
	 * Method for resetting the game
	 */
	public void reset() {
		// sets the paddles to the original location
		paddle1.setYPos(200);
		paddle2.setYPos(200);
		
		// randomizes the ball in the center
		ball.setXPos(450 - (ball.getImgWidth()));
		ball.setYPos((int) (Math.random()*480));
		ball.setyVel((int) (Math.random()*2));
		ball.setxVel((int) (Math.random()*2));
		
		// if statements for the balls y direction + initial difficulty
		if (ball.getyVel() == 0) {
			ball.setyVel(2 + ball.getIntSpeed());
		}
		else {
			ball.setyVel(-2 - ball.getIntSpeed());
		}
		
		// if statements for the balls x direction + initial difficulty
		if (ball.getxVel() == 0) {
			ball.setxVel(2 + ball.getIntSpeed());
		}
		else {
			ball.setxVel(-2 - ball.getIntSpeed());
		}
		
		// stops timer to give players a break in between games
		movement.stop();
		movement.setInitialDelay(2000); // sets a delay of 2 seconds
		movement.start();
	}
	
	/*
	 * Method not in use
	 */
	public void keyTyped(KeyEvent e) {}
	
	/*
	 * Method to see if key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		// sends a signal for paddles to move
		paddle1.KeyPressed(e); 
		paddle2.KeyPressed(e);
	}
	
	/*
	 * Method to see if is not longer pressed
	 */
	public void keyReleased(KeyEvent e) {
		// sends a signal for paddles to stop moving
		paddle1.KeyReleased(e);
		paddle2.KeyReleased(e);
	}
	
	/*
	 * Method to perform all the movements
	 */
	public void actionPerformed(ActionEvent e) {
		
		// if user clicks reset game
		if (e.getSource() == btnRestart) {
			
			setFocusable(true); // to focus on the paddles
			
			
			// resets the score
			p1Score = 0;
			p2Score = 0;
			
			// resets the score text
			s1.setText(p1Score + "");
			s2.setText(p2Score + "");
			
			// calls the reset method to make all objects in start position
			reset();
			
			// repaints the score text, and all objects
			repaint();
			
			// make win screen invisible
			w1.setVisible(false);
			
			// hide the buttons
			btnRestart.setVisible(false);
			btnLobby.setVisible(false);
			
			// delay before starting the game
			movement.setInitialDelay(2000);
			movement.start();
			
		}
		
		// if user wants to go back to main menu
		if (e.getSource() == btnLobby) {
			new Menu(); // show menu
			this.dispose(); // disposes current frame
		}
		
		// if timer is running
		if (e.getSource() == movement) {

			// creates rectangles (hitboxes) around the paddles, and ball 
			r1 = new Rectangle(0, paddle1.getYPos(), paddle1.getImgWidth(), paddle1.getImgHeight());
			r2 = new Rectangle(865, paddle2.getYPos(), paddle2.getImgWidth(), paddle2.getImgHeight());
			r3 = new Rectangle(ball.getXPos(), ball.getYPos(), ball.getImgWidth(), ball.getImgHeight());
			
			// checks for collision for paddles, makes sure that paddles stay on the screen
			if (paddle1.getYPos() <= 0) {
				paddle1.setYPos(0);
			}
			
			// checks for collision for paddles, makes sure that paddles stay on the screen
			if (paddle1.getYPos() >= 510 - (paddle1.getImgHeight())) {
				paddle1.setYPos(510 - (paddle1.getImgHeight()));
			}
			
			// checks for collision for paddles, makes sure that paddles stay on the screen
			if (paddle2.getYPos() <= 0) {
				paddle2.setYPos(0);
			}
			
			// checks for collision for paddles, makes sure that paddles stay on the screen
			if (paddle2.getYPos() >= 510 - (paddle1.getImgHeight())) {
				paddle2.setYPos(510 - (paddle1.getImgHeight()));
			}
			
			// moves paddles up and down
			paddle1.setYPos(paddle1.getYPos() + paddle1.getyVel());
			paddle2.setYPos(paddle2.getYPos() + paddle2.getyVel());
			
			// moves the ball in its designated path
			ball.setXPos(ball.getXPos() + ball.getxVel());
			ball.setYPos(ball.getYPos() + ball.getyVel());
			
			// if the rectangles collide with each other (paddles collides with ball)
			if (r3.intersects(r1)) {
				ball.setxVel(ball.getxVel()*-1);
				ball.setXPos(20); // change x position so the ball does not glitch
				ball.setxVel(ball.getxVel()+1); // makes the ball faster with each hit

			}
			
			// if the rectangles collide with each other (paddles collides with ball)
			if (r3.intersects(r2)) {
				ball.setxVel(ball.getxVel()*-1);
				ball.setXPos(835); // change x position so the ball does not glitch
				ball.setxVel(ball.getxVel()-1); // makes the ball faster with each hit
			}

			// changes the balls velocity if it collides with the roof/floor
			if (ball.getYPos() <= 0 || ball.getYPos() >= 480) {
				ball.setyVel(ball.getyVel()*-1);
			}
			
			// if ball hits behind the paddle
			if (ball.getXPos() <= 0) {
				p2Score++; // increases score
				s2.setText(p2Score + ""); // changes the text
				reset(); // resets the objects
				movement.stop(); // stops the timer
				movement.setInitialDelay(1000); // sets initial delay after each round
				movement.start(); // starts the timer
			}
			
			// if ball hits behind the paddle
			else if (ball.getXPos() >= 855) {
				p1Score++; // increases score
				s1.setText(p1Score + ""); // changes the text
				reset(); // resets the objects
				movement.stop(); // stops the timer
				movement.setInitialDelay(1000); // sets initial delay after each round
				movement.start(); // starts the timer
			}
			
			// if either of the players win
			if (p1Score == rounds || p2Score == rounds) {
				movement.stop();
				
				// if player one wins
				if (p1Score == rounds) {
					w1.setText("Red Wins!");
				}
				else { // if player two wins
					w1.setText("Blue Wins!");
				}
				w1.setVisible(true); // show the winning message
				btnRestart.setVisible(true); // show the button for restarting
				btnLobby.setVisible(true); // show the button for lobby
			}

			repaint(); // repaint all the objects and JLabels
		}
	}

	/**
	 * Main method for testing
	 */
	public static void main(String[] args) {
		new PongGame(0); // runs the game at easy difficulty

	}
}
