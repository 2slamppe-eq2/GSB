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
    //rempli la JComboBox avec la liste de tous les visiteurs
    public void chargerListeVisiteurs() throws Exception {
        
        ArrayList<Visiteur> lesVisiteurs = getVisiteurs();
        
        getVue().getModelJComboBoxChercher().removeAllElements();
        getVue().getModelJComboBoxChercher().addElement("- - - - - - -");
        for(Visiteur unVisiteur: lesVisiteurs){
            getVue().getModelJComboBoxChercher().addElement(unVisiteur);
        }
    } 
    //rempli les champs avec les informations d'un visiteur
    public void remplir(Visiteur unVisiteur, int item) {
        //la première fois que la fonction est appelé dans le controleur principal visiteur est nul, il est remplacé par le premier visiteur de la liste
        if(unVisiteur == null){
            try {  
                //chargement de la liste de tous les visiteurs
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
    //lors du choix d'un visiteur dans la JComboBox on affiche de nouvelles informations
    public void choixVisiteur(){
        Visiteur unVisiteur = new Visiteur();
        if(!getVue().getjComboBoxChercher().getSelectedItem().toString().equals("- - - - - - -")){
            
            unVisiteur = (Visiteur)getVue().getjComboBoxChercher().getSelectedItem();        
            remplir(unVisiteur,getVue().getjComboBoxChercher().getSelectedIndex() );
        }
              
        
    }
    //lors du clique sur suivant on affiche le visiteur suivant dans la liste de tous les visiteurs
    public void suivant() throws Exception{        
        //chargement du visiteur actuellement affiché à partir de son matricule affiché dans la champ matricule
        Visiteur VisiteurActuel = new Visiteur();
        try {
            VisiteurActuel = daoVisiteur.getOne(getVue().getjTextFieldMatricule().getText());
        } catch (Exception ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        //chargement de la liste de tous les visiteur
        ArrayList<Visiteur> LesVisiteur = getVisiteurs();
        ArrayList<String> MatriculeVisiteur = new ArrayList<String>();
        for(Visiteur unVisiteur: LesVisiteur){
             MatriculeVisiteur.add(unVisiteur.getMatricule());
        }
        //on cherche l'index du visiteur actuelle dans la liste de tous les visiteurs
        int index = MatriculeVisiteur.indexOf(VisiteurActuel.getMatricule());
        if(index < LesVisiteur.size()-1 && index>=0){
        remplir(LesVisiteur.get(index+1), (index+2));//on rempli les champs avec les informations du visiteur suivant
        }
        
        
        
        
    }
    
        //lors du clique sur precedent on affiche les informations du visiteur précédent
        public void precedent() throws Exception{        
        
        //chargement du visiteur actuellement affiché à partir de son matricule affiché dans la champ matricule
        Visiteur VisiteurActuel = new Visiteur();
        try {
            VisiteurActuel = daoVisiteur.getOne(getVue().getjTextFieldMatricule().getText());
        } catch (Exception ex) {
            Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        //chargement de la liste de tous les visiteur
        ArrayList<Visiteur> LesVisiteur = getVisiteurs();
        ArrayList<String> MatriculeVisiteur = new ArrayList<String>();
        for(Visiteur unVisiteur: LesVisiteur){
             MatriculeVisiteur.add(unVisiteur.getMatricule());
        }
        //on cherche l'index du visiteur actuelle dans la liste de tous les visiteurs
        int index = MatriculeVisiteur.indexOf(VisiteurActuel.getMatricule());
        if(index > 0){
        remplir(LesVisiteur.get(index-1), index);//on remplit les champs avec les informations du visiteur suivant
        }
        
        
        
        
    }
    
//    public void nouveauVisiteur() throws Exception{        
//        this.getCtrlPrincipal().action(EnumAction.VISITEUR_AJOUTER);        
//    }
    
    
    //charge la liste de visiteurs une seule fois
    public static ArrayList<Visiteur> getVisiteurs() throws Exception{
       if (LesVisiteurs==null){
           LesVisiteurs = daoVisiteur.getAll();
           
       }
       return LesVisiteurs;
    }
    
   
}

  
    
   
    

