package utilities;

public class MyDLL<E> implements ListADT<E> {
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private int size;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140796753013938413L;
	

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.head = this.tail = null;
		this.size = 0;

	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addToFront(toAdd);
        } else if (index == size) {
            addToRear(toAdd);
        } else {
            addAtIndex(index, toAdd);
        }

        return true;
    }
	
	private void addToFront(E toAdd) {
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, null, head);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }
	
	private void addToRear(E toAdd) {
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, tail, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
	
	private void addAtIndex(int index, E toAdd) {
        MyDLLNode<E> current = getNode(index);
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd, current.getPrev(), current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }
	
	private MyDLLNode<E> getNode(int index) {
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
            throw new NullPointerException();
        }

        addToRear(toAdd);
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
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyDLLNode<E> current = getNode(index);
        return current.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyDLLNode<E> current = getNode(index);
        return unlink(current);
	}
	
	private E unlink(MyDLLNode<E> node) {
        E element = node.getElement();
        MyDLLNode<E> prev = node.getPrev();
        MyDLLNode<E> next = node.getNext();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }

        size--;
        return element;
    }

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
            throw new NullPointerException();
        }

        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.getElement())) {
                return unlink(current);
            }
            current = current.getNext();
        }

        return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyDLLNode<E> current = getNode(index);
        E oldElement = current.getElement();
        current.setElement(toChange);
        return oldElement;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
            throw new NullPointerException();
        }

        MyDLLNode<E> current = head;
        while (current != null) {
            if (toFind.equals(current.getElement())) {
                return true;
            }
            current = current.getNext();
        }

        return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
            throw new NullPointerException();
        }

        if (toHold.length < size) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
            toHold = newArray;
        }

        int i = 0;
        MyDLLNode<E> current = head;
        while (current != null) {
            toHold[i++] = current.getElement();
            current = current.getNext();
        }

        return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
        int i = 0;
        MyDLLNode<E> current = head;
        while (current != null) {
            array[i++] = current.getElement();
            current = current.getNext();
        }
        return array;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
	        private MyDLLNode<E> current = head;

	        @Override
	        public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public E next() {
	            if (!hasNext()) {
	                throw new java.util.NoSuchElementException();
	            }
	            E element = current.getElement();
	            current = current.getNext();
	            return element;
	        }
	    };
	}

}
