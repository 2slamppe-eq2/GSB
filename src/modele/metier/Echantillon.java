/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Echantillon {
    
   
    private RapportVisite rapport;
    private Medicament medicament;
    private int quantite;

    public Echantillon() {
    }

    public Echantillon(RapportVisite rapport, Medicament medicament, int quantite) {
       
        this.rapport = rapport;
        this.medicament = medicament;
        this.quantite = quantite;
    }
    
    

    

    public RapportVisite getRapport() {
        return rapport;
    }

    public void setRapport(RapportVisite rapport) {
        this.rapport = rapport;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
}
