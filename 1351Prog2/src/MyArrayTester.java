import java.lang.reflect.*;
import java.util.Random;

public class MyArrayTester {
  public static void main(String[] args) throws Exception {
    try {
      assert false;
      throw new Error("Assertions need to be enabled.");
    } catch(AssertionError ae) {}
    assert args.length == 1 : "You have to give the name of your class as argument";
    Class<?> c = Class.forName(args[0]);
    Constructor c1 = null;
    try {
      c1 = c.getDeclaredConstructor(new Class[]{});
    } catch(Exception ex) {}
    assert c1 != null : "Constructor 1 from the instructions isn't present.";
    assert Modifier.isPublic(c1.getModifiers()) : "Constructor 1 should be public";
    Constructor c2 = null;
    try {
      c2 = c.getDeclaredConstructor(new Class[]{MyArray.class});
    } catch(Exception ex) {}
    assert c2 != null : "Constructor 2 from the instructions isn't present.";
    assert Modifier.isPublic(c2.getModifiers()) : "Constructor 2 should be public";
    c2.setAccessible(true);
    Constructor c3 = null;
    try {
      c3 = c.getDeclaredConstructor(new Class[]{MyArray.class,Integer.TYPE,Integer.TYPE});
    } catch(Exception ex) {}
    assert c3 != null : "Constructor 3 from the instructions isn't present.";
    assert Modifier.isPublic(c3.getModifiers()) : "Constructor 3 should be public";
    c3.setAccessible(true);

    MyArray arr = (MyArray)c1.newInstance();
    assert arr.size() == 0 : "size() of newly generated array not 0";
    assert arr.get(0) == (String)null : "get(0) on empty array does not return null.";
    assert arr.get(-1) == (String)null : "get(-1) on empty array does not return null.";
    arr.append("one");
    assert arr.size() == 1 : "size() of one-element array not 1 (used append())";
    assert "one".equals(arr.get(0)) == true : "could not get correct value from array using get()";
    assert arr.get(-1) == (String)null : "get(-1) does not return null.";
    arr.append("two");
    assert arr.size() == 2 : "size() of two-element array not 2 (used append())";
    assert "one".equals(arr.get(0)) == true : "could not get correct value from array using get()";
    assert "two".equals(arr.get(1)) == true : "could not get correct value from array using get()";
    arr.set(-1, "nil");
    assert arr.size() == 2 : "set(-1, ...) should not do anything.";
    assert "one".equals(arr.get(0)) == true : "set(-1, ...) should not do anything.";
    assert "two".equals(arr.get(1)) == true : "set(-1, ...) should not do anything.";
    arr.set(6, "nil");
    assert arr.size() == 2 : "set(6, ...) should not do anything at this point.";
    assert "one".equals(arr.get(0)) == true : "set(6, ...) should not do anything here.";
    assert "two".equals(arr.get(1)) == true : "set(6, ...) should not do anything here.";
    arr.set(0, "eins");
    assert arr.size() == 2 : "size() of two-element array not 2 (used set())";
    assert "eins".equals(arr.get(0)) == true : "set() did not set correct element";
    assert "two".equals(arr.get(1)) == true : "set() did not set correct element";
    arr.set(1, "zwei");
    assert arr.size() == 2 : "size() of two-element array not 2 (used set())";
    assert "eins".equals(arr.get(0)) == true : "set() did not set correct element";
    assert "zwei".equals(arr.get(1)) == true : "set() did not set correct element";
    arr.append("drei");

    MyArray arr2 = (MyArray)c2.newInstance(arr);
    assert arr2.size() == 3: "size() of new array created with constructor 2 wrong";
    assert "eins".equals(arr2.get(0)) == true : "new array created with constructor 2 wrong";
    assert "zwei".equals(arr2.get(1)) == true : "new array created with constructor 2 wrong";
    assert "drei".equals(arr2.get(2)) == true : "new array created with constructor 2 wrong";

    MyArray arr3 = (MyArray)c3.newInstance(arr, 0, 0);
    assert arr3.size() == 0: "size() of new array created with constructor 3 wrong";
    arr3 = (MyArray)c3.newInstance(arr, 0, 1);
    assert arr3.size() == 1: "size() of new array created with constructor 3 wrong";
    assert "eins".equals(arr3.get(0)) == true : "new array created with constructor 3 wrong";
    arr3 = (MyArray)c3.newInstance(arr, 0, 2);
    assert arr3.size() == 2: "size() of new array created with constructor 3 wrong";
    assert "eins".equals(arr3.get(0)) == true : "new array created with constructor 3 wrong";
    assert "zwei".equals(arr3.get(1)) == true : "new array created with constructor 3 wrong";
    arr3 = (MyArray)c3.newInstance(arr, 0, 3);
    assert arr3.size() == 3: "size() of new array created with constructor 3 wrong";
    assert "eins".equals(arr3.get(0)) == true : "new array created with constructor 3 wrong";
    assert "zwei".equals(arr3.get(1)) == true : "new array created with constructor 3 wrong";
    assert "drei".equals(arr3.get(2)) == true : "new array created with constructor 3 wrong";
    arr3 = (MyArray)c3.newInstance(arr, -1, 0);
    assert arr3.size() == 0 : "constructor 3 didn't return empty array for invalid input";
    arr3 = (MyArray)c3.newInstance(arr, 1, 0);
    assert arr3.size() == 0 : "constructor 3 didn't return empty array for invalid input";

    assert "[eins, zwei, drei]".equals(arr.toString()) : "toString() not correct.";
    assert "[]".equals(arr3.toString())                : "toString() not correct.";

    assert arr.contains("eins") == true : "contains() does not return true";
    assert arr.contains("one")  != true : "contains() does not return false";
    arr.set(0, "drei");
    assert arr.contains("eins") != true : "contains() does not return false";
    assert arr.contains("drei") == true : "contains() does not return true";
    assert arr.get("eins") == -1: "get() does not return -1 for non-existing element";
    assert arr.get("drei") ==  0: "get() does not return correct index for existing element";
    assert arr.get("zwei") ==  1: "get() does not return correct index for existing element";

    arr.insert(1, "vier");
    assert arr.size() == 4: "insert() did not increase size";
    assert "drei".equals(arr.get(0)) == true : "new array after insert() wrong";
    assert "vier".equals(arr.get(1)) == true : "new array after insert() wrong";
    assert "zwei".equals(arr.get(2)) == true : "new array after insert() wrong";
    assert "drei".equals(arr.get(3)) == true : "new array after insert() wrong";

    assert arr.remove(-1) == null : "remove(int) did not return null for invalid data";
    assert arr.remove(4)  == null : "remove(int) did not return null for invalid data";

    assert "vier".equals(arr.remove(1)) : "remove() did not return correct value";
    assert arr.size() == 3: "remove() didn't decrease size";
    assert "drei".equals(arr.get(0)) == true : "new array after remove() wrong";
    assert "zwei".equals(arr.get(1)) == true : "new array after remove() wrong";
    assert "drei".equals(arr.get(2)) == true : "new array after remove() wrong";

    arr.insert(0, "fuenf");
    assert arr.size() == 4: "insert() did not increase size";
    assert "fuenf".equals(arr.get(0))== true : "new array after insert() wrong";
    assert "drei".equals(arr.get(1)) == true : "new array after insert() wrong";
    assert "zwei".equals(arr.get(2)) == true : "new array after insert() wrong";
    assert "drei".equals(arr.get(3)) == true : "new array after insert() wrong";

    assert "fuenf".equals(arr.remove(0)) : "remove() did not return correct value";
    assert arr.size() == 3: "remove() didn't decrease size";
    assert "drei".equals(arr.get(0)) == true : "new array after remove() wrong";
    assert "zwei".equals(arr.get(1)) == true : "new array after remove() wrong";
    assert "drei".equals(arr.get(2)) == true : "new array after remove() wrong";

    arr.insert(3, "sechs");
    assert arr.size() == 4: "insert() did not increase size";
    assert "drei".equals(arr.get(0))  == true : "new array after insert() wrong";
    assert "zwei".equals(arr.get(1))  == true : "new array after insert() wrong";
    assert "drei".equals(arr.get(2))  == true : "new array after insert() wrong";
    assert "sechs".equals(arr.get(3)) == true : "new array after insert() wrong";

    assert "sechs".equals(arr.remove(3)) : "remove() did not return correct value";
    assert arr.size() == 3: "remove() didn't decrease size";
    assert "drei".equals(arr.get(0)) == true : "new array after remove() wrong";
    assert "zwei".equals(arr.get(1)) == true : "new array after remove() wrong";
    assert "drei".equals(arr.get(2)) == true : "new array after remove() wrong";

    arr.insert(-1, "null");
    assert arr.size() == 3: "insert() didn't no-op for invalid input";
    arr.insert(4, "null");
    assert arr.size() == 3: "insert() didn't no-op for invalid input";

    assert arr.remove("zwei") == 1: "remove(String) didn't return correct index";
    assert arr.size() == 2: "remove(String) didn't decrease size";
    assert arr.remove("drei") == 0: "remove(String) didn't return correct index";
    assert arr.size() == 1: "remove(String) didn't decrease size";
    assert arr.remove("eins") ==-1: "remove(String) didn't return correct index";
    assert arr.size() == 1: "remove(String) changed size for invalid input";
    assert arr.remove("drei") == 0: "remove(String) didn't return correct index";
    assert arr.size() == 0: "remove(String) didn't decrease size";

    assert arr2.size() == 3: "size() of new array created with constructor 2 wrong";
    assert "eins".equals(arr2.get(0)) == true : "new array created with constructor 2 wrong";
    assert "zwei".equals(arr2.get(1)) == true : "new array created with constructor 2 wrong";
    assert "drei".equals(arr2.get(2)) == true : "new array created with constructor 2 wrong";

    for (int i = 1; i <= 10000; i++) {
      arr.append(" ");
      assert arr.size() == i : "size not correct after append";
    }
    for (int i = 1; i <= 10000; i++) {
      arr.remove(" ");
      assert arr.size() == 10000-i: "size not correct after remove(string)";
    }
    System.out.println("All tests passed.");
  }
}