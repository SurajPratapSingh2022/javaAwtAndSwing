package com.application;

import javax.swing.JFrame;

class MyJFrame extends JFrame{
	JFrame f1;
	MyJFrame(){
		f1=new JFrame();
		f1.setSize(600,500);
		f1.setTitle("My First Swing Frame");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLayout(null);
		f1.setVisible(true);
	}
}
public class ActivateCloseButton {
	public static void main(String[] args) {
		new MyJFrame();
	}
}
