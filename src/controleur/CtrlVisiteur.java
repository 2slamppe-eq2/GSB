/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.dao.DaoVisiteur;
import modele.metier.Visiteur;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlVisiteur extends CtrlAbstrait{
    
    private CtrlVisiteur ctrlVisiteur = null;
    private DaoLabo daoLabo = null;
    private DaoSecteur daoSecteur = null;
    private static DaoVisiteur daoVisiteur = null;
    private static ArrayList<Visiteur> LesVisiteurs = null;
    
    
    public CtrlVisiteur(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueVisiteur(this);
        daoLabo = new DaoLabo();
        daoSecteur = new DaoSecteur();
        daoVisiteur = new DaoVisiteur();
                
    } 
             
    @Override
    public VueVisiteur getVue() {
        return (VueVisiteur) vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.VISITEUR_QUITTER);
    }
    
    public void chargerListeVisiteurs() throws Exception {
        
        ArrayList<Visiteur> lesVisiteurs = getVisiteurs();
        
        getVue().getModelJComboBoxChercher().removeAllElements();
        getVue().getModelJComboBoxChercher().addElement("- - - - - - -");
        for(Visiteur unVisiteur: lesVisiteurs){
            getVue().getModelJComboBoxChercher().addElement(unVisiteur);
        }
    } 
    
    public void remplir(Visiteur unVisiteur, int item) {
        if(unVisiteur == null){
            try {   
                ArrayList<Visiteur> LesVisiteur = getVisiteurs();
                unVisiteur = LesVisiteurs.get(0);
            } catch (Exception ex) {
                Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getVue().getjTextFieldMatricule().setText(unVisiteur.getMatricule());
        getVue().getjTextFieldNom().setText(unVisiteur.getNom());
        getVue().getjTextFieldPrenom().setText(unVisiteur.getPrenom());
        getVue().getjTextFieldAdresse().setText(unVisiteur.getAdresse());
        getVue().getjTextFieldVille().setText(unVisiteur.getVille());
        getVue().getjTextFieldCP().setText(unVisiteur.getCP());
        getVue().getModelJComboBoxLabo().removeAllElements();
        getVue().getModelJComboBoxSecteur().removeAllElements();
        getVue().getModelJComboBoxLabo().addElement(unVisiteur.getLabo());
        getVue().getModelJComboBoxSecteur().addElement(unVisiteur.getSecteur());
        getVue().getjComboBoxChercher().setSelectedIndex(item);
        
    } 
    
    public void choixVisiteur(){
        Visiteur unVisiteur = new Visiteur();
        if(!getVue().getjComboBoxChercher().getSelectedItem().toString().equals("- - - - - - -")){
            
            unVisiteur = (Visiteur)getVue().getjComboBoxChercher().getSelectedItem();        
            remplir(unVisiteur,getVue().getjComboBoxChercher().getSelectedIndex() );
        }
              
        
    }
    
    public void suivant() throws Exception{        
        
        Visiteur VisiteurActuel = new Visiteur();
        try {
            VisiteurActuel = daoVisiteur.getOne(getVue().getjTextFieldMatricule().getText());
        } catch (Exception ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Visiteur> LesVisiteur = getVisiteurs();
        ArrayList<String> MatriculeVisiteur = new ArrayList<String>();
        for(Visiteur unVisiteur: LesVisiteur){
             MatriculeVisiteur.add(unVisiteur.getMatricule());
        }
        
        int index = MatriculeVisiteur.indexOf(VisiteurActuel.getMatricule());
        if(index < LesVisiteur.size()-1 && index>=0){
        remplir(LesVisiteur.get(index+1), (index+2));
        }
        
        
        
        
        //obtenir liste de tous les visiteurs, trouver le visiteurs actuel et charger le suivant
    }
    
    
        public void precedent() throws Exception{        
        
        Visiteur VisiteurActuel = new Visiteur();
        try {
            VisiteurActuel = daoVisiteur.getOne(getVue().getjTextFieldMatricule().getText());
        } catch (Exception ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Visiteur> LesVisiteur = getVisiteurs();
        ArrayList<String> MatriculeVisiteur = new ArrayList<String>();
        for(Visiteur unVisiteur: LesVisiteur){
             MatriculeVisiteur.add(unVisiteur.getMatricule());
        }
        
        int index = MatriculeVisiteur.indexOf(VisiteurActuel.getMatricule());
        if(index > 0){
        remplir(LesVisiteur.get(index-1), index);
        }
        
        
        
        
        //obtenir liste de tous les visiteurs, trouver le visiteurs actuel et charger le suivant
    }
    
    public void nouveauVisiteur() throws Exception{        
        this.getCtrlPrincipal().action(EnumAction.VISITEUR_AJOUTER);        
    }
    
    public void OuvrirVuePraticien() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_AFFICHER);
    }
    
    public static ArrayList<Visiteur> getVisiteurs() throws Exception{
       if (LesVisiteurs==null){
           LesVisiteurs = daoVisiteur.getAll();
           
       }
       return LesVisiteurs;
    }
    
   
}

  
    
   
    

