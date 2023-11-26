package utilities;

public class MyDLLNode<E> {
    private E element;
    private MyDLLNode<E> prev;
    private MyDLLNode<E> next;

    public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public MyDLLNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public MyDLLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
}

