/*
 * SmartFrogActionListener.java
 * 
 * Created on 25.10.2007, 11:11:25
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package builder.smartfrog;

/**
 *
 * @author dominik
 */
public interface SmartFrogActionListener {
   public void stateChanged(SmartFrogAction action, SmartFrogAction.State newState);
}
