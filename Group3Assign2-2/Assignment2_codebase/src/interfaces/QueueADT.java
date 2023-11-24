package interfaces;

public interface QueueADT<E> {

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param element The element to be inserted
     */
    void enqueue(E element);

    /**
     * Removes and returns the front element from the queue.
     *
     * @return The front element of the queue
     * @throws java.util.NoSuchElementException If the queue is empty
     */
    E dequeue();

    /**
     * Retrieves, but does not remove, the front element of the queue.
     *
     * @return The front element of the queue
     * @throws java.util.NoSuchElementException If the queue is empty
     */
    E first();

    /**
     * Returns whether the queue is empty.
     *
     * @return True if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue
     */
    int size();
}