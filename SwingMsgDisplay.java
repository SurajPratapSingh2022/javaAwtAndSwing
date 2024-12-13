package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyApp {
    JFrame f1;
    JLabel l1, l2;
    JTextField t1;
    JButton b1;

    MyApp() {
        f1 = new JFrame();
        f1.setSize(600, 400);
        f1.setLayout(null);
        f1.setTitle("My First Swing Application");

        l1 = new JLabel("Enter Your Name: ");
        l1.setBounds(20, 20, 200, 20);
        f1.add(l1);

        l2 = new JLabel(" ");
        l2.setBounds(20, 60, 300, 30);
        f1.add(l2);

        t1 = new JTextField(10);
        t1.setBounds(300, 30, 100, 30);
        f1.add(t1);

        b1 = new JButton("Show");
        b1.setBounds(100, 100, 100, 30);
        f1.add(b1);

        // Add ActionListener to the button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l2.setText("I am " + t1.getText());
                System.out.println("TextField Msg: " + t1.getText());
            }
        });

        // Make the frame visible after adding all components
        f1.setVisible(true);
    }
}

public class SwingMsgDisplay {
    public static void main(String[] args) {
        new MyApp();
    }
}
