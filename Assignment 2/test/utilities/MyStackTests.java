/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author david
 *
 */
class MyStackTests {
	private MyStack<Integer> stack;
	private MyStack<Integer> populatedStack;
	private MyStack<Integer> stack2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
		stack2 = new MyStack<>();
		populatedStack = new MyStack<>();
		populatedStack.push(1);
		populatedStack.push(2);
		populatedStack.push(3);
		
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		stack.push(1);
		assertEquals(1, stack.peek());
		stack.push(2);
		assertEquals(2, stack.peek());
		stack.push(3);
		assertEquals(3, stack.peek());
		assertEquals(3, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNull() {
		stack.push(1);
		assertEquals(1, stack.peek());
		assertThrows(NullPointerException.class, () -> 
			stack.push(null)
		);
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testSinglePop() {
		assertEquals(3, populatedStack.pop());
		assertEquals(2, populatedStack.peek());
		assertEquals(2, populatedStack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testMultiplePop() {
		assertEquals(3, populatedStack.pop());
		assertEquals(2, populatedStack.peek());
		assertEquals(2, populatedStack.size());
		
		assertEquals(2, populatedStack.pop());
		assertEquals(1, populatedStack.peek());
		assertEquals(1, populatedStack.size());
		
		assertEquals(1, populatedStack.pop());
		assertEquals(0, populatedStack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testEmptyStackPop() {
		assertTrue(stack.isEmpty());
		assertThrows(EmptyStackException.class, () -> 
			stack.pop()
		);
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		assertEquals(3, populatedStack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekAfterPush() {
		assertEquals(3, populatedStack.peek());
		populatedStack.push(4);
		assertEquals(4, populatedStack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekAfterPop() {
		assertEquals(3, populatedStack.peek());
		populatedStack.pop();
		assertEquals(2, populatedStack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testEmptyStackPeek() {
		assertTrue(stack.isEmpty());
		assertThrows(EmptyStackException.class, () -> 
			stack.peek()
		);
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearOnPopulatedStack() {
		assertFalse(populatedStack.isEmpty());
		populatedStack.clear();
		assertTrue(populatedStack.isEmpty());
		
	}
	
	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearOnEmptyStack() {
		stack.clear();
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearAndPush() {
		assertTrue(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertFalse(stack.isEmpty());
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyOnEmptyStack() {
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyOnPopulatedStack() {
		assertFalse(populatedStack.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyAndPop() {
		assertFalse(populatedStack.isEmpty());
		populatedStack.pop();
		populatedStack.pop();
		populatedStack.pop();
		assertTrue(populatedStack.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyAfterClear() {
		populatedStack.clear();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		Object[] array = populatedStack.toArray();
        assertArrayEquals(new Object[]{3, 2, 1}, array);
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		Integer[] array = new Integer[3];
        array = populatedStack.toArray(array);
        assertArrayEquals(new Integer[]{3, 2, 1}, array);
	}
	
	/**
     * Test method for {@link utilities.MyStack#toArray(E[])} with a larger array.
     */
    @Test
    void testToArrayEArrayLarger() {
        Integer[] array = new Integer[5];
        array = populatedStack.toArray(array);
        assertArrayEquals(new Integer[]{3, 2, 1, null, null}, array);
    }

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		assertTrue(populatedStack.contains(2));
        assertFalse(populatedStack.contains(4));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		assertEquals(3, populatedStack.search(1));
        assertEquals(2, populatedStack.search(2));
        assertEquals(1, populatedStack.search(3));
        assertEquals(-1, populatedStack.search(4));
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		Iterator<Integer> iterator = populatedStack.iterator();
        int expected = 1;
        while (iterator.hasNext()) {
            assertEquals(expected++, iterator.next());
        }
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		assertTrue(stack.equals(stack2));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEOnEmptyStacks() {
		assertTrue(stack.isEmpty());
		assertTrue(stack2.isEmpty());
		assertTrue(stack.equals(stack2));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEOnNonEqualStacks() {
		assertFalse(stack.equals(populatedStack));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEAfterClear() {
		populatedStack.clear();
		stack.clear();
		assertTrue(stack.equals(populatedStack));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEWithDifferentSizes() {
		stack.push(1);
		stack2.push(1);
		stack2.push(2);
		assertFalse(stack.equals(stack2));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEWithUnequalStacks() {
		stack.push(3);
		stack.push(2);
		stack.push(1);
		assertFalse(stack.equals(populatedStack));
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeOnEmptyStack() {
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeOnPopulatedStack() {
		assertEquals(3, populatedStack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeAfterPushAndPop() {
		assertEquals(0, stack.size());
		stack.push(1);
		assertEquals(1, stack.size());
		stack.push(2);
		stack.push(3);
		stack.pop();
		assertEquals(2, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeAfterClear() {
		populatedStack.clear();
		assertEquals(0, populatedStack.size());
	}

}
