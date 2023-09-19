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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addButton){
                    JDialog addCourseDialog = new JDialog();
                    addCourseDialog.setTitle("Add Course");

                    JTextField yearField = new JTextField(20);
                    JTextField termField = new JTextField(20);
                    JTextField courseNumberField = new JTextField(20);
                    JTextField descTitleField = new JTextField(20);
                    JTextField unitsField = new JTextField(20);
                    JTextField gradeField = new JTextField(20);

                    JButton okButton = new JButton("Ok");

                    JButton cancelButton = new JButton("Cancel");
                    cancelButton.addActionListener(f -> {
                        addCourseDialog.dispose();
                    });

                    JPanel addCoursePanel = new JPanel(new GridLayout(6, 2, 5, 5));
                    addCoursePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                    addCoursePanel.add(new JLabel("Year:"));
                    addCoursePanel.add(yearField);
                    addCoursePanel.add(new JLabel("Term:"));
                    addCoursePanel.add(termField);
                    addCoursePanel.add(new JLabel("Course Number:"));
                    addCoursePanel.add(courseNumberField);
                    addCoursePanel.add(new JLabel("Descriptive Title:"));
                    addCoursePanel.add(descTitleField);
                    addCoursePanel.add(new JLabel("Units:"));
                    addCoursePanel.add(unitsField);
                    addCoursePanel.add(new JLabel("Grade (Leave blank if not graded):"));
                    addCoursePanel.add(gradeField);
                    addCoursePanel.setBackground(pink);

                    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
                    buttonPanel.add(okButton);
                    buttonPanel.add(cancelButton);
                    buttonPanel.setBackground(pink);
                    buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));

                    addCourseDialog.add(addCoursePanel, BorderLayout.NORTH);
                    addCourseDialog.add(buttonPanel, BorderLayout.CENTER);

                    addCourseDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    addCourseDialog.setSize(500, 250);
                    addCourseDialog.setVisible(true);
                    addCourseDialog.setLocationRelativeTo(null);
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
