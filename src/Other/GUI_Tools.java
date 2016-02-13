package Other;

import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author David
 */
public class GUI_Tools
{
    public static void repaintAll(Component c)
    {
        c.repaint();
        if(c instanceof Container)
            for(Component c0 : ((Container)c).getComponents())
                repaintAll(c0);
    }
}
