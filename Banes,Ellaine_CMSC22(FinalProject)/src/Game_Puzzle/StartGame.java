/**Submitted By: ELLAINE B. BAÑES
*  CMSC 22 - Section 1 
*  Final Project - Number Puzzle
*/
package Game_Puzzle;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.sound.sampled.*;

/**
*  Creates the Start button for the game.
*/
public class StartGame {

	private JFrame frame;
	public Image img_logo = new ImageIcon(StartGame.class.getResource("Title.png")).getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGame window = new StartGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();												//creates frame
		frame.getContentPane().setBackground(new Color(221, 160, 221));		//set the background color of the frame
		frame.setBackground(Color.WHITE);									//set the background color of the frame
		frame.setBounds(100, 100, 650, 500);								//set the size of the frame
		frame.setLocationRelativeTo(null);									//display the window to the center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//buttons above the frame
		frame.getContentPane().setLayout(null);								//sets the layout to null to pack the components inside
		
		try {
			music();														//plays background music
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel = new JPanel();										//creates panel
		panel.setBackground(new Color(255, 240, 245));									//set the background color
		panel.setBounds(10, 11, 614, 439);									//size of the panel
		frame.getContentPane().add(panel);									//adds the panel to the frame
		panel.setLayout(null);												//sets the layout to null to pack the components inside
		
		JPanel panel_1 = new JPanel();										//creates panel of the button
		panel_1.setBackground(new Color(255, 182, 193));						//set the background color
		panel_1.setBounds(167, 268, 290, 75);								//size of the panel
		panel.add(panel_1);													//adds the panel to the frame
		panel_1.setLayout(null);											//sets the layout to null to pack the components inside
		
		JButton bttnStart = new JButton("START");							//creates Start button 
		bttnStart.setBackground(new Color(199, 21, 133));					//background color of the button
		bttnStart.addMouseListener(new MouseAdapter() 						//adds event to the button
		{
			/**
			 * Event executed when button was clicked
			 */
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Puzzle.main(null);											//calls the next page of the program (Instruction.java)
				
				frame.dispose();											//close this frame and open the second window
			}
		});
		bttnStart.setOpaque(false);											//set the opacity to 0
		bttnStart.setForeground(new Color(148, 0, 211));								//color of the text used
		bttnStart.setFont(new Font("Cooper Black", Font.BOLD, 18));			//font and font size used
		bttnStart.setBounds(10, 11, 270, 53);								//size of the button
		panel_1.add(bttnStart);												//add the button to the panel
		
		JLabel lblTitle = new JLabel();										//holds the image of the Title
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);				//center the text
		lblTitle.setBounds(10, 40, 594, 321);								//size of the label
		lblTitle.setIcon(new ImageIcon(img_logo));							//display the imported image
		panel.add(lblTitle);
	}
	
	/**
	 * Plays background music at the beginning of the game
	 */
	public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		File file = new File("PuzzleSong.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		
		clip.open(audioStream);
		
		clip.start();
	}
}
