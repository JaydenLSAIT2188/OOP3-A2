package utilities;

/**
 * @author Isaac, David, Jayden
 * */

/**
 * This class represents a doubly linked list and offers a variety of methods
 * for manipulating its elements. It includes methods for adding, removing,
 * and accessing elements from both the front and back of the list.
 *
 * @param <E> the type of elements held in the list
 */
public class MyDLL<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    /**
     * Constructs an empty MyDLL instance.
     */
    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param data the element to add
     */
    public void addFirst(E data) {
        MyDLLNode<E> newNode = new MyDLLNode<>(data, null, head);
        if (head != null) {
            head.setPrev(newNode);
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param data the element to add
     */
    public void addLast(E data) {
        MyDLLNode<E> newNode = new MyDLLNode<>(data, tail, null);
        if (tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element from the list.
     *
     * @return the data from the first element of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        E temp = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return temp;
    }

    /**
     * Removes and returns the last element from the list.
     *
     * @return the data from the last element of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        E temp = tail.getData();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        size--;
        return temp;
    }

    /**
     * Retrieves, but does not remove, the first element of the list.
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public E getFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return head.getData();
    }

    /**
     * Retrieves, but does not remove, the last element of the list.
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public E getLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return tail.getData();
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list contains no elements, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

}

