package artifact;

import java.awt.FlowLayout;
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
				
				String command = "SELECT username, password FROM users";
				
				Statement selection = connection.createStatement();
				ResultSet result = selection.executeQuery(command);
				
				while (result.next()) {
					if (username.getText().equals(result.getString("username")) 
							&& password.getText().equals(result.getString("password"))) {
						System.out.println("Im here");
						isLogged = true;
						continue;
					}
				}
				if (isLogged) {
					Information info = new Information();
				} else JOptionPane.showMessageDialog(loginFrame, "Something went wrong:(");
			} catch (SQLException exc) {
				System.out.println("Error with SQL");
			}
		}
		
		if (event.getActionCommand().equals("Register")) {
			Register reg = new Register();
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
