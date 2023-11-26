package utilities;

public class MyArrayList<E> implements ListADT<E> {
    private E[] array;
    private int size;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2194962780183568720L;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.array = (E[]) new Object[10];
    }

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.array = (E[]) new Object[10];
		this.size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
            throw new NullPointerException();
        }
		
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        
        checkCapacity();
        
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        
        this.array[index] = toAdd;
        this.size++;
        return true;
	}

	@SuppressWarnings("unchecked")
	private void checkCapacity() {
		if (this.size == this.array.length) {
			E[] newArray = (E[]) new Object[this.array.length * 2];
			
			for (int i = 0; i < this.array.length; i++) {
				newArray[i] = this.array[i];
			}
			
			this.array = newArray;
		}
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
            throw new NullPointerException();
        }
		
		checkCapacity();

		if (this.size == this.array.length) {
	        @SuppressWarnings("unchecked")
			E[] newElements = (E[]) new Object[this.size * 2];

	        for (int i = 0; i < this.size; i++) {
	            newElements[i] = this.array[i];
	        }

	        this.array = newElements;
	    }

		this.array[this.size++] = toAdd;
	    return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
            throw new NullPointerException();
        }

        if (toAdd instanceof Iterable<?>) {
            @SuppressWarnings("unchecked")
            Iterator<? extends E> iterator = (Iterator<? extends E>) ((Iterable<? extends E>) toAdd).iterator();
            while (iterator.hasNext()) {
                add(iterator.next());
            }
            return true;
        }
        return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        E removedElement = this.array[index];

        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);

        this.array[this.size - 1] = null;
        this.size--;

        return removedElement;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		
		for (int i = 0; i < this.size; i++) {
            if (toRemove.equals(this.array[i])) {
                return remove(i);
            }
        }
        return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        E previousElement = this.array[index];
        this.array[index] = toChange;
        return previousElement;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		
		for (E element : this.array) {
            if (toFind.equals(element)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
	        throw new NullPointerException();
	    }

	    for (int i = 0; i < this.size; i++) {
	        toHold[i] = this.array[i];
	    }

	    return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[this.size];
	    for (int i = this.size - 1, j = 0; i >= 0; i--, j++) {
	        newArray[j] = this.array[i];
	    }
	    return newArray;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
	        private int currentIndex = 0;

	        @Override
	        public boolean hasNext() {
	            return currentIndex < size;
	        }

	        @Override
	        public E next() {
	            return array[currentIndex++];
	        }
	    };
	}

}
