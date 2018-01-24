/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genbt;

import java.util.Comparator;
import java.util.List;
import java.util.*;

/**
 *
 * @author Mikhail
 */
class NotFound extends RuntimeException {
}

public class BTImpl<K, V> implements BTreeI<K, V> {

    Comparator<K> c;
    NodeImp<K, V> head;
    K k;
    V v;

     
    public BTImpl(Comparator<K> c) {
        this.c = c;
    }

      
    @Override
    public NodeI<K, V> getHead() {
        return head;
    }

      
    @Override
    public NodeI<K, V> get(K k) {
        if (head == null) {
            throw new NotFound();
        }
        return head.get(k, c);
    }

      
    @Override
    public void put(NodeI<K, V> node) {
        if (head == null) {
            head = new NodeImp<>(node.getKey(), node.getValue());
        } else {
            head.put(node.getKey(), node.getValue(), c);
        }
    }

      
    @Override
    public int size() {
        return size(head);
    }

      
    private int size(NodeImp<K, V> node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

      
    @Override
    public void clear() {
        head = null;
    }

      
    @Override
    public BTreeI<K, V> removeSubtree(K k) {
        BTImpl btree = new BTImpl(c);
        btree.head = removeSubtreeHelp(k);
        if (btree.head == null) {
            return null;
        }
        return btree;
    }

      
    public NodeImp<K, V> removeSubtreeHelp(K k) {
        if (head == null) {
            return null;
        }
        int com = c.compare(k, head.k);
        if (com == 0) {
            NodeImp<K, V> node = head;
            head = null;
            return node;
        }
        return removeNodeN(head, k, c);
    }

      
    private NodeImp<K, V> removeNodeN(NodeImp<K, V> node, K k, Comparator<K> c) {
        if (node == null) {
            return null;
        }
        int com = c.compare(k, node.k);
        if (com < 0 && node.left != null) {
            int com2 = c.compare(k, (K) node.left.k);
            if (com2 == 0) {
                NodeImp<K, V> re = node.left;
                node.left = null;
                return re;
            } else {
                return removeNodeN(node.left, k, c);
            }
        } else if (com > 0 && node.right != null) {
            int com2 = c.compare(k, (K) node.right.k);
            if (com2 == 0) {
                NodeImp<K, V> re = node.right;
                node.right = null;
                return re;
            } else {
                return removeNodeN(node.right, k, c);
            }
        }
        return null;
    }

      
    @Override
    public List<NodeI<K, V>> list() {
        List<NodeI<K, V>> list = new ArrayList<>();
        addList(head, list);
        return list;
    }

      
    private void addList(NodeImp<K, V> node, List<NodeI<K, V>> list) {
        if (node == null) {
            return;
        }
        addList(node.left, list);
        list.add(node);
        addList(node.right, list);
    }

      
    public class NodeImp<K, V> implements NodeI<K, V> {

        K k;
        V v;
        NodeImp<K, V> left;
        NodeImp<K, V> right;

          
        NodeImp(K key, V value) {
            k = key;
            v = value;
        }

          
        @Override
        public K getKey() {
            return k;
        }

          
        @Override
        public V getValue() {
            return v;
        }

          
        @Override
        public NodeI<K, V> getLeft() {
            return left;
        }

          
        @Override
        public NodeI<K, V> getRight() {
            return right;
        }

          
        NodeI get(K key, Comparator<K> c) {
            int com = c.compare(key, k);
            if (com == 0) {
                return this;
            }
            if (com < 0) {
                if (left == null) {
                    throw new NotFound();
                }
                return left.get(key, c);
            } else {
                if (right == null) {
                    throw new NotFound();
                }
                return right.get(key, c);
            }
        }

          
        void put(K key, V value, Comparator<K> c) {
            int com = c.compare(key, k);
            if (com == 0) {
                v = value;
            } else if (com < 0) {
                if (left == null) {
                    left = new NodeImp<>(key, value);
                } else {
                    left.put(key, value, c);
                }

            } else if (right == null) {
                right = new NodeImp<>(key, value);
            } else {
                right.put(key, value, c);
            }
        }
    }
}
