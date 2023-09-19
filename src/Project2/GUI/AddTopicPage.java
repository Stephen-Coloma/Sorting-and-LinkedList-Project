package Project2.GUI;

import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTopicPage extends JFrame {
    private JTextField moduleField;
    private JTextField taskField;
    private Term<Topic> selectedTerm;
    private DefaultListModel<Topic> topicListModel;

    public AddTopicPage(Term<Topic> selectedTerm, DefaultListModel<Topic> topicListModel) {
        this.selectedTerm = selectedTerm;
        this.topicListModel = topicListModel;

        setTitle("Add Topic");
        setLayout(new BorderLayout());

        moduleField = new JTextField(20);
        taskField = new JTextField(20);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String module = moduleField.getText();
                String task = taskField.getText();

                if (!module.isEmpty() && !task.isEmpty()) {
                    Topic newTopic = new Topic(module, task);
                    selectedTerm.insert(newTopic);
                    topicListModel.addElement(newTopic);
                    dispose();
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e->{
                dispose();
        });

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

