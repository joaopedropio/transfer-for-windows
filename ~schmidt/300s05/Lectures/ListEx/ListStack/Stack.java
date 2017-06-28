
package ListStack;
/** Stack models a stack data structure (using a linked list)  */
public class Stack
{ private Cell top;  // the top cell of the stack, which is modelled by
                     //  a linked list of Cells.
                     // invariant: top == null means the stack is empty

  /** Constructor  Stack  creates an empty stack. */
  public Stack()
  { top = null; }

  /** push  inserts a new element onto the stack
    * @param ob - the element to be added */
  public void push(Object ob)
  { // reset the top of the stack to be a new Cell that holds  ob:
    top = new Cell(ob, top); 
  }

  /** pop  removes the most recently added element
    * @return the element removed from the stack
    * @exception RuntimeException if stack is empty */
  public Object pop()
  { if ( top == null )
       { throw new RuntimeException("Stack error: stack empty"); }
    // else, return the value in the  top  stack cell:
    Object answer = top.getVal();
    top = top.getNext();
    return answer;
  }

  /** top  returns the identity of the most recently added element
    * @return the element
    * @exception RuntimeException if stack is empty */
  public Object top()
  { if ( top == null )
       { throw new RuntimeException("Stack error: stack empty"); }
    // else:
    return top.getVal();
  }

  /** isEmpty  states whether the stack has 0 elements.
    * @return whether the stack has no elements  */
  public boolean isEmpty()
  { return ( top == null ); }
}
