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

package Project2.GUI;

import Project2.GUI.UtilGUI.RoundButton;
import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TermListPage extends JPanel {
    // GUI components declarations
    private final JLabel termLabel;
    private final RoundButton addButton;
    private final RoundButton editButton;
    private final RoundButton deleteButton;
    private final RoundButton prelimButton;
    private final RoundButton midtermButton;
    private final RoundButton finalButton;

    //Declare static instances of the Color class representing colors used in the GUI of the program.
    static  Color mustard = new Color(255, 219, 87);
    static Color royalBlue = new Color(17, 41, 107);
    static Color flashWhite = new Color(237, 237, 237);
    static Color polynesianBlue = new Color(0, 80, 157);

    public TermListPage(Course<Term<Topic>> course) {

        prelimButton = new RoundButton("");
        midtermButton = new RoundButton("");
        finalButton = new RoundButton("");

        // list of button
        DoublyLinkedList<RoundButton> buttonsToPopulate = new DoublyLinkedList<>();
        buttonsToPopulate.insert(prelimButton);
        buttonsToPopulate.insert(midtermButton);
        buttonsToPopulate.insert(finalButton);

        // Populate button text with the course's list of terms
        try {
            if (course.getSize() > 0) {
                for (int i = 0; i < course.getSize(); i++) {
                    buttonsToPopulate.getElement(i).setText(course.getElement(i).toString());
                }
            } else {
                System.out.println("Course is empty");
            }
        } catch (Exception ex) {
            System.out.println("Error while populating buttons: " + ex.getMessage());
        }

        // construct components
        termLabel = new JLabel("TERM");
        addButton = new RoundButton("Add");
        editButton = new RoundButton("Edit");
        deleteButton = new RoundButton("Delete");

        // Set the background and font colors based on the specification
        setBackground(royalBlue);
        termLabel.setFont(new Font("", Font.BOLD, 20));
        termLabel.setForeground(mustard);

        // Modify the term buttons' appearance
        buttonDesign(prelimButton);
        buttonDesign(midtermButton);
        buttonDesign(finalButton);
        buttonDesign(addButton);
        buttonDesign(editButton);
        buttonDesign(deleteButton);

        // disabling add, delete, and edit button
        addButton.setEnabled(false);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

        // adjust size and set layout
        setPreferredSize(new Dimension(452, 457));
        setLayout(null);

        // add components
        add(termLabel);
        add(addButton);
        add(editButton);
        add(deleteButton);
        add(prelimButton);
        add(midtermButton);
        add(finalButton);

        // set component bounds (only needed by Absolute Positioning)
        termLabel.setBounds(28, 15, 130, 35);
        addButton.setBounds(24, 398, 120, 35);
        editButton.setBounds(165, 398, 120, 35);
        deleteButton.setBounds(307, 398, 120, 35);
        prelimButton.setBounds(25, 65, 400, 80);
        midtermButton.setBounds(25, 180, 400, 80);
        finalButton.setBounds(25, 290, 400, 80);

        prelimButton.addActionListener(e -> {
            Term<Topic> prelims = course.getElement(0);
            openTopicsListPage(prelims);
        });

        midtermButton.addActionListener(e -> {
            Term<Topic> midterms = course.getElement(1);
            openTopicsListPage(midterms);
        });

        finalButton.addActionListener(e -> {
            Term<Topic> finals = course.getElement(2);
            openTopicsListPage(finals);
        });

    }

    private void openTopicsListPage(Term<Topic> term) {
        JFrame frame = new JFrame(term.getTermName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.getContentPane().add(new TopicListPage(term));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    } // end of openTopicsListPage method

    private void buttonDesign(RoundButton button) {
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(mustard, 2, false), // Set border color, thickness, and roundness
                BorderFactory.createEmptyBorder(8, 18, 8, 18)));
        button.setBackground(flashWhite);
        button.setForeground(polynesianBlue);
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(mustard, 2, false), // Set border color, thickness, and roundness
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(mustard); // Set a new color when mouse hovers over the button
                button.setForeground(royalBlue);
            } // end of mouseEntered method

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(mustard, 2, false), // Set border color, thickness, and roundness
                        BorderFactory.createEmptyBorder(8, 18, 8, 18)));
                button.setBackground(flashWhite); // Set back the original color when the mouse leaves the button
                button.setForeground(polynesianBlue);
            } // end of mouseExited method
        });
    } // end of buttonDesign method

} // end of TermPage class
