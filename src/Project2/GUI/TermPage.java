package Project2.GUI;

import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TermPage extends JPanel {
    private JLabel termLabel;
    private JButton addButton, editButton, deleteButton, prelimButton, midtermButton, finalButton;

    public TermPage(Course<Term<Topic>> course) {
        // Debugging: Print out the terms in the course
        if (course.getSize() > 0) {
            for (int i = 0; i < course.getSize(); i++) {
                Term<Topic> term = course.getElement(i);
                System.out.println("Term: " + term.getTermName());
            }
        } else {
            System.out.println("Course is empty");
        }
        //construct components
        termLabel = new JLabel ("TERM");
        addButton = new JButton ("Add");
        editButton = new JButton ("Edit");
        deleteButton = new JButton ("Delete");

        prelimButton = new JButton ("Prelim");
        midtermButton = new JButton ("Midterm");
        finalButton = new JButton ("Finals");

        //disabling add and delete button
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 457));
        setLayout (null);

        //add components
        add (termLabel);
        add (addButton);
        add(editButton);
        add (deleteButton);
        add (prelimButton);
        add (midtermButton);
        add (finalButton);

        //set component bounds (only needed by Absolute Positioning)
        termLabel.setBounds (30, 15, 130, 35);
        addButton.setBounds (75, 405, 90, 35);
        editButton.setBounds (180, 405, 90, 35);
        deleteButton.setBounds(285, 405, 90, 35);


        prelimButton.setBounds (25, 55, 400, 90);
        midtermButton.setBounds (25, 170, 400, 95);
        finalButton.setBounds (25, 290, 400, 95);

        prelimButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Term<Topic> prelimsTerm = course.getTerm("Prelims");
                if (prelimsTerm != null) {
                    openTopicsListPage(prelimsTerm);
                    SwingUtilities.getWindowAncestor(TermPage.this).dispose();
                } else {
                    System.out.println("Prelims term is null");
                }
            }
        });

        midtermButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Term<Topic> midtermTerm = course.getTerm("Midterms");
                if (midtermTerm != null) {
                    openTopicsListPage(midtermTerm);
                    SwingUtilities.getWindowAncestor(TermPage.this).dispose();
                } else {
                    System.out.println("Midterms term is null");
                }
            }
        });

        finalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Term<Topic> finalTerm = course.getTerm("Finals");
                if (finalTerm != null) {
                    openTopicsListPage(finalTerm);
                    SwingUtilities.getWindowAncestor(TermPage.this).dispose();
                } else {
                    System.out.println("Finals term is null");
                }
            }
        });
    }

    private void openTopicsListPage(Term<Topic> term) {
        JFrame frame = new JFrame(term.getTermName()); // Use getTermName to set the frame title
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new TopicListPage(term));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    } // end of openTopicsListPage method

//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("Term Page");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new TermPage());
//        frame.pack();
//        frame.setVisible (true);
//    }
} // end of TermPage class