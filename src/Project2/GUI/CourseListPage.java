package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import static java.awt.Color.pink;

public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextArea searchBar;
    private JList<Course<Term<Topic>>> listOfCourses;
    private JButton addButton, deleteButton, editButton;

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
        editButton = new JButton ("Edit");

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 457));
        setLayout (null);

        //add components
        add (coursesLabel);
        add (searchBar);
        add (listOfCourses);
        add (addButton);
        add(editButton);
        add (deleteButton);
        add (editButton);


        //set component bounds (only needed by Absolute Positioning)
        coursesLabel.setBounds (30, 15, 130, 35);
        searchBar.setBounds (245, 20, 180, 25);
        listOfCourses.setBounds (25, 60, 400, 330);

        addButton.setBounds (75, 405, 90, 35);
        editButton.setBounds (180, 405, 90, 35);
        deleteButton.setBounds(285, 405, 90, 35);

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

        /**RE EDIT ADD BUTTON*/
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addButton) {
                    AddCoursePage addCourseDialog = new AddCoursePage((JFrame) SwingUtilities.getWindowAncestor(CourseListPage.this), courseListModel, courseList);
                    addCourseDialog.setVisible(true);
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
}
