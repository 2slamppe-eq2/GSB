/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import vue.*;

/**
 *
 * @author btssio
 */
public class CtrlConnexion extends CtrlAbstrait{
    
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
        JTextField jTextFieldId = vueConnexion.getjTextFieldIdentifiant();
        JPasswordField jPasswordFieldPwd = vueConnexion.getjPasswordFieldPwd();
        String id = "swiss";
        String pwd = "jun-2003";
        String pwdEntre = new String(jPasswordFieldPwd.getPassword());
        JLabel jLabelErreur = vueConnexion.getjLabelErreur();
        
        if(id.equals(jTextFieldId.getText())&&pwd.equals(pwdEntre)){
            this.getCtrlPrincipal().action(EnumAction.ACCUEIL_GCR_AJOUTER);
            
        }else{
            jLabelErreur.setText("L'identifiant ou le mot de passe est incorrect!");
        }
        
        
        
    }
    
        public void quitter() throws Exception{
        this.getCtrlPrincipal().action(EnumAction.CONNEXION_QUITTER);
    }
}
