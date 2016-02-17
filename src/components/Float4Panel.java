package components;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector4f;
import dialogs.ObserverDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;
import se.datadosen.component.RiverLayout;

/**
 * A Panel with 4 Textfields that stores the values of a Vector4f
 *
 * @author David
 */
public class Float4Panel extends JPanel
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
                setVector(new Vector4f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText())));
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
                setVector(new Vector4f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText())));
            }
        }
    },
            zField = new BTextField("Float", "z")
    {
        @Override
        public void setText(String text)
        {
            super.setText(text);
            if (wasJustDragged())
            {
                resetJustDragged();
                setVector(new Vector4f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText())));
            }
        }
    },
            wField = new BTextField("Float", "w")
    {
        @Override
        public void setText(String text)
        {
            super.setText(text);
            if (wasJustDragged())
            {
                resetJustDragged();
                setVector(new Vector4f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText())));
            }
        }
    };
    private Dimension prefDimension = new Dimension(60, 20);
    public static final int HORIZONTAL = 0, VERTICAL = 1;

    /**
     * Sets the start-Vector & sets up the GUI
     *
     * @param vec
     */
    public Float4Panel(Object vec, int orientation)
    {
        if (vec != null)
            if (vec instanceof Vector4f)
            {
                Vector4f vec4 = (Vector4f) vec;
                xField.setText("" + vec4.getX());
                yField.setText("" + vec4.getY());
                zField.setText("" + vec4.getZ());
                wField.setText("" + vec4.getW());
            } else
            {
                Quaternion vec4 = (Quaternion) vec;
                xField.setText("" + vec4.getX());
                yField.setText("" + vec4.getY());
                zField.setText("" + vec4.getZ());
                wField.setText("" + vec4.getW());
            }
        xField.setPreferredSize(prefDimension);
        yField.setPreferredSize(prefDimension);
        zField.setPreferredSize(prefDimension);
        wField.setPreferredSize(prefDimension);
        if (orientation == HORIZONTAL)
        {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(xField);
            add(yField);
            add(zField);
            add(wField);
        } else
        {
            setLayout(new RiverLayout(10, 10));
            add(new JLabel("x: "));
            add("tab hfill", xField);
            add("br", new JLabel("y: "));
            add("tab hfill", yField);
            add("br", new JLabel("z: "));
            add("tab hfill", zField);
            add("br", new JLabel("w: "));
            add("tab hfill", wField);
        }
    }

    /**
     *
     * @param vec
     */
    public void setVector(Vector4f vec)
    {
        if (vec == null)
        {
            xField.setText("null");
            yField.setText("null");
            zField.setText("null");
            wField.setText("null");
        } else
        {
            xField.setText("" + vec.getX());
            yField.setText("" + vec.getY());
            zField.setText("" + vec.getZ());
            wField.setText("" + vec.getW());
        }
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
        zField.addFocusListener(focusListener);
        wField.addFocusListener(focusListener);
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
        zField.addMouseListener(mouseListener);
        wField.addMouseListener(mouseListener);
    }

    /**
     *
     * Add a KeyListener to every TextField
     *
     * @param keyListener
     */
    public void addFieldKeyListener(KeyListener keyListener)
    {
        xField.addKeyListener(keyListener);
        yField.addKeyListener(keyListener);
        zField.addKeyListener(keyListener);
        wField.addKeyListener(keyListener);
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
        zField.getDocument().addDocumentListener(documentListener);
        wField.getDocument().addDocumentListener(documentListener);
    }

    public void setFloats(Vector4f vec4f)
    {
        xField.setText("" + vec4f.getX());
        yField.setText("" + vec4f.getY());
        zField.setText("" + vec4f.getZ());
        wField.setText("" + vec4f.getW());
    }

    public void setFloats(Quaternion qua)
    {
        xField.setText("" + qua.getX());
        yField.setText("" + qua.getY());
        zField.setText("" + qua.getZ());
        wField.setText("" + qua.getW());
    }

    /**
     *
     * @return vector
     */
    public Vector4f getVector()
    {
        try
        {
            return new Vector4f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText()));
        } catch (java.lang.NumberFormatException nfe)
        {
            ObserverDialog.getObserverDialog().printMessage("Error returning Vector4 from Float4Panel, returning Vector4f.ZERO");
            return Vector4f.ZERO;
        }
    }

    /**
     *
     * @return quaternion
     */
    public Quaternion getQuaternion()
    {
        try
        {
            return new Quaternion(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()), Float.parseFloat(wField.getText()));
        } catch (java.lang.NumberFormatException nfe)
        {
            ObserverDialog.getObserverDialog().printMessage("Error returning Vector4 from Float4Panel, returning Vector4f.ZERO");
            return Quaternion.ZERO;
        }
    }
}
