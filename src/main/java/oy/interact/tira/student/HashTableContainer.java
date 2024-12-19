package oy.interact.tira.student;
import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V> {

    private Pair<K,V>[] array;
    private int size;
    private static final int HASHTABLE_DEFAULT_SIZE = 16;
    private static final double MAX_FILL_FACTOR = 0.60;

    private int collisionChain;
    private int firstIndexCollison;

    @SuppressWarnings("unchecked")
    public HashTableContainer() {
        this.array =  new Pair[HASHTABLE_DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Cannot add null key or values to hash table.");
        }     
        int collisionCount = 0;
        int hash = key.hashCode(); 
        boolean added = false;

        if (size >= array.length * MAX_FILL_FACTOR) {
            reallocate(array.length * 2);
        }

        do {
            int index = indexFor(hash, collisionCount);
            if (array[index] == null) {
                // Add new
                array[index] = new Pair<K,V>(key, value);
                size++;
                added = true;

            } else if (array[index].getKey().equals(key)) {
                // Update value
                array[index].setValue(value);
                added = true;

            } else {
                // Collision
                collisionCount++;
            }
        } while (!added);      
        
        if (collisionCount > 0) {
            firstIndexCollison++;
        }
        if (collisionCount > collisionChain) {
            collisionChain = collisionCount;
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Cannot get from null key!");
        }

        int hash = key.hashCode();
        int collisionCount = 0;

        do {
            int index = indexFor(hash, collisionCount);
            if (array[index] == null) {
                return null;
            }

            if (array[index].getKey().equals(key)) {
                return array[index].getValue();
            }

            collisionCount++;

        } while (collisionCount <= size);

        return null;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // Grade 4 task
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && searcher.test(array[i].getValue())) {
                return array[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity <= size * (1.0 + MAX_FILL_FACTOR)) {
            throw new IllegalArgumentException("Not enough space for already existing elements!");
        }
        if (size == 0) {
            array = new Pair[capacity];
            return;
        }
        reallocate(capacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        size = 0;
        array = new Pair[HASHTABLE_DEFAULT_SIZE];

        collisionChain = 0;
        firstIndexCollison = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K,V>[] toArray = new Pair[size];
        int newIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                toArray[newIndex] = array[i];
                newIndex++;
            }
        }
        System.out.println("with " + size + " elements, longest collision chain is " + collisionChain);
        System.out.println("Collisions occured on adding elements with " + firstIndexCollison + " keys");
        
        return toArray;
    }

    private int indexFor(int hash, int collisionCount) {
        return ((hash + collisionCount) & 0x7FFFFFFF) % array.length;
    }

    @SuppressWarnings("unchecked")
    private void reallocate(int newCapacity) {
        Pair<K,V>[] oldArray = this.array;
        int oldArrayLength = this.array.length;
        size = 0;

        collisionChain = 0;
        firstIndexCollison = 0;
        array = new Pair[newCapacity];

        for (int i = 0; i < oldArrayLength; i++) {
            if (oldArray[i] != null) {
                add(oldArray[i].getKey(), oldArray[i].getValue());
            }
        }
    }
}
