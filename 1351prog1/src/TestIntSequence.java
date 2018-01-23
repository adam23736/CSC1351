import java.util.Random;

public class TestIntSequence {
  final static Random RAND = new Random();
  public static void main(String[] args) throws Exception {
    try {
      assert false;
      throw new Error("You need to enable assertions");
    } catch(AssertionError ae) {}
    Class c = Class.forName(args[0]);
    IntSequence seq = (IntSequence)c.newInstance();
    IntSequence a = null;
    
    int st = RAND.nextInt(10);
    int en = RAND.nextInt(10)+st+3;
    a = seq.generate(st,en);
    System.out.printf("Testing sequence from %d to %d%n",st,en);
    System.out.printf("  seq=%s%n",a);
    for(int i=st;i<=en;i++) {
      assert a.hasNextInt() : "hasNextInt() returned false, but more values should have been available";
      assert a.nextInt() == i : "nextInt() returned a wrong value";
    }
    assert !a.hasNextInt() : "hasNextInt() returned true, but there should be no more values";

    st = RAND.nextInt(10);
    en = RAND.nextInt(10)+st+3;
    a = seq.generate(st,en);
    System.out.printf("Testing sequence from %d to %d%n",en,st);
    System.out.printf("  seq=%s%n",a);
    a = seq.generate(en,st);
    for(int i=en;i>=st;i--) {
      assert a.hasNextInt() : "hasNextInt() returned false, but more values should have been available";
      assert a.nextInt() == i: "nextInt() returned a wrong value";
    }
    assert !a.hasNextInt() : "hasNextInt() returned true, but there should be no more values";
    
    st = RAND.nextInt(10);
    en = RAND.nextInt(10)+st+3;
    a = seq.generate(en,st).generateReverse();
    System.out.printf("Testing reverse sequence from %d to %d%n",en,st);
    System.out.printf("  seq=%s%n",a);
    for(int i=st;i<=en;i++) {
      assert a.hasNextInt() : "hasNextInt() returned false, but more values should have been available";
      assert a.nextInt() == i: "nextInt() returned a wrong value";
    }
    assert !a.hasNextInt()  : "hasNextInt() returned true, but there should be no more values";

    int v = RAND.nextInt(100);
    System.out.printf("Testing random sequence");
    a = seq.generateRandom(10,v,v);
    for(int i=0;i<10;i++) {
      assert a.hasNextInt() : "hasNextInt() returned false, but more values should have been available";
      assert a.nextInt()==v: "nextInt() returned a wrong value";
    }
    assert !a.hasNextInt() : "hasNextInt() returned true, but there should be no more values";

    int vc = 0, vp = 0;
    System.out.println("Testing random sequence again");
    a = seq.generateRandom(1000,v,v+1);
    while(a.hasNextInt()) {
      int r = a.nextInt();
      if(r == v) vc++;
      else if(r == v+1) vp++;
      else assert false: "nextInt() returned a wrong value";
    }
    assert vc > 0 && vp > 0 : "Something is wrong with random number generation";

    System.out.println("Testing toString()");

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    int[] vdata = new int[RAND.nextInt(10)+5];
    for(int i=0;i<vdata.length;i++) {
      vdata[i] = RAND.nextInt(100);
      if(i>0) sb.append(',');
      sb.append(vdata[i]);
    }
    sb.append(']');
    a = seq.generate(vdata);
    assert sb.toString().equals(a.toString()) : "ToString() isn't formatting correctly";

    System.out.println("Testing generate(int[])");
    System.out.printf("  seq=%s%n",a);
    for(int i=0;i<vdata.length;i++) {
      assert a.hasNextInt() : "hasNextInt() returned false, but more values should have been available";
      int old = vdata[i];
      vdata[i] = RAND.nextInt(100);
      assert a.nextInt() == old : "nextInt() returned a wrong value";
    }
    assert !a.hasNextInt() : "hasNextInt() returned true, but there should be no more values";

    System.out.println("All tests passed");
  }
}