/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     COLOMA, Stephen M.- 2232847@slu.edu.ph
 *     GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *     NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *     RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *     RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *     ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *     SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

// TODO: Provide the algorithm here:
/*
ALGORITHM:
 */

package Project2.GUI;

import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TermPage extends JPanel {
    private final JLabel termLabel;
    private final JButton addButton;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JButton prelimButton;
    private final JButton midtermButton;
    private final JButton finalButton;

    public TermPage(Course<Term<Topic>> course) {

        prelimButton = new JButton ();
        midtermButton = new JButton ();
        finalButton= new JButton ();

        //list  of button
        DoublyLinkedList<JButton> buttonsToPopulate = new DoublyLinkedList<>();
        buttonsToPopulate.insert(prelimButton);
        buttonsToPopulate.insert(midtermButton);
        buttonsToPopulate.insert(finalButton);

        //construct components
        termLabel = new JLabel ("TERM");
        addButton = new JButton ("Add");
        editButton = new JButton ("Edit");
        deleteButton = new JButton ("Delete");


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


        prelimButton.addActionListener(e->{
            Term<Topic> prelims = course.getElement(0);
            openTopicsListPage(prelims);
        });

        midtermButton.addActionListener(e->{
            Term<Topic> midterms = course.getElement(1);
            openTopicsListPage(midterms);
        });

        finalButton.addActionListener(e->{
            Term<Topic> finals = course.getElement(2);
            openTopicsListPage(finals);
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
} // end of TermPage class