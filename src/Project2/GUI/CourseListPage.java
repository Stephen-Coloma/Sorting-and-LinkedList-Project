package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.annotation.ElementType;
import javax.swing.*;

import static java.awt.Color.pink;

public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextField searchBar;
    private JList<Course<Term<Topic>>> listOfCourses;
    private JButton addButton, deleteButton, editButton;

    public CourseListPage(DoublyLinkedList<Course<Term<Topic>>> courseList) {
        //changing courseList type to what is compatible to JList
        DefaultListModel<Course<Term<Topic>>> courseListModel = new DefaultListModel<>();
        for (int i = 0; i < courseList.getSize(); i++) {
            courseListModel.addElement(courseList.getElement(i));
        }

        //construct components
        coursesLabel = new JLabel("ENROLLED COURSES");
        searchBar = new JTextField( "Search",5);
        listOfCourses = new JList(courseListModel);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");

        //adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);


        //set component bounds (only needed by Absolute Positioning)
        coursesLabel.setBounds(30, 15, 130, 35);
        searchBar.setBounds(245, 20, 180, 25);
        listOfCourses.setBounds(25, 60, 400, 330);

        addButton.setBounds(75, 405, 90, 35);
        editButton.setBounds(180, 405, 90, 35);
        deleteButton.setBounds(285, 405, 90, 35);

        //double click implementation
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

        //add button implementation
        addButton.addActionListener(e -> {
            if (e.getSource() == addButton) {
                AddCoursePage addCoursePage = new AddCoursePage(courseListModel, courseList);
                addCoursePage.setVisible(true);
            }

        });

        //delete button implementation
        deleteButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected course?", "Delete Course", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        courseListModel.remove(selectedIndex);   //If you want to debug, remove this code and delete the selected topic twice to determine if the topic was also removed from the list
                        courseList.delete(selectedCourse);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // If no course selected, show an error message or do nothing
                    JOptionPane.showMessageDialog(this, "Please select a course to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //edit button implementation
        editButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);

                // Open the edit page for the selected course
                try {
                    EditCoursePage editCoursePage = new EditCoursePage(courseListModel, selectedCourse, selectedIndex);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // If no course selected, show an error message or do nothing
                JOptionPane.showMessageDialog(this, "Please select a course to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        DefaultListModel<Course<Term<Topic>>> filteredListModel = new DefaultListModel<>();
        searchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchBar.getText().toLowerCase(); // Convert to lowercase for case-insensitive search
                // Clear the filtered list model
                filteredListModel.clear();

                if (searchText.isEmpty()) {
                    // If there's no search text, show the full original list
                    for (int i = 0; i < courseListModel.size(); i++) {
                        filteredListModel.addElement(courseListModel.get(i));
                    }
                } else {
                    // Filter and add matching items to the filtered list model
                    for (int i = 0; i < courseListModel.size(); i++) {
                        String listItem = courseListModel.get(i).toString().toLowerCase();
                        if (listItem.contains(searchText)) {
                            filteredListModel.addElement(courseListModel.get(i));
                        }
                    }
                }
                listOfCourses.setModel(filteredListModel);
            }
        });

        //add components
        add(coursesLabel);
        add(searchBar);
        add(listOfCourses);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(editButton);
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
