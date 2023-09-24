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
        this.setTitle("Enrolled Courses List");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the icon image for the taskbar
        String iconPath = "D:\\cs211_9342_mixandmatch\\src\\Project2\\GUI\\Icons\\COURSE ICON.png";
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private DoublyLinkedList<Course<Term<Topic>>> initialPopulation() {
        DoublyLinkedList<Course<Term<Topic>>> courseList = new DoublyLinkedList<>();

        // Create and populate Course 1: FOUNDATIONS OF SERVICE
        Course<Term<Topic>> course1 = new Course<>("FOUNDATIONS OF SERVICE", "7022 - NSTP-CWTS 1");

        Term<Topic> prelims1 = new Term<>("Prelims");
        Term<Topic> midterms1 = new Term<>("Midterms");
        Term<Topic> finals1 = new Term<>("Finals");

        // Populate Prelims for course1
        prelims1.insert(new Topic("Introduction to CWTS",
                "Discuss the evolution and significance of the Civil Welfare Training Service in the national context"));
        prelims1.insert(new Topic("Role of Youth in Nation Building",
                "Examine the integral role of the youth in building and uplifting communities"));
        prelims1.insert(new Topic("Basic First Aid",
                "Introduction to basic first aid techniques and their importance in community service"));
        prelims1.insert(new Topic("Environmental Awareness",
                "Understand the environmental challenges and the role of CWTS in promoting sustainable practices"));
        prelims1.insert(new Topic("Community Immersion",
                "Engage in a basic community immersion activity, understanding the grassroots level issues and concerns"));

        // Populate Midterms for course1
        midterms1.insert(new Topic("Community Assessment",
                "Methods and tools for assessing community needs and resources"));
        midterms1.insert(new Topic("Project Planning and Implementation",
                "Learn the basics of planning and executing community-based projects"));
        midterms1.insert(new Topic("Resource Mobilization",
                "Strategies for sourcing resources for community projects"));
        midterms1.insert(new Topic("Basic Counseling Skills",
                "Introduction to basic counseling techniques for community engagement"));
        midterms1.insert(new Topic("Stakeholder Collaboration",
                "Engage and collaborate with different stakeholders in the community for successful project outcomes"));

        // Populate Finals for course1
        finals1.insert(new Topic("Monitoring and Evaluation",
                "Techniques for monitoring and evaluating the progress and impact of community projects"));
        finals1.insert(new Topic("Documenting Community Projects",
                "Methods for documenting and reporting community engagements and projects"));
        finals1.insert(new Topic("Ethical Considerations in Community Service",
                "Understanding ethical dilemmas and responsibilities while serving in communities"));
        finals1.insert(new Topic("Leadership and Team Building",
                "Develop leadership skills and understand the dynamics of working in teams"));
        finals1.insert(new Topic("Reflection and Feedback",
                "Reflect on the experiences during the course and provide feedback for future improvements"));

        course1.insert(prelims1);
        course1.insert(midterms1);
        course1.insert(finals1);
        courseList.insert(course1);

        // Create and populate Course 2: PHYSICAL ACTIVITY TOWARDS HEALTH AND FITNESS
        Course<Term<Topic>> course2 = new Course<>("PHYSICAL ACTIVITY TOWARDS HEALTH & FITNESS", "7897 - FIT OA");

        Term<Topic> prelims2 = new Term<>("Prelims");
        Term<Topic> midterms2 = new Term<>("Midterms");
        Term<Topic> finals2 = new Term<>("Finals");

        // Populate Prelims for course2
        prelims2.insert(new Topic("Introduction to Outdoor Activities",
                "Discuss the significance of outdoor activities in promoting physical and mental well-being"));
        prelims2.insert(new Topic("Basic Outdoor Safety",
                "Understand safety protocols and necessary preparations for outdoor adventures"));
        prelims2.insert(new Topic("Hiking and Trekking",
                "Introduction to hiking techniques, trail etiquette, and benefits for health"));
        prelims2.insert(new Topic("Camping Basics",
                "Learn the foundational skills for camping, including setting up tents and camp cooking"));
        prelims2.insert(new Topic("Water-based Activities",
                "Introduction to activities like kayaking, canoeing, and their health benefits"));

        // Populate Midterms for course2
        midterms2.insert(new Topic("Mountain Climbing",
                "Basics of mountain climbing, equipment usage, and its impact on fitness"));
        midterms2.insert(new Topic("Survival Skills",
                "Learn basic wilderness survival techniques and their importance in outdoor adventures"));
        midterms2.insert(new Topic("Nature and Wildlife Conservation",
                "Understand the importance of preserving nature and wildlife during outdoor activities"));
        midterms2.insert(new Topic("Outdoor Group Activities",
                "Engage in group-based outdoor games and understand their role in team-building"));
        midterms2.insert(new Topic("Health Benefits of Nature Exposure",
                "Discuss the physical and mental health benefits of spending time in nature"));

        // Populate Finals for course2
        finals2.insert(new Topic("Adventure Sports",
                "Introduction to adventure sports like paragliding, rafting, and their health implications"));
        finals2.insert(new Topic("Outdoor Equipment and Gear",
                "Learn about various outdoor equipment, their uses, and maintenance"));
        finals2.insert(new Topic("Ethics of Outdoor Activities",
                "Understand the ethical considerations while engaging in outdoor and adventure activities"));
        finals2.insert(new Topic("Outdoor Activity Planning",
                "Plan and execute an outdoor activity, ensuring safety and maximum health benefits"));
        finals2.insert(new Topic("Reflection and Experience Sharing",
                "Reflect on the experiences during the course and share learnings with peers"));

        course2.insert(prelims2);
        course2.insert(midterms2);
        course2.insert(finals2);
        courseList.insert(course2);

        // Create and populate Course 3: DATA STRUCTURES
        Course<Term<Topic>> course3 = new Course<>("DATA STRUCTURES", "9342 - CS 211");

        Term<Topic> prelims3 = new Term<>("Prelims");
        Term<Topic> midterms3 = new Term<>("Midterms");
        Term<Topic> finals3 = new Term<>("Finals");

        // Populate Prelims for course3
        prelims3.insert(new Topic("Abstract Data Types", "Explaining ADT"));
        prelims3.insert(new Topic("Algorithm Complexity", "Technical Paper"));
        prelims3.insert(new Topic("Big Oh Notation", "Big Oh Identification"));
        prelims3.insert(new Topic("The List Data Structure and ADT",
                "Project on Implementation of List ADT"));
        prelims3.insert(new Topic("Singly, Doubly, and Circular Linked List",
                "Describing LinkedList Implementation"));

        // Populate Midterms for course3
        midterms3.insert(new Topic("The Stack and Queue Data Structures",
                "Two-Stack Queue Implementation"));
        midterms3.insert(new Topic("The Stack and Queue ADT",
                "Building a Stack and Queue Data Structure from Scratch"));
        midterms3.insert(new Topic("Applications of the Queue",
                "Exploring Practical Applications of Queues"));
        midterms3.insert(new Topic("The Tree Data Structures",
                "Implementing and Traversing Tree Structures"));
        midterms3.insert(new Topic("Huffman Coding - Application of the Tree Data Structure",
                "Implementing Huffman Coding for Data Compression"));

        // Populate Finals for course3
        finals3.insert(new Topic("The Graph Data Structure",
                "Graph Basics: Implementation and Algorithms"));
        finals3.insert(new Topic("Graph Representation", "Implementing Graph Representation"));
        finals3.insert(new Topic("Graph Search/Traversal", "Graph Search and Traversal Challenge"));
        finals3.insert(new Topic("Hash Function and Table", "Hash Function and Table Implementation "));
        finals3.insert(new Topic("Collision Handling", "Handling Collisions in Hash Tables"));

        course3.insert(prelims3);
        course3.insert(midterms3);
        course3.insert(finals3);
        courseList.insert(course3);

        // Create and populate Course 4: OPERATING SYSTEMS
        Course<Term<Topic>> course4 = new Course<>("OPERATING SYSTEMS", "9343A - CS 212");

        Term<Topic> prelims4 = new Term<>("Prelims");
        Term<Topic> midterms4 = new Term<>("Midterms");
        Term<Topic> finals4 = new Term<>("Finals");

        // Populate Prelims for course4
        prelims4.insert(new Topic("Introduction to Operating Systems", "Read Chapter 1 and summarize key concepts."));
        prelims4.insert(new Topic("Process Management", "Implement a basic process scheduling algorithm in C."));
        prelims4.insert(new Topic("Memory Management", "Compare and contrast paging and segmentation in OS memory management."));
        prelims4.insert(new Topic("File Systems and Storage Management", "Create a file system structure diagram for a given scenario."));
        prelims4.insert(new Topic("I/O Systems and Device Management", "Write a program to demonstrate I/O operations in Java."));

        // Populate Midterms for course4
        midterms4.insert(new Topic("Process Synchronization", "Implement the producer-consumer problem using semaphores in C++."));
        midterms4.insert(new Topic("CPU Scheduling and Multiprogramming", "Analyze the performance of various CPU scheduling algorithms through simulation."));
        midterms4.insert(new Topic("Virtual Memory Management", "Explain the concept of demand paging and its advantages."));
        midterms4.insert(new Topic("File System Implementation", "Design and document the structure of a simple file system."));
        midterms4.insert(new Topic("I/O Systems Optimization", "Optimize file read and write operations in a given program."));

        // Populate Finals for course4
        finals4.insert(new Topic("Process and Thread Management", "Discuss the differences between processes and threads in terms of management and overhead."));
        finals4.insert(new Topic("Memory Protection and Security", "Present a case study on a real-world OS security breach and propose countermeasures."));
        finals4.insert(new Topic("Security and Authentication", "Design a secure authentication system for a cloud-based application."));
        finals4.insert(new Topic("Virtualization and Cloud Computing", "Explain the benefits and challenges of virtualization in cloud computing."));

        course4.insert(prelims4);
        course4.insert(midterms4);
        course4.insert(finals4);
        courseList.insert(course4);

        // Create and populate Course 5: HUMAN COMPUTER INTERACTION
        Course<Term<Topic>> course5 = new Course<>("HUMAN COMPUTER INTERACTION", "9344 - CS 213");

        Term<Topic> prelims5 = new Term<>("Prelims");
        Term<Topic> midterms5 = new Term<>("Midterms");
        Term<Topic> finals5 = new Term<>("Finals");

        // Populate Prelims for course5
        prelims5.insert(new Topic("Introduction to Human Computer Interaction", "Discuss the evolution of Human-Computer Interaction (HCI) " + "and its impact on modern design practices"));
        prelims5.insert(new Topic("Design of Everyday Things", "Examine key principles of user-centered design and their real-world applications"));
        prelims5.insert(new Topic("Errors", "Explore common usability errors in interface design and propose strategies " + "for error prevention and recovery"));
        prelims5.insert(new Topic("Interface Design Principles", "Discuss foundational principles of interface design, providing practical examples " + "from user interfaces in use today"));
        prelims5.insert(new Topic("Usability Evaluation", "Perform a usability evaluation for a software application, identify usability issues, " + "and suggest actionable improvements"));

        // Populate Midterms for course5
        midterms5.insert(new Topic("Introduction to Information Architecture", "Define information architecture and illustrate its role in designing intuitive websites"));
        midterms5.insert(new Topic("Interaction Design", "Prototype creation for a mobile app"));
        midterms5.insert(new Topic("User Interface Prototyping", "Develop both low-fidelity and high-fidelity prototypes for a web application"));
        midterms5.insert(new Topic("Mobile and Responsive Design", "Analyze the complexities of designing"));
        midterms5.insert(new Topic("Information Visualization", "Visualize a dataset using appropriate techniques and interpret"));

        // Populate Finals for course5
        finals5.insert(new Topic("Accessibility and Inclusive Design", "Evaluate the accessibility of a websites or applications and propose enhancements"));
        finals5.insert(new Topic("User Experience (UX) Design", "Conduct user research to identify user needs and preferences for a chosen product"));
        finals5.insert(new Topic("Ethical Considerations in HCI", "Delve into ethical dilemmas tied to user data privacy in digital products " + "and provide ethical guidelines for responsible design"));
        finals5.insert(new Topic("Future Trends in HCI", "Research emerging technologies and analyze their potential impacts on the field"));
        finals5.insert(new Topic("Cognitive Psychology in UX Design", "Apply cognitive psychology principles to assess the user experience"));

        course5.insert(prelims5);
        course5.insert(midterms5);
        course5.insert(finals5);
        courseList.insert(course5);

        // ... [previous courses' code]

// Create and populate Course 6: SCIENCE, TECHNOLOGY, AND SOCIETY
        Course<Term<Topic>> course6 = new Course<>("SCIENCE, TECHNOLOGY, AND SOCIETY", "9345 - GSTS");

        Term<Topic> prelims6 = new Term<>("Prelims");
        Term<Topic> midterms6 = new Term<>("Midterms");
        Term<Topic> finals6 = new Term<>("Finals");

// Populate Prelims for course6
        prelims6.insert(new Topic("General Concepts and STS Historical Developments", "Present key historical developments in the field of STS."));
        prelims6.insert(new Topic("Intellectual Revolutions that Defined Society", "Write an essay on how intellectual revolutions have shaped society."));
        prelims6.insert(new Topic("Science and Technology and Nation Building", "Analyze the role of science and technology in the process of nation-building."));
        prelims6.insert(new Topic("The Human Person Flourishing in Science and Technology", "Discuss the ethical considerations of technological advancements"));

// Populate Midterms for course6
        midterms6.insert(new Topic("STS and Human Condition: The Good Life", "Explore the concept of 'the good life' in the context of STS"));
        midterms6.insert(new Topic("When Technology and Humanity Cross", "Examine ethical dilemmas that arise when technology and humanity intersect."));
        midterms6.insert(new Topic("The Information Age", "Research and present a case study on the impact of the information age on society."));

// Populate Finals for course6
        finals6.insert(new Topic("Biodiversity and Health Society", "Investigate the relationship between biodiversity and public health and propose solutions."));
        finals6.insert(new Topic("The Nanotechnology World", "Summarize recent advancements in nanotechnology and their potential applications."));
        finals6.insert(new Topic("Genetic Engineering", "Discuss the ethical and societal implications of genetic engineering " + "and gene editing technologies."));

        course6.insert(prelims6);
        course6.insert(midterms6);
        course6.insert(finals6);
        courseList.insert(course6);

// Create and populate Course 7: READING VISUAL ART
        Course<Term<Topic>> course7 = new Course<>("READING VISUAL ART", "9346 - GRVA");

        Term<Topic> prelims7 = new Term<>("Prelims");
        Term<Topic> midterms7 = new Term<>("Midterms");
        Term<Topic> finals7 = new Term<>("Finals");

// Populate Prelims for course7
        prelims7.insert(new Topic("Introduction to Visual Arts", "Discuss the fundamental elements and principles of visual arts."));
        prelims7.insert(new Topic("Historical Evolution of Visual Arts", "Trace the transformation of visual arts from ancient to modern times."));
        prelims7.insert(new Topic("Visual Arts and Cultural Identity", "Examine how visual arts represent and shape cultural identities across different societies."));
        prelims7.insert(new Topic("Art Criticism and Interpretation", "Learn the techniques of critiquing and interpreting various forms of visual arts."));

// Populate Midterms for course7
        midterms7.insert(new Topic("Techniques in Visual Arts", "Explore different techniques and mediums used in visual arts, from traditional to digital."));
        midterms7.insert(new Topic("Visual Arts in Digital Age", "Investigate the impact of digital technology on the evolution and consumption of visual arts."));
        midterms7.insert(new Topic("Art Movements and Their Influence", "Study various art movements and their influence on contemporary visual arts."));

// Populate Finals for course7
        finals7.insert(new Topic("Public Art and Society", "Analyze the role of public art in society and its influence on public spaces and community engagement."));
        finals7.insert(new Topic("Careers in Visual Arts", "Discover various career paths in the field of visual arts and what they entail."));
        finals7.insert(new Topic("Art and Activism", "Discuss how visual arts have been used as a tool for social and political activism throughout history."));

        course7.insert(prelims7);
        course7.insert(midterms7);
        course7.insert(finals7);
        courseList.insert(course7);

        // Create and populate Course 8: CATHOLIC FOUNDATION OF MISSION
        Course<Term<Topic>> course8 = new Course<>("CATHOLIC FOUNDATION OF MISSION", "9347 - CFE 103");

        Term<Topic> prelims8 = new Term<>("Prelims");
        Term<Topic> midterms8 = new Term<>("Midterms");
        Term<Topic> finals8 = new Term<>("Finals");

        // Populate Prelims for course8
        prelims8.insert(new Topic("Introduction to Catholic Mission", "Discuss the essence and importance of the Catholic mission in the context of faith."));
        prelims8.insert(new Topic("Historical Foundations of Catholic Mission", "Explore the history and evolution of the Catholic Church's mission efforts."));
        prelims8.insert(new Topic("Biblical Foundations of Mission", "Examine Biblical texts that emphasize the importance of mission in Catholicism."));
        prelims8.insert(new Topic("Role of Laity in Mission", "Understand the role and responsibilities of the laity in the mission of the Church."));
        prelims8.insert(new Topic("Mission and Social Justice", "Discuss the Church's stance on social justice and its correlation with the Catholic mission"));

        // Populate Midterms for course8
        midterms8.insert(new Topic("Missionary Saints and Martyrs", "Study the lives of saints and martyrs who played pivotal roles in mission work"));
        midterms8.insert(new Topic("Contemporary Challenges in Mission", "Understand the modern-day challenges faced by missionaries and the Church's mission efforts"));
        midterms8.insert(new Topic("Ecclesiology and Mission", "Explore the Church's teachings and structure in relation to its mission"));
        midterms8.insert(new Topic("Evangelization and Dialogue", "Learn about the principles of evangelization and the importance of dialogue in mission work"));
        midterms8.insert(new Topic("Missionary Spirituality", "Deepen the understanding of the spirituality that underpins missionary work"));

        // Populate Finals for course8
        finals8.insert(new Topic("Mission and Interfaith Relations", "Discuss the Church's stance on interfaith relations and its implications for mission work"));
        finals8.insert(new Topic("Missionary Training and Formation", "Understand the process and importance of training and forming individuals for mission"));
        finals8.insert(new Topic("Ethics of Mission Work", "Delve into the ethical considerations and responsibilities associated with mission work"));
        finals8.insert(new Topic("Future of Catholic Mission", "Reflect on the potential future challenges and opportunities for the Church's mission efforts"));
        finals8.insert(new Topic("Reflection and Personal Mission", "Reflect on personal experiences and understand one's role in the broader Catholic mission"));

        course8.insert(prelims8);
        course8.insert(midterms8);
        course8.insert(finals8);
        courseList.insert(course8);

        // Return the course list
        return courseList;
    }
} // end of GoogleClassroomApp class
