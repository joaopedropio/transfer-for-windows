package ListStack;
/** Cell models one cell used to assemble a linked list.  */
public class Cell
{ private Object val;  // value in the cell
  private Cell next;   // the address of the next cell in the list

  /** Constructor Cell builds a new cell 
    * @param value - the value inserted in the cell
    * @param link - the cell that is chained to this new cell */
  public Cell(Object value, Cell link)
  { val = value; 
    next = link;
  }

  /** getVal  returns the value held in the cell  */
  public Object getVal()
  { return val; }

  /** getNext  returns the address of the cell chained to this one */
  public Cell getNext()
  { return next; }

  /** setNext  resets the address of the cell chained to this one
    * @param link - the address of the Cell that is chained to this one */
  public void setNext(Cell link)
  { next = link; }
}

