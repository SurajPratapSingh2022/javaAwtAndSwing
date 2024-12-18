package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class StudentRecord extends JFrame{
	JFrame f1;
	JLabel name,rollno,gender,semester,fee;
	JTextField tname,troll,tsem,ffee;
	JRadioButton r1,r2;
	ButtonGroup buttongroup;
	JButton btnsave;
	StudentRecord(){
		f1=new JFrame("Student Record");
		f1.setSize(600,400);
		f1.setLayout(null);
		f1.setVisible(true);
		
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
		
		r1=new JRadioButton("male");
		r1.setBounds(100,80,80,20);
		f1.add(r1);
		
		r2=new JRadioButton("female");
		r2.setBounds(180,80,80,20);
		f1.add(r2);
		
		buttongroup=new ButtonGroup();
		buttongroup.add(r1);
		buttongroup.add(r2);
		
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
		
		btnsave=new JButton("Save");
		btnsave.setBounds(50,170,100,20);
		f1.add(btnsave);
		
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n,gender,sem;
				int roll;
				double fee;
				gender="";
				if(r1.isSelected()==true) {
					gender=r1.getText();
				}
				else if(r2.isSelected()==true) {
					gender=r2.getText();
				}
				n=tname.getText();
				sem=tsem.getText();
				roll=Integer.parseInt(troll.getText());
				fee=Double.parseDouble(ffee.getText());
				try {
				    Connection con;
				    Statement stmt;
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");
				    stmt = con.createStatement();
				    stmt.execute("insert into student(name, rollno, gender, sem, fee) values('" + n + "', " + roll + ", '" + gender + "', '" + sem + "', " + fee + ")");
				    JOptionPane.showMessageDialog(null, "Save student details successfully");
				    tname.setText("");
				    troll.setText("");
				    tsem.setText("");
				    ffee.setText("");
				} catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, ex.toString());
				}

			}
		});
	}
}
public class StudentRecordDbCnt{
	public static void main(String[] args) {
		new StudentRecord();
	}
}