
package Shop;
import Queue.*;
import java.awt.*;
/** Start assembles the components of the print shop and starts it.
  *  The print shop consists of 
  *  (i) two input-view components, into which
  *   the user deposits sequences of text lines and color choices;
  *  (ii) two queues, which hold the text lines and colors;
  *  (iii) a print shop, which extracts materials from the two queues
  *   and assembles lines of colored text;
  *  (iv) an output frame, which shows the assembled colored text lines. */
public class Start
{ public static void main(String[] args)
  { // Construct and connect the components of the print shop:

    // queues that hold the input text lines and input colors:
    Queue text_queue = new Queue();
    Queue color_queue = new Queue();

    // input views (sources of text lines and colors):
    TextFrame text_frame = new TextFrame();
    ColorFrame color_frame = new ColorFrame();

    // output view that displays the assembled colored text lines:
    OutputFrame out_frame = new OutputFrame();

    // the ``print shop'' that assembles colored text lines:
    PrintShop shop = new PrintShop(text_queue, color_queue, out_frame);

    // controllers:
    TextController text_controller
             = new TextController(text_queue, text_frame, shop);
    ColorController red
             = new ColorController(Color.red, color_queue, color_frame, shop);
    ColorController  blue
             = new ColorController(Color.blue, color_queue, color_frame, shop);
    ColorController black
             = new ColorController(Color.black, color_queue, color_frame, shop);
  }
}

