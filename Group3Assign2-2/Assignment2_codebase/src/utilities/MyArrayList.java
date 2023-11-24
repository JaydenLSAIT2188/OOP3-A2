package utilities;

import java.util.Iterator;

/**
 * An array-based implementation of the ListADT.
 * This class provides basic functionalities of a list data structure without using standard Java collections.
 *
 * @param <E> The type of elements held in the list.
 */
public class MyArrayList<E> implements ListADT<E> {
    public static final int DEFAULT_CAPACITY = 10;
    public E[] data;
    public int size;

    /**
     * Constructs an empty MyArrayList with an initial capacity.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return The number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index The index at which the specified element is to be inserted.
     * @param toAdd The element to be inserted.
     * @return true if the element is added successfully.
     * @throws NullPointerException if the specified element is null.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element.");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds.");

        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = toAdd;
        size++;
        return true;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param toAdd Element to be appended to this list.
     * @return true if the element is appended successfully.
     * @throws NullPointerException if the specified element is null.
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index Index of the element to return.
     * @return The element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds.");

        return data[index];
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index The index of the element to be removed.
     * @return The element previously at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds.");

        E item = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;

        return item;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param toRemove The element to be removed from this list, if present.
     * @return The element that was removed from the list, or null if the list does not contain the element.
     * @throws NullPointerException if the specified element is null.
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException("Cannot remove null element.");

        for (int i = 0; i < size; i++) {
            if (toRemove.equals(data[i])) {
                return remove(i);
            }
        }
        return null;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index The index of the element to replace.
     * @param toChange Element to be stored at the specified position.
     * @return The element previously at the specified position.
     * @throws NullPointerException if the specified element is null.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException("Cannot set null element.");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds.");

        E oldValue = data[index];
        data[index] = toChange;
        return oldValue;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param toFind The element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     * @throws NullPointerException if the specified element is null.
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException("Cannot check presence of null element.");

        for (E item : data) {
            if (toFind.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @param toHold The array into which the elements of the list are to be stored.
     * @return An array containing the elements of the list.
     * @throws NullPointerException if the specified array is null.
     */
    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException("Provided array cannot be null.");
        if (toHold.length < size) {
            return arrayCopy(data, size);
        }
        for (int i = 0; i < size; i++) {
            toHold[i] = data[i];
        }
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return An array containing all of the elements in this list in proper sequence.
     */
    @Override
    public Object[] toArray() {
        return arrayCopy(data, size);
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return An iterator over the elements in this list.
     */
    @Override
    public utilities.Iterator<E> iterator() {
        return (utilities.Iterator<E>) new MyArrayListIterator();
    }

    /**
     * Ensures that the array has enough capacity to accommodate additional elements.
     */
    private void ensureCapacity() {
        if (size == data.length) {
            data = arrayCopy(data, data.length * 2);
        }
    }

    /**
     * Copies elements of the source array into a new array of the specified length.
     *
     * @param source The source array.
     * @param newLength The length of the new array.
     * @return A new array containing elements of the source array.
     */
    private E[] arrayCopy(E[] source, int newLength) {
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[newLength];
        for (int i = 0; i < Math.min(source.length, newLength); i++) {
            newArray[i] = source[i];
        }
        return newArray;
    }

    /**
     * An iterator for MyArrayList.
     */
    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0;

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration.
         * @throws RuntimeException if the iteration has no more elements.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements");
            }
            return data[cursor++];
        }
    }

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}
}
