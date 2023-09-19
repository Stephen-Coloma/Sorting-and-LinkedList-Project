package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;

public class AddCoursePage extends JDialog {
    private JTextField courseNameField;
    private DefaultListModel<Course> courseListModel;
    private DoublyLinkedList<Course<Term<Topic>>> courseList;

    public AddCoursePage(JFrame parentFrame, DefaultListModel<Course> courseListModel, DoublyLinkedList<Course<Term<Topic>>> courseList) {
        super(parentFrame, "Add Course", true);

        this.courseListModel = courseListModel;
        this.courseList = courseList;

        courseNameField = new JTextField(20);

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(e -> {
            dispose();
        });

        okButton.addActionListener(e -> {
            String courseName = courseNameField.getText();
            if (!courseName.isEmpty()) {
                // Create a new course with the specified name
                Course<Term<Topic>> newCourse = new Course<>(courseName, "Course Code");

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

        JPanel addCoursePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        addCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addCoursePanel.add(new JLabel("Course Name:"));
        addCoursePanel.add(courseNameField);
        addCoursePanel.setBackground(Color.PINK);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.setBackground(Color.PINK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

        add(addCoursePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(parentFrame);
    }
}

