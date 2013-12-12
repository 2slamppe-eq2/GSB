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
public class CtrlMedicament extends CtrlAbstrait{
    
    private CtrlMedicament ctrlMedicament= null;
    
    public CtrlMedicament() {
        vue = new VueMedicament(this);
    }
     
        
     
    @Override
    public VueMedicament getVue() {
        return (VueMedicament) vue;
    }
    
}
