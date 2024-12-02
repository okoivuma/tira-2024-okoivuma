package oy.interact.tira.student;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;

public class TreeNode<K,V> {

    private Pair<K,V> keyValue;
    private TreeNode<K,V> leftChild;
    private TreeNode<K,V> rightChild;
    private TreeNode<K,V> parent;

    public TreeNode(K key,V value) {
        this.keyValue = new Pair<K,V>(key, value);
    }

    public K getKey() {
        return keyValue.getKey();
    }

    public V getValue() {
        return keyValue.getValue();
    }

    public TreeNode<K,V> getParent() {
        return parent;
    }

    public TreeNode<K,V> getLeftChild() {
        return leftChild;
    }

    public TreeNode<K,V> getRightChild() {
        return rightChild;
    }

    public Pair<K,V> getKeyValue() {
        return keyValue;
    }

    public boolean insert(K key, V value, Comparator<K> comparator) {
       boolean result = false;
        if (value.equals(getValue())) {
            this.keyValue.setValue(value);
            return result;
        }

        if (comparator.compare(key, getKey()) <= 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<K,V>(key, value);
                leftChild.parent = this;
                result = true;
            } else {
                result = leftChild.insert(key, value, comparator);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode<K,V>(key, value);
                rightChild.parent = this;
                result = true;
            } else {
                result = rightChild.insert(key, value, comparator);
            }
        }
        return result;
    }

    public V getValue(K key, Comparator<K> comparator) {

        if (comparator.compare(key, getKey()) == 0) {
            return getValue();
        } else {
            if (comparator.compare(key, getKey()) < 0) {
                if (leftChild != null) {
                    return leftChild.getValue(key, comparator);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.getValue(key, comparator);
                }
            }
        }
        return null;
    }

    public void toArray(Pair<K,V>[] array, AtomicInteger arrayIndex){
        if (leftChild != null) {
            leftChild.toArray(array, arrayIndex);
        }
        array[arrayIndex.incrementAndGet()] = new Pair<K,V>(this.getKey(), this.getValue());
        
        if (rightChild != null) {
            rightChild.toArray(array, arrayIndex);
        }
    }

    public V find(Predicate<V> searcher) {
        
        if (leftChild != null) {
            V leftResult = leftChild.find(searcher);
            if (leftResult != null) {
                return leftResult;
            }
        }

        if (searcher.test(getValue())) {
            return getValue();
        }

        if (rightChild != null) {
            return rightChild.find(searcher);
        }

        return null;
    }
}