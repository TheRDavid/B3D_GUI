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
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (!seriousNow)
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException ex)
                    {
                        ObserverDialog.getObserverDialog().printError("Thread.sleep in EditorWindow interrupted", ex);
                    }
                    CanvasPanel.this.repaint();
                }
                playIcon = null;
                playIcon2 = null;
            }
        }).start();
        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseMoved(MouseEvent e)
            {
                ellipse.setFrame(e.getX() - bubbleSize / 2, e.getY() - bubbleSize / 2, bubbleSize, bubbleSize);
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g2d = (Graphics2D) g;
        if (!seriousNow)
        {
            g.drawImage(playIcon.getImage(), getWidth() / 2 - playIcon.getIconWidth() / 2, getHeight() / 2 - playIcon.getIconHeight() / 2, playIcon.getIconWidth(), playIcon.getIconHeight(), null);
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1);
            g2d.setComposite(ac);
            g.setClip(ellipse);
            g.drawImage(playIcon2.getImage(), getWidth() / 2 - playIcon.getIconWidth() / 2, getHeight() / 2 - playIcon.getIconHeight() / 2, playIcon.getIconWidth(), playIcon.getIconHeight(), null);
        }
    }

    public ImageIcon getPlayIcon()
    {
        return playIcon;
    }

    public void setPlayIcon(ImageIcon playIcon)
    {
        this.playIcon = playIcon;
    }

    public ImageIcon getPlayIcon2()
    {
        return playIcon2;
    }

    public void setPlayIcon2(ImageIcon playIcon2)
    {
        this.playIcon2 = playIcon2;
    }

    public boolean isSeriousNow()
    {
        return seriousNow;
    }

    public void setSeriousNow(boolean seriousNow)
    {
        this.seriousNow = seriousNow;
    }

    public int getBubbleSize()
    {
        return bubbleSize;
    }

    public void setBubbleSize(int bubbleSize)
    {
        this.bubbleSize = bubbleSize;
    }
}
