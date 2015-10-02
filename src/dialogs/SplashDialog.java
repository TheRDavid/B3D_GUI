package dialogs;

import com.sun.awt.AWTUtilities;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import other.Wizard;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author David
 */
public class SplashDialog extends JFrame
{

    public SplashDialog(ImageIcon ii)
    {
        ImageIcon icon = Wizard.resizeImage(ii.getImage(), Toolkit.getDefaultToolkit().getScreenSize().width / 3 * 2, Toolkit.getDefaultToolkit().getScreenSize().height / 3 * 2, true, BufferedImage.TYPE_4BYTE_ABGR);
        setUndecorated(true);
        try
        {
            AWTUtilities.setWindowOpacity(this, .98f);
        } catch (UnsupportedOperationException uoe)
        {
            ObserverDialog.getObserverDialog().printMessage("No transparency supported");
        }
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setBackground(new Color(0, 255, 0, 0));
        setContentPane(new ContentPane());
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setSize(icon.getIconWidth(), icon.getIconHeight());
        setLocationRelativeTo(null);
        add(new JLabel(icon));
        setVisible(true);
    }

    public class ContentPane extends JPanel
    {

        public ContentPane()
        {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
            g2d.setColor(getBackground());
            g2d.fill(getBounds());
            g2d.dispose();

        }
    }
}
