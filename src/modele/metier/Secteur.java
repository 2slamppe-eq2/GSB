/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Secteur {
    
    private String code;
    private String libelle;

    public Secteur(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Secteur() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.getCode()+"   "+this.getLibelle();
    }
    
    
}
