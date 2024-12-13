package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Prime{
	JFrame f2;
	JLabel l3,l4;
	JTextField t3;
	JButton b2,b3;
	Prime(){
		//for 2nd JFrame
		f2=new JFrame("Check Number: ");
		f2.setSize(800,600);
		f2.setLayout(null);
		f2.setVisible(true);
		
		l3=new JLabel("Enter No.");
		l3.setBounds(20,20,100,20);
		f2.add(l3);
		
		t3=new JTextField(10);
		t3.setBounds(100,20,150,20);
		f2.add(t3);
		
		l4=new JLabel("");
		l4.setBounds(20,100,100,20);
		f2.add(l4);
		
		b2=new JButton("Prime");
		b2.setBounds(30,80,80,20);
		f2.add(b2);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=t3.getText();
				int num=Integer.parseInt(input);
				boolean flag=true;
				for(int i=2; i<num/2; i++) {
					if(num%i == 0) {
						flag=false;
						break;
					}
				}
				if(flag)
					l4.setText(num+" is Prime.");
				else
					l4.setText(num+" is not Prime.");
			}
		});
		
		
		
		b3=new JButton("Exit");
		b3.setBounds(140,80,80,20);
		f2.add(b3);
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}

class Login{
	JFrame f1;
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1;
	Login(){
		//for 1st JFrame
		f1=new JFrame("Login");
		f1.setSize(800,600);
		f1.setLayout(null);
		f1.setVisible(true);
		
		l3=new JLabel("");
		l3.setBounds(20,2,200,20);
		f1.add(l3);
		
		l1=new JLabel("UserName: ");
		l1.setBounds(20,20,200,20);
		f1.add(l1);
				
		t1=new JTextField(10);
		t1.setBounds(100,20,150,20);
		f1.add(t1);
				
		l2=new JLabel("Password: ");
		l2.setBounds(20,60,200,20);
		f1.add(l2);
				
		t2=new JTextField(10);
		t2.setBounds(100,60,150,20);
		f1.add(t2);
		
		b1=new JButton("Submit");
		b1.setBounds(60,100,100,20);
		f1.add(b1);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=t1.getText();
				String pass=t2.getText();
				if(user.equals("admin") && pass.equals("admin")) {
					l3.setText("Login Successfully");
					f1.dispose();
					new Prime();
				}else {
					l3.setText("Invalid Crendentials");
				}
			}
		});
		
	}
}

public class JFrameSwitching {
	public static void main(String[] args) {
		new Login();
	}
}
