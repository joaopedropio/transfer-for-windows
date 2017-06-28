
package ConsList;
/** Cons defines a nonempty ConsList, containing a head and a tail.  */
public class Cons extends ConsList
{ private Object hd;   // the element saved at the front of the list
  private ConsList tl; // the remainder of the list

  /** Cons  creates a new list whose front element is  x  and remainder is  y */
  public Cons(Object x, ConsList y)
  { hd = x;
    tl = y;
  }

  public Object head()
  { return hd; }

  public ConsList tail()
  { return tl; }
}


