package Project2;

import Project2.GUI.CourseListPage;
import Project2.LinkedListImplementation.DoublyLinkedList;
import Project2.ReferenceClasses.Course;
import Project2.ReferenceClasses.Term;
import Project2.ReferenceClasses.Topic;

import javax.swing.*;

public class GoogleClassroomApp extends JFrame {
    private DoublyLinkedList<Course<Term<Topic>>> courseList = new DoublyLinkedList<>();
    public static void main(String[] args) {
        GoogleClassroomApp program = new GoogleClassroomApp();
        program.run();
    }

    private void run() {
        //initial population of Courses, Terms and Topics
        courseList = initialPopulation();
        this.setContentPane(new CourseListPage(courseList));
        this.setTitle("Course List Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private DoublyLinkedList<Course<Term<Topic>>> initialPopulation() {
        // Create and populate Course 1
        Course<Term<Topic>> c1 = populateCourse1();
        courseList.insert(c1);

        // Create and populate Course 2
        Course<Term<Topic>> c2 = populateCourse2();
        courseList.insert(c2);

        // Create and populate Course 3
        Course<Term<Topic>> c3 = populateCourse3();
        courseList.insert(c3);

        return courseList;
    }


    private Course<Term<Topic>> populateCourse1() {
        Course<Term<Topic>> course = new Course<>("DATA STRUCTURES", "9342 - CS 211");

        Term<Topic> prelims = new Term<>("Prelims");
        Term<Topic> midterms = new Term<>("Midterms");
        Term<Topic> finals = new Term<>("Finals");

        // Populate Prelims
        prelims.insert(new Topic("Abstract Data Types", "Explaining ADT"));
        prelims.insert(new Topic("Algorithm Complexity", "Technical Paper"));
        prelims.insert(new Topic("Big Oh Notation", "Big Oh Identification"));
        prelims.insert(new Topic("The List Data Structure and ADT", "Project on Implementation of List ADT"));
        prelims.insert(new Topic("Singly, Doubly, and Circular Linked List", "Describing LinkedList Implementation"));

        // Populate Midterms
        midterms.insert(new Topic("The Stack and Queue Data Structures", "Task Name Here"));
        midterms.insert(new Topic("The Stack and Queue ADT", "Task Name Here"));
        midterms.insert(new Topic("Applications of the Queue", "Task Name Here"));
        midterms.insert(new Topic("The Tree Data Structures", "Task Name Here"));
        midterms.insert(new Topic("Huffman Coding - Application of the Tree Data Structure", "Task Name Here"));

        // Populate Finals
        finals.insert(new Topic("The Graph Data Structure", "Task Name Here"));
        finals.insert(new Topic("Graph Representation", "Task Name Here"));
        finals.insert(new Topic("Graph Search/Traversal", "Task Name Here"));
        finals.insert(new Topic("Hash Function and Table", "Task Name Here"));
        finals.insert(new Topic("Collision Handling", "Task Name Here"));

        course.insert(prelims);
        course.insert(midterms);
        course.insert(finals);

        return course;
    }

    private Course<Term<Topic>> populateCourse2() {
        Course<Term<Topic>> course = new Course<>("OPERATING SYSTEMS", "9343 - CS 212");

        Term<Topic> prelims = new Term<>("Prelims");
        Term<Topic> midterms = new Term<>("Midterms");
        Term<Topic> finals = new Term<>("Finals");

        // Populate Prelims
        prelims.insert(new Topic("Introduction to Operating Systems", "Task Name Here"));
        prelims.insert(new Topic("Process Management", "Task Name Here"));
        prelims.insert(new Topic("Memory Management", "Task Name Here"));
        prelims.insert(new Topic("File Systems and Storage Management", "Task Name Here"));
        prelims.insert(new Topic("I/O Systems and Device Management", "Task Name Here"));

        // Populate Midterms
        midterms.insert(new Topic("Process Synchronization", "Task Name Here"));
        midterms.insert(new Topic("CPU Scheduling and Multiprogramming", "Task Name Here"));
        midterms.insert(new Topic("Virtual Memory Management", "Task Name Here"));
        midterms.insert(new Topic("File System Implementation", "Task Name Here"));
        midterms.insert(new Topic("I/O Systems Optimization", "Task Name Here"));

        // Populate Finals
        finals.insert(new Topic("Process and Thread Management", "Task Name Here"));
        finals.insert(new Topic("Memory Protection and Security", "Task Name Here"));
        finals.insert(new Topic("Graph Search/Traversal", "Task Name Here"));
        finals.insert(new Topic("Security and Authentication", "Task Name Here"));
        finals.insert(new Topic("Virtualization and Cloud Computing", "Task Name Here"));

        course.insert(prelims);
        course.insert(midterms);
        course.insert(finals);

        return course;
    }

    private Course<Term<Topic>> populateCourse3() {
        Course<Term<Topic>> course = new Course<>("HUMAN COMPUTER INTERACTION", "9344 - CS 213");

        Term<Topic> prelims = new Term<>("Prelims");
        Term<Topic> midterms = new Term<>("Midterms");
        Term<Topic> finals = new Term<>("Finals");

        // Populate Prelims
        prelims.insert(new Topic("Introduction to Operating Systems", "Task Name Here"));
        prelims.insert(new Topic("Process Management", "Task Name Here"));
        prelims.insert(new Topic("Memory Management", "Task Name Here"));
        prelims.insert(new Topic("File Systems and Storage Management", "Task Name Here"));
        prelims.insert(new Topic("I/O Systems and Device Management", "Task Name Here"));

        // Populate Midterms
        midterms.insert(new Topic("Process Synchronization", "Task Name Here"));
        midterms.insert(new Topic("CPU Scheduling and Multiprogramming", "Task Name Here"));
        midterms.insert(new Topic("Virtual Memory Management", "Task Name Here"));
        midterms.insert(new Topic("File System Implementation", "Task Name Here"));
        midterms.insert(new Topic("I/O Systems Optimization", "Task Name Here"));

        // Populate Finals
        finals.insert(new Topic("Process and Thread Management", "Task Name Here"));
        finals.insert(new Topic("Memory Protection and Security", "Task Name Here"));
        finals.insert(new Topic("Graph Search/Traversal", "Task Name Here"));
        finals.insert(new Topic("Security and Authentication", "Task Name Here"));
        finals.insert(new Topic("Virtualization and Cloud Computing", "Task Name Here"));

        course.insert(prelims);
        course.insert(midterms);
        course.insert(finals);
        return course;
    }
    public Course<Term<Topic>> populateCourse4(){
        //FOR THE FOURTH COURSE:
        Course<Term<Topic>> course = new Course<>("SCIENCE, TECHNOLOGY AND SOCIETY" , "9345 - CS - GSTS");
        Term<Topic> prelims = new Term<>("Prelims");
        Term<Topic> midterms = new Term<>("Midterms");
        Term<Topic> finals = new Term<>("Finals");

        prelims.insert(new Topic("General Concepts and STS Historical Developments", "Task Name Here"));
        prelims.insert(new Topic("Intellectual Revolutions that Defined Society", "Task Name Here"));
        prelims.insert(new Topic("Science and Technology and Nation Building", "Task Name Here"));
        prelims.insert(new Topic("The Human Person Flourishing in Science and Technology", "Task Name Here"));

        midterms.insert(new Topic("STS and Human Condition: The GOod Life", "Task Name Here"));
        midterms.insert(new Topic("When Technology and Humanity Cross", "Task Name Here"));
        midterms.insert(new Topic("The Information Age", "Task Name Here"));

        finals.insert(new Topic("Biodiversity and Health Society", "Task Name Here"));
        finals.insert(new Topic("The Nanotechnology World", "Task Name Here"));
        finals.insert(new Topic("Genetic Engineering", "Task Name Here"));
        course.insert(prelims);
        course.insert(midterms);
        course.insert(finals);
        return course;
    }
}
