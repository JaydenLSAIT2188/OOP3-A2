package utilities;

import interfaces.StackADT;
import java.util.EmptyStackException;

/**
 * @author Isaac, David, Jayden
 * */

/**
 * A stack implementation using an array as the underlying data structure.
 * This class provides the basic operations of a stack such as push, pop, and peek.
 *
 * @param <E> the type of elements held in the stack
 */
public class MyStack<E> implements StackADT<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int top;    // Index of the top element
    private E[] elements;

    /**
     * Constructs an empty stack with default initial capacity.
     */
    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty stack with the specified initial capacity.
     *
     * @param initialCapacity the initial size of the array
     */
    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        top = -1;
    }

    /**
     * Pushes an element onto the top of this stack.
     *
     * @param element the element to be pushed onto the stack
     */
    @Override
    public void push(E element) {
        if (top == elements.length - 1) {
            expandCapacity();
        }
        elements[++top] = element;
    }

    /**
     * Removes the element at the top of this stack and returns that element.
     *
     * @return the element removed from the top of the stack
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E result = elements[top];
        elements[top] = null;  // For garbage collection
        top--;
        return result;
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return the object at the top of this stack
     * @throws EmptyStackException if this stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return true if and only if this stack contains no items; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return top + 1;
    }

    /**
     * Expands the capacity of the stack when it is full.
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        E[] larger = (E[]) (new Object[elements.length * 2]);
        System.arraycopy(elements, 0, larger, 0, elements.length);
        elements = larger;
    }
}
