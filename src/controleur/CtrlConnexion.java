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
    
     public CtrlConnexion() {
        vue = new VueConnexion(this);
    }
     
        
     
    @Override
    public VueConnexion getVue() {
        return (VueConnexion) vue;
    }
    
    
    public void quitter(){
        System.exit(0);
    }
    
    public void seConnecter(){
        VueConnexion vueConnexion = getVue();
        JTextField jTextFieldId = vueConnexion.getjTextFieldIdentifiant();
        JPasswordField jPasswordFieldPwd = vueConnexion.getjPasswordFieldPwd();
        String id = "swiss";
        String pwd = "jun-2003";
        String pwdEntre = new String(jPasswordFieldPwd.getPassword());
        JLabel jLabelErreur = vueConnexion.getjLabelErreur();
        
        if(id.equals(jTextFieldId.getText())&&pwd.equals(pwdEntre)){
            CtrlGCR ctrlGCR= new CtrlGCR();        
            ctrlGCR.getVue().setEnabled(true);
            ctrlGCR.getVue().setVisible(true);
            this.getVue().setVisible(false);
        }else{
            jLabelErreur.setText("L'identifiant ou le mot de passe est incorrect!");
        }
        
        
        
    }
}
