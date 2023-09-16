package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextArea searchBar;
    private JList<Course> listOfCourses;
    private JButton addButton;
    private JButton deleteButton;
    private JButton previousButton;
    private JButton nextButton;

    public CourseListPage(DoublyLinkedList<Course> courseList) {
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
    }

//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("Course List Page");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new CourseListPage());
//        frame.pack();
//        frame.setVisible (true);
//    }
}
