package artifact;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	public boolean isLogged = false;
	public JLabel welcomeLabel;
	public JLabel loginToUse;
	public JLabel newToUs;
	
	public App() {
		loginFrame = new JFrame("Login");
		
		loginFrame.setLayout(null);
		loginFrame.setSize(300, 265);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setBackground(Color.decode("#019FD7"));
		
		welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setBounds(10, 5, 180, 20);
		welcomeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));
		welcomeLabel.setForeground(Color.decode("#EEF9FC"));
		
		loginToUse = new JLabel("Login to get started!");
		loginToUse.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		loginToUse.setForeground(Color.decode("#EEF9FC"));
		loginToUse.setBounds(10, 25, 150, 20);
		
		usernameLabel = new JLabel("Input username");
		usernameLabel.setBounds(100, 45, 100, 30);
		usernameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		usernameLabel.setForeground(Color.decode("#EEF9FC"));
		passwordLabel = new JLabel("Input password");
		
		username = new JTextField(20);
		username.setBounds(30, 70, 230, 25);
		username.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		passwordLabel.setBounds(100, 90, 100, 30);
		passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		passwordLabel.setForeground(Color.decode("#EEF9FC"));
		
		password = new JTextField(30);
		password.setBounds(30, 115, 230, 25);
		password.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		
		login = new JButton("  Log in  ");
		login.setBounds(95, 150, 100, 30);
		login.setBackground(Color.decode("#FCC230"));
		login.addActionListener(this);
		
		newToUs = new JLabel("New to us?");
		newToUs.setBounds(120, 200, 80, 20);
		newToUs.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		newToUs.setForeground(Color.decode("#EEF9FC"));
		
		registerAdvice = new JButton("Register");
		registerAdvice.addActionListener(this);
		registerAdvice.setBounds(200, 200, 80, 20);
		registerAdvice.setBackground(Color.decode("#FCC230"));
		registerAdvice.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		
		loginFrame.add(welcomeLabel);
		loginFrame.add(loginToUse);
		loginFrame.add(usernameLabel);
		loginFrame.add(username);
		loginFrame.add(passwordLabel);
		loginFrame.add(password);
		loginFrame.add(login);
		loginFrame.add(newToUs);
		loginFrame.add(registerAdvice);
		
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		String dataBaseURL = "jdbc:postgresql://localhost:5432/login-app";
		String dbUser = new String("postgres");
		String dbPassword = "trumpet";
		
		if (event.getActionCommand().equals("  Log in  ")) {
			try {
				Connection connection = DriverManager.getConnection(dataBaseURL, dbUser, dbPassword);
				System.out.println("Connected to database");
				
				String command = "SELECT username, password FROM users";
				
				Statement selection = connection.createStatement();
				ResultSet result = selection.executeQuery(command);
				
				while (result.next()) {
					if (username.getText().equals(result.getString("username")) 
							&& password.getText().equals(result.getString("password"))) {
						isLogged = true;
						continue;
					}
				}
				if (isLogged) {
					new Information();
				} else JOptionPane.showMessageDialog(loginFrame, "Something went wrong:(");
			} catch (SQLException exc) {
				System.out.println("Error with SQL");
			}
		}
		
		if (event.getActionCommand().equals("Register")) {
			 new Register();
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
