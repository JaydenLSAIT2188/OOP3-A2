package tests;

import utilities.MyStack;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.*;

/**
 * @author Isaac, David, Jayden
 * */

public class MyStackTest {
    private MyStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertFalse("Stack should not be empty after pushing an element", stack.isEmpty());
        assertEquals("Size should be 1 after pushing one element", 1, stack.size());
    }

    @Test
    public void testPop() {
        stack.push(2);
        int element = stack.pop();
        assertEquals("Popped element should be 2", 2, element);
        assertTrue("Stack should be empty after popping the only element", stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test
    public void testPeek() {
        stack.push(3);
        int topElement = stack.peek();
        assertEquals("Peeked element should be 3", 3, topElement);
        assertEquals("Size should remain 1 after peek", 1, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        stack.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Newly created stack should be empty", stack.isEmpty());
        stack.push(4);
        assertFalse("Stack should not be empty after pushing an element", stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals("Newly created stack should have size 0", 0, stack.size());
        stack.push(5);
        assertEquals("Size should be 1 after pushing one element", 1, stack.size());
    }

    @Test
    public void testStackExpansion() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals("Stack should expand correctly and have size 15", 15, stack.size());
    }
}
