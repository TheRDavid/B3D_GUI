package components;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector4f;
import dialogs.ObserverDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

/**
 * A Panel with 4 Textfields that stores the values of a Vector4f
 *
 * @author David
 */
public class Float4Panel extends JPanel
{

    private BTextField xField = new BTextField("Float", "x"),
            yField = new BTextField("Float", "y"),
            zField = new BTextField("Float", "z"),
            wField = new BTextField("Float", "w");
    private Dimension prefDimension = new Dimension(60, 20);

    /**
     * Sets the start-Vector & sets up the GUI
     *
     * @param vec
     */
    public Float4Panel(Vector4f vec)
    {
        if (vec != null)
        {
            xField.setText("" + vec.getX());
            yField.setText("" + vec.getY());
            zField.setText("" + vec.getZ());
            wField.setText("" + vec.getW());
        }
        xField.setPreferredSize(prefDimension);
        yField.setPreferredSize(prefDimension);
        zField.setPreferredSize(prefDimension);
        wField.setPreferredSize(prefDimension);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(xField);
        add(yField);
        add(zField);
        add(wField);
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
}
