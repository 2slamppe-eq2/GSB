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
public class CtrlGCR extends CtrlAbstrait{
    
    private CtrlGCR ctrlGCR = null;
    
    public CtrlGCR() {
        vue = new VueGCR(this);
    }
     
        
     
    @Override
    public VueGCR getVue() {
        return (VueGCR) vue;
    }
    
    public void OuvrirVueCR(){
        CtrlCR ctrlCR= new CtrlCR();        
        ctrlCR.getVue().setEnabled(true);
        ctrlCR.getVue().setVisible(true);
        this.getVue().setVisible(false);
    }
    
    public void OuvrirVueVisiteur(){
        CtrlVisiteur ctrlVisiteur  = new CtrlVisiteur();        
        ctrlVisiteur.getVue().setEnabled(true);
        ctrlVisiteur.getVue().setVisible(true);
        this.getVue().setVisible(false);
    }
    
    public void OuvrirVuePraticien(){
        CtrlPraticien ctrlPraticien= new CtrlPraticien();        
        ctrlPraticien.getVue().setEnabled(true);
        ctrlPraticien.getVue().setVisible(true);
        this.getVue().setVisible(false);
    }
    
    public void OuvrirVueMedicament(){
        CtrlMedicament ctrlMedicament = new CtrlMedicament();        
        ctrlMedicament.getVue().setEnabled(true);
        ctrlMedicament.getVue().setVisible(true);
        this.getVue().setVisible(false);
    }
    
    public void Quitter(){
        System.exit(0);
    }
  
    
}
