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
public class CtrlVisiteur extends CtrlAbstrait{
    
    private CtrlVisiteur ctrlVisiteur = null;
    
    public CtrlVisiteur() {
        vue = new VueVisiteur(this);
    }
     
        
     
    @Override
    public VueVisiteur getVue() {
        return (VueVisiteur) vue;
    }
    
}
