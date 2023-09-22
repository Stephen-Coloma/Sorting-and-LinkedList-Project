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
import Project2.ReferenceClasses.Topic;
import javax.swing.*;
import java.awt.*;

public class EditTopicPage extends JFrame{
    // Declare GUI components
    private JTextField moduleField, taskField;
    private JButton updateButton;
    private JPanel editTopicPanel, buttonPanel;

    public EditTopicPage(DefaultListModel<Topic> topicDefaultListModel, Topic selectedTopic, int selectedIndex) {

        setTitle("Edit Topic");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize and populate input fields with topic details
        moduleField = new JTextField(selectedTopic.getModule());
        taskField = new JTextField(selectedTopic.getTask());

        updateButton = new JButton("Update");
        // Action listener for the Update Button
        updateButton.addActionListener(e -> {
            try {
                // Update the topic details based on the input fields
                selectedTopic.setModule(moduleField.getText());
                selectedTopic.setTask(taskField.getText());
                topicDefaultListModel.setElementAt(selectedTopic, selectedIndex);

                // Close the edit page after updating
                dispose();
            } catch (Exception ex) {
                // Handle unexpected exceptions and display an error message
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Set up GUI layout for topic editing
        editTopicPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        editTopicPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        editTopicPanel.add(new JLabel("Module:"));
        editTopicPanel.add(moduleField);
        editTopicPanel.add(new JLabel("Task:"));
        editTopicPanel.add(taskField);
        editTopicPanel.setBackground(Color.PINK);

        buttonPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        buttonPanel.add(updateButton);
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(editTopicPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
