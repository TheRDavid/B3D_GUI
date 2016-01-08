package dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTextArea;
import other.Wizard;
import se.datadosen.component.RiverLayout;

public class ObserverDialog extends BasicDialog
{

    private static ObserverDialog observerDialog = new ObserverDialog();

    public static ObserverDialog getObserverDialog()
    {
        return observerDialog;
    }
    private JProgressBar memoryProgressBar;
    private JLabel threadCountLabel = new JLabel();
    private OutputArea outputArea = new OutputArea();
    private JScrollPane outputScrollPane;
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private ObserverDialog()
    {
        outputScrollPane = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        outputScrollPane.setPreferredSize(new Dimension(800, 600));
        setTitle("Observer");
        setModal(false);
        memoryProgressBar = new JProgressBar(0, (int) (Runtime.getRuntime().totalMemory() / 1024));
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                long mb = 1024 * 1024;
                while (true)
                {
                    try
                    {
                        Thread.sleep(50);
                    } catch (InterruptedException ex)
                    {
                        ObserverDialog.this.printError("Thread.sleep in ObserverDialog interrupted", ex);
                    }
                    memoryProgressBar.setMaximum((int) (ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax() / mb));
                    memoryProgressBar.setValue((int) (ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / mb));
                    memoryProgressBar.setStringPainted(true);
                    memoryProgressBar.setString(memoryProgressBar.getValue() + "MB / " + memoryProgressBar.getMaximum() + "MB");
                    threadCountLabel.setText(Integer.toString(ManagementFactory.getThreadMXBean().getThreadCount()));
                }
            }
        }).start();
        setLayout(new RiverLayout());
        add("br left", new JLabel("Treads running: "));
        add("tab hfill", threadCountLabel);
        add("br left", new JLabel("Memory usage: "));
        add("tab hfill", memoryProgressBar);
        add("br hfill", outputScrollPane);
        setAlwaysOnTop(true);
        setSize(300, 100);
        setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight());
        setVisible(true);
    }

    public void printMessage(String msg)
    {
        outputArea.append("\n\n" + dateFormat.format(new Date())
                + " Message:\n" + msg);
        outputScrollPane.scrollRectToVisible(new Rectangle(0, outputScrollPane.getHeight(), 1, 1));
        //save();
    }

    public void printError(String msg, Exception error)
    {
        StringWriter stringWriter = new StringWriter();
        error.printStackTrace(new PrintWriter(stringWriter));
        String exception = stringWriter.toString();
        outputArea.append("\n\n" + dateFormat.format(new Date())
                + " Message:\n" + msg + "\n" + exception);
        outputScrollPane.scrollRectToVisible(new Rectangle(0, outputScrollPane.getHeight(), 1, 1));
        save();
    }

    private void save()
    {
        //Wizard.saveFile("log.txt", outputArea.getText());
    }

    private class OutputArea extends JXTextArea
    {

        public OutputArea()
        {
            setWrapStyleWord(true);
            setForeground(Color.ORANGE);
            setOpaque(false);
            setEditable(false);
        }
    }
}