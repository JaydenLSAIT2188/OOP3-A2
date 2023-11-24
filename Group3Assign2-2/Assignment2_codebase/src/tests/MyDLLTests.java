package tests;

import utilities.MyDLL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Isaac, David, Jayden
 * */

/**
 * Test class for MyDLL.
 * This class contains JUnit test cases to verify the functionality of the MyDLL class.
 */
public class MyDLLTests {
    private MyDLL<Integer> list;

    /**
     * Sets up a new list for each test case.
     */
    @Before
    public void setUp() {
        list = new MyDLL<>();
    }

    /**
     * Tests adding an element to the front of the list.
     */
    @Test
    public void testAddFirst() {
        list.addFirst(1);
        assertFalse("List should not be empty after adding an element", list.isEmpty());
        assertEquals("Size should be 1 after adding one element", 1, list.size());
        assertEquals("First element should be 1", Integer.valueOf(1), list.getFirst());
    }

    /**
     * Tests adding an element to the end of the list.
     */
    @Test
    public void testAddLast() {
        list.addLast(1);
        assertFalse("List should not be empty after adding an element", list.isEmpty());
        assertEquals("Size should be 1 after adding one element", 1, list.size());
        assertEquals("Last element should be 1", Integer.valueOf(1), list.getLast());
    }

    /**
     * Tests removing the first element from an empty list.
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemoveFirstEmptyList() {
        list.removeFirst();
    }

    /**
     * Tests removing the first element from the list.
     */
    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals("Removed element should be 2", Integer.valueOf(2), list.removeFirst());
        assertEquals("First element should now be 1", Integer.valueOf(1), list.getFirst());
    }

    /**
     * Tests removing the last element from an empty list.
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemoveLastEmptyList() {
        list.removeLast();
    }

    /**
     * Tests removing the last element from the list.
     */
    @Test
    public void testRemoveLast() {
        list.addLast(1);
        list.addLast(2);
        assertEquals("Removed element should be 2", Integer.valueOf(2), list.removeLast());
        assertEquals("Last element should now be 1", Integer.valueOf(1), list.getLast());
    }

    /**
     * Tests retrieving the first element from an empty list.
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetFirstEmptyList() {
        list.getFirst();
    }

    /**
     * Tests retrieving the first element from the list.
     */
    @Test
    public void testGetFirst() {
        list.addFirst(1);
        assertEquals("First element should be 1", Integer.valueOf(1), list.getFirst());
    }

    /**
     * Tests retrieving the last element from an empty list.
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetLastEmptyList() {
        list.getLast();
    }

    /**
     * Tests retrieving the last element from the list.
     */
    @Test
    public void testGetLast() {
        list.addLast(1);
        assertEquals("Last element should be 1", Integer.valueOf(1), list.getLast());
    }

    /**
     * Tests if the list is empty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("Newly created list should be empty", list.isEmpty());
        list.addFirst(1);
        assertFalse("List should not be empty after adding an element", list.isEmpty());
    }

    /**
     * Tests the size of the list.
     */
    @Test
    public void testSize() {
        assertEquals("Newly created list should have size 0", 0, list.size());
        list.addFirst(1);
        assertEquals("Size should be 1 after adding one element", 1, list.size());
    }
}
