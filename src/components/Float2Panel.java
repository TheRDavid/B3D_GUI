package components;

import com.jme3.math.Vector2f;
import dialogs.ObserverDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

/**
 * A Panel with 2 Textfields that stores the values of a Vector2f
 *
 * @author David
 */
public class Float2Panel extends JPanel
{

    private BTextField xField = new BTextField("Float", "x")
    {
        @Override
        public void setText(String text)
        {
            super.setText(text);
            if (wasJustDragged())
            {
                resetJustDragged();
                setVector(new Vector2f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText())));
            }
        }
    },
            yField = new BTextField("Float", "y")
    {
        @Override
        public void setText(String text)
        {
            super.setText(text);
            if (wasJustDragged())
            {
                resetJustDragged();
                setVector(new Vector2f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText())));
            }
        }
    };
    private Dimension prefDimension = new Dimension(100, 20);

    /**
     * Sets the start-Vector & sets up the GUI
     *
     * @param vec
     */
    public Float2Panel(Vector2f vec)
    {
        if (vec != null)
        {
            xField.setText("" + vec.getX());
            yField.setText("" + vec.getY());
        }
        xField.setPreferredSize(prefDimension);
        yField.setPreferredSize(prefDimension);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(xField);
        add(yField);
    }

    public Vector2f getVector()
    {
        try
        {
            return new Vector2f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()));
        } catch (java.lang.NumberFormatException nfe)
        {
            ObserverDialog.getObserverDialog().printMessage("Error returning Vector2 from Float2Panel, returning Vector2f.ZERO");
            return Vector2f.ZERO;
        }
    }

    /**
     *
     * @param vec
     */
    public void setVector(Vector2f vec)
    {
        xField.setText("" + vec.getX());
        yField.setText("" + vec.getY());
    }

    /**
     * Add a FocusListener to every TextField
     *
     * @param focusListener
     */
    public void addFieldFocusListener(FocusListener focusListener)
    {
        xField.addFocusListener(focusListener);
        yField.addFocusListener(focusListener);
    }

    /**
     * Add a MouseListener to every TextField
     *
     * @param mouseListener
     */
    public void addFieldMouseListener(MouseListener mouseListener)
    {
        xField.addMouseListener(mouseListener);
        yField.addMouseListener(mouseListener);
    }

    /**
     * Add a KeyListener to every TextField
     *
     * @param keyListener
     */
    public void addFieldKeyListener(KeyListener keyListener)
    {
        xField.addKeyListener(keyListener);
        yField.addKeyListener(keyListener);
    }

    /**
     * Add a DocumentListener to every TextField
     *
     * @param documentListener
     */
    public void addFieldDocumentListener(DocumentListener documentListener)
    {
        xField.getDocument().addDocumentListener(documentListener);
        yField.getDocument().addDocumentListener(documentListener);
    }
}
