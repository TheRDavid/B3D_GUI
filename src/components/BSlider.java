package components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A slider that displays the value as text. Deals with the problem of storing
 * floats in a Slider that can only deal with ints.
 *
 * @author David
 */
public class BSlider extends JSlider
{

    private float min = 0.0f;
    private float max = 100.0f;
    private float mid = 50.0f;
    private String stringValue;
    private Class valueClass;

    /**
     * Sets up a new BSlider
     *
     * @param c - is it a float?
     * @param minimum
     * @param maximum
     * @param value
     */
    public BSlider(Class c, float minimum, float maximum, float value)
    {
        super();
        valueClass = c;
        _setMin(minimum);
        _setMax(maximum);
        _setValue(value);
        addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                //Refresh text
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g)
    {
        //Draw a rectangle over the lower part of the component and display the value there as a String
        super.paintComponent(g);
        g.setColor(getParent().getBackground());
        g.fillRect(0, getHeight() / 2, getWidth(), getHeight());
        g.setColor(new Color(153, 153, 204));
        stringValue = Float.toString(_getValue());
        g.drawString(stringValue, getWidth() / 2 - (int) (stringValue.length() * 1.8f), getHeight() / 2 + 10);
    }

    /**
     * Is it a float? Return the getMaximum / local max. If not, return
     * getMaximum
     */
    public float _getMax()
    {
        if (valueClass.equals(Float.class))
        {
            return (getMaximum() / max);
        } else
        {
            return getMaximum();
        }
    }

    /**
     * Is it a float? Return the getMinimum / local max. If not, return
     * getMinimum
     */
    public float _getMin()
    {
        if (valueClass.equals(Float.class))
        {
            return (getMinimum() / max);
        } else
        {
            return getMinimum();
        }
    }

    /**
     * Is it a float? Return the getValue / local max. If not, return getValue
     */
    public float _getValue()
    {
        if (valueClass.equals(Float.class))
        {
            return (getValue() / max);
        } else
        {
            return getValue();
        }
    }

    /**
     * Is it a float? set Maximum to local max * 100 (maybe percentages) If not,
     * set it to local max
     *
     * @param max
     */
    public void _setMax(float max)
    {
        if (valueClass.equals(Float.class))
        {
            setMaximum((int) (max * 100));
        } else
        {
            setMaximum((int) max);
        }
    }

    /**
     * Is it a float? set Minimum to local min * 100 (maybe percentages) If not,
     * set it to local min
     *
     * @param min
     */
    public void _setMin(float min)
    {
        if (valueClass.equals(Float.class))
        {
            setMinimum((int) (min * 100));
        } else
        {
            setMinimum((int) min);
        }
    }

    /**
     * Is it a float? set Value to local val * 100 (maybe percentages) If not,
     * set it to local val
     *
     * @param val
     */
    public void _setValue(float val)
    {
        if (valueClass.equals(Float.class))
        {
            setValue((int) (val * 100));
        } else
        {
            setValue((int) val);
        }
    }
}
