package dialogs;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class BasicDialog extends JDialog
{

    public BasicDialog()
    {
        setType(Type.UTILITY);
        setModal(true);
        setIconImage(new ImageIcon("dat//img//other//logo.png").getImage());
    }

    public BasicDialog(String title)
    {
        setType(Type.UTILITY);
        setModal(true);
        setIconImage(new ImageIcon("dat//img//other//logo.png").getImage());
        setTitle(title);
    }
}
