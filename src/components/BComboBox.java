package components;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import org.jdesktop.swingx.JXComboBox;

/**
 * A JXCombobox that sorts the elements.
 *
 * @author David
 * @param <E>
 */
public class BComboBox<E> extends JXComboBox
{

    public BComboBox()
    {
        setBorder(new RoundBorder());
    }

    public BComboBox(Object[] items)
    {
        super(items);
    }

    public BComboBox(ComboBoxModel model)
    {
        super(model);
    }

    public BComboBox(Vector<?> items)
    {
        super(items);
    }

    public void sort()
    {
        Vector<String> vec = new Vector<String>();
        String selected = getSelectedItem().toString();
        for (int i = 0; i < getItemCount(); i++)
        {
            vec.add(getItemAt(i).toString());
        }
        removeAllItems();
        Collections.sort(vec, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < vec.size(); i++)
        {
            addItem(vec.get(i));
        }
        for (int i = 0; i < getItemCount(); i++)
        {
            if (selected.equals(getItemAt(i).toString()))
            {
                setSelectedIndex(i);
            }
        }
    }
}
