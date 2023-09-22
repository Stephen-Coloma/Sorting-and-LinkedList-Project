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

public class AddCoursePage extends JFrame {

    // Declare GUI components and data structures
    private JTextField courseNameField, courseCodeField;
    private DefaultListModel<Course<Term<Topic>>> courseListModel;
    private DoublyLinkedList<Course<Term<Topic>>> courseList;
    private JButton okButton, cancelButton;
    JPanel addCoursePanel, buttonPanel;
    public AddCoursePage(DefaultListModel<Course<Term<Topic>>> courseListModel, DoublyLinkedList<Course<Term<Topic>>> courseList) {

        setTitle("Add Course");
        setLayout(new BorderLayout());

        // Initialize data structures
        this.courseListModel = courseListModel;
        this.courseList = courseList;

        // Initialize GUI components
        courseNameField = new JTextField(20);
        courseCodeField = new JTextField(4);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        // Action listener for the cancel button
        cancelButton.addActionListener(e -> {
            dispose();
        });

        // Action listener for the OK button
        okButton.addActionListener(e -> {
            try {
                String courseName = courseNameField.getText();
                String courseID = courseCodeField.getText();

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
                    dispose();
                } else {
                    // Display error message if input fields are empty
                    JOptionPane.showMessageDialog(this, "Both Course ID and Course Name must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                // Generic error handling
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Set up GUI layout
        addCoursePanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addCoursePanel.add(new JLabel("Course ID:"));
        addCoursePanel.add(courseCodeField);
        addCoursePanel.add(new JLabel("Course Name:"));
        addCoursePanel.add(courseNameField);

        buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(addCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null);
    }
}

