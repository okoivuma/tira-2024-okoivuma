package oy.interact.tira.student;
import java.util.Comparator;
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

    public boolean insert(K key, V value, Comparator<K> comparator) {
       boolean result = false;
        if (value.equals(keyValue.getValue())) {
            this.keyValue.setValue(value);
            result = false;
        }

        if (comparator.compare(key, keyValue.getKey()) <= 0) {
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

}
