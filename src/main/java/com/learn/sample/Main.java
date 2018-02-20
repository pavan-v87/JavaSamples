package com.learn.sample;

import com.learn.sample.thread.MyThread;
import com.learn.sample.thread.WakeMeUpThread;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Created by pavan.vijayanar on 9/2/2016.
 */
public class Main {

    private static final WakeMeUpThread thread = new WakeMeUpThread();
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");

        JButton button = new JButton("Interrupt");
        button.setMargin(new Insets(10, 10, 10, 10));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thread.interruptMe();
            }
        });

        JButton button2 = new JButton("Notify");
        button2.setMargin(new Insets(10, 10, 10, 10));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thread.notifyMe();
            }
        });

        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.getContentPane().add(button2);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        System.out.println("Namaskara!!");
        thread.start();
        //new MyThread().start();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
