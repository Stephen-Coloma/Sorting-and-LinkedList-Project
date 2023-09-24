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

package Project2.GUI;

import Project2.GUI.UtilGUI.AddCoursePage;
import Project2.GUI.UtilGUI.EditCoursePage;
import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CourseListPage extends JPanel {
    private JLabel coursesLabel;
    private JTextField searchBar;
    private JList<Course<Term<Topic>>> listOfCourses;
    private JButton addButton, deleteButton, editButton;


    // Custom cell renderer to change the background color of the selected item
    class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                c.setBackground(new Color(255, 219, 87));
            } else {
                c.setBackground(list.getBackground());
            }
            return c;
        }
    }

    public CourseListPage(DoublyLinkedList<Course<Term<Topic>>> courseList) {
        //changing courseList type to what is compatible to JList
        DefaultListModel<Course<Term<Topic>>> courseListModel = new DefaultListModel<>();
        for (int i = 0; i < courseList.getSize(); i++) {
            courseListModel.addElement(courseList.getElement(i));
        }

        //construct components
        coursesLabel = new JLabel("COURSES");
        searchBar = new JTextField( "Search...",4);
        listOfCourses = new JList(courseListModel);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");

        //adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        setBackground(new Color(17, 41, 107));
        coursesLabel.setFont(new Font("", Font.BOLD, 20));
        coursesLabel.setForeground(new Color(255, 219, 87));

        Color buttonBgColor = new Color(237, 237, 237);

        // Modify the buttons' appearance when pressed
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        addButton.setBackground(buttonBgColor); 
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addButton.setBackground(new Color(255, 219, 87));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                addButton.setBackground(buttonBgColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addButton.setBackground(buttonBgColor);
            }
        });

        editButton.setFont(new Font("Roboto", Font.BOLD, 14));
        editButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        editButton.setBackground(buttonBgColor);
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                editButton.setBackground(new Color(255, 219, 87));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                editButton.setBackground(buttonBgColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editButton.setBackground(buttonBgColor);
            }
        });

        deleteButton.setFont(new Font("Roboto", Font.BOLD, 14));
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
        deleteButton.setBackground(buttonBgColor); 
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                deleteButton.setBackground(new Color(255, 219, 87));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                deleteButton.setBackground(buttonBgColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteButton.setBackground(buttonBgColor);
            }
        });

        //set component bounds (only needed by Absolute Positioning)
        listOfCourses.setBounds(25, 60, 400, 330);
        listOfCourses.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));

        coursesLabel.setBounds(28, 14, 130, 35);
        searchBar.setBounds(245, 18, 180, 25);
        listOfCourses.setBounds(25, 60, 400, 330);
        
        addButton.setBounds(24, 406, 120, 35);
        editButton.setBounds(165, 406, 120, 35);
        deleteButton.setBounds(307, 406, 120, 35);

        //add components
        add(coursesLabel);
        add(searchBar);
        add(listOfCourses);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(editButton);

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

        listOfCourses.setCellRenderer(new CustomListCellRenderer());

        //add button implementation
        addButton.addActionListener(e -> {
            if (e.getSource() == addButton) {
                AddCoursePage addCoursePage = new AddCoursePage(courseListModel, courseList);
                addCoursePage.setVisible(true);
            }

        });

        // Action listener for Delete button
        deleteButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);
                int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected course?", "Delete Course", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        courseListModel.remove(selectedIndex);
                        courseList.delete(selectedCourse);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error deleting course: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for Edit button
        editButton.addActionListener(e -> {
            int selectedIndex = listOfCourses.getSelectedIndex();
            if (selectedIndex >= 0) {
                Course selectedCourse = courseListModel.getElementAt(selectedIndex);
                try {
                    EditCoursePage editCoursePage = new EditCoursePage(courseListModel, selectedCourse, selectedIndex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error editing course: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add a FocusListener to clear the text when focused
        searchBar.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if ("Search".equals(searchBar.getText())) {
                    searchBar.setText("");
                }
                searchBar.setBorder(BorderFactory.createLineBorder(new Color(255, 219, 87), 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search");
                }
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

    }

    // Open TermListPage for the given course
    private void openTermPage(Course<Term<Topic>> selectedCourse) {
        JFrame frame = new JFrame(selectedCourse.getCourseName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new TermListPage(selectedCourse));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
