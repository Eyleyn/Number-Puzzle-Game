/**Submitted By: ELLAINE B. BAÑES
*  CMSC 22 - Section 1 
*  Final Project - Number Puzzle
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import Game_Puzzle.StartGame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Welcome message for the user and to engage him/her to play
 */
public class WelcomeMessage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeMessage window = new WelcomeMessage();
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
	public WelcomeMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 196));
		frame.setBounds(200, 200, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 70, 434, 222);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("This number puzzle game was created to enhance your brain. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 414, 26);
		panel.add(lblNewLabel);
		
		JLabel lblItCanBe = new JLabel("It can be played by all ages for fun and learning. You are expected  ");
		lblItCanBe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItCanBe.setBounds(10, 41, 435, 26);
		panel.add(lblItCanBe);
		
		JLabel lblTo = new JLabel("to assign the number tiles in order (1-15) in order to solve the");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(10, 68, 435, 26);
		panel.add(lblTo);
		
		JLabel lblPuzzleACheckmark = new JLabel("puzzle. A checkmark will show if you are done. Have fun!");
		lblPuzzleACheckmark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuzzleACheckmark.setBounds(10, 96, 435, 26);
		panel.add(lblPuzzleACheckmark);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(199, 21, 133), 3));
		separator_1.setBackground(new Color(199, 21, 133));
		separator_1.setBounds(10, 54, 454, 2);
		frame.getContentPane().add(separator_1);
		
		
		JLabel lblUserName = new JLabel("Hi User!");
		lblUserName.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lblUserName.setForeground(new Color(160, 82, 45));
		lblUserName.setBounds(20, 27, 464, 32);
		frame.getContentPane().add(lblUserName);
		
		JButton bttnOkay = new JButton("OKAY");
		bttnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartGame.main(null);
				frame.dispose();
			}
		});
		bttnOkay.setForeground(new Color(219, 112, 147));
		bttnOkay.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		bttnOkay.setBounds(375, 303, 89, 23);
		frame.getContentPane().add(bttnOkay);
		
		JButton bttnCancel = new JButton("CANCEL");
		bttnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeLogIn.main(null);
				frame.dispose();
			}
		});
		bttnCancel.setForeground(new Color(219, 112, 147));
		bttnCancel.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		bttnCancel.setBounds(264, 303, 101, 23);
		frame.getContentPane().add(bttnCancel);
	}
}
