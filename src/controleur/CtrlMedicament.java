/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import modele.dao.DaoMedicament;
import modele.metier.Medicament;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlMedicament extends CtrlAbstrait{
    private static DaoMedicament daoMedicament = new DaoMedicament();
    private static ArrayList<Medicament> lesMedicaments = null;
    
    public CtrlMedicament(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMedicament(this);
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
     
    public void remplirMedicament(Medicament unMedicament, int item) throws Exception{
        {
            if(unMedicament == null){
                ArrayList <Medicament> listMedicaments = getLesMedicaments();
                unMedicament = listMedicaments.get(0);
                
                
            }
            getVue().getjTextFieldCode().setText(unMedicament.getDepotLegal());
            getVue().getjTextFieldNomCom().setText(unMedicament.getNomCommercial());
//            getVue().getjTextFieldFamille().setText(unMedicament.getFamille().getLibelle());
            getVue().getjTextFieldComposation().setText(unMedicament.getComposition());
            getVue().getjTextAreaCIndications().setText(unMedicament.getContreIndic());
            getVue().getjTextAreaEffets().setText(unMedicament.getEffet());
            getVue().getjTextFieldPrix().setText(String.valueOf(unMedicament.getPrixEchantillon()));
            getVue().getjComboBoxMedicament().setSelectedIndex(item);
        }
    }
    
    public void chargerListeMedicaments() throws Exception{
        ArrayList<Medicament> listMedicaments = getLesMedicaments();
        
        getVue().getDefaultComboBoxModelMedicament().removeAllElements();
        getVue().getDefaultComboBoxModelMedicament().addElement("- - - - - - -");
        for(Medicament unMedicament: listMedicaments){
            getVue().getDefaultComboBoxModelMedicament().addElement(unMedicament);
        }
    }
    
    //lors du choix d'un visiteur dans la JComboBox on affiche de nouvelles informations
    public void choixMedicament() throws Exception{
        Medicament unMedicament = new Medicament();
        if(!getVue().getDefaultComboBoxModelMedicament().getSelectedItem().toString().equals("- - - - - - -")){
            
            unMedicament = (Medicament)getVue().getjComboBoxMedicament().getSelectedItem();        
            remplirMedicament(unMedicament,getVue().getjComboBoxMedicament().getSelectedIndex() );
        }
              
        
    }

    @Override
    public VueMedicament getVue() {
        return (VueMedicament) vue;
    }
    
         public void quitter() throws Exception{
         this.getCtrlPrincipal().action(EnumAction.MEDICAMENT_QUITTER);
     } 
         
         public static ArrayList<Medicament> getLesMedicaments() throws Exception{
             if(lesMedicaments == null){
                 lesMedicaments = daoMedicament.getAll();                
             }
             return lesMedicaments;
         }
    
}
