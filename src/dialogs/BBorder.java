package dialogs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author David
 */
public class BBorder extends AbstractBorder
{

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        super.paintBorder(c, g, x, y, width, height); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        g.fillOval(0, 0, 30, 30);
    }
    
}
