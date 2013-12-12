/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlCR extends CtrlAbstrait{
    
     private CtrlCR ctrlCR = null;
    
    public CtrlCR() {
        vue = new VueCR(this);
    }
     
        
     
    @Override
    public VueCR getVue() {
        return (VueCR) vue;
    }
    
}
