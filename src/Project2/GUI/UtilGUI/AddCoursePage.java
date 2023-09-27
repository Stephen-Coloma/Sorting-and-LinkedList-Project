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

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCoursePage extends JFrame {

    // Declare GUI components and data structures
    private JTextField courseNameField, courseCodeField;
    private DefaultListModel<Course<Term<Topic>>> courseListModel;
    private DoublyLinkedList<Course<Term<Topic>>> courseList;
    private RoundButton okButton, cancelButton;
    private JPanel addCoursePanel, buttonPanel;
    private JLabel courseIdLabel, courseNameLabel;

    // Color theme from CourseListPage
    static Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);
    public AddCoursePage(DefaultListModel<Course<Term<Topic>>> courseListModel, DoublyLinkedList<Course<Term<Topic>>> courseList) {

        setTitle("Add Course");
        setLayout(new BorderLayout());

        // Initialize data structures
        this.courseListModel = courseListModel;
        this.courseList = courseList;

        // Initialize GUI components
        courseIdLabel = new JLabel("Course ID:");
        courseNameLabel = new JLabel("Course Name:");
        courseNameField = new JTextField(20);
        courseCodeField = new JTextField(4);
        okButton = new RoundButton ("Ok");
        cancelButton = new RoundButton ("Cancel");
        courseNameField.setBorder(BorderFactory.createLineBorder(polynesianBlue));
        courseCodeField.setBorder(BorderFactory.createLineBorder(polynesianBlue));

        // Modify the text field appearance
        int textFieldHeight = 40; // Adjust the height as needed
        courseNameField.setPreferredSize(new Dimension(200, textFieldHeight));
        courseNameField.setBorder(BorderFactory.createLineBorder(royalBlue, 2));
        courseCodeField.setPreferredSize(new Dimension(200, textFieldHeight));
        courseCodeField.setBorder(BorderFactory.createLineBorder(royalBlue, 2));

        //Modify the label appearance
        Font labelFont = new Font("Roboto", Font.BOLD, 18); // Replace "Roboto" with your desired font
        courseNameLabel.setForeground(royalBlue);
        courseIdLabel.setForeground(royalBlue);
        courseNameLabel.setFont(labelFont);
        courseIdLabel.setFont(labelFont);

        // Apply the color theme and styles
        setBackground(mustard);
        buttonDesign(okButton);
        buttonDesign(cancelButton);

        // Set up GUI layout with the color theme
        addCoursePanel = new JPanel(new GridLayout(2, 2, 5, 10));
        addCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addCoursePanel.setBackground(mustard);
        addCoursePanel.add(courseIdLabel);
        addCoursePanel.add(courseCodeField);
        addCoursePanel.add(courseNameLabel);
        addCoursePanel.add(courseNameField);

        buttonPanel = new JPanel(new GridLayout(1, 2, 30, 5));
        buttonPanel.setBackground(mustard);
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(addCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add the icon to the JFrame
        String iconPath = "src/Project2/GUI/Icons/COURSE ICON.png";
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(470, 210);
        setLocationRelativeTo(null);

        cancelButton.addActionListener(e -> {
            dispose();
        });

        okButton.addActionListener(e -> {
            try {
                String courseName = courseNameField.getText().trim();
                String courseID = courseCodeField.getText().trim();

                if (!courseName.isEmpty() && !courseID.isEmpty()) {
                    // Create a new course object
                    Course<Term<Topic>> newCourse = new Course<>(courseName, courseID);

                    // Add default terms to the new course
                    newCourse.insert(new Term<>("Prelims"));
                    newCourse.insert(new Term<>("Midterms"));
                    newCourse.insert(new Term<>("Finals"));

                    // Add the new course to the list and update the GUI
                    courseList.insert(newCourse);
                    courseListModel.addElement(newCourse);

                    JOptionPane.showMessageDialog(this, "Course added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    dispose(); // Close the Add Course Page
                } else {
                    // Display error message if input fields are empty
                    JOptionPane.showMessageDialog(this, "Both Course ID and Course Name must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Generic error handling
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

    private void buttonDesign(JButton button) {
        // Styling buttons similar to CourseListPage's buttonDesign method
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(royalBlue, 2, false),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)));
        button.setBackground(polynesianBlue);
        button.setForeground(mustard);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(royalBlue, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(royalBlue);
                button.setForeground(flashWhite);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(royalBlue, 2, false),
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(polynesianBlue);
                button.setForeground(mustard);
            }
        });
    }
}
