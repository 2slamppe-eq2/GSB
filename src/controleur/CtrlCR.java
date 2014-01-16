/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.sun.java.swing.plaf.windows.resources.windows;
import static controleur.CtrlVisiteur.getVisiteurs;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modele.dao.DaoException;
import modele.dao.DaoMedicament;
import modele.dao.DaoOffrir;
import modele.dao.DaoPraticien;
import modele.dao.DaoRapportVisite;
import modele.metier.Echantillon;
import modele.metier.Medicament;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import modele.metier.Visiteur;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlCR extends CtrlAbstrait{
    
     //déclaration des variables globales et instanciation
     private CtrlCR ctrlCR = null;
     private static ArrayList<Praticien> LesPraticiens = null;
     private static ArrayList<RapportVisite> LesRapportsVisites = null;
     private static ArrayList<Medicament> LesMedicaments = null;
     private static DaoPraticien daoPraticien = new DaoPraticien();
     private static DaoRapportVisite daoRapportVisite= new DaoRapportVisite();
     private static DaoMedicament daoMedicament = new DaoMedicament();
     private DaoOffrir daoOffrir = new DaoOffrir();
    
    public CtrlCR(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueCR(this);
    }
    
//return la vue correspondant au controleur
    @Override
    public VueCR getVue() {
        return (VueCR) vue;
    }
    
    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
     
    //réponse au bouton fermer pour quitter la vue 
    public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.CR_QUITTER);
    }
    //vide tous les champs de la vueCR
    public void vider() {
        getVue().getjTextAreaBilan().setText("");
        getVue().getjTextFieldDate().setText("");
        getVue().getjTextFieldMotif().setText("");
        getVue().getjTextFieldNum().setText("");
    }
    //prépare la vue pour pouvoir remplir les champs et crér un nouveau rapport de visite
    public void nouveau() throws Exception{
        this.vider();
        java.util.Date today= Calendar.getInstance().getTime();//obtenir la date du jour
        String date = new SimpleDateFormat("yyyy-MM-dd").format(today);//met la date au format sql
        getVue().getjTextFieldDate().setText(date);//remplir le champs date avec la date du jour
        
        int dernierRapport = daoRapportVisite.getMaxNumRapport();
        getVue().getjTextFieldNum().setText(String.valueOf(dernierRapport));//affiche le numéro du nouveau rapport
        //rends les boutons spécifique à l'ajout d'un nouveau rapport visible
        visibiliteBouton(true);
        getVue().getjTableEchantillon().removeAll();
        
    }
    //enregistre le rapport dans la base
    public void enregistrer() throws Exception{
        RapportVisite rapportVisite = new RapportVisite();//creer un nouvel objet RapportVisite
        Visiteur visiteurActuel = new Visiteur();//obtient le visiteur concerné par ce rapport, ce devrait être le visiteur connecté mais actuellement il y a un mot de passe et un utilisateur unique pour l'application
        visiteurActuel.setMatricule("zzz");//un visiteur de la base de données
        //les valeur des champs sont récupérée pour rcompleter les valeur des attributs de ce nouveau rapport
        rapportVisite.setBilan(getVue().getjTextAreaBilan().getText());
        rapportVisite.setMotif(getVue().getjTextFieldMotif().getText());
        rapportVisite.setNumero(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        rapportVisite.setPraticien((Praticien)getVue().getjComboBoxPraticien().getSelectedItem());
        rapportVisite.setVisiteur(visiteurActuel);
        //création d'une date du même format que celui de la base de données
        String [] dateSaisie = getVue().getjTextFieldDate().getText().split("-");
        rapportVisite.setDateDeSaisieString(dateSaisie[2]+"/"+dateSaisie[1]+"/"+dateSaisie[0].substring(2));
        //insertion dans la table RAPPORT_VISITE
        int effectue = daoRapportVisite.create(rapportVisite);
        LesRapportsVisites=null;//remise à zero des rapports visite pour remettre à jour la base ors du prochain getAll
        //insertion dans la table OFFRIR
        effectue = enregistrerLesEchantillons(getLesRapports().get(getLesRapports().size()-1));
        
        if(effectue==1){
                JOptionPane.showMessageDialog(null, "Rapport enregistré!");
        }else{
            JOptionPane.showMessageDialog(null, "Erreur lors de la saisie du rapport!");
        }
        
  
        
    }
    //insertion des echantillon entrée durant le rapport de viste dans la table OFFRIR
    public int enregistrerLesEchantillons(RapportVisite unRapport) throws Exception{
        int effectue = 1;
        int i =0;
        int nbLigne = ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).getRowCount();
        //parcourt les lignes du tableaux d'échantillon
        while(i < nbLigne && effectue==1){
            Echantillon unEchantillon = new Echantillon();
            unEchantillon.setRapport(unRapport);
            unEchantillon.setMedicament((Medicament)getVue().getjTableEchantillon().getValueAt(i, 0));
            unEchantillon.setQuantite((int)getVue().getjTableEchantillon().getValueAt(i, 1));
            effectue = daoOffrir.create(unEchantillon);
            
        }
        return effectue;
    
        
    }

    //rempli la JComboBox avecla liste de tous les praticiens
    public void remplirPraticien() throws Exception{
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        getVue().getModelJComboBoxPraticien().removeAllElements();
        getVue().getModelJComboBoxPraticien().addElement("----");
        for (Praticien unPraticien:lesPraticiens){
            getVue().getModelJComboBoxPraticien().addElement(unPraticien);
        }
        
    }
    //rempli tous les champs avec les données d'un rapport
    public void remplirRapportVisite(RapportVisite unRapport, int index) throws Exception{
        //Lors du premier remplissage rapport est nul on prend le premier de la liste
        if(unRapport == null){
            unRapport = getLesRapports().get(0);
            //obtient la liste de tous les praticiens
            ArrayList<Praticien> lesPraticiens = getLesPraticiens();
            int i = 0;
            //sélectionne l'index du praticien dans la liste des praticiens
            for(Praticien unPraticien: lesPraticiens){
               if(unPraticien.getNumero()==unRapport.getPraticien().getNumero()){
                   index = i;
               } 
               i++;
            }
        }
        //rempli les champs et sélectionne la praticien 
        getVue().getjComboBoxPraticien().setSelectedIndex(index);
        getVue().getjTextAreaBilan().setText(unRapport.getBilan());
        getVue().getjTextFieldDate().setText(unRapport.getDateDeSaisie().toString());
        getVue().getjTextFieldMotif().setText(unRapport.getMotif());
        getVue().getjTextFieldNum().setText(String.valueOf(unRapport.getNumero()));
        //remplirEchantillons(unRapport);
    }
    //lors du clic sur le bouton suivant , on affiche le rapport de visite suivant
     public void suivant() throws Exception{        
        //on récupère le rapport qui est actuellement affiché
        RapportVisite rapportActuel = new RapportVisite();
        try {
            
            rapportActuel = daoRapportVisite.getOne(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        } catch (Exception ex) {
            Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        //on récupère la liste de tous les rapports et de tous les praticiens
        ArrayList<RapportVisite> lesRapports = getLesRapports();
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        int index = -1;
        int i = 0;
        int indexPraticien = -1;
        //on cherche l'index dans la liste du rapport actuel
        for(RapportVisite unRapport: lesRapports){
            if(unRapport.getNumero()== rapportActuel.getNumero()){
               index = i; 
            }
            i++;
        }
        i = 0;
        
        //on cherche l'index dans la liste du praticien correspondant
        for(Praticien unPraticien: lesPraticiens){
            if(unPraticien.getNumero()== rapportActuel.getPraticien().getNumero()){
               indexPraticien = i; 
            }
            i++;
        }
        
        //on remplit les champs en utilisant la fonction, +1 indique le rapport suivant
        if(index>=0 &&index < lesRapports.size()-1 && indexPraticien>=0){
        remplirRapportVisite(lesRapports.get(index+1), indexPraticien);
        }
              
    }
    
        //lors du clic sur le bouton precedent , on affiche le rapport de visite precedent
        public void precedent() throws Exception{        
        //on récupère le rapport qui est actuellement affiché
         RapportVisite rapportActuel = new RapportVisite();
        try {
            rapportActuel = daoRapportVisite.getOne(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        } catch (Exception ex) {
            Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        //on récupère la liste de tous les rapports et de tous les praticiens
        ArrayList<RapportVisite> lesRapports = getLesRapports();
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        int index = -1;
        int i = 0;
        int indexPraticien = -1;
        //on cherche l'index dans la liste du rapport actuel
        for(RapportVisite unRapport: lesRapports){
            if(unRapport.getNumero()== rapportActuel.getNumero()){
               index = i; 
            }
            i++;
        }
         //on cherche l'index dans la liste du praticien correspondant
        i = 0;
        for(Praticien unPraticien: lesPraticiens){
            if(unPraticien.getNumero()== rapportActuel.getPraticien().getNumero()){
               indexPraticien = i; 
            }
            i++;
        }
        
        
        //on remplit les champs en utilisant la fonction, +1 indique le rapport suivant
        if(index>0 && indexPraticien>=0){
        remplirRapportVisite(lesRapports.get(index-1), indexPraticien);
        }
        }
        //fonction qui se déclenche lors du clique sur Ajouter sous le tableau des échantillon permet d'ajouter la quantité correspondant aux échantillons dans le tableaux 
        public void AjouterUnEchantillon() throws Exception{
            //nouveaux tableau qui contientdra la liste de tous les médicaments
            Medicament [] lesMedicaments = new Medicament[getLesMedicaments().size()];
            int i = 0;
            for (Medicament medicament: getLesMedicaments()){
                lesMedicaments[i] = medicament;
                i++;
            }           
            
                //servira à sélectionner le médicament
                JComboBox medicament = new JComboBox(lesMedicaments);
                JTextField quantite = new JTextField();
                int qte = 0;
                //affiche la boite de dialogue et récupère une valeur représentant le choix de l'utilisateur valider ou annuler
                
                int reponse = JOptionPane.showConfirmDialog(null, new Object[]{"choix du médicament :",medicament ,"quantité :",quantite}, 
                        "Echantillon",
                        JOptionPane.YES_NO_OPTION);
                if (reponse== JOptionPane.YES_OPTION){
                //récupère le médicament sélectionné               
                Medicament leMedicament = (Medicament) medicament.getSelectedItem();
                //récupère la quantite d'échantillon
                if(quantite.getText()!=""){
                Integer.parseInt(quantite.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "veuillez saisir une quantité pour ce médicament");
                }
                i= 0;
               
                //ajoute la ligne dans le tableau avec le médicament et la quantité
                int nbLigne = ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).getRowCount();
                boolean medicamentSaisi = false;
                while(i<nbLigne){
                    if(leMedicament == (Medicament)getVue().getjTableEchantillon().getValueAt(i, 0)){
                       JOptionPane.showMessageDialog(null, "Un échantillon ne peut être saisi qu'une seule fois par rapport"); 
                       medicamentSaisi = true;
                    }
                }
                if(!medicamentSaisi){
                ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(nbLigne+1);
                getVue().getjTableEchantillon().setValueAt(leMedicament, nbLigne, 0);
                getVue().getjTableEchantillon().setValueAt(qte, nbLigne, 1);
                }
                }
                
                
                
                
            
        }
        //supprime l'échantillon sélectionné
        public void supprimerMedicament(){
            getVue().getjTableEchantillon().remove(getVue().getjTableEchantillon().getSelectedRow());
        }
        
        //affiche les échantillon du rapport
//        public void remplirEchantillons(RapportVisite unRapport){
//         try {
//             ArrayList<Echantillon> lesEchantillons = daoOffrir.getEchantillonRapport(unRapport.getNumero());
//             
//             int i = 0;
//             while(i<lesEchantillons.size()){
//                 int nbLigne = ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).getRowCount();
//                 ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(nbLigne+1);
//                 getVue().getjTableEchantillon().setValueAt(lesEchantillons.get(i).getMedicament(), i, 0);
//                getVue().getjTableEchantillon().setValueAt(lesEchantillons.get(i).getQuantite(), i, 1);
//             }
//         } catch (DaoException ex) {
//             Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (Exception ex) {
//             Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         
//         
//            
//        }
        //retourne à la visualisation des rapport après la création de l'un d'eux
        public void retourRapport() throws Exception{
            remplirRapportVisite(null, 0);
            visibiliteBouton(false);
        }
        //rend les boutons relatifs à la création d'un nouveau rapport visible ou non
        public void visibiliteBouton(boolean etat){
            getVue().getjButtonEnregistrer().setVisible(etat);
            getVue().getjButtonRetour().setVisible(etat);
            getVue().getjButtonAjouterMed().setVisible(etat);
            getVue().getjButtonSupprimerMed().setVisible(etat);
        }
        
       //affiche la vuePraticien avec les détails du praticen choisie
        public void detailsPraticien() throws Exception{
            getCtrlPrincipal().AfficherPraticien((Praticien)getVue().getjComboBoxPraticien().getSelectedItem());
        }
        //charge une seule fois la liste de tous les rapports
        public static ArrayList<RapportVisite> getLesRapports() throws Exception{
            if(LesRapportsVisites == null){
                LesRapportsVisites = daoRapportVisite.getAll();
            }
            return LesRapportsVisites;
        }
        //charge une seule fois la liste de tous les praticiens
        public static ArrayList<Praticien> getLesPraticiens() throws Exception{
            if(LesPraticiens == null){
                LesPraticiens = daoPraticien.getAll();
            }
            return LesPraticiens;
        }
        //charge une seule fois la liste de tous les médicaments
        public static ArrayList<Medicament> getLesMedicaments() throws Exception{
            if(LesMedicaments == null){
                LesMedicaments = daoMedicament.getAll();
            }
            return LesMedicaments;
        }
}
    

