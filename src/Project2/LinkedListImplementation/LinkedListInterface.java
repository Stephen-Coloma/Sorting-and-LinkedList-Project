package Project2.LinkedListImplementation;

public interface LinkedListInterface<E> {
    public int getSize();
    public boolean isEmpty();
    public int search(String data);
    public void clear();
    public void setHead(E data);
    public void setTail(E data);
    public void insert(E data);
    public void insertAtHead(E data);
    public void insertAtTail(E data);
    public void insertAtIndex(int index, E data);
    public E getElement(int index);
    public E getElement(E data);
    public void delete();
    public void delete(E data);
    public void deleteAtHead();
    public void deleteAtTail();
    public void deleteAtIndex(int index);
    public String toString();
}
