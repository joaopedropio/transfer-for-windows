
package Stack;
/** Stack models a stack data structure  */
public class Stack
{ private int INITIAL_SIZE = 5;
  private int top;     // how many elements in the stack
  private Object[] s;  // the stack
         // invariants: elements on stack are  s[top-1] s[top-2] ... s[0]
         //             top  is always in range  0 .. s.length-1

  /** Constructor  Stack  creates a stack. */
  public Stack()
  { s = new Object[INITIAL_SIZE]; 
    top = 0; 
  }

  /** push  inserts a new element onto the stack
    * @param ob - the element to be added */
  public void push(Object ob)
  { if ( top == s.length )
         { // array is full---create a new one to hold more objects:
           Object[] temp = new Object[s.length * 2];
           for ( int j = 0;  j != top;  j = j+1 )
               { temp[j] = s[j]; }  // copy elements into  temp
           s = temp;   // set  s  to hold address of  temp
         }
    s[top] = ob;
    top = top + 1;
  }

  /** pop  removes the most recently added element
    * @return the element removed from the stack
    * @exception RuntimeException if stack is empty */
  public Object pop()
  { if ( top == 0 )
       { throw new RuntimeException("Stack error: stack empty"); }
    top = top - 1;
    return s[top];
  }

  /** top  returns the identity of the most recently added element
    * @return the element
    * @exception RuntimeException if stack is empty */
  public Object top()
  { if ( top == 0 )
       { throw new RuntimeException("Stack error: stack empty"); }
    return s[top - 1];
  }

  /** isEmpty  states whether the stack has 0 elements.
    * @return whether the stack has no elements  */
  public boolean isEmpty()
  { return ( top == 0 ); }
}

