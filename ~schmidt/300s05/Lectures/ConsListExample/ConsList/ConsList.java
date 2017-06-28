
package ConsList;
/** ConsList defines the data type of cons-lists:
  *   a  Nil  cons-list will be modelled by   new Nil();
  *   a  Cons cons-list will be modelled by   new Cons(h, t). 
  * We use the Composite Design Pattern to model cons-lists. */
public abstract class ConsList
{ /** head returns the element at the front of this list
    * @return the head element, if it exists
    * @throw RuntimeException, if the list is empty and has no head  */
  public Object head()
  // here is the default coding of this method:
  { throw new RuntimeException("ConsList: head error"); }

  /** tail returns the remainder of the list 
    * @return the list's tail, if it exists
    * @throw RuntimeException, if the list is empty and has no tail */
  public ConsList tail()
  // here is the default coding of this method:
  { throw new RuntimeException("ConsList: tail error"); }
}

