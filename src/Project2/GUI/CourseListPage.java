package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextArea searchBar;
    private JList<Course<Term<Topic>>> listOfCourses;
    private JButton addButton, deleteButton, previousButton, nextButton;

    public CourseListPage(DoublyLinkedList<Course<Term<Topic>>> courseList) {
        //changing courseList type to what is compatible to JList
        DefaultListModel<Course> courseListModel = new DefaultListModel<>();
        for (int i = 0; i < courseList.getSize(); i++) {
            courseListModel.addElement(courseList.getElement(i));
        }

        //construct components
        coursesLabel = new JLabel ("ENROLLED COURSES");
        searchBar = new JTextArea (5, 5);
        listOfCourses = new JList (courseListModel);
        addButton = new JButton ("Add");
        deleteButton = new JButton ("Delete");
        previousButton = new JButton ("Previous");
        nextButton = new JButton ("Next");

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 457));
        setLayout (null);

        //add components
        add (coursesLabel);
        add (searchBar);
        add (listOfCourses);
        add (addButton);
        add (deleteButton);
        add (previousButton);
        add (nextButton);

        //set component bounds (only needed by Absolute Positioning)
        coursesLabel.setBounds (30, 15, 130, 35);
        searchBar.setBounds (245, 20, 180, 25);
        listOfCourses.setBounds (25, 60, 400, 330);
        addButton.setBounds (25, 405, 90, 35);
        deleteButton.setBounds (130, 405, 90, 35);
        previousButton.setBounds (235, 405, 85, 35);
        nextButton.setBounds (335, 405, 90, 35);

        listOfCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double-click detected
                    Course selectedCourse = listOfCourses.getSelectedValue();
                    if (selectedCourse != null) {
                        openTermPage(selectedCourse);
                    }
                }
            }
        });
    }
    private void openTermPage(Course<Term<Topic>> selectedCourse) {
        JFrame frame = new JFrame(selectedCourse.getCourseName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new TermPage(selectedCourse));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("Course List Page");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new CourseListPage());
//        frame.pack();
//        frame.setVisible (true);
//    }
}
