package Project2.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TermPage extends JPanel {
    private JLabel termLabel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton previousButton;
    private JButton nextButton;
    private JButton prelimButton;
    private JButton midtermButton;
    private JButton finalButton;

    public TermPage() {
        //construct components
        termLabel = new JLabel ("TERM");
        addButton = new JButton ("Add");
        deleteButton = new JButton ("Delete");
        previousButton = new JButton ("Previous");
        nextButton = new JButton ("Next");
        prelimButton = new JButton ("Prelim");
        midtermButton = new JButton ("Midterm");
        finalButton = new JButton ("Finals");

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 457));
        setLayout (null);

        //add components
        add (termLabel);
        add (addButton);
        add (deleteButton);
        add (previousButton);
        add (nextButton);
        add (prelimButton);
        add (midtermButton);
        add (finalButton);

        //set component bounds (only needed by Absolute Positioning)
        termLabel.setBounds (30, 15, 130, 35);
        addButton.setBounds (25, 405, 90, 35);
        deleteButton.setBounds (130, 405, 90, 35);
        previousButton.setBounds (235, 405, 85, 35);
        nextButton.setBounds (335, 405, 90, 35);
        prelimButton.setBounds (25, 55, 400, 90);
        midtermButton.setBounds (25, 170, 400, 95);
        finalButton.setBounds (25, 290, 400, 95);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Term Page");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TermPage());
        frame.pack();
        frame.setVisible (true);
    }
}
