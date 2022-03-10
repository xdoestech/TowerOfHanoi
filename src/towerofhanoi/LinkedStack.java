package towerofhanoi;

import stack.StackInterface;

public class LinkedStack<T> implements StackInterface<T>{
    private int size;
    private Node<T> topeNode;
    
    public LinkedStack() {
        // TODO Auto-generated constructor stub
    }
    
    public void size() {
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void push(T arg0) {
        // TODO Auto-generated method stub
        
    }
    
    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T entry, Node<T> node) 
        { 
         this(entry); 
           this.setNextNode(node); 
         }


        public Node(T data) 
        { 
            this.data = data; 
        }


        public T getData() {
            return data;
        }

        public Node<T> getNextNode() {
            return next;
        }


        public void setNextNode(Node nextNode) {
            next = nextNode;
        }

    }// end Node Class
}
