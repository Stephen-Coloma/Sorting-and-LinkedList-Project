package Project2.ReferenceClasses;

import Project2.LinkedListImplementation.DoublyLinkedList;

public class Course<Term> extends DoublyLinkedList<Term> {
    private String courseName;
    private String courseID;

    public Course(String courseName, String courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString(){
        return this.courseID + " (" + this.courseName + ")";
    }
    public Project2.ReferenceClasses.Term<Topic> getTerm(String termName) {
        for (int i = 0; i < getSize(); i++) {
            Project2.ReferenceClasses.Term<Topic> term = (Project2.ReferenceClasses.Term<Topic>) getElement(i);
            if (term.getTermName().equals(termName)) {
                return term;
            }
        }
        return null;
    }
}
