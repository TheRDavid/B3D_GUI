package dialogs;

import other.Wizard;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

public class AboutDialog extends BasicDialog
{

    private JTextArea textArea = new JTextArea(" Banana3D 0\n Engine Version: 3.0.10 \n\n"
            + " Using ... "
            + "\n ... jMonkeyEngine:         \thttp://jmonkeyengine.org/"
            + "\n ... SearchableComboBox:    \thttp://www.java.happycodings.com/Java_Swing/code6.html"
            + "\n ... SwingX:                \thttps://swingx.java.net/"
            + "\n ... t0neg0d-GUI:           \thttp://hub.jmonkeyengine.org/wiki/doku.php/jme3:contributions:tonegodgui"
            + "\n ... Lemur:                 \thttp://hub.jmonkeyengine.org/forum/topic/lemur-work-in-progress-posted/"
            + "\n ... Logo by armaganvideos: \thttp://www.youtube.com/channel/UCewxBLhWDSZUvtOnlXdI_sA"
            + "\n ... Icons by Icons8:       \thttps://icons8.com/");
    private JLabel logoLabel = new JLabel(Wizard.resizeImage(new ImageIcon("dat//img//other//logoBig.png").getImage(), 800, 800, false));

    public AboutDialog()
    {
        textArea.setEditable(false);
        setResizable(false);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        addWindowFocusListener(new WindowFocusListener()
        {
            @Override
            public void windowGainedFocus(WindowEvent e)
            {
            }

            @Override
            public void windowLostFocus(WindowEvent e)
            {
                dispose();
            }
        });
        setTitle("About Banana3D");
        add(logoLabel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        pack();
        setModal(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}