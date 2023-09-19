package Project2.GUI;

import Project2.ReferenceClasses.Topic;

import java.awt.*;
import javax.swing.*;

public class ModulesTasksPage extends JPanel {
    private JLabel topicName;
    private JLabel moduleName;
    private JLabel taskName;

    public ModulesTasksPage(Topic topic) {
        //construct components
        topicName = new JLabel ();
        moduleName = new JLabel ();
        taskName = new JLabel ();

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


//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("ModulesTasksPage");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new ModulesTasksPage(topic));
//        frame.pack();
//        frame.setVisible (true);
//    }
}