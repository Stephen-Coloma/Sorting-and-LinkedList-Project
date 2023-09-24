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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddTopicPage extends JFrame {
    // Declare GUI components and data structures
    private JLabel moduleLabel, taskLabel;
    private JTextField moduleField, taskField;
    private JPanel addTopicPanel, buttonPanel;
    private Term<Topic> selectedTerm;
    private DefaultListModel<Topic> topicListModel;
    private RoundButton addButton, cancelButton;

    //Declare static instances of the Color class representing colors used in the GUI of the program.
    static  Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);

    public AddTopicPage(Term<Topic> selectedTerm, DefaultListModel<Topic> topicListModel) {
        // Initialize data structures
        this.selectedTerm = selectedTerm;
        this.topicListModel = topicListModel;

        setTitle("Add Topic");
        setLayout(new BorderLayout());

        // Initialize GUI components
        moduleLabel = new JLabel("Module: ");
        taskLabel = new JLabel("Task: ");
        moduleField = new JTextField(30);
        taskField = new JTextField(30);
        addTopicPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        buttonPanel = new JPanel(new GridLayout(1, 2, 30, 5));
        cancelButton = new RoundButton("Cancel");
        addButton = new RoundButton("Add");

        // Modify the text field appearance
        int textFieldHeight = 40; // Adjust the height as needed
        moduleField.setPreferredSize(new Dimension(200, textFieldHeight));
        moduleField.setBorder(BorderFactory.createLineBorder(royalBlue, 2));
        taskField.setPreferredSize(new Dimension(200, textFieldHeight));
        taskField.setBorder(BorderFactory.createLineBorder(royalBlue, 2));

        //Modify the label appearance
        Font labelFont = new Font("Roboto", Font.BOLD, 18); // Replace "Roboto" with your desired font
        moduleLabel.setForeground(royalBlue);
        taskLabel.setForeground(royalBlue);
        moduleLabel.setFont(labelFont);
        taskLabel.setFont(labelFont);

        // Modify the term buttons' appearance
        buttonDesign(addButton);
        buttonDesign(cancelButton);

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
        cancelButton.addActionListener(e->{
                dispose();
        });

        // Set up GUI layout
        addTopicPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addTopicPanel.add(moduleLabel);
        addTopicPanel.add(moduleField);
        addTopicPanel.add(taskLabel);
        addTopicPanel.add(taskField);
        addTopicPanel.setBackground(mustard);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBackground(mustard);

        add(addTopicPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add the icon to the JFrame
        String iconPath = "src/Project2/GUI/Icons/COURSE ICON.png";
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        // Frame properties
        setSize(470, 210);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void buttonDesign(RoundButton button) {
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(royalBlue, 2, false), // Set border color, thickness, and roundness
                BorderFactory.createEmptyBorder(8, 18, 8, 18)));
        button.setBackground(polynesianBlue);
        button.setForeground(mustard);
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(royalBlue, 2, false), // Set border color, thickness, and roundness
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(royalBlue); // Set a new color when mouse hovers over the button
                button.setForeground(flashWhite);
            } // end of mouseEntered method

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(royalBlue, 2, false), // Set border color, thickness, and roundness
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(polynesianBlue); // Set back the original color when the mouse leaves the button
                button.setForeground(mustard);
            } // end of mouseExited method
        });
    } // end of buttonDesign method

} // end of AddTopicPage class