package interfaces;

	public interface StackADT<E> {

	    /**
	     * Pushes an element onto the top of the stack.
	     *
	     * @param element The element to be pushed
	     */
	    void push(E element);

	    /**
	     * Removes and returns the top element from the stack.
	     *
	     * @return The top element of the stack
	     * @throws java.util.EmptyStackException If the stack is empty
	     */
	    E pop();

	    /**
	     * Retrieves, but does not remove, the top element of the stack.
	     *
	     * @return The top element of the stack
	     * @throws java.util.EmptyStackException If the stack is empty
	     */
	    E peek();

	    /**
	     * Returns whether the stack is empty.
	     *
	     * @return True if the stack is empty, false otherwise
	     */
	    boolean isEmpty();

	    /**
	     * Returns the number of elements in the stack.
	     *
	     * @return The number of elements in the stack
	     */
	    int size();
	}


