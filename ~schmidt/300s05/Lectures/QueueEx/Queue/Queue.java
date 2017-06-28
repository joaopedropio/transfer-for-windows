
package Queue;
/** Queue implements a queue */
public class Queue
{ private Cell front;  // marks the first Cell of the queue
  private Cell rear;   // marks the last Cell of the queue

  /** Constructor Queue creates an empty queue */
  public Queue()
  { front = null;
    rear = null;
  }

  /** enqueue  inserts a new element to the end of the queue
    * @param ob - the element to be added */
  public void enqueue(Object ob)
  { Cell c = new Cell(ob, null);
    if ( front == null )  // is the queue empty?
       { front = c; }     // if true, then set front to  c
    else { rear.setNext(c); }  // else, attach  c  to the rear of the queue
    rear = c;
  }

 /** dequeue  removes the element from the front of the queue
   * @return the element removed
   * @exception RuntimeException if the queue is empty */
  public Object dequeue()
  { if ( front == null )
       { throw new RuntimeException("Queue error: queue empty"); }
    Object answer = front.getVal();
    if ( front == rear )  // queue contains just this one element?
       { rear = null; }   // if true, then set queue to empty
    front = front.getNext();
    return answer;
  }

 /** getFront returns the identity of the queue's front element
   * @return the element
   * @exception RuntimeException if stack is empty */
  public Object getFront()
  { if ( front == null )
       { throw new RuntimeException("Queue error: queue empty"); }
    return front.getVal();
  }

  /** isEmpty  states whether the queue has 0 elements.
    * @return whether the stack has no elements  */
  public boolean isEmpty()
  { return (front == null); }
}


