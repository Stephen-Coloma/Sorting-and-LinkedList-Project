package Project2.ReferenceClasses;

import Project2.LinkedListImplementation.DoublyLinkedList;

public class Term<Topic> extends DoublyLinkedList<Topic> {
    private String termName;

    public Term(String termName) {
        this.termName = termName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @Override
    public String toString(){
        return this.termName;
    }
}
