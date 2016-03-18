package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * A small Progressbar... yup (currently not used) Saves space for other
 * components.
 *
 * @author David
 */
public class SmallProgressbar extends JPanel
{

    private int max = 100;
    private int value = 0;
    private int height = 5;
    private Color color = Color.cyan;
    private String string = " ";
    private boolean displayValue = true;

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        g2d.setColor(color);
        if (displayValue)
        {
            g2d.drawRect(0, getHeight() - (height + 4), getWidth() - 1, height);
            double filled = (getWidth() - 1);
            filled = filled / max * value;
            g2d.fillRect(0, getHeight() - (height + 4), (int) filled, height);
            string = value + " / " + max;
            g2d.setColor(Color.cyan);
            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            g2d.drawString(string, getWidth() / 2 - string.length() * 3 / 2, 16);
        } else
        {
            g2d.drawRect(0, getHeight()/2 - height/2, getWidth() - 1, height);
            double filled = (getWidth() - 1);
            filled = filled / max * value;
            g2d.fillRect(0, getHeight()/2 - height/2, (int) filled, height);
        }
    }

    /**
     * Sets the height to 30
     */
    public SmallProgressbar()
    {
        setPreferredSize(new Dimension(getPreferredSize().width, 30));
    }

    public boolean isDisplayValue()
    {
        return displayValue;
    }

    public void setDisplayValue(boolean setDisplayValue)
    {
        this.displayValue = setDisplayValue;
    }

    public int getMax()
    {
        return max;
    }

    public void setMax(int max)
    {
        this.max = max;
        repaint();
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int val)
    {
        //System.out.println(val + " out of "+getMax());
        this.value = val;
        repaint();
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
        repaint();
    }
}
