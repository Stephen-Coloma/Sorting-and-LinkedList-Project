package Project2.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ModulesTasksPage extends JPanel {
    private JLabel topicName;
    private JLabel moduleName;
    private JLabel taskName;

    public ModulesTasksPage() {
        //construct components
        topicName = new JLabel ("OPERATING SYSTEMS AND ITS IMPORTANCE TO OUR DAILY LIVES");
        moduleName = new JLabel ("Module 1: Introduction to Operating Systems ");
        taskName = new JLabel ("Task        : Lab Activity 1");

        //adjust size and set layout
        setPreferredSize (new Dimension (520, 134));
        setLayout (null);

        //add components
        add (topicName);
        add (moduleName);
        add (taskName);

        //set component bounds (only needed by Absolute Positioning)
        topicName.setBounds (15, 15, 470, 30);
        moduleName.setBounds (15, 55, 365, 30);
        taskName.setBounds (15, 80, 310, 30);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("ModulesTasksPage");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ModulesTasksPage());
        frame.pack();
        frame.setVisible (true);
    }
}