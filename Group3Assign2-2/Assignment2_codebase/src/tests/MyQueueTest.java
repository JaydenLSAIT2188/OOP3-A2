package tests;

import utilities.MyQueue;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/**
 * @author Isaac, David, Jayden
 * */
/**
 * Test class for MyQueue.
 * This class contains JUnit test cases to verify the functionality of the MyQueue class.
 */
public class MyQueueTest {
    private MyQueue<Integer> queue;

    /**
     * Sets up a new queue for each test case.
     */
    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    /**
     * Tests enqueueing an element into the queue.
     */
    @Test
    public void testEnqueue() {
        queue.enqueue(1);
        assertFalse("Queue should not be empty after enqueueing an element", queue.isEmpty());
        assertEquals("Size should be 1 after enqueueing one element", 1, queue.size());
    }

    /**
     * Tests dequeueing an element from the queue.
     */
    @Test
    public void testDequeue() {
        queue.enqueue(2);
        int element = queue.dequeue();
        assertEquals("Dequeued element should be 2", 2, element);
        assertTrue("Queue should be empty after dequeueing the only element", queue.isEmpty());
    }

    /**
     * Tests dequeueing an element from an empty queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmptyQueue() {
        queue.dequeue();
    }

    /**
     * Tests retrieving the first element of the queue without removing it.
     */
    @Test
    public void testFirst() {
        queue.enqueue(3);
        int firstElement = queue.first();
        assertEquals("First element should be 3", 3, firstElement);
        assertEquals("Size should remain 1 after first", 1, queue.size());
    }

    /**
     * Tests retrieving the first element from an empty queue.
     */
    @Test(expected = NoSuchElementException.class)
    public void testFirstEmptyQueue() {
        queue.first();
    }

    /**
     * Tests if the queue is empty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("Newly created queue should be empty", queue.isEmpty());
        queue.enqueue(4);
        assertFalse("Queue should not be empty after enqueueing an element", queue.isEmpty());
    }

    /**
     * Tests the size of the queue.
     */
    @Test
    public void testSize() {
        assertEquals("Newly created queue should have size 0", 0, queue.size());
        queue.enqueue(5);
        assertEquals("Size should be 1 after enqueueing one element", 1, queue.size());
    }
}
