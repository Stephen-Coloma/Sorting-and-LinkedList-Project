package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;

public class AddCoursePage extends JFrame {
    private JTextField courseNameField, courseCodeField;
    private DefaultListModel<Course> courseListModel;
    private DoublyLinkedList<Course<Term<Topic>>> courseList;
    private JButton okButton, cancelButton;
    JPanel addCoursePanel, buttonPanel;
    public AddCoursePage(DefaultListModel<Course> courseListModel, DoublyLinkedList<Course<Term<Topic>>> courseList) {

        setTitle("Add Course");
        setLayout(new BorderLayout());
        this.courseListModel = courseListModel;
        this.courseList = courseList;

        courseNameField = new JTextField(20);
        courseCodeField = new JTextField(4);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        okButton.addActionListener(e -> {
            String courseName = courseNameField.getText();
            String courseID = courseCodeField.getText();
            if (!courseName.isEmpty() && !courseID.isEmpty()) {
                // Create a new course with the specified name
                Course<Term<Topic>> newCourse = new Course<>(courseName, courseID);

                // Add the initial terms (Prelims, Midterms, Finals) and empty topics
                newCourse.insert(new Term<>("Prelims"));
                newCourse.insert(new Term<>("Midterms"));
                newCourse.insert(new Term<>("Finals"));

                // Add the new course to your course list
                courseList.insert(newCourse);

                // Update the JList with the new course
                courseListModel.addElement(newCourse);

                // Close the dialog
                dispose();
            }
        });


        addCoursePanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addCoursePanel.add(new JLabel("Course ID:"));
        addCoursePanel.add(courseCodeField);
        addCoursePanel.add(new JLabel("Course Name:"));
        addCoursePanel.add(courseNameField);
        addCoursePanel.setBackground(Color.PINK);

        buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(addCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null);
    }
}

