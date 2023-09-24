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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditTopicPage extends JFrame{
    // Declare GUI components
    private JLabel moduleLabel, taskLabel;
    private JTextField moduleField, taskField;
    private RoundButton updateButton;
    private JPanel editTopicPanel, buttonPanel;

    //Declare static instances of the Color class representing colors used in the GUI of the program.
    static  Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);

    public EditTopicPage(DefaultListModel<Topic> topicDefaultListModel, Topic selectedTopic, int selectedIndex) {
        // Initialize and populate input fields with topic details
        moduleField = new JTextField(selectedTopic.getModule());
        taskField = new JTextField(selectedTopic.getTask());

        // Initialize GUI components
        moduleLabel = new JLabel("Module: ");
        taskLabel = new JLabel("Task: ");
        updateButton = new RoundButton("Update");

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
        buttonDesign(updateButton);

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
        editTopicPanel.add(moduleLabel);
        editTopicPanel.add(moduleField);
        editTopicPanel.add(taskLabel);
        editTopicPanel.add(taskField);
        editTopicPanel.setBackground(mustard);

        buttonPanel = new JPanel(new GridLayout(1, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 10, 100));
        buttonPanel.add(updateButton);
        buttonPanel.setBackground(mustard);

        add(editTopicPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add the icon to the JFrame
        String iconPath = "src/Project2/GUI/Icons/COURSE ICON.png";
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        // Frame Properties
        setTitle("Edit Topic");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(470, 300);
        setLocationRelativeTo(null);
        setVisible(true);
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

} // end of EditTopicPage class