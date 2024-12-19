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

class StudentRecord1 extends JFrame{
	JFrame f1;
	JLabel name,rollno,gender,semester,fee,ssid,searchid;
	JTextField tname,troll,tsem,ffee,tscrch,tgender,tsrch;
	JRadioButton r1,r2;
	ButtonGroup buttongroup;
	JButton btnsave,btndelete,btnsearch,btnupdate;
	StudentRecord1(){
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
				    stmt.execute("insert into student(name, rollno, gender, sem, fee) values('" +n+ "', " +roll+ ", '" +gender+ "', '" +sem+ "', " +fee+ ")");//use single cot for string enclosed
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
		
		//for searching student using textfield & then delete it by using a button from student record on the basis of student id 
		ssid=new JLabel("Enter Student id");
		ssid.setBounds(20,200,100,20);
		f1.add(ssid);
		
		tscrch=new JTextField(10);
		tscrch.setBounds(20,220,100,20);
		f1.add(tscrch);
		
		btndelete=new JButton("Delete");
		btndelete.setBounds(150,220,100,20);
		f1.add(btndelete);
		
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sid=Integer.parseInt(tscrch.getText());
				Connection con = null; 
				try {
				    Statement stmt;
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spsdb", "root", "system");
				    stmt = con.createStatement();
				    stmt.execute("delete from student where sid='"+sid+"' ");
				    JOptionPane.showMessageDialog(null, "Delete Record Successfully");
				    tscrch.setText(" ");
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
		
		//update record
		gender=new JLabel("Gender");
		gender.setBounds(20,250,100,20);
		f1.add(gender);
		
		tgender=new JTextField(10);
		tgender.setBounds(100,250,100,20);
		f1.add(tgender);
		
		searchid=new JLabel("SearchId");
		searchid.setBounds(20,280,100,20);
		f1.add(searchid);
		
		tsrch=new JTextField(10);
		tsrch.setBounds(100,280,70,20);
		f1.add(tsrch);
		
		btnsearch=new JButton("Search");
		btnsearch.setBounds(180,280,80,20);
		f1.add(btnsearch);

		btnsearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int sid = Integer.parseInt(tsrch.getText());
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
		                tsrch.setText("");
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
		
		btnupdate=new JButton("Update");
		btnupdate.setBounds(80,310,100,20);
		f1.add(btnupdate);
		
		btnupdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String n, g, s;
		        int r, sid;
		        double f;
		        Connection con = null; 
		        try {
		            sid = Integer.parseInt(tsrch.getText());
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
public class StudentRecordInsertDeleteUpdate{
	public static void main(String[] args) {
		new StudentRecord1();
	}
}