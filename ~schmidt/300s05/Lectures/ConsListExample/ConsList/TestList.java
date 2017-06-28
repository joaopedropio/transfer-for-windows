
package ConsList;
/** TestList shows a few experiments with ConsLists */
public class TestList
{ 
  public static void main(String[] a)
  { ListOps op = new ListOps();  // activate class of list operations
    ConsList empty = new Nil();
    ConsList alist = new Cons("a", empty);
    ConsList xlist = new Cons("x", new Cons("y", empty));

    ConsList clist = op.append(xlist, alist);

    System.out.println("The length of " + op.toString(xlist)
                        + "  is " + op.lengthOf(xlist));

    System.out.println("The length of " + op.toString(clist)
                        + "  is " + op.lengthOf(clist));
  }
}

