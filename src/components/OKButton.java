package components;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class OKButton extends BButton
{

    public OKButton(String text)
    {
        setText(text);
        setIcon(new ImageIcon("dat//img//menu//ok.png"));
        setBorder(new EmptyBorder(5, 5, 5, 25));
    }

    public OKButton(String text, boolean hasBorder)
    {
        setIcon(new ImageIcon("dat//img//menu//ok.png"));
        setText(text);
        if (hasBorder)
            setBorder(new EmptyBorder(5, 5, 5, 25));
    }
}
