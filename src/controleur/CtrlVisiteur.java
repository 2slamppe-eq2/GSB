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
import modele.metier.Labo;
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
    private DaoVisiteur daoVisiteur = null;
    
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
    
    public void chargerListeVisiteurs() {
        
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<>();
        try {
            lesVisiteurs = daoVisiteur.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        getVue().getModelJComboBoxChercher().removeAllElements();
        for(Visiteur unVisiteur: lesVisiteurs){
            getVue().getModelJComboBoxChercher().addElement(unVisiteur);
        }
    } 
    
    public void remplir(Visiteur unVisiteur) {
        if(unVisiteur == null){
            try {            
                unVisiteur = daoVisiteur.getOne("a17");
            } catch (Exception ex) {
                Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getVue().getjTextFieldNom().setText(unVisiteur.getNom());
        getVue().getjTextFieldPrenom().setText(unVisiteur.getPrenom());
        getVue().getjTextFieldAdresse().setText(unVisiteur.getAdresse());
        getVue().getjTextFieldVille().setText(unVisiteur.getVille());
        getVue().getjTextFieldCP().setText(unVisiteur.getCP());
        getVue().getModelJComboBoxLabo().removeAllElements();
        getVue().getModelJComboBoxSecteur().removeAllElements();
        getVue().getModelJComboBoxLabo().addElement(unVisiteur.getLabo());
        getVue().getModelJComboBoxSecteur().addElement(unVisiteur.getSecteur());
    } 
    
    public void choixVisiteur(){
        Visiteur unVisiteur = (Visiteur)getVue().getjComboBoxChercher().getSelectedItem();
        remplir(unVisiteur);      
        
    }
    
    public void suivant(){
        //obtenir liste de tous les visiteurs, trouver le visiteurs actuel et charger le suivant
    }
    
    public void nouveau(){
        //passe par le controleur principal pour charger une nouvelle fenêtre qui fonctione avec DaoVisiteur pour l'insertion de données et avec les autre Dao pour choisir Labo et secteur
    }
    
   
}

  
    
   
    

