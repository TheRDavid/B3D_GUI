/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author User
 */
public class BSpinnerNumberModel extends SpinnerNumberModel
{

    public BSpinnerNumberModel(int nonsense, int value, int minimum, int maximum, int stepSize)
    {
        super(value, minimum, maximum, stepSize);
    }
    
}
