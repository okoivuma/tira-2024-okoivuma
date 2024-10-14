package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class LinkedListQueue<E> implements QueueInterface<E> {


    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    
    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element to add must not be null.");
        }

        Node<E> node = new Node<>(element);

        if (head == null) {  
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;     
        }
        
        size++;

    }

    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        E element = head.data;
        head = head.next;
        size--;

        // Check if removed element was the last element,
        // and set the tail to null as well

        if (head == null) {
            tail = null;
        }

        return element;
    }

    @Override
    public E element() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            return "[]";
        }

        sb.append("[");
        
        Node<E> node = head;

        while (node != null) {
            
            sb.append(node.data);
            node = node.next;

            if (node != null) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
    
}
