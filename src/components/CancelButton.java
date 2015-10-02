package components;

import dialogs.BasicDialog;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

/**
 * A BButton that closes a Window
 *
 * @author David
 */
public class CancelButton extends BButton
{

    /**
     * Creates a CancelButton
     *
     * @param window that shall be closed when the Button is pressed
     */
    public CancelButton(final Window window)
    {
        setText("Cancel");
        setIcon(new ImageIcon("dat//img//menu//cancel.png"));
        setBorder(new EmptyBorder(5, 5, 5, 25));
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                window.dispose();
            }
        });
    }

    /**
     * Creates a CancelButton
     *
     * @param dialog that shall be closed when the Button is pressed
     * @param text of the button
     */
    public CancelButton(final BasicDialog dialog, String text)
    {
        setText(text);
        setIcon(new ImageIcon("dat//img//menu//cancel.png"));
        setBorder(new EmptyBorder(5, 5, 5, 25));
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dialog.dispose();
            }
        });
    }
}
