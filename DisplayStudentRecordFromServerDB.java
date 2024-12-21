package com.application;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Myapp {
	JFrame f1;
	JTable t1;
	JButton b1;

	Myapp() {
		f1 = new JFrame();
		f1.setSize(600, 400);
		f1.setLayout(null);
		f1.setTitle("JDBC Example With JTable");
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1 = new JButton("View All Student");
		b1.setBounds(20, 20, 200, 30);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[][] data = new String[10][6];
				String[] columns = { "S.ID", "NAME", "GENDER", "ROLL", "SEM", "FEE" };
				final String URL = "jdbc:mysql://srv1332.hstgr.io:3306/u398667489_college";
				final String USER = "u398667489_college";
				final String PASS = "ashish00@K";
				try {
					Connection con;
					Statement stm;
					ResultSet rs;
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(URL, USER, PASS);
					stm = con.createStatement();
					rs = stm.executeQuery("SELECT * FROM STUDENT");
					
					int rowCount = 0;
					while (rowCount < 10) {
						rs.next();
						String sid = rs.getString("SID");
						String name = rs.getString("NAME");
						String gender = rs.getString("GENDER");
						String roll = rs.getString("ROLL");
						String sem = rs.getString("SEM");
						String fee = rs.getString("FEE");
						System.out.println("SID: " + sid + ", NAME: " + name + ", GENDER: " + gender + ", ROLL: " + roll
								+ ", SEM: " + sem + ", FEE: " + fee);
						data[rowCount] = new String[] { sid, name, gender, roll, sem, fee };
						rowCount++;
					}
					t1 = new JTable(data, columns);
					
					JScrollPane sp = new JScrollPane(t1);
					sp.setBounds(20, 70, 550, 250);
					f1.add(sp);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		f1.add(b1);
	}
}

class DisplayStudentRecordFromServerDB {
	public static void main(String[] args) {
		try {
// Try loading the MySQL JDBC driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySQL JDBC Driver is installed and available.");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver is not installed or not available in the classpath.");
		}
		new Myapp();
	}
}
