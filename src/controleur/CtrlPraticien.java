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
    
    public CtrlPraticien() {
        vue = new VuePraticien(this);
    }
     
        
     
    @Override
    public VuePraticien getVue() {
        return (VuePraticien) vue;
    }
}
