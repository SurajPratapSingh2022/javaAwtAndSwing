package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class UpdateRecord extends JFrame{
	JFrame f1;
	JLabel name,rollno,gender,semester,fee,searchid;
	JTextField tname,troll,tsem,ffee,tscrch,tgender;
	JButton btnsearch,btnupdate;
	UpdateRecord(){
		f1=new JFrame("Update Record");
		f1.setSize(600,400);
		f1.setLayout(null);
		f1.setVisible(true);
		
		searchid=new JLabel("SearchId");
		searchid.setBounds(20,0,100,20);
		f1.add(searchid);
		
		tscrch=new JTextField(10);
		tscrch.setBounds(100,0,70,20);
		f1.add(tscrch);
		
		btnsearch=new JButton("Search");
		btnsearch.setBounds(180,0,80,20);
		f1.add(btnsearch);

		btnsearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int sid = Integer.parseInt(tscrch.getText());
		        String n, g, s;
		        int r;
		        double f;
		        Connection con = null; 
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");
		            Statement stmt;
		            ResultSet rs; 
		            stmt = con.createStatement();
		            rs = stmt.executeQuery("select * from student where sid='" + sid + "' ");
		            if (rs.next()) {
		                JOptionPane.showMessageDialog(null, "Record Found");
		                n = rs.getString("name");
		                g = rs.getString("gender");
		                s = rs.getString("sem");
		                r = rs.getInt("rollno");
		                f = rs.getDouble("fee");
		                tname.setText(n);
		                tgender.setText(g);
		                troll.setText(String.valueOf(r));
		                tsem.setText(s);
		                ffee.setText(String.valueOf(f)); 
		            } else {
		                JOptionPane.showMessageDialog(null, "Record of Student Not Found");
		                tscrch.setText("");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.toString());
		        } finally {
		            try {
		                if (con != null) {
		                    con.close();
		                }
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
		            }
		        }
		    }
		});
		
		name=new JLabel("Name");
		name.setBounds(20,20,100,20);
		f1.add(name);
		
		tname=new JTextField(20);
		tname.setBounds(100,20,150,20);
		f1.add(tname);
		
		rollno=new JLabel("Roll No");
		rollno.setBounds(20,50,100,20);
		f1.add(rollno);
		
		troll=new JTextField(10);
		troll.setBounds(100,50,150,20);
		f1.add(troll);
		
		gender=new JLabel("Gender");
		gender.setBounds(20,80,100,20);
		f1.add(gender);
		
		
		tgender=new JTextField(10);
		tgender.setBounds(100,80,100,20);
		f1.add(tgender);
		
		semester=new JLabel("Semester");
		semester.setBounds(20,110,100,20);
		f1.add(semester);
		
		tsem=new JTextField(10);
		tsem.setBounds(100,110,150,20);
		f1.add(tsem);
		
		fee=new JLabel("Fee");
		fee.setBounds(20,140,100,20);
		f1.add(fee);
		
		ffee=new JTextField(10);
		ffee.setBounds(100,140,150,20);
		f1.add(ffee);
		
		btnupdate=new JButton("Update");
		btnupdate.setBounds(80,170,80,20);
		f1.add(btnupdate);
		
		btnupdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String n, g, s;
		        int r, sid;
		        double f;
		        Connection con = null; 
		        try {
		            sid = Integer.parseInt(tscrch.getText());
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");
		            Statement stmt = con.createStatement();
		            n = tname.getText();
		            g = tgender.getText();
		            s = tsem.getText();
		            r = Integer.parseInt(troll.getText());
		            f = Double.parseDouble(ffee.getText());
		            stmt.execute("update student set name='" + n + "', rollno=" + r + ", sem='" + s + "', gender='" + g + "', fee=" + f + " where sid=" + sid);
		            JOptionPane.showMessageDialog(null, "Record updated successfully");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.toString());
		        } finally {
		            try {
		                if (con != null) {
		                    con.close();
		                }
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.toString());
		            }
		        }
		    }
		});

	}
}
public class StudentRecordUpdate{
	public static void main(String[] args) {
		new UpdateRecord();
	}
}