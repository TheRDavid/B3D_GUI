package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A BButton, used to set the Color of an Object
 */
public class ColorButton extends BButton
{

    private Color color;

    /**
     * Creates a ColorButton, used to set the Color of an Object
     *
     * @param initColor the Color the Button shall be initialized with
     */
    public ColorButton(Color initColor)
    {
        setPreferredSize(new Dimension(30, 20));
        if (initColor == null)
        {
            setText("Select Color");
        }
        setColor(initColor);
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setColor(JColorChooser.showDialog(ColorButton.this, "Select Color", ColorButton.this.getBackground()));
            }
        });
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (color != null)
        {
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    /**
     * @return the current Color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     *
     * @param col
     */
    public void setColor(Color col)
    {
        color = col;
    }
}
