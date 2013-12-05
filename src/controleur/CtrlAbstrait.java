package controleur;

import vue.VueAbstraite;

/**
 * CtrlAbstrait
 * modèle de contrôleur de base
 * chaque contrôleur possède :
 * - une vue
 * - une liaison vers le contrôleur principal
 * @author nbourgeois
 * @version 22 novembre 2013
 */
public abstract class CtrlAbstrait {
    
    protected VueAbstraite vue = null;
    protected CtrlGCR ctrlPrincipal = null;

    protected CtrlAbstrait(CtrlGCR ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
     
    public VueAbstraite getVue() {
        return vue;
    }

    public void setVue(VueAbstraite vue) {
        this.vue = vue;
    }

    public CtrlGCR getCtrlPrincipal() {
        return (CtrlGCR)ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlGCR ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    

}
