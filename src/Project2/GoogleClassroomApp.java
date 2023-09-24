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
        //initial population of Courses, Terms, and Topics
        courseList = initialPopulation();
        this.setContentPane(new CourseListPage(courseList));
        this.setTitle("Enrolled Courses List");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the icon image for the taskbar
        String iconPath = "D:\\cs211_9342_mixandmatch\\src\\Project2\\GUI\\Icons\\COURSE ICON.jpg";
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private DoublyLinkedList<Course<Term<Topic>>> initialPopulation() {
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

        // Create and populate Course 2: PHYSICAL ACTIVITY TOWARDS HEALTH AND FITNESS (OUTDOOR AND ADVENTURE ACTIVITIES)
        Course<Term<Topic>> course2 = new Course<>("PHYSICAL ACTIVITY TOWARDS HEALTH AND FITNESS (OUTDOOR AND ADVENTURE ACTIVITIES)", "7897 - FIT OA");
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
        Course<Term<Topic>> course3 = new Course<>("DATA STRUCTURES", "9342A - CS 211");
        Term<Topic> prelims3 = new Term<>("Prelims");
        Term<Topic> midterms3 = new Term<>("Midterms");
        Term<Topic> finals3 = new Term<>("Finals");

        // Populate Prelims for course3
        prelims3.insert(new Topic("Introduction to Data Structures",
                "Overview of different types of data structures and their significance"));
        prelims3.insert(new Topic("Arrays and Strings",
                "Study of linear data structures and their implementations"));
        prelims3.insert(new Topic("Linked Lists",
                "Introduction to singly and doubly linked lists"));
        prelims3.insert(new Topic("Stacks and Queues",
                "Understanding of LIFO and FIFO data structures and their applications"));
        prelims3.insert(new Topic("Recursion",
                "Concept of recursion, its applications, and related problems"));

        // Populate Midterms for course3
        midterms3.insert(new Topic("Trees",
                "Introduction to binary trees, BSTs, AVL trees, and their operations"));
        midterms3.insert(new Topic("Heaps",
                "Study of heap data structure and priority queue"));
        midterms3.insert(new Topic("Graphs",
                "Introduction to graph data structures, representations, and traversal methods"));
        midterms3.insert(new Topic("Hashing",
                "Understanding of hashing, hash functions, and collision resolution techniques"));
        midterms3.insert(new Topic("Dynamic Programming",
                "Introduction to dynamic programming, its applications, and problem-solving"));

        // Populate Finals for course3
        finals3.insert(new Topic("Search Algorithms",
                "Study of linear search, binary search, and other related algorithms"));
        finals3.insert(new Topic("Sort Algorithms",
                "Introduction to bubble sort, insertion sort, quicksort, and others"));
        finals3.insert(new Topic("Advanced Data Structures",
                "Study of trie, disjoint set, and other advanced data structures"));
        finals3.insert(new Topic("Space and Time Complexity",
                "Analysis of algorithms, Big O notation, and performance optimization"));
        finals3.insert(new Topic("Real-world Applications",
                "Applications of data structures in real-world scenarios and problem-solving"));

        course3.insert(prelims3);
        course3.insert(midterms3);
        course3.insert(finals3);
        courseList.insert(course3);

        // Create and populate Course 4: DATA STRUCTURES LAB
        Course<Term<Topic>> course4 = new Course<>("DATA STRUCTURES (LAB)", "9342B - CS 211L");
        Term<Topic> prelims4 = new Term<>("Prelims");
        Term<Topic> midterms4 = new Term<>("Midterms");
        Term<Topic> finals4 = new Term<>("Finals");

        // Populate Prelims for course4
        prelims4.insert(new Topic("Introduction to Lab Environment", "Setting up the lab environment and tools"));
        prelims4.insert(new Topic("Hands-on Linked Lists", "Implementing singly and doubly linked lists"));
        prelims4.insert(new Topic("Stacks and Queues Lab", "Implementing and testing stack and queue data structures"));
        prelims4.insert(new Topic("Recursion Lab", "Solving problems using recursion and debugging"));
        prelims4.insert(new Topic("Complexity Analysis", "Practical tasks to understand and analyze algorithm complexity"));

        // Populate Midterms for course4
        midterms4.insert(new Topic("Trees Lab", "Implementing binary trees and AVL trees"));
        midterms4.insert(new Topic("Heaps Lab Session", "Implementing and testing heap operations"));
        midterms4.insert(new Topic("Graphs Lab", "Implementing graph data structures and traversal algorithms"));
        midterms4.insert(new Topic("Hashing Lab", "Implementing hash tables and resolving collisions"));
        midterms4.insert(new Topic("Dynamic Programming Lab", "Solving problems using dynamic programming techniques"));

        // Populate Finals for course4
        finals4.insert(new Topic("Search Algorithms Lab", "Implementing and testing various search algorithms"));
        finals4.insert(new Topic("Sort Algorithms Lab", "Implementing and comparing various sorting algorithms"));
        finals4.insert(new Topic("Advanced Structures Lab", "Hands-on tasks with tries, disjoint sets, and more"));
        finals4.insert(new Topic("Real-world Data Structures", "Applying data structures to solve real-world problems"));
        finals4.insert(new Topic("Final Lab Project", "A cumulative project encompassing topics from the entire term"));

        course4.insert(prelims4);
        course4.insert(midterms4);
        course4.insert(finals4);
        courseList.insert(course4);

        // Create and populate Course 5: SCIENCE, TECHNOLOGY, AND SOCIETY
        Course<Term<Topic>> course5 = new Course<>("SCIENCE, TECHNOLOGY, AND SOCIETY", "9345 - GSTS");
        Term<Topic> prelims5 = new Term<>("Prelims");
        Term<Topic> midterms5 = new Term<>("Midterms");
        Term<Topic> finals5 = new Term<>("Finals");

        // Populate Prelims for course5
        prelims5.insert(new Topic("STS Introduction", "Understanding the interplay between science, technology, and society"));
        prelims5.insert(new Topic("Historical Overview", "Exploring the evolution of science and technology"));
        prelims5.insert(new Topic("Technological Revolutions", "The impact of various technological revolutions on society"));
        prelims5.insert(new Topic("Ethics in Technology", "Understanding the ethical implications of modern technologies"));
        prelims5.insert(new Topic("Science and Policy", "The role of science in shaping public policies"));

        // Populate Midterms for course5
        midterms5.insert(new Topic("Environmental Technology", "The role of technology in environmental conservation"));
        midterms5.insert(new Topic("Health and Technology", "Modern healthcare technologies and their societal impacts"));
        midterms5.insert(new Topic("Information Age", "Exploring the societal effects of the information revolution"));
        midterms5.insert(new Topic("Science, Tech, and War", "The application and implications of tech in warfare"));
        midterms5.insert(new Topic("Space Exploration", "The societal and technological aspects of exploring space"));

        // Populate Finals for course5
        finals5.insert(new Topic("Artificial Intelligence", "Exploring the societal implications of AI"));
        finals5.insert(new Topic("Genetic Engineering", "The science, ethics, and societal aspects of genetic engineering"));
        finals5.insert(new Topic("Future of Transportation", "Emerging transportation technologies and their potential impacts"));
        finals5.insert(new Topic("Energy Solutions", "Future technologies for sustainable energy"));
        finals5.insert(new Topic("STS Project Presentation", "Students present a project on a relevant STS topic"));

        course5.insert(prelims5);
        course5.insert(midterms5);
        course5.insert(finals5);
        courseList.insert(course5);

        // Create and populate Course 6: READING VISUAL ART
        Course<Term<Topic>> course6 = new Course<>("READING VISUAL ART", "9346 - GRVA");
        Term<Topic> prelims6 = new Term<>("Prelims");
        Term<Topic> midterms6 = new Term<>("Midterms");
        Term<Topic> finals6 = new Term<>("Finals");

        // Populate Prelims for course6
        prelims6.insert(new Topic("Visual Arts Overview", "Introduction to various forms of visual arts"));
        prelims6.insert(new Topic("Art and History", "Understanding art in various historical contexts"));
        prelims6.insert(new Topic("Art Techniques", "Exploring different techniques used in creating art"));
        prelims6.insert(new Topic("Modern Art", "Understanding the evolution and characteristics of modern art"));
        prelims6.insert(new Topic("Art Criticism", "Techniques and methodologies for critiquing art"));

        // Populate Midterms for course6
        midterms6.insert(new Topic("Photography as Art", "Exploring photography as a form of visual art"));
        midterms6.insert(new Topic("Digital Art", "Understanding the tools and techniques for creating digital art"));
        midterms6.insert(new Topic("Public Art", "Exploring the role and impact of art in public spaces"));
        midterms6.insert(new Topic("Art and Politics", "How art has been used as a tool for political expression"));
        midterms6.insert(new Topic("Art Movements", "Exploring various art movements and their characteristics"));

        // Populate Finals for course6
        finals6.insert(new Topic("Art and Technology", "The impact of technology on the creation and consumption of art"));
        finals6.insert(new Topic("Interactive Art", "Exploring art that requires viewer interaction"));
        finals6.insert(new Topic("Art Installations", "Understanding the design and impact of art installations"));
        finals6.insert(new Topic("Art and Society", "Exploring the role of art in shaping and reflecting societal values"));
        finals6.insert(new Topic("Portfolio Presentation", "Students present a portfolio of their art critiques"));

        course6.insert(prelims6);
        course6.insert(midterms6);
        course6.insert(finals6);
        courseList.insert(course6);

        // Create and populate Course 7: PHYSICAL ACTIVITY TOWARDS HEALTH AND FITNESS (OUTDOOR AND ADVENTURE ACTIVITIES)
        Course<Term<Topic>> course7 = new Course<>("PHYSICAL ACTIVITY TOWARDS HEALTH AND FITNESS (OUTDOOR AND ADVENTURE ACTIVITIES)", "7897 - FIT OA");
        Term<Topic> prelims7 = new Term<>("Prelims");
        Term<Topic> midterms7 = new Term<>("Midterms");
        Term<Topic> finals7 = new Term<>("Finals");

        // Populate Prelims for course7
        prelims7.insert(new Topic("Introduction to Physical Activity", "Understanding the importance of physical activity for health"));
        prelims7.insert(new Topic("Basic Outdoor Safety", "Safety protocols and preparations for outdoor activities"));
        prelims7.insert(new Topic("Hiking Basics", "Introduction to hiking and its health benefits"));
        prelims7.insert(new Topic("Camping Essentials", "Skills and knowledge needed for camping"));
        prelims7.insert(new Topic("Water Activities", "Exploring activities like kayaking and swimming"));

        // Populate Midterms for course7
        midterms7.insert(new Topic("Mountain Climbing Basics", "Introduction to mountain climbing and its health implications"));
        midterms7.insert(new Topic("Survival Skills", "Learning basic wilderness survival techniques"));
        midterms7.insert(new Topic("Conservation Ethics", "The importance of nature conservation during outdoor activities"));
        midterms7.insert(new Topic("Group Activities", "Engaging in group-based outdoor activities"));
        midterms7.insert(new Topic("Benefits of Outdoor Activities", "Physical and mental health benefits of engaging in outdoor activities"));

        // Populate Finals for course7
        finals7.insert(new Topic("Adventure Sports Introduction", "Exploring adventure sports like paragliding and rafting"));
        finals7.insert(new Topic("Equipment Knowledge", "Understanding various outdoor equipment and their maintenance"));
        finals7.insert(new Topic("Ethical Outdoor Activities", "Engaging in outdoor activities responsibly"));
        finals7.insert(new Topic("Planning Outdoor Activities", "Steps to plan and execute a safe outdoor adventure"));
        finals7.insert(new Topic("Reflection and Experience Sharing", "Sharing experiences and lessons learned from outdoor activities"));

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
        prelims8.insert(new Topic("Introduction to Catholic Mission", "Understanding the essence of the Catholic mission"));
        prelims8.insert(new Topic("Historical Overview of Missions", "Tracing the history of Catholic missions"));
        prelims8.insert(new Topic("Biblical Foundations", "Exploring Biblical teachings on missions"));
        prelims8.insert(new Topic("Role of Laity in Missions", "The responsibilities of laypersons in the Church's mission"));
        prelims8.insert(new Topic("Mission and Social Justice", "How missions promote justice and societal well-being"));

        // Populate Midterms for course8
        midterms8.insert(new Topic("Notable Missionaries", "Learning about significant figures in Catholic missionary work"));
        midterms8.insert(new Topic("Modern Challenges in Missions", "Understanding contemporary issues faced in missions"));
        midterms8.insert(new Topic("Ecclesiology and Mission", "The role of Church teachings in guiding missions"));
        midterms8.insert(new Topic("Evangelization Techniques", "Methods and approaches for spreading the Gospel"));
        midterms8.insert(new Topic("Missionary Spirituality", "The spiritual foundation of mission work"));

        // Populate Finals for course8
        finals8.insert(new Topic("Interfaith Dialogue", "Engaging in respectful dialogue with members of other religions"));
        finals8.insert(new Topic("Missionary Training", "The process of preparing individuals for mission work"));
        finals8.insert(new Topic("Ethics in Missions", "Navigating the ethical challenges in missionary activities"));
        finals8.insert(new Topic("Future of Missions", "Contemplating the evolving nature of missionary work in the modern world"));
        finals8.insert(new Topic("Personal Mission Reflection", "Reflecting on one's personal mission and calling within the Church"));

        course8.insert(prelims8);
        course8.insert(midterms8);
        course8.insert(finals8);
        courseList.insert(course8);

        // Return the populated course list
        return courseList;
    }
} // end of GoogleClassroomApp class
