package components;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/**
 * ToggleButton with the style of a BButton
 *
 * @author David
 */
public class BToggleButton extends JToggleButton
{

    public BToggleButton()
    {
    }

    /**
     *
     * @param text
     * @param selected
     */
    public BToggleButton(String text, boolean selected)
    {
        setText(text);
        setSelected(selected);
    }

    public BToggleButton(ImageIcon icon, boolean selected)
    {
        setIcon(icon);
        setSelected(selected);
    }

    public BToggleButton(String text, boolean selected, boolean hasBorder)
    {
        if (!hasBorder)
            setBorder(null);
        setText(text);
        setSelected(selected);
    }

    public BToggleButton(String text, boolean selected, Border border)
    {
        setBorder(border);
        setText(text);
        setSelected(selected);
    }

    public BToggleButton(String text, ImageIcon icon, boolean selected)
    {
        setText(text);
        setIcon(icon);
        setSelected(selected);
    }
}
