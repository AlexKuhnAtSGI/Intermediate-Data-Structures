package comp2402a2;
import java.util.List;


/**
 */
public class Tester {
  public static boolean testPart1(List<Integer> ell) throws Exception {
    int K = 100000;
    Stopwatch s = new Stopwatch();
    System.out.print("Appending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      ell.add(i);
      if (ell.get(ell.size() - 1) != i) {
        System.out.println(ell.get(ell.size() - 1));
        return false;
      }
      if (ell.size() != i + 1) {
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Prepending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      ell.add(0, i);
      if (ell.get(0) != i) {
        System.out.println(i);
        System.out.println(ell.get(0));
        return false;}
      if (ell.size() != K + i + 1) {
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Setting " + K + " items at the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      ell.set(K - i - 1, i);
      if (ell.get(i) != K - i - 1) {
        System.out.println(i);
        System.out.println(ell.get(i));
        return false;}
      if (ell.size() != K + K) {
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Midpending(?!) " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      ell.add(ell.size()/2, i);
      if (ell.get(ell.size()/2) != i  && ell.get(ell.size()/2 - 1) != i) {
        System.out.println(i);
        System.out.println(ell.get(ell.size()/2));
        System.out.println(ell.get(ell.size()/2 + 1));
        System.out.println(ell.get(ell.size()/2 - 1));
        return false;}
      if (ell.size() != K + K + i + 1) {
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    
    System.out.print("Removing " + K + " items from the back...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      if (ell.remove(ell.size()-1) != K - i - 1) {
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Removing " + K + " items from the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      if (ell.remove(0) != K - i - 1){
        System.out.println(ell.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Removing " + K + " items from the middle...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      ell.remove(ell.size()/2);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    return true;
  }
  
  public static boolean testPart2(List<Integer> rad) {
    int K = 100000;
    Stopwatch s = new Stopwatch();
    System.out.print("Appending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      rad.add(i);
//      System.out.println(i);
//      System.out.println(rad.get(rad.size() - 1));
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Prepending " + K + " items...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      rad.add(0, i);
//      System.out.println(i);
//      System.out.println(rad.get(0));
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Setting " + K + " items at the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      rad.set(K - i - 1, i);
      if (rad.get(i) != K - i - 1) {
        System.out.println(i);
        System.out.println(rad.get(i));
        return false;}
      if (rad.size() != K + K) {
        System.out.println(rad.size());
        return false;
      }
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    if (s.elapsedSeconds() > 2) {return false;}
    
    System.out.print("Removing " + K + " items from the back...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      rad.remove(rad.size()-1);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    
    System.out.print("Removing " + K + " items from the front...");
    System.out.flush();
    s.start();
    for (int i = 0; i < K; i++) {
      rad.remove(0);
    }
    s.stop();
    System.out.println("done (" + s.elapsedSeconds() + "s)");
    return true;
  }
  
  public static boolean testPart3(AbstractTable<Integer> t) {
    int nrows = 9, ncols = 6;
    for (int i = 0; i < ncols; i++) {
      t.addCol(t.cols());
      
    }
    if (t.cols() != ncols) {return false;}
      
    for (int i = 0; i < nrows; i++) {
      t.addRow(t.rows());
    }
    if (t.rows() != nrows) {return false;}
    
    for (int i = 1; i <= nrows; i++) {
      t.set(i-1, (i-1)%t.cols(), 1111*i);
    }
    System.out.println(t.toString());
    t.addCol(2);
    t.addRow(3);
    System.out.println(t.toString());
    t.removeCol(2);
    t.removeRow(3);
    System.out.println(t.toString());
    t.set(0,0,1234);
    if (t.get(0,0) != 1234) {return false;}
    return true;
  }
  
  public static void main (String[] args) throws Exception {
    System.out.println("TREQUE TEST");
    List<Integer> ell = new Treque<Integer>(Integer.class);
    testPart1(ell);
    System.out.println("ROOTISHARRAYDEQUE TEST");
    List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);
    testPart2(rad);
    System.out.println("TABLE TEST");
    AbstractTable<Integer> t = new Table<Integer>(Integer.class);
    testPart3(t);
  }
  
}
