/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author david
 *
 */
class MyArrayListTests {
	
	//attributes
	ListADT<String> list1;
	ListADT<String> list2;
	ListADT<String> list3;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		list1 = new MyArrayList<>();
		list2 = new MyDLL<>();
		list3 = new MyArrayList<>();
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list1.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		assertEquals(3, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClearEmpty() {
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClearNotEmpty() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> 
			list1.add(-1, "A")
		);
	}	
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEGreaterThanSizeIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> 
			list1.add(1, "A")
		);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointer() {
		assertThrows(NullPointerException.class, () -> 
			list1.add(0, null)
		);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEBeginning() {
		list1.add("B");
	    list1.add("C");
	    assertTrue(list1.add(0, "A"));
	    assertEquals(3, list1.size());
	    assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEMiddle() {
		list1.add("A");
		list1.add("C");
		assertTrue(list1.add(1, "B"));
		assertEquals(3, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEnd() {
		list1.add("A");
		list1.add("B");
		assertTrue(list1.add(2, "C"));
		assertEquals(3, list1.size());
		assertEquals("C", list1.get(2));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddEOnEmptyList() {
		list1.add("A");
		assertEquals(1, list1.size());
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddEOnPopulatedList() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		assertEquals(3, list1.size());
		assertEquals("A", list1.get(0));
        assertEquals("B", list1.get(1));
        assertEquals("C", list1.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddENull() {
		assertThrows(NullPointerException.class, () ->
			list1.add(0, null)
		);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllArrayList() {
		list1.add("A");
		list1.add("B");
		list3.add("C");
		list3.add("D");
		assertTrue(list1.addAll(list3));
		assertEquals(4, list1.size());
		
		assertEquals("A", list1.get(0));
	    assertEquals("B", list1.get(1));
	    assertEquals("C", list1.get(2));
	    assertEquals("D", list1.get(3));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllLinkedList() {
		list1.add("A");
		list1.add("B");
		list2.add("C");
		list2.add("D");
		assertTrue(list1.addAll(list2));
		assertEquals(4, list1.size());
		
		assertEquals("A", list1.get(0));
	    assertEquals("B", list1.get(1));
	    assertEquals("C", list1.get(2));
	    assertEquals("D", list1.get(3));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		list1.add("A");
	    list1.add("B");
	    list1.add("C");

	    assertEquals("A", list1.get(0));
	    assertEquals("B", list1.get(1));
	    assertEquals("C", list1.get(2));

	    assertThrows(IndexOutOfBoundsException.class, () ->
	        list1.get(3)
	    );
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		list1.add("A");
	    list1.add("B");
	    list1.add("C");

	    assertEquals("B", list1.remove(1));
	    assertEquals(2, list1.size());
	    assertEquals("A", list1.get(0));
	    assertEquals("C", list1.get(1));

	    assertThrows(IndexOutOfBoundsException.class, () ->
	        list1.remove(2)
	    );
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		list1.add("A");
	    list1.add("B");
	    list1.add("C");

	    assertEquals("B", list1.remove("B"));

	    assertEquals(2, list1.size());
	    assertEquals("A", list1.get(0));
	    assertEquals("C", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENull() {
		list1.add("A");
	    list1.add("B");
	    list1.add("C");
	    
	    assertNull(list1.remove("D"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		list1.add("A");
	    list1.add("B");
	    list1.add("C");

	    assertEquals("B", list1.set(1, "D"));
	    assertEquals(3, list1.size());
	    assertEquals("A", list1.get(0));
	    assertEquals("D", list1.get(1));
	    assertEquals("C", list1.get(2));

	    assertThrows(IndexOutOfBoundsException.class, () ->
	        list1.set(3, "E")
	    );
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list1.isEmpty());

	    list1.add("A");
	    assertFalse(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		assertFalse(list1.contains("A"));

	    list1.add("A");
	    list1.add("B");

	    assertTrue(list1.contains("A"));
	    assertTrue(list1.contains("B"));
	    assertFalse(list1.contains("C"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		String[] strArr = new String[3];
		String[] arr = list1.toArray(strArr);
		assertEquals(3, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list1.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		Object[] arr = list1.toArray();
		assertEquals(3, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
		    assertEquals(list1.get(i), arr[arr.length - 1 - i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArrayWithEmptyList() {
	    Object[] arr = list1.toArray();
	    assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllWithNullList() {
	    assertThrows(NullPointerException.class, () ->
	        list1.addAll(null)
	    );
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> iterator = list1.iterator();
		assertFalse(iterator.hasNext());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		Iterator<String> iterator = list1.iterator();
		assertTrue(iterator.hasNext());
		
		int i = 0;
		while (iterator.hasNext()) {
			assertEquals(list1.get(i), iterator.next());
			i++;
		}
		
		assertEquals(3, i);
		assertFalse(iterator.hasNext());
	}

}
