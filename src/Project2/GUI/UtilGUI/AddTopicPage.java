/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

package Project2.GUI.UtilGUI;

import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTopicPage extends JFrame {
    // Declare GUI components and data structures
    private JTextField moduleField;
    private JTextField taskField;
    private Term<Topic> selectedTerm;
    private DefaultListModel<Topic> topicListModel;

    public AddTopicPage(Term<Topic> selectedTerm, DefaultListModel<Topic> topicListModel) {
        // Initialize data structures
        this.selectedTerm = selectedTerm;
        this.topicListModel = topicListModel;

        setTitle("Add Topic");
        setLayout(new BorderLayout());

        // Initialize GUI components
        moduleField = new JTextField(20);
        taskField = new JTextField(20);

        JButton addButton = new JButton("Add");

        // Action listener for the Add button
        addButton.addActionListener(e -> {
            try {
                String module = moduleField.getText();
                String task = taskField.getText();

                if (!module.isEmpty() && !task.isEmpty()) {
                    // Create a new topic and add it to the term and list model
                    Topic newTopic = new Topic(module, task);
                    selectedTerm.insert(newTopic);
                    topicListModel.addElement(newTopic);
                    dispose();
                } else {
                    // Display error message if input fields are empty
                    JOptionPane.showMessageDialog(AddTopicPage.this, "Both Module and Task must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Generic error handling
                JOptionPane.showMessageDialog(AddTopicPage.this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for the cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e->{
                dispose();
        });

        // Set up GUI layout
        JPanel addTopicPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        addTopicPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addTopicPanel.add(new JLabel("Module:"));
        addTopicPanel.add(moduleField);
        addTopicPanel.add(new JLabel("Task:"));
        addTopicPanel.add(taskField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(addTopicPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

