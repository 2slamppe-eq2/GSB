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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import modele.dao.DaoPraticien;
import modele.dao.DaoRapportVisite;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import modele.metier.Visiteur;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlCR extends CtrlAbstrait{
    
     private CtrlCR ctrlCR = null;
     private static ArrayList<Praticien> LesPraticiens = null;
     private static ArrayList<RapportVisite> LesRapportsVisites = null;
     private static DaoPraticien daoPraticien = new DaoPraticien();
     private static DaoRapportVisite daoRapportVisite= new DaoRapportVisite();
    
    public CtrlCR(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueCR(this);
    }
    

    @Override
    public VueCR getVue() {
        return (VueCR) vue;
    }
    
    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
     
    
    public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.CR_QUITTER);
    }
        
    public void vider() {
        getVue().getjTextAreaBilan().setText("");
        getVue().getjTextFieldDate().setText("");
        getVue().getjTextFieldMotif().setText("");
        getVue().getjTextFieldNum().setText("");
    }
    
    public void nouveau() throws Exception{
        this.vider();
        java.util.Date today= Calendar.getInstance().getTime();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(today);
        getVue().getjTextFieldDate().setText(date);
        
        ArrayList<RapportVisite> lesRapports = getLesRapports();
        getVue().getjTextFieldNum().setText(String.valueOf(lesRapports.get(lesRapports.size()-1).getNumero()+1));
        
        getVue().getjButtonEnregistrer().setVisible(true);
        getVue().getjButtonRetour().setVisible(true);
        
    }
    
    public void enregistrer() throws Exception{
        RapportVisite rapportVisite = new RapportVisite();
        Visiteur visiteurActuel = new Visiteur();
        visiteurActuel.setMatricule("zzz");
        rapportVisite.setBilan(getVue().getjTextAreaBilan().getText());
        rapportVisite.setMotif(getVue().getjTextFieldMotif().getText());
        rapportVisite.setNumero(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        rapportVisite.setPraticien((Praticien)getVue().getjComboBoxPraticien().getSelectedItem());
        rapportVisite.setVisiteur(visiteurActuel);
        String [] dateSaisie = getVue().getjTextFieldDate().getText().split("-");
        rapportVisite.setDateDeSaisieString(dateSaisie[2]+"/"+dateSaisie[1]+"/"+dateSaisie[0].substring(2));
        int effectue = daoRapportVisite.create(rapportVisite);
        if(effectue>0){
                JOptionPane.showMessageDialog(null, "Rapport enregistré!");
        }else{
            JOptionPane.showMessageDialog(null, "Erreur lors de la saisie du rapport!");
        }
        
  
        
    }

    
    public void remplirPraticien() throws Exception{
        ArrayList<Praticien> lesPraticiens = daoPraticien.getAll();
        getVue().getModelJComboBoxPraticien().removeAllElements();
        getVue().getModelJComboBoxPraticien().addElement("----");
        for (Praticien unPraticien:lesPraticiens){
            getVue().getModelJComboBoxPraticien().addElement(unPraticien);
        }
        
    }
    
    public void remplirRapportVisite(RapportVisite unRapport, int index) throws Exception{
        if(unRapport == null){
            unRapport = getLesRapports().get(0);
            ArrayList<Praticien> lesPraticiens = getLesPraticiens();
            int i = 0;
            for(Praticien unPraticien: lesPraticiens){
               if(unPraticien.getNumero()==unRapport.getPraticien().getNumero()){
                   index = i;
               } 
               i++;
            }
        }
        getVue().getjComboBoxPraticien().setSelectedIndex(index);
        getVue().getjTextAreaBilan().setText(unRapport.getBilan());
        getVue().getjTextFieldDate().setText(unRapport.getDateDeSaisie().toString());
        getVue().getjTextFieldMotif().setText(unRapport.getMotif());
        getVue().getjTextFieldNum().setText(String.valueOf(unRapport.getNumero()));
        getVue().getjComboBoxPraticien().setSelectedItem(unRapport.getPraticien());
    }
    
     public void suivant() throws Exception{        
        
        RapportVisite rapportActuel = new RapportVisite();
        try {
            rapportActuel = daoRapportVisite.getOne(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        } catch (Exception ex) {
            Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<RapportVisite> lesRapports = getLesRapports();
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        int index = -1;
        int i = 0;
        int indexPraticien = -1;
        for(RapportVisite unRapport: lesRapports){
            if(unRapport.getNumero()== rapportActuel.getNumero()){
               index = i; 
            }
            i++;
        }
        i = 0;
        for(Praticien unPraticien: lesPraticiens){
            if(unPraticien.getNumero()== rapportActuel.getPraticien().getNumero()){
               indexPraticien = i; 
            }
            i++;
        }
        
        
        if(index < lesRapports.size()-1){
        remplirRapportVisite(lesRapports.get(index+1), indexPraticien);
        }
              
    }
    
    
        public void precedent() throws Exception{        
        
         RapportVisite rapportActuel = new RapportVisite();
        try {
            rapportActuel = daoRapportVisite.getOne(Integer.parseInt(getVue().getjTextFieldNum().getText()));
        } catch (Exception ex) {
            Logger.getLogger(CtrlCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<RapportVisite> lesRapports = getLesRapports();
        ArrayList<Praticien> lesPraticiens = getLesPraticiens();
        int index = -1;
        int i = 0;
        int indexPraticien = -1;
        for(RapportVisite unRapport: lesRapports){
            if(unRapport.getNumero()== rapportActuel.getNumero()){
               index = i; 
            }
            i++;
        }
        i = 0;
        for(Praticien unPraticien: lesPraticiens){
            if(unPraticien.getNumero()== rapportActuel.getPraticien().getNumero()){
               indexPraticien = i; 
            }
            i++;
        }
        
        
        
        if(index>0){
        remplirRapportVisite(lesRapports.get(index-1), indexPraticien);
        }
        }
        
        
        public static ArrayList<RapportVisite> getLesRapports() throws Exception{
            if(LesRapportsVisites == null){
                LesRapportsVisites = daoRapportVisite.getAll();
            }
            return LesRapportsVisites;
        }
        
        public static ArrayList<Praticien> getLesPraticiens() throws Exception{
            if(LesPraticiens == null){
                LesPraticiens = daoPraticien.getAll();
            }
            return LesPraticiens;
        }
        
}
    

