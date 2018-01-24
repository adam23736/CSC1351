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
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Comparator;
import java.lang.reflect.Constructor;
import java.util.Random;
class Str {
  final String s;
  Str(String s) { this.s = s; }
  public String toString() { return s; }
}
class StrComp implements Comparator<Str> {
  public int compare(Str a,Str b) {
    Str sa = (Str)a;
    Str sb = (Str)b;
    return sa.s.compareTo(sb.s);
  }
}
class NegStrComp implements Comparator<Str> {
  public int compare(Str a,Str b) {
    Str sa = (Str)a;
    Str sb = (Str)b;
    return -sa.s.compareTo(sb.s);
  }
}
public class BTreeTester {
  public final static StrComp STR_COMP = new StrComp();
  public final static NegStrComp NEG_STR_COMP = new NegStrComp();
  public final static Random RAND = new Random();
  public final static String VOWEL = "aeiou";
  public final static String CONSONANT = "bcdfghijklmnpqrstvwx";
  static String randWord() {
    int len = 2*RAND.nextInt(3)+3;
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<len;i++) {
      String src = CONSONANT;
      if((i % 2) == 0)
        src = VOWEL;
      char c = src.charAt(RAND.nextInt(src.length()));
      if(i == 0)
        c = Character.toUpperCase(c);
      sb.append(c);
    }
    return sb.toString();
  }
  static int count(NodeI<?,?> n) {
    if(n == null) return 0;
    return 1 + count(n.getLeft())+count(n.getRight());
  }
  static <K,V> void check(NodeI<K,V> node,Comparator<K> c) {
    NodeI<K,V> nl = node.getLeft();
    NodeI<K,V> nr = node.getRight();
    if(nl != null) {
      assert c.compare(nl.getKey(),node.getKey()) < 0 :
        "Tree ordering problem";
      check(nl,c);
    }
    if(nr != null) {
      assert c.compare(nr.getKey(),node.getKey()) > 0 :
        "Tree ordering problem";
      check(nr,c);
    }
  }
  @SuppressWarnings("unchecked")
  static <K,V> BTreeI<K,V> newInstance(String clName,Comparator<K> c) throws Exception {
    Class<?> cl = Class.forName(clName);
    Constructor<?> con = cl.getDeclaredConstructor(new Class[]{
        Comparator.class});
    con.setAccessible(true);
    return (BTreeI)con.newInstance(new Object[]{c});
  }
  public static void main(String[] args) throws Exception {
    try {
      assert(false);
      throw new Error("Assertions not enabled");
    } catch(AssertionError ae) {
    }
    for(int m=0;m<100;m++) {
      Integer zero = 0;
      //Class cl = Class.forName(args[0]);
      //Constructor con = cl.getDeclaredConstructor(new Class[]{
          //Comparator.class});
      //BTreeI<Str,Integer> btree = (BTreeI)con.newInstance(new Object[]{STR_COMP});
      //BTreeI<Str,Integer> btree2 = (BTreeI)con.newInstance(new Object[]{NEG_STR_COMP});
      BTreeI<Str,Integer> btree = newInstance(args[0],STR_COMP);
      BTreeI<Str,Integer> btree2 = newInstance(args[0],NEG_STR_COMP);
      int num = RAND.nextInt(10)+10;
      Map<Str,Integer> reference = new TreeMap<>(STR_COMP);
      for(int i=0;i<num;i++) {
        final String word = randWord();
        final Str key = new Str(word);
        final Integer val = i;
        reference.put(key,val);
        NodeI<Str,Integer> n = new NodeI<Str,Integer>() {
            public Str getKey() { return key; }
            public Integer getValue() { return val; }
            public NodeI<Str,Integer> getLeft() { return null; }
            public NodeI<Str,Integer> getRight() { return null; }
            };
        btree.put(n);
        btree2.put(n);
      }
      check(btree.getHead() ,STR_COMP);
      check(btree2.getHead(),NEG_STR_COMP);
      assert count(btree.getHead()) == reference.size() :
        "Tree contains "+count(btree.getHead())+" but should contain "+reference.size()+" nodes";
      assert count(btree2.getHead()) == reference.size() :
        "Tree contains "+count(btree.getHead())+" but should contain "+reference.size()+" nodes";
      Iterator<NodeI<Str,Integer>> iter = btree.list().iterator();
      int rm = RAND.nextInt(reference.size());
      int n = 0;
      Str keyRm = null;
      for(Map.Entry<Str,Integer> e : reference.entrySet()) {
        if(n == rm) {
          keyRm = e.getKey();
        }
        n++;
        assert iter.hasNext() : "Items missing from tree";
          NodeI<Str,Integer> node = iter.next();
          assert STR_COMP.compare(e.getKey(),node.getKey())==0 :
            "Tree element extra or missing: "+e.getKey();
          assert e.getValue().compareTo((Integer)node.getValue())==0 :
            "Tree value wrong: "+e.getValue();
          assert btree.get(e.getKey()).getValue().equals(e.getValue()) :
            "Lookup failed for "+e.getKey();
      }
      assert keyRm != null;
      assert !iter.hasNext() : "Too many items in tree";
      int size1 = btree.size();
      BTreeI<Str,Integer> subtree = btree.removeSubtree(keyRm);
      assert btree.removeSubtree(keyRm)==null;
      int size2 = btree.size();
      assert size2 < size1;
      List<NodeI<Str,Integer>> nodes = all(subtree);
      assert size1 == size2 + nodes.size() :
        String.format("%d == %d + %d",size1,size2,nodes.size());
      int count = 0;
      for(NodeI<Str,Integer> missing : nodes) {
        try {
          btree.get(missing.getKey());
          assert false : "Didn't throw exception for missing element";
        } catch(RuntimeException re) {
          assert !re.getClass().getName().startsWith("java.") :
            "Exception should be a custom class not "+re.getClass().getName();
          count++;
        }
      }
      assert count == nodes.size() :
        String.format("%d == %d",count,nodes.size());
      assert count > 0;
      btree.clear();
      assert btree.size()==0;
    }
    System.out.println("All tests passed.");
    System.out.println("However, you must also check that your code compiles with no warnings");
    System.out.println("resulting from unchecked types. In addition, inspect your code to ensure");
    System.out.println("that you have generic type annotations everywhere.");
  }
  static <K,V> List<NodeI<K,V>> all(BTreeI<K,V> b) {
    List<NodeI<K,V>> list = new ArrayList<>();
    for(NodeI<K,V> n : b.list())
      list.add(n);
    return list;
  }
}