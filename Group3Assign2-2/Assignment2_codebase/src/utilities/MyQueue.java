package utilities;

import interfaces.QueueADT;


/**
 * @author Isaac, David, Jayden
 * */

/**
 * A queue implementation using a doubly linked list as the underlying data structure.
 * This class provides the basic operations of a queue such as enqueue, dequeue, and inspecting the first element.
 *
 * @param <E> the type of elements held in the queue
 */
public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;  // Underlying doubly linked list

    /**
     * Constructs an empty queue.
     */
    public MyQueue() {
        list = new MyDLL<>();
    }

    /**
     * Inserts the specified element into the queue.
     *
     * @param element the element to be added to the queue
     */
    @Override
    public void enqueue(E element) {
        list.addLast(element);  // Add element to the end of the list
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();  // Remove and return the first element of the list
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();  // Return the first element of the list
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if this queue contains no elements, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();  // Return true if the list is empty
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return list.size();  // Return the size of the list
    }
}
