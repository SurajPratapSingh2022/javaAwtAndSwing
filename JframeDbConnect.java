package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JframeDbConnect extends JFrame {
    JFrame f1;
    JButton b1;

    JframeDbConnect() {
        f1 = new JFrame("JDBC Connection");
        f1.setSize(400, 400);
        f1.setLayout(null);
        f1.setVisible(true);

        b1 = new JButton("Connect");
        b1.setBounds(20, 100, 100, 30);
        f1.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection con = null; // Declare outside try block
                try {
                    // Load MySQL JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish connection
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");

                    // Check if connection is not null
                    if (con != null) {
                        JOptionPane.showMessageDialog(null, "Database Connection Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Database Not Connected, Retry!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                } finally {
                    // Close the connection if it is not null
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new JframeDbConnect();
    }
}
