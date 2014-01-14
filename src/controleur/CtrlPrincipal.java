/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.metier.RapportVisite;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class CtrlPrincipal {
    
    private CtrlCR ctrlCR = null;
    private CtrlConnexion ctrlConnexion = null;
    private CtrlGCR ctrlGCR = null;
    private CtrlMedicament ctrlMedicament = null;
    private CtrlPraticien ctrlPraticien = null;
    private CtrlVisiteur ctrlVisiteur = null;
    private CtrlNouveauVisiteur ctrlNouveauVisiteur = null;
    private Visiteur VisiteurConnecte = null;
    
    public void action(){
        if(ctrlConnexion == null){
            ctrlConnexion = new CtrlConnexion(this);
        }
        ctrlConnexion.getVue().setEnabled(true);
        ctrlConnexion.getVue().setVisible(true);
    }
    
    public void action(EnumAction action) throws Exception{
        switch (action){
            case ACCUEIL_GCR_AJOUTER:
                accueilGCRAfficher();
                break;
            case GCR_QUITTER:
                quitterGCR();
                break;
            case CR_AFFICHER:
                afficherCR();
                break;
            case CR_QUITTER:
                quitterCR();
                break;
            case MEDICAMENT_AFFICHER:
                afficherMedicament();
                break;
            case MEDICAMENT_QUITTER:
                quitterMedicament();
                break;
            case PRATICIEN_AFFICHER:
                afficherPraticien();
                break;
            case PRATICIEN_QUITTER:
                quitterPraticien();
                break;
            case VISITEUR_AFFICHER:
                afficherVisiteur();
                break;
            case VISITEUR_AJOUTER:
                afficherVueNouveauVisiteur();
                break;
            case VISITEUR_QUITTER:
                quitterVisiteur();
                break;
            case CONNEXION_QUITTER:
                quitterConnexion();
                break;
            
        }
    }
    
    private void accueilGCRAfficher(){
        
        if(ctrlGCR == null){
            ctrlGCR = new CtrlGCR(this);
        }
        ctrlGCR.getVue().setEnabled(true);
        ctrlGCR.getVue().setVisible(true);
        ctrlConnexion.getVue().setVisible(false);
        
    }

    public Visiteur getVisiteurConnecte() {
        return VisiteurConnecte;
    }

    public void setVisiteurConnecte(Visiteur VisiteurConnecte) {
        this.VisiteurConnecte = VisiteurConnecte;
    }
    
    private void afficherCR () throws Exception{
        
        if(ctrlCR == null){
            ctrlCR = new CtrlCR(this);
            ctrlCR.remplirPraticien();
            ctrlCR.remplirRapportVisite(null, 0);
            
        }
        ctrlCR.getVue().getjButtonEnregistrer().setVisible(false);
        ctrlCR.getVue().getjButtonRetour().setVisible(false);
        ctrlCR.getVue().setEnabled(true);
        ctrlCR.getVue().setVisible(true);
        ctrlGCR.getVue().setVisible(false);
        
    }
    
    private void afficherMedicament() throws Exception{
    
        if(ctrlMedicament == null){
            ctrlMedicament = new CtrlMedicament(this);
            
        }
        ctrlMedicament.getVue().setEnabled(true);
        ctrlMedicament.getVue().setVisible(true);
        ctrlGCR.getVue().setVisible(false);
    }
    
    private void afficherPraticien(){
    
        if(ctrlPraticien == null){
            ctrlPraticien = new CtrlPraticien(this);
        }
        ctrlPraticien.getVue().setEnabled(true);
        ctrlPraticien.getVue().setVisible(true);
        ctrlGCR.getVue().setVisible(false);
    }
    
    private void afficherVisiteur() throws Exception{
    
        if(ctrlVisiteur == null){
            ctrlVisiteur = new CtrlVisiteur(this);
            ctrlVisiteur.chargerListeVisiteurs();
            ctrlVisiteur.remplir(null,0);  
        }
        ctrlVisiteur.getVue().setEnabled(true);
        ctrlVisiteur.getVue().setVisible(true);  
        ctrlGCR.getVue().setVisible(false);
        ctrlGCR.getVue().setEnabled(false);
    }
    
    private void afficherVueNouveauVisiteur() throws Exception{//erreur vue s'affiche pas
        if(ctrlNouveauVisiteur == null){
            ctrlNouveauVisiteur = new CtrlNouveauVisiteur(this);
        }
        ctrlNouveauVisiteur.getVue().setEnabled(true);
        ctrlNouveauVisiteur.getVue().setVisible(true);
        ctrlVisiteur.getVue().setVisible(false);
    }
    
    private void quitterCR(){
        ctrlCR.getVue().setVisible(false);
        ctrlCR.getVue().setEnabled(false);
        ctrlGCR.getVue().setVisible(true);
        ctrlGCR.getVue().setEnabled(true);
    }
    
    private void quitterGCR(){
        System.exit(0);
       
        
    }
    
    private void quitterMedicament(){
        ctrlMedicament.getVue().setVisible(false);
        ctrlMedicament.getVue().setEnabled(false);
        ctrlGCR.getVue().setVisible(true);
        ctrlGCR.getVue().setEnabled(true);
        
    }
    
    private void quitterPraticien(){
        ctrlPraticien.getVue().setVisible(false);
        ctrlPraticien.getVue().setEnabled(false);
        ctrlGCR.getVue().setVisible(true);
        ctrlGCR.getVue().setEnabled(true);
        
    }
    
    private void quitterVisiteur(){
        ctrlVisiteur.getVue().setVisible(false);
        ctrlVisiteur.getVue().setEnabled(false);
        ctrlGCR.getVue().setVisible(true);
        ctrlGCR.getVue().setEnabled(true);
        
    }
    
    private void quitterConnexion(){
        System.exit(0);
    }
    
    
    
    
    
}

