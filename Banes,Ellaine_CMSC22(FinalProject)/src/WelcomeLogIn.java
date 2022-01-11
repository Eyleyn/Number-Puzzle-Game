/**Submitted By: ELLAINE B. BAÑES
*  CMSC 22 - Section 1 
*  Final Project - Number Puzzle
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

//import UserPermission.UserInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** This is the Welcome Log In frame which requires
*   the user to input his/her desire user name and password (it can be any)
*/
@SuppressWarnings("serial")
public class WelcomeLogIn extends JFrame {

	public JPanel WelcomeFrame;
	public JTextField Username_txt;
	
	//Import Image
	public Image img_background = new ImageIcon(WelcomeLogIn.class.getResource("resources/background.jpg")).getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
	
	public JPasswordField Password_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeLogIn frame = new WelcomeLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeLogIn() {
		setUndecorated(true);
		setType(Type.POPUP);
		setTitle("Number Puzzle Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 400);
		WelcomeFrame = new JPanel();
		WelcomeFrame.setBackground(new Color(255, 255, 255));
		WelcomeFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(WelcomeFrame);
		setLocationRelativeTo(null);
		WelcomeFrame.setLayout(null);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 206, 209));
		panel1.setBorder(new LineBorder(new Color(240, 248, 255), 3, true));
		panel1.setBounds(60, 82, 364, 200);
		WelcomeFrame.add(panel1);
		panel1.setLayout(null);
		
		/** This gets the user name of the user and use the 
		 * 	Focus event to be easy for the user to clear and input in the textfield
		 */
		Username_txt = new JTextField();
		Username_txt.setText("Username");
		Username_txt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Username_txt.getText().equals("Username"))
				{
					Username_txt.setText("");
				}
				else
				{
					Username_txt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (Username_txt.getText().equals(""))
				{
					Username_txt.setText("Username");
				}
			}
		});
		Username_txt.setBackground(new Color(222, 184, 135));
		Username_txt.setSelectedTextColor(new Color(238, 232, 170));
		Username_txt.setBorder(new LineBorder(new Color(184, 134, 11), 2));
		Username_txt.setForeground(new Color(0, 0, 0));
		Username_txt.setToolTipText("Enter Username");
		Username_txt.setFont(new Font("Verdana", Font.PLAIN, 12));
		Username_txt.setBounds(62, 90, 224, 35);
		panel1.add(Username_txt);
		Username_txt.setColumns(10);
		Username_txt.setOpaque(false);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(253, 245, 230));
		separator.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(255, 255, 255)));
		separator.setBounds(10, 58, 338, 2);
		panel1.add(separator);
		
		JLabel Welcome_lbl = new JLabel("Welcome");
		Welcome_lbl.setBounds(99, 11, 181, 52);
		panel1.add(Welcome_lbl);
		Welcome_lbl.setFont(new Font("Arial Black", Font.PLAIN, 34));
		Welcome_lbl.setForeground(new Color(248, 248, 255));
		
		/** This gets the password of the user and use the 
		 * 	Focus event to be easy for the user to clear and input in the textfield
		 */
		Password_txt = new JPasswordField();
		Password_txt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (Password_txt.getText().equals("Password"))
				{
					Password_txt.setEchoChar('•');
					Password_txt.setText("");
				}
				else
				{
					Password_txt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (Password_txt.getText().equals(""))
				{
					Password_txt.setText("Password");
					Password_txt.setEchoChar((char)0);
					
				}
			}
		});
		Password_txt.setFont(new Font("Verdana", Font.PLAIN, 12));
		Password_txt.setEchoChar((char)0);
		Password_txt.setForeground(new Color(0, 0, 0));
		Password_txt.setBorder(new LineBorder(new Color(184, 134, 11), 2));
		Password_txt.setOpaque(false);
		Password_txt.setToolTipText("Enter Password");
		Password_txt.setText("Password");
		Password_txt.setBounds(62, 136, 224, 35);
		panel1.add(Password_txt);
		
		/** This code gives changes on the color 
		 *  of the Sign in button when it is clicked.
		 */
		JButton SignIn_bttn = new JButton("Sign In");
		SignIn_bttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SignIn_bttn.setBackground(new Color(60, 104, 100));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SignIn_bttn.setBackground(new Color(255, 204, 153));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				SignIn_bttn.setBackground(new Color(200, 250, 200));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				SignIn_bttn.setBackground(new Color(200, 104, 100));
			}
		});
		SignIn_bttn.setBounds(120, 293, 248, 35);
		WelcomeFrame.add(SignIn_bttn);
		SignIn_bttn.setBackground(new Color(0, 206, 209));
		SignIn_bttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Password_txt.setText(null);
				Username_txt.setText(null);
				
				WelcomeMessage.main(null);
				WelcomeLogIn.this.dispose();
			}
		});
		SignIn_bttn.setBorder(new LineBorder(new Color(95, 158, 160), 2));
		SignIn_bttn.setForeground(new Color(0, 206, 209));
		SignIn_bttn.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JLabel Back_label = new JLabel("X");
		Back_label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		Back_label.setHorizontalAlignment(SwingConstants.CENTER);
		Back_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close this program?", "Exit", JOptionPane.YES_NO_OPTION)== 0)
				{
					WelcomeLogIn.this.dispose();
				}
			}
		});
		Back_label.setBounds(466, -11, 45, 48);
		WelcomeFrame.add(Back_label);
		
		//This holds the background image of the frame
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setBounds(-21, -26, 521, 426);
		lblBackground.setIcon(new ImageIcon(img_background));
		WelcomeFrame.add(lblBackground);
		
	}
}
