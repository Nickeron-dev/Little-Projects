package artifact;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class App implements ActionListener {
	public JFrame loginFrame;
	public JTextField username;
	public JTextField password;
	public JLabel usernameLabel;
	public JLabel passwordLabel;
	public JButton login;
	public JButton registerAdvice;
	
	public App() {
		loginFrame = new JFrame("Login");
		
		loginFrame.setLayout(new FlowLayout());
		loginFrame.setSize(300, 200);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login = new JButton("  Login  ");
		login.addActionListener(this);
		registerAdvice = new JButton("Register");
		registerAdvice.addActionListener(this);
		
		username = new JTextField(20);
		password = new JTextField(20);
		
		usernameLabel = new JLabel("Input username");
		passwordLabel = new JLabel("Input password");
		
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
	
	public void actionPerformed(ActionEvent event) {
		String dataBaseURL = "jdbc:postgresql://localhost:5432/login-app";
		String dbUser = new String("postgres");
		String dbPassword = "trumpet";
		
		if (event.getActionCommand().equals("  Login  ")) {
			//if (username.getText().equals())
			try {
				Connection connection = DriverManager.getConnection(dataBaseURL, dbUser, dbPassword);
				System.out.println("Connected to database");
				
			} catch (SQLException exc) {
				System.out.println("Error with SQL");
			}
		}
		
		if (event.getActionCommand().equals("Register")) {
			//if (username.getText().equals())
			
			Register reg = new Register();
			
			/*
			JFrame registerFrame = new JFrame("Register");
			
			registerFrame.setLayout(new FlowLayout());
			registerFrame.setSize(300, 230);
			registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registerFrame.setVisible(true);
			registerFrame.setResizable(false);
			
			JTextField usernameRegisterField = new JTextField(20);
			JTextField passwordRegisterField = new JTextField(20);
			JTextField emailRegisterField = new JTextField(20);
			JLabel usernameRegisterLabel = new JLabel("Input username");
			JLabel passwordRegisterLabel = new JLabel("Input password");
			JLabel emailRegisterLabel = new JLabel("Input email    ");
			JButton register = new JButton("Register");
			register.addActionListener(this);
			
			registerFrame.add(usernameRegisterLabel);
			registerFrame.add(usernameRegisterField);
			registerFrame.add(passwordRegisterLabel);
			registerFrame.add(passwordRegisterField);
			registerFrame.add(emailRegisterLabel);
			registerFrame.add(emailRegisterField);
			registerFrame.add(register);
			*/
			try {
				Connection connection = DriverManager.getConnection(dataBaseURL, dbUser, dbPassword);
				System.out.println("Connected to database");
				
				String command = "INSERT INTO users " + 
						"VALUES (?, ?, ?)";
				
			} catch (SQLException exc) {
				System.out.println("Error with SQL");
				exc.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App();
			}
		});
	}
	
}
