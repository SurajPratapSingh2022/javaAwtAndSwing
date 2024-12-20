package com.application;
//Display Student Record
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class StudentRec extends JFrame {
    JFrame f;
    JButton btnview;
    JTable t;

    StudentRec() {
        f = new JFrame("View Student");
        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);

        btnview = new JButton("View All Record");
        btnview.setBounds(80, 20, 200, 20);
        f.add(btnview);

        btnview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    rs = stmt.executeQuery("SELECT sid, name, rollno, gender, sem, fee FROM student");

                    // Get the number of rows and columns
                    rs.last();  // Moves the cursor to the last row
                    int rowCount = rs.getRow();
                    rs.beforeFirst();  // Move the cursor back to the beginning
                    int columnCount = rs.getMetaData().getColumnCount();
                    String[][] data = new String[rowCount][columnCount];

                    // Populate the data array with results from the ResultSet
                    int row = 0;
                    while (rs.next()) {
                        for (int col = 0; col < columnCount; col++) {
                            data[row][col] = rs.getString(col + 1);
                        }
                        row++;
                    }
                    String[] columns = {"sid", "name", "rollno", "gender", "sem", "fee"};
                    t = new JTable(data, columns);
                    
                    // Create a JScrollPane for the JTable and add it to the frame
                    JScrollPane scrollPane = new JScrollPane(t);
                    scrollPane.setBounds(30, 70, 520, 250);
                    f.add(scrollPane);

                    JOptionPane.showMessageDialog(null, "Record displayed successfully");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
                    }
                }
            }
        });
    }
}
public class DisplayStudentRecord {
    public static void main(String[] args) {
        new StudentRec();
    }
}