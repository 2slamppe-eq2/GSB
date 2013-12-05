/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
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
}
