package utilities;

import java.util.NoSuchElementException;

public interface QueueADT<E> {
	/**
	 * Pushes toAdd object to the end of the queue.
	 * Preconditions: A valid QueueADT object exists, and an object to be pushed is supplied.
	 * Postconditions: toAdd is added to the end of the queue.
	 * @param toAdd object to be added to the end of the queue.
	 * @return true if toAdd was enqueued, false otherwise.
	 * @throws NullPointerException if toAdd is null.
	 */
	boolean enqueue(E toAdd) throws NullPointerException;
	
	/**
	 * Removes and returns the first element from the queue.
	 * Preconditions: A valid QueueADT object exists, and the queue object is not empty.
	 * Postconditions: The first element from the queue is removed and returned.
	 * @return the first element from the queue.
	 * @throws NoSuchElementException when the queue is empty.
	 */
	E dequeue() throws NoSuchElementException;
	
	/**
	 * Inspects and returns the first element from the queue without mutating the queue.
	 * Preconditions: A valid QueueADT object exists, and the queue object is not empty.
	 * Postconditions: The first element from the queue is returned.
	 * @return the first element from the queue.
	 * @throws NoSuchElementException when the queue is empty.
	 */
	E peek() throws NoSuchElementException;
	
	/**
	 * Returns the current element count contained in the queue.
	 * Preconditions: A valid QueueADT object exists, and the queue object is not empty.
	 * Postconditions: The element count of the queue is returned.
	 * @return The current element count.
	 */
	int size();
	
	/**
	 * Checks if the current queue is empty
	 * Preconditions: A valid QueueADT object exists.
	 * Postconditions: A boolean representing whether the current queue is empty.
	 * @return true if the current queue is empty, and false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Removes all of the elements from this queue.
	 * The queue will contain zero elements after this call returns.
	 * Preconditions: A valid QueueADT object exists.
	 * Postconditions: The queue contains zero elements.
	 */
	void dequeueALL();
	
	/**
	 * Checks if this queue and the given queue contain equal items in the same order.
	 * Preconditions: Two valid QueueADT objects exist.
	 * Postconditions: A boolean representing whether the queues are equal
	 * and in the same order is returned.
	 * @param that, the queue to be compared to. 
	 * @return true if this queue and the given queue are equal and in the same order, 
	 * false otherwise.
	 */
	boolean equals(QueueADT<E> that);
	
	/**
	 * Returns an array containing all the elements in the queue.
	 * Preconditions: A valid QueueADT object exists.
	 * Postconditions: An array containing all the elements in the queue exists.
	 * @return an array containing every element of the queue with elements cast to Object.
	 */
	Object[] toArray();
	
	/**
	 * Returns an array containing all the elements in the queue, 
	 * copying them into the provided array.
	 * Preconditions: A valid QueueADT object exists. 
	 * A target array object of the correct size exists.
	 * Postconditions: The provided array contains a copy of all the elements in the queue.
	 * @param copy, the array to which the elements will be copied.
	 * @return an array containing every element of the queue, copied to the provided array.
	 * @throws NullPointerException If the provided 'copy' array is null.
	 */
	E[] toArray(E[] copy) throws NullPointerException;
}
