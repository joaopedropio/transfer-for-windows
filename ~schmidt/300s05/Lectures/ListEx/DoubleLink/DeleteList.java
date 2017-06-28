package DoubleLink;
/** DeleteList models a list that allows deletion of arbitrary elements:
  *   -- the insertion method adds a new object to the list, and returns
  *      a ``key'' to that object;
  *   -- the deletion method uses the ``key'' to locate and delete the object;
  *   -- the list's contents can be printed from front to rear  */
public class DeleteList
{ private DoubleCell front;  // the first DoubleCell of the list
  private DoubleCell rear;   // the last DoubleCell of the list
                             // invariant:  if the list is empty, 
                             //  then front == null == rear

  /** Constructor DeleteList constructs an empty list */
  public DeleteList()
  { front = null;
    rear = null;
  }

  /** insert adds a new object to the list
    * @param ob - the object added  
    * @return  an address which will be used as the ``key'' to the object */
  public Object insert(Object ob)
  { // ``chain'' a new cell to the rear of the list:
    DoubleCell new_cell = new DoubleCell(ob, rear, null); 
    // if list is empty, then set  front  and  rear  to  new_cell:
    if ( front == null )
         { front = new_cell; 
           rear = new_cell;
         }
    else // list is nonempty, so add  new_cell  to the end of the list:
        { rear.setNext(new_cell);
          rear = new_cell;
        }
    return new_cell;   // use the cell's address at the ``key''!
  }

  /** delete  removes the object from the list that is identified by the
    *  ``key'' parameter
    * @param key - the ``key'' to the object to be removed
    * @throw RuntimeException if the ``key'' is invalid and matches no
    *   no object in the list. */
  public void delete(Object key)
  { // recast the ``key'' into a Cell address:
    DoubleCell delete_me = (DoubleCell)key; 

    // remove the deleted cell from the list by resetting its neighbors' links:
    if ( delete_me.getPrev() == null ) // is deleted cell at the front?
         { front = delete_me.getNext(); }
    else { delete_me.getPrev().setNext(delete_me.getNext()); }

    if ( delete_me.getNext() == null ) // is deleted cell at the rear?
         { rear = delete_me.getPrev(); }
    else { delete_me.getNext().setPrev(delete_me.getPrev()); }

    // for safety's sake, erase all links from deleted cell:
    delete_me.setPrev(null);
    delete_me.setNext(null);
  }

  /** toString constructs a string representation of the list's contents
    * @return the string  */
  public String toString()
  { DoubleCell current = front;
    String answer = "";
    while ( current != null )
          // invariant: so far, have included values in all cells from
          // the  front  cell up to (but not including) the  current  cell
          { answer = answer + current.getVal().toString();
            current = current.getNext();
          }
    return answer;
  }
}
