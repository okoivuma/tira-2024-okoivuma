package oy.interact.tira.student;
import oy.interact.tira.util.QueueInterface;

public class ArrayQueue<E> implements QueueInterface<E> {

    private int count;
    private int head;
    private int tail;
    private Object[] array;
    private static final int DEFAULT_QUEUE_SIZE = 10;

    /*
     * Constructors
     */

    public ArrayQueue() {
        this(DEFAULT_QUEUE_SIZE);
    }

    /*
     * Constructor with parameter
     * @Parameter size
     *  The capacity of the array.
     * 
     * @Throws IllegalArgumentException
     *  If given capacity is zero or less.
     */
    public ArrayQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }
        this.array = new Object[size];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }

    /*
     * Implemented methods
     */

    @Override
    public int capacity() {
        return array.length;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element to add must not be null.");
        }
        
        if (count == array.length) {
            reallocate(array.length * 2);
        }

        if (tail >= array.length && head > 0) {
            tail = 0;
        }

        array[tail] = element;
        tail ++;
        count ++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        E element = (E) array[head];
        array[head] = null;

        head ++;
        count --;

        if (head >= array.length) {
            head = 0;
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E element() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return (E) array[head];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_QUEUE_SIZE];
        count = 0;
        tail = 0;
        head = 0;
    }

    private void reallocate(int newSize) {
        Object[] temp = new Object[newSize];

        //If the queue hasn't wrapped around
        if (head < tail) {
            int j = 0;
            for (int i = head; i < tail; i++) {
                temp[j] = array[i];
                j++;
            }
        } else {

            //If the queue is wrapped around
            int j = 0;
            for (int i = head; i < array.length; i++) {
                temp[j] = array[i];
                j++;
            }

            for (int i = 0; i < tail; i++) {
                temp[j] = array[i];
                j++;
            }
        }
        array = temp;
        head = 0;
        tail = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if (isEmpty()) {
            return "[]";
        }
        sb.append("[");

        //If queue hasn't wrapped around
        if (head < tail) {
            for (int i = head; i < tail; i++) {
                sb.append(array[i]);

                if (i < tail - 1) {
                    sb.append(", ");
                }
            }
        } else {

            // if the queue has wrapped around
            for (int i = head; i < array.length; i++) {
                sb.append(array[i]);
                sb.append(", ");
                
            }

            for (int i = 0; i < tail; i++) {
                sb.append(array[i]);

                if (i < tail - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]");

        return sb.toString();
    }

}
