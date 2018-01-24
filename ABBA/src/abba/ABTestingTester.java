/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abba;

import java.lang.reflect.*;
import java.util.Random;

public class ABTestingTester {
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
      c2 = c.getDeclaredConstructor(new Class[]{Integer.TYPE,Integer.TYPE});
    } catch(Exception ex) {}
    assert c2 != null : "Constructor 2 from the instructions isn't present.";
    assert Modifier.isPrivate(c2.getModifiers()) : "Constructor 2 should be private";
    c2.setAccessible(true);

    Random r = new Random();
    int numInstances = 100+r.nextInt(100);
    for(int i=0;i<numInstances;i++) {
      int a = r.nextInt(20);
      int b = r.nextInt(20);
      ABTesting ab = (ABTesting)c1.newInstance();
      assert ab.votesForAinThisTest() == 0 : "votesForAinThisTest() should be zero for a newly constructed object.";
      assert ab.votesForBinThisTest() == 0 : "votesForBinThisTest() should be zero for a newly constructed object.";
      for(int ia = 0; ia < a; ia++)
        ab.voteForA();
      for(int ib = 0; ib < b; ib++)
        ab.voteForB();
      assert ab.votesForAinThisTest() == a : "votesForAinThisTest() not working";
      assert ab.votesForBinThisTest() == b : "votesForBinThisTest() not working";
      assert ab.totalVotesInThisTest() == a+b : "totalVotesInThisTest() not working";
      assert ab.totalTests() == i+1 : "totalTests() not working";

      ABTesting ab2 = (ABTesting)c2.newInstance(new Object[]{a,b});
      c2.newInstance(0,0);
      assert ab.votesForAinThisTest() == a : "Constructor 2 not working";
      assert ab.votesForBinThisTest() == b : "Constructor 2 not working";
    }
    System.out.println("All tests passed.");
  }
}