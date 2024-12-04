package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
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
            throw new IllegalArgumentException("Cannot add null key or values to BST.");
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
        if (key == null) {
            throw new IllegalArgumentException("Cannot get value from null key.");
        }

        if (root == null) {
            return null;
        }
        return root.getValue(key, comparator);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        if (root == null) {
            return null;
        }

        return root.find(searcher);
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

    @SuppressWarnings("unchecked")
    @Override
    public Pair<K, V>[] toArray() throws Exception {
        if (root == null) {
            return (Pair<K, V>[]) new Pair[0];
        }

        Pair<K,V>[] array = (Pair<K, V>[]) new Pair[count];
        AtomicInteger arrayIndex = new AtomicInteger(-1);
        root.toArray(array, arrayIndex);

        return array;
    }

    @Override
    public int indexOf(K itemKey) {
        if (root == null) {
            return -1;
        }

        int index = 0;
        TreeNode<K,V> current = root;
        TreeNode<K,V> parent = null;
        StackImplementation<TreeNode<K,V>> nodeStack = new StackImplementation<>();

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();

                if (parent.getKey().equals(itemKey)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        int currentIndex = 0;
        TreeNode<K,V> current = root;
        StackImplementation<TreeNode<K,V>> nodeStack = new StackImplementation<>();

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                current = current.getLeftChild();
            } else {
                current = nodeStack.pop();

                if (currentIndex == index) {
                    return current.getKeyValue();
                }
                currentIndex++;
                current = current.getRightChild();
            }
        }
        return null;
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        if (root == null) {
            return -1;
        }

        int index = 0;
        TreeNode<K,V> current = root;
        TreeNode<K,V> parent = null;
        StackImplementation<TreeNode<K,V>> nodeStack = new StackImplementation<>();

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();

                if (searcher.test(parent.getValue())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
    
}
