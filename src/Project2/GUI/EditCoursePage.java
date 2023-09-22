package Project2.GUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;
import java.awt.*;


public class EditCoursePage {
    private JTextField courseNameField, courseIdField;
    private JButton updateButton;
    private JPanel editCoursePanel, buttonPanel;

    public EditCoursePage(DefaultListModel<Course> courseDefaultListModel, Course<Term<Topic>> selectedCourse, int selectedIndex) {
        setTitle("Edit Course");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize and populate input fields with course details
        courseNameField = new JTextField(selectedCourse.getCourseName());
        courseIdField = new JTextField(selectedCourse.getCourseID());

        updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {



        }
    }
}
