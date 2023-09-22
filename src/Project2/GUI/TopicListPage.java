package Project2.GUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TopicListPage extends JPanel {
    private JScrollPane scrollPane;
    private JLabel topicsLabel;
    private JButton addButton, deleteButton, editButton;
    private JTextField searchBar;
    private JList<Topic> topicsList;
    private Term<Topic> selectedTerm;

    public TopicListPage(Term<Topic> term) {
        // Construct components
        topicsLabel = new JLabel("Topics for " + term.getTermName());
        topicsList = new JList<>(new DefaultListModel<>());
        selectedTerm = term;

        // Add topics to the list
        DefaultListModel<Topic> topicListModel = new DefaultListModel<>();
        for (int i = 0; i < term.getSize(); i++) {
            topicListModel.addElement(term.getElement(i));
        }

        topicsList = new JList<>(topicListModel);
        scrollPane = new JScrollPane(topicsList);
        searchBar = new JTextField("Search", 5);
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");


        // Adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        // Add components
        add(topicsLabel);
        add(searchBar);
        add(scrollPane);
        add(addButton);
        add(editButton);
        add(deleteButton);
        topicsLabel.setBounds (30, 15, 130, 35);
        searchBar.setBounds (245, 20, 180, 25);
        scrollPane.setBounds (25, 60, 400, 330);
        addButton.setBounds (75, 405, 90, 35);
        editButton.setBounds (180, 405, 90, 35);
        deleteButton.setBounds(285, 405, 90, 35);

        //double click on list
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

        //add button implementation
        addButton.addActionListener(e-> {
            AddTopicPage addTopicFrame = new AddTopicPage(selectedTerm, (DefaultListModel<Topic>) topicsList.getModel());
            addTopicFrame.setVisible(true);
        });

        //delete button implementation
        deleteButton.addActionListener(e -> {
            int selectedIndex = topicsList.getSelectedIndex();
            if (selectedIndex >= 0) {
                Topic selectedTopic = topicListModel.getElementAt(selectedIndex);
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected Topic?", "Delete Topic", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // User confirmed deletion, remove the topic both from the list display and the data structure
                    topicListModel.remove(selectedIndex);   //If you want to debug, remove this code and delete the selected topic twice to determine if the topic was also removed from the list
                    selectedTerm.delete(selectedTopic);
                }
            } else {
                // If no topic selected, show an error message or do nothing
                JOptionPane.showMessageDialog(this, "Please select a course to delete.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });

        //edit button implementation
        editButton.addActionListener(e -> {
            int selectedIndex = topicsList.getSelectedIndex();
            if (selectedIndex >= 0) {
                Topic selectedTopic = topicListModel.getElementAt(selectedIndex);

                // Open the edit page for the selected course
                EditTopicPage editTopicPage = new EditTopicPage(topicListModel, selectedTopic, selectedIndex);
            } else {
                // If no course selected, show an error message or do nothing
                JOptionPane.showMessageDialog(this, "Please select a course to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add a FocusListener to clear the text when focused
        searchBar.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if ("Search".equals(searchBar.getText())) {
                    searchBar.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search");
                }
            }
        });

        DefaultListModel<Topic> filteredListModel = new DefaultListModel<>();
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchBar.getText().toLowerCase(); // Convert to lowercase for case-insensitive search
                // Clear the filtered list model
                filteredListModel.clear();

                if (searchText.isEmpty()) {
                    // If there's no search text, show the full original list
                    for (int i = 0; i < topicListModel.size(); i++) {
                        filteredListModel.addElement(topicListModel.get(i));
                    }
                } else {
                    // Filter and add matching items to the filtered list model
                    for (int i = 0; i < topicListModel.size(); i++) {
                        String listItem = topicListModel.get(i).toString().toLowerCase();
                        if (listItem.contains(searchText)) {
                            filteredListModel.addElement(topicListModel.get(i));
                        }
                    }
                }
                topicsList.setModel(filteredListModel);
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
} // end of TopicListPage class