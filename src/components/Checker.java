package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Checker extends JComponent
{

    private boolean checked = false, animating = false, lastPaint = false;
    private int borderWidth = 2, transitionSpeed = 5;
    private double checkerPosition;
    private Color borderColor = new Color(250, 250, 250);

    public Checker()
    {
        setOpaque(false);
        setForeground(new Color(60, 205, 60));
        setBackground(new Color(150, 150, 150));
        setPreferredSize(new Dimension(50, 15));
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (isEnabled())
                    if (checked && e.getX() <= getWidth() / 2 || !checked && e.getX() >= getWidth() / 2)
                    {
                        checked = !checked;
                        animating = true;
                        repaint();
                    }
            }
        });
        checkerPosition = getPreferredSize().getWidth() / 2;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if (checkerPosition < 0)
            checkerPosition = 0;
        if (checkerPosition > getWidth() / 2)
            checkerPosition = getWidth() / 2;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //Fill background
        double bgRed = getBackground().getRed() - (50 / (getWidth() / 2)) * (getWidth() / 2 - checkerPosition);
        double bgGreen = getBackground().getGreen() - (50 / (getWidth() / 2)) * (getWidth() / 2 - checkerPosition);
        double bgBlue = getBackground().getBlue() - (50 / (getWidth() / 2)) * (getWidth() / 2 - checkerPosition);
        g2d.setColor(new Color((int) bgRed, (int) bgGreen, (int) bgBlue));
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), getWidth() / 3, getWidth() / 3);
        g2d.setColor(getForeground());
        if (!animating)
        {
            //Fill checker
            if (!checked)
            {
                g2d.setColor(Color.lightGray);
                g2d.fillRoundRect(0, 0, getWidth() / 2, getHeight(), getWidth() / 3, getWidth() / 3);
            } else
                g2d.fillRoundRect(getWidth() / 2, 0, getWidth() / 2, getHeight(), getWidth() / 3, getWidth() / 3);
            //Checker border
            g2d.setColor(borderColor);
            if (!checked)
                g2d.drawRoundRect(0, 0, getWidth() / 2, getHeight() - 1, getWidth() / 3, getWidth() / 3);
            else
                g2d.drawRoundRect(getWidth() / 2, 0, getWidth() / 2 - 1, getHeight() - 1, getWidth() / 3, getWidth() / 3);
        } else
        {
            lastPaint = true;
            //Translate checker
            if (checked)
                checkerPosition += getWidth() / (double) (100 / transitionSpeed);
            else
                checkerPosition -= getWidth() / (double) (100 / transitionSpeed);
            g2d.fillRoundRect((int) checkerPosition, 0, getWidth() / 2, getHeight(), getWidth() / 3, getWidth() / 3);
            //Checker border
            g2d.setColor(borderColor);
            if (!checked)
                g2d.drawRoundRect((int) checkerPosition, 0, getWidth() / 2, getHeight(), getWidth() / 3, getWidth() / 3);
            else
                g2d.drawRoundRect((int) checkerPosition, 0, getWidth() / 2, getHeight(), getWidth() / 3, getWidth() / 3);
            if (checkerPosition >= getWidth() / 2 && checked || checkerPosition <= 0 && !checked)
                animating = false;
        }
        if (animating)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Checker.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
        }
        //Paint once more for the text
        if (!animating && lastPaint)
        {
            lastPaint = false;
            repaint();
        }
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
        if (checked)
            checkerPosition = getWidth() / 4 * 3;
        else
            checkerPosition = 0;
    }

    public int getBorderWidth()
    {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth)
    {
        this.borderWidth = borderWidth;
    }

    public int getTransitionSpeed()
    {
        return transitionSpeed;
    }

    public void setTransitionSpeed(int transitionSpeed)
    {
        this.transitionSpeed = transitionSpeed;
    }

    public Color getBorderColor()
    {
        return borderColor;
    }

    public void setBorderColor(Color borderColor)
    {
        this.borderColor = borderColor;
    }

    @Override
    public void setBackground(Color bg)
    {
        
            super.setBackground(bg);
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        if (!enabled)
        {
            setForeground(getForeground().darker());
            setBackground(getBackground().darker());
        } else
        {
            setForeground(getForeground().brighter());
            setBackground(getBackground().brighter());
        }
        super.setEnabled(enabled); //To change body of generated methods, choose Tools | Templates.
    }
}