/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Famille {
    private String code;
    private String Libelle;

    public Famille() {
    }

    public Famille(String code, String Libelle) {
        this.code = code;
        this.Libelle = Libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }
    
    
    
}
