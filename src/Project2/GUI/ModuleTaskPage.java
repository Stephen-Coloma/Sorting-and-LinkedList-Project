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
package Project2.GUI;

import Project2.ReferenceClasses.Topic;
import java.awt.*;
import javax.swing.*;

public class ModuleTaskPage extends JPanel {
    // Declare GUI components in ModuleTaskPage class
    private JPanel panel;
    private JLabel moduleName, taskName;

    //Declare static instances of the Color class representing colors used in the GUI of the program.
    static  Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);

    public ModuleTaskPage(Topic topic) {
        // Create a JPanel to contain the labels
        panel = new JPanel(new GridLayout(2, 1, 20, 5));
        panel.setLayout(null);
        panel.setBackground(mustard);

        // Construct components
        moduleName = new JLabel("<html> Module: " + topic.getModule() + "</html>");
        taskName = new JLabel("<html> Task: " + topic.getTask() + "</html>");

        // Modify the label appearance
        Font labelFont = new Font("Roboto", Font.BOLD, 15);
        moduleName.setForeground(royalBlue);
        taskName.setForeground(royalBlue);
        moduleName.setFont(labelFont);
        taskName.setFont(labelFont);

        // Calculate the preferred size of the labels based on their text
        Dimension moduleNameSize = moduleName.getPreferredSize();
        Dimension taskNameSize = taskName.getPreferredSize();

        // Set bounds for the labels dynamically based on their preferred size
        int labelWidth = Math.max(moduleNameSize.width, taskNameSize.width);
        int labelHeight = moduleNameSize.height + taskNameSize.height + 10;

        moduleName.setBounds(20, 20, labelWidth, moduleNameSize.height);
        taskName.setBounds(20, 30 + moduleNameSize.height, labelWidth, taskNameSize.height);

        // Calculate the preferred size of the panel
        int panelWidth = labelWidth + 40;
        int panelHeight = labelHeight + 40;

        // Set the preferred size of the ModuleTaskPage
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setLayout(new BorderLayout());

        // Add components in the panel
        panel.add(moduleName);
        panel.add(taskName);

        add(panel, BorderLayout.CENTER);
    }

} // end of ModuleTaskPage class