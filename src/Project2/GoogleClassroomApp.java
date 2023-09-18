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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private DoublyLinkedList<Course<Term<Topic>>> initialPopulation() {
        // Create and populate Course 1
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
        midterms.insert(new Topic("The Stack and Queue Data Structures", "Two-Stack Queue Implementation"));
        midterms.insert(new Topic("The Stack and Queue ADT", "Building a Stack and Queue Data Structure from Scratch"));
        midterms.insert(new Topic("Applications of the Queue", "Exploring Practical Applications of Queues"));
        midterms.insert(new Topic("The Tree Data Structures", "Implementing and Traversing Tree Structures"));
        midterms.insert(new Topic("Huffman Coding - Application of the Tree Data Structure", "Implementing Huffman Coding for Data Compression"));

        // Populate Finals
        finals.insert(new Topic("The Graph Data Structure", "Graph Basics: Implementation and Algorithms"));
        finals.insert(new Topic("Graph Representation", "Implementing Graph Representation"));
        finals.insert(new Topic("Graph Search/Traversal", "Graph Search and Traversal Challenge"));
        finals.insert(new Topic("Hash Function and Table", "Hash Function and Table Implementation "));
        finals.insert(new Topic("Collision Handling", "Handling Collisions in Hash Tables"));

        course.insert(prelims);
        course.insert(midterms);
        course.insert(finals);

        //adds the 1st course into the list
        courseList.insert(course);

        //Create and populate Course 2
        Course<Term<Topic>> course2 = new Course<>("OPERATING SYSTEMS", "9343 - CS 212");

        Term<Topic> prelims2 = new Term<>("Prelims");
        Term<Topic> midterms2 = new Term<>("Midterms");
        Term<Topic> finals2 = new Term<>("Finals");

        // Populate Prelims
        prelims2.insert(new Topic("Introduction to Operating Systems", "Read Chapter 1 and summarize key concepts."));
        prelims2.insert(new Topic("Process Management", "Implement a basic process scheduling algorithm in C."));
        prelims2.insert(new Topic("Memory Management", "Compare and contrast paging and segmentation in OS memory management."));
        prelims2.insert(new Topic("File Systems and Storage Management", "Create a file system structure diagram for a given scenario."));
        prelims2.insert(new Topic("I/O Systems and Device Management", "Write a program to demonstrate I/O operations in Java."));

// Populate Midterms
        midterms2.insert(new Topic("Process Synchronization", "Implement the producer-consumer problem using semaphores in C++."));
        midterms2.insert(new Topic("CPU Scheduling and Multiprogramming", "Analyze the performance of various CPU scheduling algorithms through simulation."));
        midterms2.insert(new Topic("Virtual Memory Management", "Explain the concept of demand paging and its advantages."));
        midterms2.insert(new Topic("File System Implementation", "Design and document the structure of a simple file system."));
        midterms2.insert(new Topic("I/O Systems Optimization", "Optimize file read and write operations in a given program."));

// Populate Finals
        finals2.insert(new Topic("Process and Thread Management", "Discuss the differences between processes and threads in terms of management and overhead."));
        finals2.insert(new Topic("Memory Protection and Security", "Present a case study on a real-world OS security breach and propose countermeasures."));
        finals2.insert(new Topic("Graph Search/Traversal", "Implement breadth-first search (BFS) and depth-first search (DFS) algorithms in Python."));
        finals2.insert(new Topic("Security and Authentication", "Design a secure authentication system for a cloud-based application."));
        finals2.insert(new Topic("Virtualization and Cloud Computing", "Explain the benefits and challenges of virtualization in cloud computing."));

        course2.insert(prelims2);
        course2.insert(midterms2);
        course2.insert(finals2);

        //adds the 2nd course in the courseList
        courseList.insert(course2);

        //create and populate course3
        Course<Term<Topic>> course3 = new Course<>("HUMAN COMPUTER INTERACTION", "9344 - CS 213");

        Term<Topic> prelims3 = new Term<>("Prelims");
        Term<Topic> midterms3 = new Term<>("Midterms");
        Term<Topic> finals3 = new Term<>("Finals");

        // Populate Prelims
        prelims3.insert(new Topic("Introduction to Operating Systems", "Read Chapter 1 and summarize key concepts"));
        prelims3.insert(new Topic("Process Management", "Implement a basic process scheduling algorithm in C"));
        prelims3.insert(new Topic("Memory Management", "Compare and contrast paging and segmentation in OS memory management"));
        prelims3.insert(new Topic("File Systems and Storage Management", "Create a file system structure diagram for a given scenario"));
        prelims3.insert(new Topic("I/O Systems and Device Management", "Optimize file read and write operations in a given program"));

        // Populate Midterms
        midterms3.insert(new Topic("Process Synchronization", "Implementing Process Synchronization Mechanisms"));
        midterms3.insert(new Topic("CPU Scheduling and Multiprogramming", "Designing CPU Scheduling Algorithms"));
        midterms3.insert(new Topic("Virtual Memory Management", "Develop a Virtual Memory Management Strategies"));
        midterms3.insert(new Topic("File System Implementation", "Creating a File System from Scratch"));
        midterms3.insert(new Topic("I/O Systems Optimization", "Optimizing I/O Systems for Performance"));

        // Populate Finals
        finals3.insert(new Topic("Process and Thread Management", "Efficient Process and Thread Management Implementation"));
        finals3.insert(new Topic("Memory Protection and Security", "Enhancing Memory Protection and Security Measures"));
        finals3.insert(new Topic("Graph Search/Traversal", "Implementation of Graph Search and Traversal Algorithms"));
        finals3.insert(new Topic("Security and Authentication", "Security and Authentication Project"));
        finals3.insert(new Topic("Virtualization and Cloud Computing", "Exploring Cloud Computing using Java    "));

        course3.insert(prelims3);
        course3.insert(midterms3);
        course3.insert(finals3);

        //adds the 3rd course into the list
        courseList.insert(course3);

        //create and populate course4
        Course<Term<Topic>> course4 = new Course<>("SCIENCE, TECHNOLOGY AND SOCIETY" , "9345 - CS - GSTS");
        Term<Topic> prelims4 = new Term<>("Prelims");
        Term<Topic> midterms4 = new Term<>("Midterms");
        Term<Topic> finals4 = new Term<>("Finals");

        //populate prelims
        prelims4.insert(new Topic("General Concepts and STS Historical Developments", "Task Name Here"));
        prelims4.insert(new Topic("Intellectual Revolutions that Defined Society", "Task Name Here"));
        prelims4.insert(new Topic("Science and Technology and Nation Building", "Task Name Here"));
        prelims4.insert(new Topic("The Human Person Flourishing in Science and Technology", "Task Name Here"));

        //populate midterms
        midterms4.insert(new Topic("STS and Human Condition: The GOod Life", "Task Name Here"));
        midterms4.insert(new Topic("When Technology and Humanity Cross", "Task Name Here"));
        midterms4.insert(new Topic("The Information Age", "Task Name Here"));


        //populate finals
        finals4.insert(new Topic("Biodiversity and Health Society", "Task Name Here"));
        finals4.insert(new Topic("The Nanotechnology World", "Task Name Here"));
        finals4.insert(new Topic("Genetic Engineering", "Task Name Here"));

        course4.insert(prelims4);
        course4.insert(midterms4);
        course4.insert(finals4);

        //adds the 4th course into the list
        courseList.insert(course4);

        return courseList;
    }
}
