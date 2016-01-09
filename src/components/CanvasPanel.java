package components;

import dialogs.ObserverDialog;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This Panel either contains the 3D-Canvas or the welcome image / animation.
 */
public class CanvasPanel extends JPanel
{

    private ImageIcon playIcon;
    private ImageIcon playIcon2;
    private boolean seriousNow = false;
    private Ellipse2D.Double ellipse = new Ellipse2D.Double();
    private Graphics2D g2d;
    private AlphaComposite ac;
    private int bubbleSize = Toolkit.getDefaultToolkit().getScreenSize().width / 10;

    public CanvasPanel()
    {
    }

    public boolean isSeriousNow()
    {
        return seriousNow;
    }

    public void setSeriousNow(boolean seriousNow)
    {
        this.seriousNow = seriousNow;
    }
}
