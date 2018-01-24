/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genbt;

/**
 *
 * @author Mikhail
 */
import java.util.List;

public interface BTreeI<K,V> {
    /**
     * Return the head of the tree.
     */
    public NodeI<K,V> getHead();
    /**
     * Get an element from the tree,
     * identified by key. It should
     * throw a custom exception (which
     * subclasses RuntimeException) if
     * the key is not present. The return
     * value should be the NodeI for
     * the subtree at that location.
     */
    public NodeI<K,V> get(K k);

    /**
     * Set a key and value on the
     * tree by obtaining them from
     * the node. Do NOT insert the
     * node itself or its subtree.
     */
    public void put(NodeI<K,V> node);

    /**
     * Compute the size (number of nodes)
     * in the tree.
     */
    public int size();
    /**
     * After calling this method,
     * the tree should have nothing
     * in it.
     */
    public void clear();

    /**
     * Remove an entire subtree whose
     * head is k. The removed node
     * should be returned.
     */
    public BTreeI<K,V> removeSubtree(K k);

    /**
     * This method will return a sorted
     * list of nodes. Note that you should
     * **NOT** call a sort method, but
     * obtain your sorted list by recursively
     * descending through the tree.
     */
    public List<NodeI<K,V>> list();
}