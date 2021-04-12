package artifact;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Register implements ActionListener {
	public JFrame registerFrame;
	public JTextField username;
	public JTextField password;
	public JTextField email;
	public JLabel usernameLabel;
	public JLabel passwordLabel;
	public JLabel emailLabel;
	public JButton register;
	ArrayList<String> list= new ArrayList<String>();
	
	public Register() {
		registerFrame = new JFrame("Register");
		
		registerFrame.setLayout(null);
		registerFrame.setSize(300, 230);
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.getContentPane().setBackground(Color.decode("#019FD7"));
		
		usernameLabel = new JLabel("Input username");
		usernameLabel.setForeground(Color.decode("#EEF9FC"));
		usernameLabel.setBounds(100, 5, 100, 20);
		username = new JTextField(20);
		username.setBounds(30, 30, 225, 20);
		
		passwordLabel = new JLabel("Input password");
		passwordLabel.setForeground(Color.decode("#EEF9FC"));
		passwordLabel.setBounds(100, 50, 100, 20);
		password = new JTextField(20);
		password.setBounds(30, 70, 225, 20);
		
		emailLabel = new JLabel("Input your email");
		emailLabel.setForeground(Color.decode("#EEF9FC"));
		emailLabel.setBounds(100, 90, 100, 20);
		email = new JTextField(20);
		email.setBounds(30, 110, 225, 20);
		
		register = new JButton("Register");
		register.setBackground(Color.decode("#FCC230"));
		register.setBounds(100, 140, 100, 25);
		register.addActionListener(this);
			
		registerFrame.add(emailLabel);
		registerFrame.add(email);
		registerFrame.add(usernameLabel);
		registerFrame.add(username);
		registerFrame.add(passwordLabel);
		registerFrame.add(password);
		registerFrame.add(register);
		
		registerFrame.setVisible(true);
		registerFrame.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		String dataBaseURL = "jdbc:postgresql://localhost:5432/login-app";
		String dbUser = new String("postgres");
		String dbPassword = "trumpet";

		
		if (event.getActionCommand().equals("Register")) {
			if ((username.getText().length() <= 20 && username.getText().length() >= 4) && (email.getText().length() <= 80 && email.getText().length() >= 15) && (password.getText().length() <= 30 && password.getText().length() >= 5 )) {
				try {
					Connection connection = DriverManager.getConnection(dataBaseURL, dbUser, dbPassword);
					System.out.println("Connected to database");

					String addCommand = "INSERT INTO users (username, email, password)" + " VALUES (?, ?, ?)";
					PreparedStatement statement = connection.prepareStatement(addCommand);

					statement.setString(1, username.getText());
					statement.setString(2, email.getText());
					statement.setString(3, password.getText());

					statement.executeUpdate();
					registerFrame.dispose();

				} catch (SQLException exc) {
					System.out.println("Error with SQL");
					exc.printStackTrace();
				} 
			} else {
				if (username.getText().length() > 21 || username.getText().length() < 4) {
					JOptionPane.showMessageDialog(registerFrame, "Error: Username's length must be between 4 and 20 symbols(inclusive)");
				}
				if (email.getText().length() > 80 || email.getText().length() < 15) {
					JOptionPane.showMessageDialog(registerFrame, "Error: Email's length must be between 15 and 80 symbols(inclusive)");
				}
				if (password.getText().length() > 30 || password.getText().length() < 5) {
					JOptionPane.showMessageDialog(registerFrame, "Error: Password's length must be between 5 and 30 symbols(inclusive)");
				}
			}
		} 
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Register();
			}
		});
	}

}
