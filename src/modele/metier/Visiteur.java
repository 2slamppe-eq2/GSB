/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Date;

/**
 *
 * @author btssio
 */
public class Visiteur {
    
    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String CP;
    private String ville;
    private Date dateEmbauche;
    private Labo labo;
    private Secteur secteur;

    public Visiteur(String matricule, String nom, String prenom, String adresse, String CP, String ville, Date dateEmbauche, Labo labo, Secteur secteur) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.CP = CP;
        this.ville = ville;
        this.dateEmbauche = dateEmbauche;
        this.labo = labo;
        this.secteur = secteur;
    }

    public Visiteur() {
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Labo getLabo() {
        return labo;
    }

    public void setLabo(Labo labo) {
        this.labo = labo;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Visiteur{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", CP=" + CP + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + ", labo=" + labo + ", secteur=" + secteur + '}';
    }
    
    
}
