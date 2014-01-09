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
public class RapportVisite {
    
    private Visiteur visiteur;
    private int numero;
    private Praticien praticien;
    private Date dateDeSaisie;
    private String bilan;
    private String motif;

    public RapportVisite(Visiteur visiteur, int numero, Praticien praticien, Date dateDeSaisie, String bilan, String motif) {
        this.visiteur = visiteur;
        this.numero = numero;
        this.praticien = praticien;
        this.dateDeSaisie = dateDeSaisie;
        this.bilan = bilan;
        this.motif = motif;
    }

    public RapportVisite() {
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    public Date getDateDeSaisie() {
        return dateDeSaisie;
    }

    public void setDateDeSaisie(Date dateDeSaisie) {
        this.dateDeSaisie = dateDeSaisie;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    
    
}
