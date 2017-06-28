
import DoubleLink.*;
/** TestDeleteList does simple tests of a DeleteList.  */
public class TestDeleteList
{ public static void main(String[] args)
  { DeleteList x = new DeleteList();

    System.out.println("List so far (should be empty): " + x.toString());

    Object keyA = x.insert("A");
    System.out.println("List after adding A: " + x.toString());

    Object keyB = x.insert("B");
    Object keyC = x.insert("C");
    System.out.println("List after adding B and C: " +  x.toString());

    x.delete(keyB);
    System.out.println("List after removing with keyB: " + x.toString());

    x.delete(keyA);
    System.out.println("List after removing with keyA: " + x.toString());

    x.delete(keyC);
    System.out.println("List after removing with keyC: " + x.toString());
  }
}
