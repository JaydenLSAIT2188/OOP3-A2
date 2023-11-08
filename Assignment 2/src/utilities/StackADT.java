package utilities;

import java.util.EmptyStackException;

public interface StackADT<E> {
	/**
	 * Pushes toAdd object to the top of the StackADT.
	 * Preconditions: A valid StackADT object exists, and an object to be pushed is supplied.
	 * Postconditions: toAdd is added to the top of the stack.
	 * @param toAdd object to be added to the top of the Stack.
	 * @return true if toAdd was pushed, false otherwise.
	 * @throws NullPointerException when toAdd is null.
	 */
	boolean push(E toAdd) throws NullPointerException;
	
	/**
	 * Removes and returns the topmost element from the stack.
	 * Preconditions: A valid StackADT object exists, and the stack object is not empty.
	 * Postconditions: The topmost element from the stack is removed and returned
	 * @return the topmost element from the stack.
	 * @throws EmptyStackException when the stack is empty.
	 */
	E pop() throws EmptyStackException;
	
	/**
	 * Inspects and returns the topmost element from the stack without mutating the stack.
	 * Preconditions: A valid StackADT object exists, and the stack object is not empty.
	 * Postconditions: The topmost element from the stack is returned.
	 * @return the topmost element from the stack.
	 * @throws EmptyStackException when the stack is empty.
	 */
	E peek() throws EmptyStackException;
	
	/**
	 * Returns the current element count contained in the stack.
	 * Preconditions: A valid StackADT object exists, and the stack object is not empty.
	 * Postconditions: The element count of the stack is returned.
	 * @return The current element count.
	 */
	int size();
	
	/**
	 * Checks if the two stacks contain equal items in the same order.
	 * Preconditions: Two valid StackADT object exists.
	 * Postconditions: A boolean representing whether the stacks are equal
	 * and in the same order is returned.
	 * @param that, the stack to be compared to. 
	 * @return true if the two stacks are equal
	 * and in the same order, and false otherwise.
	 */
	boolean equals(StackADT<E> that);
	
	/**
	 * Checks if the current stack is empty
	 * Preconditions: A valid StackADT object exists.
	 * Postconditions: A boolean representing whether the current stack is empty.
	 * @return true if the current stack is empty, and false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Removes all of the elements from this stack,
	 * The stack will contain zero elements after this call returns.
	 * Preconditions: A valid StackADT object exists.
	 * Postconditions: The stack contains zero elements.
	 */
	void clear();
	
	/**
	 * Returns an array containing all the elements in the stack.
	 * Preconditions: A valid StackADT object exists.
	 * Postconditions: An array containing all the elements in the stack exists.
	 * @return an array containing every element of the stack with elements cast to Object.
	 */
	Object[] toArray();
	
	/**
	 * Returns an array containing all the elements in the stack, 
	 * copying them into the provided array.
	 * Preconditions: A valid StackADT object exists. 
	 * A target array object of the correct size exists.
	 * Postconditions: The provided array contains a copy of all the elements in the stack.
	 * @param copy, the array to which the elements will be copied.
	 * @return an array containing every element of the stack, copied to the provided array.
	 */
	E[] toArray(E[] copy);
}
