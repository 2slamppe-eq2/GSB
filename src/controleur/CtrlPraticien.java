/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import static controleur.CtrlVisiteur.getVisiteurs;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoPraticien;
import modele.metier.Praticien;
import modele.metier.Visiteur;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlPraticien extends CtrlAbstrait{
    private CtrlPraticien ctrlPraticien = null;
    private static DaoPraticien daoPraticien = new DaoPraticien();
    private static ArrayList<Praticien> LesPraticiens = null;
            
    
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
     //rempli les champs avec les informations d'un praticien
    public void remplirPraticien(Praticien unPraticien, int item){
               //la première fois que la fonction est appelé dans le controleur principal visiteur est nul, il est remplacé par le premier visiteur de la liste
        if(unPraticien == null){
            try {  
                //chargement de la liste de tous les visiteurs
                ArrayList<Praticien> lesPraticiens = getLesPraticiens();
                unPraticien = lesPraticiens.get(0);
            } catch (Exception ex) {
                Logger.getLogger(CtrlVisiteur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        getVue().getjTextFieldNom().setText(unPraticien.getNom());
        getVue().getjTextFieldPrenom().setText(unPraticien.getPrenom());
        getVue().getjTextFieldAdresse().setText(unPraticien.getAdresse());
        getVue().getjTextFieldVille().setText(unPraticien.getVille());
        getVue().getjTextFieldCP().setText(unPraticien.getCp());
        getVue().getModelJComboBoxExercice().removeAllElements();
        getVue().getModelJComboBoxNotoriete().removeAllElements();
        getVue().getModelJComboBoxExercice().addElement(unPraticien.getType().getLieu());
        getVue().getModelJComboBoxNotoriete().addElement(unPraticien.getCoefNotoriete());
        getVue().getjComboBoxChercher().setSelectedIndex(item);
        
     
    }
    
     //lors du choix d'un praticien dans la JComboBox on affiche de nouvelles informations
    public void choixPraticien(){
        Praticien unPraticien = new Praticien();
        if(!getVue().getjComboBoxChercher().getSelectedItem().toString().equals("- - - - - - -")){
            
            unPraticien = (Praticien)getVue().getjComboBoxChercher().getSelectedItem();        
            remplirPraticien(unPraticien,getVue().getjComboBoxChercher().getSelectedIndex() );
        }
              
        
    }
    
    //rempli la JComboBox avec la liste de tous les Praticiens
    public void chargerListePraticien() throws Exception {
        
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        
        getVue().getModelJComboBoxChercher().removeAllElements();
        getVue().getModelJComboBoxChercher().addElement("- - - - - - -");
        for(Praticien unPraticien: lesPraticiens){
            getVue().getModelJComboBoxChercher().addElement(unPraticien);
        }
    } 
    
    public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_QUITTER);
    }
    
    public ArrayList<Praticien> getLesPraticiens() throws Exception{
        if(LesPraticiens==null){
            LesPraticiens = daoPraticien.getAll();
        }
        return LesPraticiens;
    }
}

