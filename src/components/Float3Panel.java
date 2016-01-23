package components;

import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import dialogs.ObserverDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;
import org.jdesktop.swingx.VerticalLayout;
import se.datadosen.component.RiverLayout;

/**
 * A Panel with 3 Textfields that stores the values of a Vector3f
 *
 * @author David
 */
public class Float3Panel extends JPanel
{

    private BTextField xField = new BTextField("Float", "x"),
            yField = new BTextField("Float", "y"),
            zField = new BTextField("Float", "z");
    private Dimension prefDimension = new Dimension(65, 20);
    private boolean manualUserChangeMade = false;
    private DecimalFormat rounder = new DecimalFormat("0.000");
    public static final int HORIZONTAL = 0, VERTICAL = 1;

    /**
     * Sets the start-Vector & sets up the GUI
     *
     * @param vec
     */
    public Float3Panel(Vector3f vec, Camera cam, int orientation)
    {
        this.addFieldMouseListener(new InsertCamLocationMouseListener(this, cam));
        if (vec != null)
        {
            xField.setText("" + rounder.format(vec.getX()).replace(',', '.'));
            yField.setText("" + rounder.format(vec.getY()).replace(',', '.'));
            zField.setText("" + rounder.format(vec.getZ()).replace(',', '.'));
        }
        xField.setPreferredSize(prefDimension);
        yField.setPreferredSize(prefDimension);
        zField.setPreferredSize(prefDimension);
        if (orientation == HORIZONTAL)
        {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(xField);
            add(yField);
            add(zField);
        } else
        {
            setLayout(new RiverLayout(10, 10));
            add(new JLabel("x: "));
            add("tab hfill", xField);
            add("br", new JLabel("y: "));
            add("tab hfill", yField);
            add("br", new JLabel("z: "));
            add("tab hfill", zField);
        }
    }

    /**
     *
     * @return vector
     */
    public Vector3f getVector()
    {
        //NULL-Vector
        if (xField.getText().equals("null"))
            return null;
        try
        {
            return new Vector3f(Float.parseFloat(xField.getText()), Float.parseFloat(yField.getText()), Float.parseFloat(zField.getText()));
        } catch (java.lang.NumberFormatException nfe)
        {
            ObserverDialog.getObserverDialog().printMessage("Error returning Vector3 from Float3Panel, returning Vector3f.ZERO");
            return Vector3f.ZERO;
        }
    }

    /**
     *
     * @return true if one of the textfields is focused
     */
    @Override
    public boolean hasFocus()
    {
        return (xField.hasFocus() || yField.hasFocus() || zField.hasFocus());
    }

    /**
     *
     * @param vec
     */
    public void setVector(Vector3f vec)
    {
        if (vec == null)
        {
            xField.setText("null");
            yField.setText("null");
            zField.setText("null");
        } else
        {
            xField.setText("" + rounder.format(vec.getX()).replace(',', '.'));
            yField.setText("" + rounder.format(vec.getY()).replace(',', '.'));
            zField.setText("" + rounder.format(vec.getZ()).replace(',', '.'));
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
    }

    /**
     * Add a MouseListener to every TextField
     *
     * @param mouseListener
     */
    private void addFieldMouseListener(MouseListener mouseListener)
    {
        xField.addMouseListener(mouseListener);
        yField.addMouseListener(mouseListener);
        zField.addMouseListener(mouseListener);
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
        zField.addKeyListener(keyListener);
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
    }

    public BTextField getxField()
    {
        return xField;
    }

    public BTextField getyField()
    {
        return yField;
    }

    public BTextField getzField()
    {
        return zField;
    }

    public boolean isManualUserChangeMade()
    {
        return manualUserChangeMade;
    }

    /**
     *
     * @param manualUserChangeMade
     */
    public void setManualUserChangeMade(boolean manualUserChangeMade)
    {
        this.manualUserChangeMade = manualUserChangeMade;
    }

    public DecimalFormat getRounder()
    {
        return rounder;
    }

    public float[] getFloats()
    {
        float x = Float.parseFloat(xField.getText());
        float y = Float.parseFloat(yField.getText());
        float z = Float.parseFloat(zField.getText());
        return new float[]
        {
            x, y, z
        };
    }

    public void setFloats(float[] toAngles)
    {
        xField.setText("" + toAngles[0]);
        yField.setText("" + toAngles[1]);
        zField.setText("" + toAngles[2]);
    }
}
