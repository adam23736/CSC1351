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
public interface NodeI<K,V> {
  K getKey();
  V getValue();
  NodeI<K,V> getLeft();
  NodeI<K,V> getRight();
}