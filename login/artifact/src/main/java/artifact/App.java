package artifact;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class App {
	public JFrame loginFrame;
	public JTextField username;
	public JTextField email;
	public JTextField password;
	public JLabel usernameLabel;
	public JLabel emailLabel;
	public JLabel passwordLabel;
	public JButton login;
	public JButton registerAdvice;
	
	public App() {
		loginFrame = new JFrame("Login");
		
		loginFrame.setLayout(new FlowLayout());
		loginFrame.setSize(300, 200);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login = new JButton("  Login  ");
		registerAdvice = new JButton("Register");
		
		username = new JTextField(20);
		email = new JTextField(20);
		password = new JTextField(20);
		
		usernameLabel = new JLabel("Input username");
		passwordLabel = new JLabel("Input password");
		emailLabel = new JLabel("Input email");
		
		//registerAdvice = new JLabel("New to us? ");
		
		loginFrame.add(usernameLabel);
		loginFrame.add(username);
		loginFrame.add(passwordLabel);
		loginFrame.add(password);
		loginFrame.add(login);
		loginFrame.add(registerAdvice);
		
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App();
			}
		});
	}
	
}
