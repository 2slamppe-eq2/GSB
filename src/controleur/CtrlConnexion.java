/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.dao.DaoVisiteur;
import modele.metier.Visiteur;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlConnexion extends CtrlAbstrait{
    
    private DaoVisiteur daoVisiteur = new DaoVisiteur();
    
     public CtrlConnexion(CtrlPrincipal ctrlPrincipal) {
         super(ctrlPrincipal);
         vue = new VueConnexion(this);
    }
     
        
     
    @Override
    public VueConnexion getVue() {
        return (VueConnexion) vue;
    }
    
    


    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    public void seConnecter() throws Exception{
        VueConnexion vueConnexion = getVue();
        String identifiant = vueConnexion.getjTextFieldIdentifiant().getText();
        String motDePasse= new String(vueConnexion.getjPasswordFieldPwd().getPassword());
        boolean visiteurAccepte =false;
        
        ArrayList<Visiteur> lesVisiteurs = daoVisiteur.getAll();
        
        for (Visiteur unVisiteur: lesVisiteurs){
            if(unVisiteur.getLogin().equals(identifiant) && String.valueOf(unVisiteur.getDateEmbauche()).equals(motDePasse)){
                visiteurAccepte = true;
                ctrlPrincipal.setVisiteurConnecte(unVisiteur);
            }
        }
        if(visiteurAccepte){
            this.getCtrlPrincipal().action(EnumAction.ACCUEIL_GCR_AJOUTER);
        }
//        String id = "swiss";
//        String pwd = "jun-2003";
//        //si l'identifiant et le mot de passe rentrer sont égaux à ceux donner aux dessus la page d'accueil s'affiche
//        if(id.equals(identifiant)&&pwd.equals(motDePasse)){
//            this.getCtrlPrincipal().action(EnumAction.ACCUEIL_GCR_AJOUTER);
//        }
//            
//        else{
//            getVue().getjLabelErreur().setText("L'identifiant ou le mot de passe est incorrect!");
//        }
        
        
        
    }
    
        public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.CONNEXION_QUITTER);
    }
}
