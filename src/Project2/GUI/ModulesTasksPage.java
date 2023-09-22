/**

 Group MixAndMatch
 Class Code and Course Number: 9342 - CS 211
 Schedule: TF 9:00 - 10:30 AM
 <p>
 COLOMA, Stephen M.- 2232847@slu.edu.ph
 GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 </p>
 */

// TODO: Provide the algorithm here:
/*
ALGORITHM:
 */
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