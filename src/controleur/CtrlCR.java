/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.swing.JTextArea;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlCR extends CtrlAbstrait{
    
     private CtrlCR ctrlCR = null;
    
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
    
    public void nouveau(){
        this.vider();
        
        getVue().getjButtonEnregistrer().setVisible(true);
        getVue().getjButtonRetour().setVisible(true);
        
    }

    
}
