package artifact;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Information {
	public JFrame frame;
	public JTextArea text;
	
	public Information() {
		frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		frame.setSize(300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setResizable(false); // might will be changed
		
		String dbURL = "jdbc:postgresql://localhost:5432/login-app";
		String user = "postgres";
		String password = "trumpet";
		
		
		try {
			Connection connect = DriverManager.getConnection(dbURL, user, password);
			System.out.println("Information connected to sql db");
		} catch (SQLException e) {
			System.out.println("Error in Connecting to database");
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Information();
			}
		});
	}

}
