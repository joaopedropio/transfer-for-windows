
package Shop;
import Queue.*;
import java.awt.*;

/** PrintShop assembles colors and text lines into colored text */
public class PrintShop
{
  private Queue text_queue;  // the queue that holds text lines
  private Queue color_queue; // the queue that holds colors for the lines
  private OutputFrame outview; // the output view that displays the text

  /** PrintShop initializes the print shop
    * @param t - the queue that holds lines of text
    * @param c - the queue that holds colors
    * @param f - the output frame into which the colored text is deposited */
  public PrintShop(Queue t, Queue c, OutputFrame f)
  { text_queue = t;
    color_queue = c;
    outview = f;
  }

  /** materialArrived attempts to assemble a colored line of text, provided
    * there are ample materials in both the text queue and colors queue */
  public void materialArrived()
  { if ( ! text_queue.isEmpty()  &&  ! color_queue.isEmpty())
       { String s  = (String)(text_queue.dequeue());
         Color c = (Color)(color_queue.dequeue());
         outview.paintText(c, s);
       }
  }
}

