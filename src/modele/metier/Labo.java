/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Labo {
    
    private String code;
    private String nom;
    private String ChefVente;

    public Labo(String code, String nom, String ChefVente) {
        this.code = code;
        this.nom = nom;
        this.ChefVente = ChefVente;
    }

    public Labo() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChefVente() {
        return ChefVente;
    }

    public void setChefVente(String ChefVente) {
        this.ChefVente = ChefVente;
    }

    @Override
    public String toString() {
        return "Labo{" + "code=" + code + ", nom=" + nom + ", ChefVente=" + ChefVente + '}';
    }
    
    
    
}
