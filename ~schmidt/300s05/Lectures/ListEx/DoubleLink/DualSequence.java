package DoubleLink;
/** DualSequence models a sequence of objects so such that:
  *   -- objects at added to the front and to the rear of the sequence;
  *   -- objects can be removed from the front and rear of the sequence;
  *   -- the sequence's contents can be displayed from front to rear and  
  *       from rear to front (that is, in reverse order)  */
public class DualSequence
{ private DoubleCell front;  // the first DoubleCell of the path
  private DoubleCell rear;   // the last DoubleCell of the path
                             // invariant:  if path is empty, 
                             //  then front == null == rear

  /** Constructor DualSequence constructs an empty sequence */
  public DualSequence()
  { front = null;
    rear = null;
  }

  /** addToFront  adds a new object to the front of this sequence
    * @param ob - the object added  */
  public void addToFront(Object ob)
  { // ``chain'' a new cell to the front:
    DoubleCell new_cell = new DoubleCell(ob, null, front);
    // if sequence is empty, then set  front  and  rear  to  new_cell:
    if ( front == null )
         { front = new_cell;
           rear = new_cell;
         }
    else // sequence is nonempty, so add  new_cell  to the front:
         { front.setPrev(new_cell);
           front = new_cell;
         }
  }

  /** addToRear  adds a new object to the end of this sequence
    * @param ob - the object added  */
  public void addToRear(Object ob)
  { // ``chain'' a new cell to the rear:
    DoubleCell new_cell = new DoubleCell(ob, rear, null); 
    // if sequence is empty, then set  front  and  rear  to  new_cell:
    if ( front == null )
         { front = new_cell; 
           rear = new_cell;
         }
    else // sequence is nonempty, so add  new_cell  to the end:
        { rear.setNext(new_cell);
          rear = new_cell;
        }
  }

  /** removeFromFront  deletes the front object of this sequence
    * @return the object that is removed.
    * @throw RuntimeException if the sequence is empty. */
  public Object removeFromFront()
  { if ( front == null )
         { throw new RuntimeException("DualSequence delete error: empty"); }
    // else, sequence is nonempty:
    DoubleCell answer = front;
    if ( answer.getNext() != null )  // any other objects in the sequence?
         { answer.getNext().setPrev(null);
           front = answer.getNext();   // reset the next object to be the front
         }
    else // we removed the only object:
         { rear = null;
           front = null;
         }
    return answer.getVal();
  }

  /** removeFromRear deletes the rear object of this sequence
    * @return the object that is removed.
    * @throw RuntimeException if the sequence is empty. */
  public Object removeFromRear()
  { if ( front == null )
         { throw new RuntimeException("DualSequence delete error: empty"); }
    // else, sequence is nonempty:
    DoubleCell answer = rear;
    if ( answer.getPrev() != null )  // any othere objects in the sequence?
         { answer.getPrev().setNext(null); 
           rear = answer.getPrev();
         }
    else // we removed the only object:
         { rear = null;
           front = null;
         }
    return answer.getVal();
  }

  /** toString  constructs a string representation of the sequence from front
    *  to rear
    * @return the string  */
  public String toString()
  { DoubleCell current = front;
    String answer = "";
    while ( current != null )
          // invariant: so far, have included values in all cells from
          // the  front  cell up to (but not including) the  current  cell
          { answer = answer + " " + current.getVal().toString();
            current = current.getNext();
          }
    return answer;
  }

  /** toStringReversed  constructs a string representation of the sequence
    *  in reverse order, from rear to front
    * @return the string  */
  public String toStringReversed()
  { DoubleCell current = rear;
    String answer = "";
    while ( current != null )
          // invariant: so far, have included values in all cells from
          // the  rear cell up to (but not including) the  current  cell
          { answer = answer + " " + current.getVal().toString();
            current = current.getPrev();
          }
    return answer;
  }
}
