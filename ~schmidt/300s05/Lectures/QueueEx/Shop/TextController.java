
package Shop;
import java.awt.event.*;
import Queue.*;

/** TextController delivers lines of text to the print shop */
public class TextController implements ActionListener
{ Queue text_queue;  // the queue that holds the text lines
  PrintShop shop; // the print shop that comsumes the text lines
  TextFrame text_frame;  // the frame from which the text lines are extracted

  /** Constructor TextController initializes the controller
    * @param q - the queue into which the text lines are deposited
    * @param f - the text frame from which the lines are extracted
    * @param s - the print shop that consumes the text lines */
  public TextController(Queue q, TextFrame f, PrintShop s)
  { text_queue = q; 
    shop = s;
    text_frame = f;
    text_frame.connectSaveButton(this);
  }

  /** actionPerformed inserts a new text line into the queue and signals the
    *  print shop */
  public void actionPerformed(ActionEvent e)
  { String s = text_frame.getText();
    text_queue.enqueue(s);
    shop.materialArrived();
  }
}
