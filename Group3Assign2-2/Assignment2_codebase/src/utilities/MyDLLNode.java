package utilities;

/**
 * @author Isaac, David, Jayden
 * */

/**
 * Represents a node in a doubly linked list.
 * This class contains data along with references to the previous and next nodes in the list.
 *
 * @param <E> the type of element held in the node
 */
public class MyDLLNode<E> {
    private E data;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    /**
     * Constructs a new node with the specified data and links to previous and next nodes.
     *
     * @param data the element to be stored in the new node
     * @param prev the previous node in the list
     * @param next the next node in the list
     */
    public MyDLLNode(E data, MyDLLNode<E> prev, MyDLLNode<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Retrieves the data stored in this node.
     *
     * @return the data stored in this node
     */
    public E getData() {
        return data;
    }

    /**
     * Sets or updates the data stored in this node.
     *
     * @param data the new data to be stored in this node
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Retrieves the next node in the list.
     *
     * @return the next node
     */
    public MyDLLNode<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the node to be set as the next node
     */
    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }

    /**
     * Retrieves the previous node in the list.
     *
     * @return the previous node
     */
    public MyDLLNode<E> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the node to be set as the previous node
     */
    public void setPrev(MyDLLNode<E> prev) {
        this.prev = prev;
    }
}
