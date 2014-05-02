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
    
    
    public CtrlGCR(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueGCR(this);
    }
     
        
     
    @Override
    public VueGCR getVue() {
        return (VueGCR) vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    /**
     * Appelle le controleur principal qui affiche la vue VueCR permettant de consulter les rapports de visite
     * @throws Exception 
     */
    public void OuvrirVueCR() throws Exception{ 
        this.getCtrlPrincipal().action(EnumAction.CR_AFFICHER);
    }
    
    public void OuvrirVueVisiteur() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.VISITEUR_AFFICHER);
    }
    
    public void OuvrirVuePraticien() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_AFFICHER);
    }
    
    public void OuvrirVueMedicament() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.MEDICAMENT_AFFICHER);
    }
    
    public void Quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.GCR_QUITTER);
    }
  
    
}
