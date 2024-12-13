package com.application;
// textfield inputting msg print in console
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyFrame extends Frame {
    Label l1;
    TextField t1;
    Button b1;

    MyFrame() {
        setSize(400, 400);
        setTitle("My first AWT application");

        // Initialize components
        l1 = new Label("Welcome to AWT Frame");
        t1 = new TextField(20);
        b1 = new Button("Click Me");

        // Set bounds for components
        l1.setBounds(50, 50, 300, 30);
        t1.setBounds(50, 100, 300, 30);
        b1.setBounds(50, 150, 100, 30);

        // Add components to the frame
        add(l1);
        add(t1);
        add(b1);

        // Set layout and visibility
        setLayout(null);
        setVisible(true);

        // Add button action listener
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print TextField message in the console
                System.out.println("TextField Msg: " + t1.getText());
            }
        });

        // Add window listener for closing the frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

public class AwtMsgDisplay {
    public static void main(String[] args) {
        new MyFrame();
    }
}
