package artifact;

import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Information {
	public JFrame frame;
	public JTextArea text;
	public JTable outputDB;
	public JScrollPane scroll;
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	
	public Information() {
		frame = new JFrame("Database");
		
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.decode("#019FD7"));

		String dbURL = "jdbc:postgresql://localhost:5432/login-app";
		String user = "postgres";
		String password = "trumpet";
		
		try {
			Connection connect = DriverManager.getConnection(dbURL, user, password);
			
			String selectCommand = "SELECT * FROM users";
			Statement selectAll = connect.createStatement();
			ResultSet dbReturn = selectAll.executeQuery(selectCommand);
			
			while (dbReturn.next()) {
				int index = dbReturn.getInt("id");
				String dbUsername = dbReturn.getString("username");
				String dbEmail = dbReturn.getString("email"); 
				String dbPassword = dbReturn.getString("password");
				
				data.add(new ArrayList<String>());
				data.get(index - 1).add(Integer.toString(index)); 
				data.get(index - 1).add(dbUsername);
				data.get(index - 1).add(dbEmail);
				data.get(index - 1).add(dbPassword);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error in Connecting to database");
			e.printStackTrace();
		}
		
		String[] columns = {"id", "username", "email", "password"};
		String[][] dataArray = new String[data.size()][4];
		for (int k = 0; k < dataArray.length; k++) {
			for (int i = 0; i < dataArray[k].length; i++) {
				dataArray[k][i] = data.get(k).get(i); // moving from ArrayList to String[][]
			}
		}
		outputDB = new JTable(dataArray, columns);
		outputDB.setBackground(Color.decode("#FCC230"));
		outputDB.getColumnModel().getColumn(0).setPreferredWidth(5);
		outputDB.getColumnModel().getColumn(1).setPreferredWidth(70);
		outputDB.getColumnModel().getColumn(2).setPreferredWidth(100);
		outputDB.getColumnModel().getColumn(3).setPreferredWidth(50);
		scroll = new JScrollPane(outputDB, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		frame.add(scroll);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Information();
			}
		});
	}

}
