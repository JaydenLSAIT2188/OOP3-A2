package utilities;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5020374182030896278L;
	
	private MyArrayList<E> list;
	
	public MyStack() {
		this.list = new MyArrayList<>();
	}

	@Override 
	public void push(E toAdd) throws NullPointerException {
		this.list.add(toAdd);
		
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
		return this.list.get(this.list.size() - 1);
	}

	@Override
	public void clear() {
		this.list.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public Object[] toArray() {
		return this.list.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
	        throw new NullPointerException();
	    }

	    // If the provided array is too small, create a new array of the same type
	    // as the input array, but with the size of the stack.
	    if (holder.length < this.size()) {
	        holder = (E[]) new Object[this.size()];
	    }

	    // Use the toArray method of MyArrayList to get the elements in proper order.
	    Object[] tempArray = this.list.toArray();

	    // Copy the elements to the provided array.
	    System.arraycopy(tempArray, 0, holder, 0, this.size());

	    // If the provided array is larger than needed, set the first unused element to null.
	    if (holder.length > this.size()) {
	        holder[this.size()] = null;
	    }

	    return holder;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
            throw new NullPointerException();
        }

        return list.contains(toFind);
	}

	@Override
	public int search(E toFind) {
	        int index = list.size() - 1;
	        for (int position = 1; index >= 0; position++, index--) {
	            if (toFind.equals(list.get(index))) {
	                return position;
	            }
	        }

	        return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return this.list.iterator();
	}

	@Override
	public boolean equals(StackADT<E> that) {
		if (that == null) {
			return false;
	        }

        if (this == that) {
            return true;
        }

        if (this.size() != that.size()) {
            return false;
        }

        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();

            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }

        return true;
	}

	@Override
	public int size() {
		return this.list.size();
	}

}
