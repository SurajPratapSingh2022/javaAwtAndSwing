package com.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Fibonacci extends JFrame {
    JFrame j;
    JLabel l1, l2;
    JTextField t1;
    JButton b1;

    Fibonacci() {
        j = new JFrame("Fibonacci Series");
        j.setSize(900, 600);
        j.setLayout(null);
        j.setVisible(true);

        l1 = new JLabel("Enter term for series ");
        l1.setBounds(20, 20, 200, 20);
        j.add(l1);

        t1 = new JTextField(10);
        t1.setBounds(200, 20, 150, 20);
        j.add(t1);

        l2 = new JLabel(""); // Label to display the series
        l2.setBounds(20, 120, 800, 20); // Adjusted width for a longer series
        j.add(l2);

        b1 = new JButton("Print Series");
        b1.setBounds(60, 60, 150, 20);
        j.add(b1);

        // Add ActionListener to the button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(t1.getText());
                int first = 0, second = 1;

                // StringBuilder to store the Fibonacci series
                StringBuilder series = new StringBuilder();

                for (int i = 1; i <= n; i++) {
                    series.append(first).append(" "); // Append current Fibonacci number
                    int next = first + second;
                    first = second;
                    second = next;
                }

                // Update the label with the complete series
                l2.setText("Fibonacci Series: " + series.toString());
                
             // Print the series to the console
                System.out.println("Fibonacci Series: " + series.toString());
            }
        });
    }
}

public class JFrameFibonacci {
    public static void main(String[] args) {
        new Fibonacci();
    }
}
