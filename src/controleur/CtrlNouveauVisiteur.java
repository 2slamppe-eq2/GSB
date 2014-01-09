/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Date;
import java.util.ArrayList;
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.dao.DaoVisiteur;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;
import vue.VueNouveauVisiteur;
import vue.VueVisiteur;

/**
 *
 * @author btssio
 */
public class CtrlNouveauVisiteur extends CtrlAbstrait{
    
    private CtrlNouveauVisiteur ctrlNouveauVisiteur = null;
    private DaoLabo daoLabo = null;
    private DaoSecteur daoSecteur = null;
    private static DaoVisiteur daoVisiteur = null;
    
    
    public CtrlNouveauVisiteur(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueNouveauVisiteur(this);
        daoLabo = new DaoLabo();
        daoSecteur = new DaoSecteur();
        daoVisiteur = new DaoVisiteur();
                
    } 
    
    @Override
    public VueNouveauVisiteur getVue() {
        return (VueNouveauVisiteur) vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    
    public void chargerSecteur() throws Exception{
        ArrayList<Secteur> lesSecteurs = daoSecteur.getAll();
        
        getVue().getModelJComboBoxSecteur().removeAllElements();
        getVue().getModelJComboBoxSecteur().addElement("- - - - - - -");
        for(Secteur unSecteur: lesSecteurs){
            getVue().getModelJComboBoxSecteur().addElement(unSecteur);
        }
    }
    
    public void chargerLabo() throws Exception{
        ArrayList<Labo> lesLabo = daoLabo.getAll();
        
        getVue().getModelJComboBoxLabo().removeAllElements();
        getVue().getModelJComboBoxLabo().addElement("- - - - - - -");
        for(Labo unLabo: lesLabo){
            getVue().getModelJComboBoxLabo().addElement(unLabo);
        }
    }
    
    public void insererNouveauVisiteur() throws Exception{
        Visiteur leVisiteur = new Visiteur();
        leVisiteur.setMatricule(getVue().getjTextFieldMatricule().getText());
        leVisiteur.setNom(getVue().getjTextFieldNom().getText());
        leVisiteur.setPrenom(getVue().getjTextFieldPrenom().getText());
        leVisiteur.setAdresse(getVue().getjTextFieldAdresse().getText());
        leVisiteur.setCP(getVue().getjTextFieldCP().getText());
        leVisiteur.setVille(getVue().getjTextFieldVille().getText());
        leVisiteur.setDateEmbauche((Date) getVue().getjDateChooserEmbauche().getDate());
        leVisiteur.setLabo((Labo)getVue().getjComboBoxLabo().getSelectedItem());
        leVisiteur.setSecteur((Secteur)getVue().getjComboBoxSecteur().getSelectedItem());
        
        int reussi = daoVisiteur.create(leVisiteur);
        if(reussi>0){
            getVue().getjLabelResultat().setText("insertion réussie!");
        }else{
            getVue().getjLabelResultat().setText("L'enregistrement du nouveau visiteur a échouée");
        }
    }
}
