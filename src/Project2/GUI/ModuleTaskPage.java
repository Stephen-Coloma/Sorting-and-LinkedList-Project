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

public class ModuleTaskPage extends JPanel {
    private JLabel moduleName;
    private JLabel taskName;

    public ModuleTaskPage(Topic topic) {
        try {
            //construct components
            moduleName = new JLabel ("Module: "+ topic.getModule());
            taskName = new JLabel ("Task: " + topic.getTask());

            //adjust size and set layout
            setPreferredSize (new Dimension (400, 100));
            setLayout (null);

            //add components
            add (moduleName);
            add (taskName);

            //set component bounds (only needed by Absolute Positioning)
            moduleName.setBounds (10, 20, 390, 30);
            taskName.setBounds (10, 45, 390, 30);

        } catch (Exception ex) {
            // Generic error handling
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}