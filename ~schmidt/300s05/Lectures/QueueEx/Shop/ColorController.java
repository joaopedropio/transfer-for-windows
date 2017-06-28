
package Shop;
import java.awt.*;
import java.awt.event.*;
import Queue.*;

/** ColorController delivers a newly produced color into the print shop */
public class ColorController implements ActionListener
{ Color my_color;   // the color that is produced by this controller
  Queue color_queue; // the queue into which colors are delivered
  PrintShop shop;  // the print shop that consumes the queue

  /** Constructor ColorController initializes the controller
    * @param c - the color to be delivered
    * @param q - the queue to where the color is delivered
    * @param f - the frame into which the user makes the color request
    * @param s - the print shop that comsumes colors placed into the queue */
  public ColorController(Color c, Queue q, ColorFrame f, PrintShop s)
  { my_color = c;
    color_queue = q; 
    shop = s;
    f.connectSaveButton(my_color, this);
  }

  /** actionPerformed delivers a color into the queue and signals the shop */
  public void actionPerformed(ActionEvent e)
  { color_queue.enqueue(my_color);
    shop.materialArrived();
  }
}
