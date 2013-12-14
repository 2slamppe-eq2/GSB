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
public class CtrlPraticien extends CtrlAbstrait{
    private CtrlPraticien ctrlPraticien = null;
    
    public CtrlPraticien(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VuePraticien(this);
    }
     
        
     
    @Override
    public VuePraticien getVue() {
        return (VuePraticien) vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_QUITTER);
    }
}

