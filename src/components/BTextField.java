package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

/**
 * Textfield with round border, that displays the given type as tooltip
 *
 * @author David
 */
public class BTextField extends JTextField implements MouseMotionListener
{

    private String valueType;
    private String val;
    private int iPrevMX = 0;
    private float fPrevMX = 0;
    private boolean justDragged = false;

    public boolean wasJustDragged()
    {
        return justDragged;
    }

    public void resetJustDragged()
    {
        justDragged = false;
    }

    /**
     *
     * @param type (like Integer, Float, whaevr)
     */
    public BTextField(String type)
    {
        this(type, type);
    }

    /**
     *
     * @param type (like int, float, whatever)
     * @param value -> default value
     */
    public BTextField(String type, String value)
    {
        addMouseMotionListener(this);
        val = value;
        valueType = type;
        setText(value);
        setFont(new Font("TimesNewRoman", Font.ITALIC, 12));
        //display type
        setToolTipText(valueType);
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                //special font if no value is inserted
                if (BTextField.this.getText().equals(valueType))
                {
                    setFont(new Font("TimesNewRoman", Font.ITALIC, 12));
                } else
                {
                    setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
                }
            }
        });
        addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                selectAll();
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if (getText().length() == 0)
                {
                    setText(val);
                    setFont(new Font("TimesNewRoman", Font.BOLD, 12));
                }
            }
        });
        setBorder(new AbstractBorder()
        {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
            {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int r = (height - 1) / 3;
                RoundRectangle2D round = new RoundRectangle2D.Float(x, y, width - 1, height - 1, r, r);
                Container parent = c.getParent();
                if (parent != null)
                {
                    g2.setColor(parent.getBackground());
                    Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
                    corner.subtract(new Area(round));
                    g2.fill(corner);
                }
                g2.setColor(Color.GRAY);
                g2.draw(round);
                g2.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c)
            {
                return new Insets(4, 8, 4, 8);
            }

            @Override
            public Insets getBorderInsets(Component c, Insets insets)
            {
                insets.left = insets.right = 8;
                insets.top = insets.bottom = 4;
                return insets;
            }
        });
    }

    public String getValueType()
    {
        return valueType;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        switch (valueType)
        {
            case "Integer":
                int diff = (e.getX() - iPrevMX) / 10;
                iPrevMX = e.getX();
                System.out.println("DIFF: " + diff);
                int value = Integer.parseInt(getText());
                justDragged = true;
                setText("" + (value + diff));
                break;
            case "Float":
                float difff = (e.getX() - fPrevMX) / 10;
                fPrevMX = (float) e.getPoint().getX();
                System.out.println("DIFF: " + difff);
                float valuef = Float.parseFloat(getText());
                justDragged = true;
                setText("" + (valuef + difff));
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }
}
