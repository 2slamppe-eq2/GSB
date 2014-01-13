/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Praticien {
    
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String cp;
    private String ville;
    private float coefNotoriete;
    private TypePraticien type;

    public Praticien() {
    }

    public Praticien(int numero, String nom, String prenom, String adresse, String cp, String ville, float coefNotoriete, TypePraticien type) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.coefNotoriete = coefNotoriete;
        this.type = type;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(float coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public TypePraticien getType() {
        return type;
    }

    public void setType(TypePraticien type) {
        this.type = type;
    }
    
    public String toString() {
        return this.getNom()+ "   "+this.getPrenom();
    }
    
    
}
