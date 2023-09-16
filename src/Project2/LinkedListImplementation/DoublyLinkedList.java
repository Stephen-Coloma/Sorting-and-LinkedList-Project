package Project2.LinkedListImplementation;

import java.util.NoSuchElementException;

/**
 *  DoublyLinkedList class is the template to make doubly-linked list. <br>
 *  Methods:
 *  1. getSize()
 *  2. isEmpty()
 *  3. search(E data)
 *  4. clear()
 *  5. setHead(E data)
 *  6. setTail(E data)
 *  7. insert(E data)
 *  8. insertAtHead(E data)
 *  9. insertAtTail(E data)
 *  10. insertAtIndex(int index, E data)
 *  11. getElement(int index)
 *  12. getElement(E data)
 *  13. delete()
 *  14. delete(E data)
 *  15. deleteAtHead()
 *  16.deleteAtTail()
 *  17. deleteAtIndex(int index)
 *  18. toString()
 *
 *  @author  Stephen Coloma
 */
public class DoublyLinkedList<E> implements LinkedListInterface<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public int search(String element) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if (element.equals(current.getData())) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1; // Element not found
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void setHead(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        }else if(size == 1) {
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head.getNext()); //temp point to second element
            head.getNext().setPrev(newNode); //second element point back to temp
            this.head = newNode;
        }
    }

    @Override
    public void setTail(E data) {
        Node<E> newNode = new Node<>(data);

        if (this.tail == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        }else if(size == 1) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            Node<E> current = this.tail.getPrev();
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    @Override
    public void insert(E data){
        Node<E> newNode = new Node<>(data);

        if (tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
        }

        size++;
    }

    @Override
    public void insertAtHead(E data) {
        Node<E> newNode = new Node<>(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head); //newNOde points to head
            this.head.setPrev(newNode);//head points to newNOde
            this.head = newNode;
        }

        size++;
    }

    @Override
    public void insertAtTail(E data) {
        Node<E> newNode = new Node<>(data);

        if (tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
        }

        size++;
    }

    @Override
    public void insertAtIndex(int index, E data) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Cannot add the element: Index " + index + " is out of bounds");
        }

        Node<E> newNode = new Node<>(data);

        if (index == 0) {
            // Insert at the head
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;

            if (tail == null) {
                // If the list was empty, update the tail
                tail = newNode;
            }
        } else if (index == this.size) {
            // Insert at the tail
            newNode.setPrev(tail);
            if (tail != null) {
                tail.setNext(newNode);
            }
            tail = newNode;

            if (head == null) {
                // If the list was empty, update the head
                head = newNode;
            }
        } else {
            // Insert in the middle
            int counterFromHead = 0;
            Node<E> current = head;

            while (counterFromHead < index) {
                current = current.getNext();
                counterFromHead++;
            }

            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }

        size++;
    }

    @Override
    public E getElement(int index) throws NoSuchElementException{
        if (index < 0 || index>=this.size){
            throw new NoSuchElementException("No such element was found");
        } else if (index >= (size/2)) { //traverse from tail
            int counterFromTail = size-1;

            Node<E> current = tail;
            while (counterFromTail != index){
                current = current.getPrev(); //traverse from tail backwards
                counterFromTail--;
            }
            return current.getData();
        }else { //traverse from head
            int counterFromHead = 0;

            Node<E> current = head;
            while (counterFromHead != index){
                current = current.getNext(); //traverse from tail backwards
                counterFromHead++;
            }
            return current.getData();
        }
    }

    @Override
    public E getElement(E data) throws NoSuchElementException{
        Node<E> current = head;

        while (current != null) {
            if (data.equals(current.getData())) {
                return current.getData(); // Found the element, return it
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No such element was found");
    }

    @Override
    public void delete() throws NoSuchElementException{
        if (tail == null){//0 elements
            throw new NoSuchElementException("There is no current element at Tail");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        }else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
        }
    }

    @Override
    public void delete(E data) throws NoSuchElementException{
        if (this.isEmpty()){
            throw new NoSuchElementException("The list is empty");
        } else if (size == 1) {
            if (data.equals(this.head.getData())){
                this.head = null;
                this.tail = null;
                size--;
            }else throw new NoSuchElementException("Element not found in the list");
        }else {
            Node<E> current = head;
            if (data.equals(head.getData())){
                head = current.getNext();
                head.setPrev(null);
                size--;
                return;
            }
            while (current != null){
                if (data.equals(current.getData())){
                    Node<E> prevNode = current.getPrev();
                    Node<E> nextNode = current.getNext();

                    if (prevNode != null) {
                        prevNode.setNext(nextNode);
                    }
                    if (nextNode != null) {
                        nextNode.setPrev(prevNode);
                    } else {
                        // If the deleted node is the tail, update the tail
                        tail = prevNode;
                    }
                    size--;
                    return;
                }
                current = current.getNext();
            }

            throw new NoSuchElementException("Element not found in the list");
        }
    }


    @Override
    public void deleteAtHead() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("There is no current element at Head");
        } else if (size == 1) {
            head =null;
            tail=null;
            size--;
        }else {
            head.getNext().setPrev(null);
            head = head.getNext();
            size--;
        }
    }

    @Override
    public void deleteAtTail() {
        if (tail == null){//0 elements
            throw new NoSuchElementException("There is no current element at Tail");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        }else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
        }
    }

    @Override
    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("Cannot add the element: Index " + index + " is out of bounds");
        }else if(index == 0){
            deleteAtHead();
        }else if (index == this.size-1) {
            deleteAtTail();
        }else {
            if (index >= (size / 2)) { //a,b,c,d,e,f  5 size, index 3.
                int counterFromTail = size - 1;

                Node<E> current = tail;
                while (counterFromTail != index) {
                    current = current.getPrev(); //traverse from tail backwards
                    counterFromTail--;
                }
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            } else {
                int counterFromHead = 0;

                Node<E> current = head;
                while (counterFromHead != index) {
                    current = current.getNext(); //traverse from tail backwards
                    counterFromHead++;
                }
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
            size--;
        }
    }

    @Override
    public String toString(){
        if (head == null){
            return "null";
        }else {
            Node<E> current = head;

            String temp = "null <--> " + current.toString();

            while (current.getNext() != null){
                temp += " <--> " + current.getNext().toString() ;
                current = current.getNext();
            }

            temp += " <--> null";

            return temp;
        }
    }
}


