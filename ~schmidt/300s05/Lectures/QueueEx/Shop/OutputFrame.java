
package Shop;
import javax.swing.*;
import java.awt.*;
/** OutputFrame  displays the lines of colored output text. */
public class OutputFrame extends JFrame
{ private int FRAME_WIDTH = 200;
  private String text;   // the most recent text line to print
  private Color c;       // the text's color
  private int location;  // where to print the text on the frame

  public OutputFrame ()
  { text = "";
    c = Color.black;
    location = 40;
    setTitle("Output");
    setSize(FRAME_WIDTH, FRAME_WIDTH * 4);
    setVisible(true);
  }

  /** paint paints the window 
    * @param g - the window's graphics pen */
  public void paint(Graphics g)
  { g.setColor(c);
    g.drawString(text, 40, location);
  }

  /** paintText paints a new string 
    * @param k - the color of the new string
    * @param t - the new string  */
  public void paintText(Color k, String t)
  { c = k;  text = t;  location = location + 15;
    repaint();
  }
}

