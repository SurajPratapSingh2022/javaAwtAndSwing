package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyJFrame1 extends JFrame {
    JFrame j;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    JRadioButton r1, r2;
    JButton b1;

    MyJFrame1() {
        j = new JFrame();
        j.setSize(800, 600);
        j.setLayout(null);
        j.setVisible(true);
        j.setTitle("Check Voting");

        l1 = new JLabel("Name ");
        l1.setBounds(40, 20, 200, 20);
        j.add(l1);

        t1 = new JTextField(10);
        t1.setBounds(130, 20, 200, 30);
        j.add(t1);

        l2 = new JLabel("Gender ");
        l2.setBounds(40, 80, 200, 20);
        j.add(l2);

        r1 = new JRadioButton("Male");
        r1.setBounds(120, 80, 200, 20);
        j.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(120, 100, 200, 20);
        j.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        l3 = new JLabel("Age ");
        l3.setBounds(40, 150, 200, 20);
        j.add(l3);

        t2 = new JTextField(3);
        t2.setBounds(130, 150, 100, 30);
        j.add(t2);

        b1 = new JButton("Check");
        b1.setBounds(140, 200, 100, 40);
        j.add(b1);

        // Initialize l4 to avoid null reference
        l4 = new JLabel("");
        l4.setBounds(40, 250, 400, 40);
        j.add(l4);

        // Event listener for the button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = "";
                if (r1.isSelected()) {
                    gender = r1.getText();
                } else if (r2.isSelected()) {
                    gender = r2.getText();
                }

                String name = t1.getText();
                int age = Integer.parseInt(t2.getText());

                String eligibilityMessage;
                if (age >= 18) {
                    eligibilityMessage = "Your Name: " + name + ", Gender: " + gender + " & Age: " + age + " is eligible to vote.";
                } else {
                    eligibilityMessage = "Your Name: " + name + ", Gender: " + gender + " & Age: " + age + " is not eligible to vote.";
                }

                // Update the existing label instead of creating a new one
                l4.setText(eligibilityMessage);
            }
        });
    }
}

public class VotingEligibility {
    public static void main(String[] args) {
        new MyJFrame1();
    }
}
