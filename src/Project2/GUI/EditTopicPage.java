package Project2.GUI;
import Project2.ReferenceClasses.Topic;
import javax.swing.*;
import java.awt.*;

public class EditTopicPage extends JFrame{
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
        updateButton.addActionListener(e -> {
            // Update the topic details based on the input fields
            selectedTopic.setModule(moduleField.getText());
            selectedTopic.setTask(taskField.getText());
            topicDefaultListModel.setElementAt(selectedTopic, selectedIndex);

            //Debugging: to determine if the topic is indeed edited
            System.out.println(selectedTopic.getModule());
            System.out.println(selectedTopic.getTask());

            // Close the edit page
            dispose();

        });

        editTopicPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        editTopicPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        editTopicPanel.add(new JLabel("Module:"));
        editTopicPanel.add(moduleField);
        editTopicPanel.add(new JLabel("Task:"));
        editTopicPanel.add(taskField);
        editTopicPanel.setBackground(Color.PINK);

    }
}
