package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {

    private Object [] itemArray;
    private int top;
    private static final int DEFAULT_STACK_SIZE = 20;

    /*
     * Constructors
     */

    public StackImplementation() {
        this.itemArray = new Object[DEFAULT_STACK_SIZE];
        this.top = -1;
    }

    /*
     * Constructor with parameter
     * @Parameter size
     *  The capacity of the inner array.
     * 
     * @Throws IllegalArgumentException
     *  If given capacity is zero or less.
     */
    public StackImplementation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0.");
        }
        itemArray = new Object[size];
        top = -1;
    }



    /*
     * Interface methods
     */

    @Override
    public int capacity() {
        return itemArray.length;
    }
    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException{
        if (element == null) {
            throw new NullPointerException("Push must not be null.");
        }

        if (top == itemArray.length - 1) {  
            reallocate(itemArray.length * 2);
        }

        top += 1;
        itemArray[top] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if (top == -1) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }

        E popped = (E) itemArray[top];
        itemArray[top] = null;
        top -= 1;

        return popped;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if (top == -1) {
            throw new IllegalStateException("Cannot peek from an empty stack.");
        }

        return (E) itemArray[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }



    private void reallocate(int newSize) {
        Object[] temp = new Object[newSize];
        for (int i = 0; i < top + 1; i++) {
            temp[i] = itemArray[i];
        }
        itemArray = temp;
    }

    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        if (top == -1) {
            return "[]";
        }

        sb.append("[");

        for (int i = 0; i < top + 1; i++) {
            sb.append(itemArray[i]);

            if (i < top) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

}
