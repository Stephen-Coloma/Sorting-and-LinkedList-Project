package Project2.GUI;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TopicListPage extends JPanel {
    private JLabel topicsLabel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextArea jcomp6;
    private JList topicsList;

    public TopicListPage() {
        //construct preComponents
        String[] topicsListItems = {"Topic 1: Introduction to Operating Systems", "Topic 2: Process Management", "Topic 3: Memory Management", "Topic 4: File Systems and Storage Management", "Topic 5: I/O Systems and Device Management"};

        //construct components
        topicsLabel = new JLabel ("TOPICS");
        addButton = new JButton ("Add");
        deleteButton = new JButton ("Delete");
        previousButton = new JButton ("Previous");
        nextButton = new JButton ("Next");
        jcomp6 = new JTextArea (5, 5);
        topicsList = new JList (topicsListItems);

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 457));
        setLayout (null);

        //add components
        add (topicsLabel);
        add (addButton);
        add (deleteButton);
        add (previousButton);
        add (nextButton);
        add (jcomp6);
        add (topicsList);

        //set component bounds (only needed by Absolute Positioning)
        topicsLabel.setBounds (30, 15, 130, 35);
        addButton.setBounds (25, 405, 90, 35);
        deleteButton.setBounds (130, 405, 90, 35);
        previousButton.setBounds (235, 405, 85, 35);
        nextButton.setBounds (335, 405, 90, 35);
        jcomp6.setBounds (230, 20, 195, 30);
        topicsList.setBounds (25, 65, 400, 320);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Topics Page");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new TopicListPage());
        frame.pack();
        frame.setVisible (true);
    }
}
