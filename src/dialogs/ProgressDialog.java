/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import components.SmallProgressbar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class ProgressDialog extends BasicDialog
{

    private SmallProgressbar progressBar;
    private JLabel label;

    public ProgressDialog(String string, int i, int i0)
    {
        setModal(false);
        setTitle("Saving Scene to " + string);
        progressBar = new SmallProgressbar();
        progressBar.setColor(Color.orange);
        progressBar.setDisplayValue(false);
        progressBar.setMax(i0);
        progressBar.setValue(i);
        label = new JLabel("Saving");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(progressBar, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        setAlwaysOnTop(true);
        setSize(500, 80);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void valueUp()
    {
        valueUp(1);
    }

    public void valueMax()
    {
        progressBar.setValue(progressBar.getMax());
    }

    @Override
    public void dispose()
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.dispose();
    }

    public void valueUp(int size)
    {
        progressBar.setValue(progressBar.getValue() + size);
    }
}
