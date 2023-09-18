package Project2.GUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TopicListPage extends JPanel {
    private JScrollPane scrollPane;
    private JLabel topicsLabel;
    private JButton addButton, deleteButton, previousButton, nextButton;
    private JTextArea searchBar;
    private JList<Topic> topicsList;

    public TopicListPage(Term<Topic> term) {
        // Construct components
        topicsLabel = new JLabel("Topics for " + term.getTermName());
        topicsList = new JList<>(new DefaultListModel<>());

        // Add topics to the list
        DefaultListModel<Topic> topicListModel = (DefaultListModel<Topic>) topicsList.getModel();
        for (int i = 0; i < term.getSize(); i++) {
            topicListModel.addElement(term.getElement(i));
        }

        scrollPane = new JScrollPane(topicsList);
        searchBar = new JTextArea(5, 5);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        // Adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        // Add components
        add(topicsLabel);
        add(searchBar);
        add(scrollPane);
        add(addButton);
        add(deleteButton);
        add(previousButton);
        add(nextButton);
        topicsLabel.setBounds (30, 15, 130, 35);
        searchBar.setBounds (245, 20, 180, 25);
        scrollPane.setBounds (25, 60, 400, 330);
        addButton.setBounds (25, 405, 90, 35);
        deleteButton.setBounds (130, 405, 90, 35);
        previousButton.setBounds (235, 405, 85, 35);
        nextButton.setBounds (335, 405, 90, 35);

        topicsList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double-click detected
                    Topic selectedTopic = topicsList.getSelectedValue();
                    if (selectedTopic != null) {
                        openModulesTasksPage(selectedTopic);
                    }
                }
            }
        });

    }

    private void openModulesTasksPage(Topic topic) {
        JFrame frame = new JFrame(topic.getModule()); // Use getModule to set the frame title
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ModulesTasksPage(topic));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    } // end of openModulesTasksPage method


//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("Topics Page");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new TopicListPage());
//        frame.pack();
//        frame.setVisible (true);
//    }
} // end of TopicListPage class