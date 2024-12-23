package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testAddLast() {
      BuggyAList<Integer> broken = new BuggyAList<>();
      broken.addLast(Integer.valueOf(5));
      broken.addLast(Integer.valueOf(8));
      broken.addLast(Integer.valueOf(10));
      //Integer last = broken.getLast();
      assertEquals(10, broken.getLast().intValue());
      assertEquals(3, broken.size());
  }
  @Test 
  public void testRemoveLast() {
      BuggyAList<Integer> broken = new BuggyAList<>();
      broken.addLast(Integer.valueOf(5));
      broken.addLast(Integer.valueOf(8));
      broken.addLast(Integer.valueOf(10));
      assertEquals(10, broken.removeLast().intValue());
      assertEquals(2, broken.size());
      assertEquals(8, broken.getLast().intValue());
  }
  @Test
  public void testGetLast() {
      BuggyAList<Integer> broken = new BuggyAList<>();
      broken.addLast(Integer.valueOf(5));
      broken.addLast(Integer.valueOf(8));
      broken.addLast(Integer.valueOf(10));
      assertEquals(10, broken.getLast().intValue());
      assertEquals(3, broken.size());
  }
  /** AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
        } */
  @Test
  public void randomizedTest() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      int N = 500;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              
              int randVal = StdRandom.uniform(0, 100);
              correct.addLast(randVal);
              broken.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {

              int sizeCorrect = correct.size();
              int sizeBroken = broken.size();
              System.out.println("size: correct = " + sizeCorrect + ", broken = " + sizeBroken);
              assertEquals(sizeCorrect, sizeBroken);
          } else if (operationNumber == 2) {
                 
              if (correct.size() > 0) {
                int lastCorrect = correct.getLast();
                int lastBroken = broken.getLast();
                System.out.println("getLast: correct = " + lastCorrect + ", broken = " + lastBroken);
                assertEquals(lastCorrect, lastBroken);
          } else if (operationNumber == 3) {
              if (correct.size() > 0) {
              int removedCorrect = correct.removeLast();
              int removedBroken = broken.removeLast();

              System.out.println("removeLast: correct = " + removedCorrect + ", broken = " + removedBroken);
              assertEquals(removedCorrect, removedBroken); 
            }
          }
        }

    }
  }
}
