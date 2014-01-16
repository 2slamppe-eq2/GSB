/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Medicament {
    
    private String depotLegal;
    private String nomCommercial;
    private Famille famille;
    private String composition;
    private String effet;
    private String contreIndic;
    private float prixEchantillon;

    public Medicament() {
    }

    public Medicament(String depotLegal, String nomCommercial, Famille famille, String effet, String contreIndic, float prixEchantillon) {
        this.depotLegal = depotLegal;
        this.nomCommercial = nomCommercial;
        this.famille = famille;
        this.effet = effet;
        this.contreIndic = contreIndic;
        this.prixEchantillon = prixEchantillon;
    }

    public String getDepotLegal() {
        return depotLegal;
    }

    public void setDepotLegal(String depotLegal) {
        this.depotLegal = depotLegal;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getContreIndic() {
        return contreIndic;
    }

    public void setContreIndic(String contreIndic) {
        this.contreIndic = contreIndic;
    }

    public float getPrixEchantillon() {
        return prixEchantillon;
    }

    public void setPrixEchantillon(float prixEchantillon) {
        this.prixEchantillon = prixEchantillon;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    @Override
    public String toString() {
        return nomCommercial;
    }
    
    
    
    
    
    
}
