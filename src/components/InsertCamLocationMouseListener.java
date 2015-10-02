package components;

import com.jme3.renderer.Camera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Special MouseListener to insert the cam's location into a Float3Panel
 *
 * @author David
 */
public class InsertCamLocationMouseListener implements MouseListener
{

    private Float3Panel float3Panel;
    private JPopupMenu popupMenu = new JPopupMenu();
    private JMenuItem insertCameraLocationItem = new JMenuItem("Camera Location");
    private Camera cam;

    /**
     * Sets the Float3Panel & add the ActionListener
     * @param f3p
     */
    public InsertCamLocationMouseListener(Float3Panel f3p, Camera camera)
    {
        cam=camera;
        float3Panel = f3p;
        popupMenu.add(insertCameraLocationItem);
        insertCameraLocationItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float3Panel.setManualUserChangeMade(true);
                float3Panel.setVector(cam.getLocation().clone());
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON3)
        {
            popupMenu.show(float3Panel, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}
