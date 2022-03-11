package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * Makes a linked Stack
 * 
 * @author Xavier Henschel 
 * @version 2022-10-03
 * “I have neither given nor received unauthorized assistance on this
 *          assignment.”
 * @param <T> 
 *            generic
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node<T> topNode;

    /**
     * constructor
     * 
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * 
     * @return
     *         number of items in stack
     */
    public int size() {
        return this.size;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        Node<T> current = topNode;
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        while (current.getNextNode() != null) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(current.getData()));
            current = current.getNextNode();
        }
        builder.append(", ");
        builder.append(String.valueOf(current.getData()));
        builder.append(']');
        return builder.toString();
    }


    /**
     * clears the stack
     */
    @Override
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * shows data in the top Node
     * 
     * @return T
     *         data in the topNode
     */
    @Override
    public T peek() throws EmptyStackException {
        if (this.topNode == null) {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    /**
     * removes entry at top of stack
     * 
     * @return T
     *         the method that was popped
     */
    @Override
    public T pop() {
        T top = this.peek();
        topNode = topNode.getNextNode();
        size--;
        return top;

    }


    /**
     * adds new node to stack
     * 
     * @param anEntry
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }


        public Node(T data) {
            this.data = data;
        }


        public T getData() {
            return data;
        }


        public Node<T> getNextNode() {
            return next;
        }


        public void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }

    }// end Node Class
}
