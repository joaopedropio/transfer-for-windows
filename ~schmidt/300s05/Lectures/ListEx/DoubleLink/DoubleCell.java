package DoubleLink;
/** DoubleCell models a cell with double links; it is used to assemble
  *  doubly linked list.  */
public class DoubleCell
{ private Object val;  // value in the cell
  private DoubleCell next;   // the address of the next cell in the list
  private DoubleCell prev;   // the address of the previous cell in the list

  /** Constructor DoubleCell builds a new cell 
    * @param value - the value inserted in the cell
    * @param prevlink - the predecessor cell to this one
    * @param nextlink - the successor cell to this one  */
  public DoubleCell(Object value, DoubleCell prevlink, DoubleCell nextlink)
  { val = value; 
    prev = prevlink;
    next = nextlink;
  }

  /** getVal  returns the value held in the cell  */
  public Object getVal()
  { return val; }

  /** getPrev  returns the address of the previous cell chained to this one */
  public DoubleCell getPrev()
  { return prev; }

  /** getNext  returns the address of the next cell chained to this one */
  public DoubleCell getNext()
  { return next; }

  /** setPrev  resets the address of the predecessor cell to this one
    * @param link - the address of the new predecessor DoubleCell */
  public void setPrev(DoubleCell link)
  { prev = link; }

  /** setNext  resets the address of the successor cell chained to this one
    * @param link - the address of the new successor DoubleCell */
  public void setNext(DoubleCell link)
  { next = link; }
}

