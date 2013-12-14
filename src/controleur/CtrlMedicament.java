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
    
    public CtrlMedicament(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMedicament(this);
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
     

    @Override
    public VueMedicament getVue() {
        return (VueMedicament) vue;
    }
    
         public void quitter() throws Exception{
         this.getCtrlPrincipal().action(EnumAction.MEDICAMENT_QUITTER);
     } 
    
}
