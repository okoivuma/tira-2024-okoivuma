package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K, V> implements TIRAKeyedOrderedContainer<K, V> {

    private int count;
    private TreeNode<K,V> root;
    private Comparator<K> comparator;


    public BinarySearchTreeContainer(Comparator<K> comparator) {
        this.comparator = comparator;
    }
     

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Cannot add null values to BST or values to null key.");
        }       

        if (root == null) {
            root = new TreeNode<K,V>(key, value);
            count++;
        } else {
            if (root.insert(key, value, comparator)) {
                count++;
            }            
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
    }

    @Override
    public void clear() {
        root = null;
        count = 0;
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public int indexOf(K itemKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndex'");
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIndex'");
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
    
}
