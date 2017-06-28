
import DoubleLink.*;
/** TestSequence does simple tests of the linked-list sequence.  */
public class TestSequence
{ public static void main(String[] args)
  { DualSequence p  = new DualSequence();

    System.out.println("Sequence so far (should be empty): " + p.toString());

    p.addToRear("B");
    System.out.println("Sequence after adding B: " + p.toString());

    p.addToRear("C");
    p.addToFront("A");
    System.out.println("Sequence after adding C and A: " + p.toString());
    System.out.println("Reversed: " + p.toStringReversed());

    Object s = p.removeFromRear();
    System.out.println("Sequence after removing an object: " + p.toString());
    s = p.removeFromFront();
    System.out.println("Sequence after removing another: " + p.toString());
  }
}
