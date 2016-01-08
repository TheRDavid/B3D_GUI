package components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * A styled JButton
 *
 * @author David
 */
public class BButton extends JButton
{

    /*Making it extendable*/
    public BButton()
    {
        setBorder(null);
    }

    /**
     *
     * @param text
     */
    public BButton(String text, boolean hasBorder)
    {
        setText(text);
        if (hasBorder)
            setBorder(new EmptyBorder(5, 5, 5, 5));
        else
            setBorder(null);
    }

    /**
     *
     * @param text
     */
    public BButton(String text)
    {
        setText(text);
    }

    public BButton(String text, Border border)
    {
        setBorder(border);
        setText(text);
    }

    public BButton(String text, ImageIcon icon)
    {
        setText(text);
        setIcon(icon);
        setBorder(new EmptyBorder(5, 5, 5, 25));
    }

    public BButton(ImageIcon icon, boolean emptyBorder)
    {
        setIcon(icon);
        if (emptyBorder)
        {
            setBorder(null);
            setBorder(new EmptyBorder(5, 5, 5, 5));
        }
    }
}
