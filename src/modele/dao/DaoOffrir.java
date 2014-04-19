/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.Echantillon;
import modele.metier.RapportVisite;
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class DaoOffrir {
    
    private DaoMedicament daoMedicament = new DaoMedicament();
    private DaoRapportVisite daoRapportVisite = new DaoRapportVisite();
    
    public int create(Echantillon unEchantillon) throws Exception {
        Jdbc.getInstance().connecter();
        int effectue;
        String requete = "INSERT INTO OFFRIR(VIS_MATRICULE, RAP_NUM, MED_DEPOTLEGAL, OFF_QTE) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1,unEchantillon.getRapport().getVisiteur().getMatricule());
            ps.setInt(2, unEchantillon.getRapport().getNumero());
            ps.setString(3, unEchantillon.getMedicament().getDepotLegal());
            ps.setInt(4,unEchantillon.getQuantite());
            effectue = ps.executeUpdate();
        }catch (Exception ex){
            throw new modele.dao.DaoException("DaoOffrir::create : erreur requete INSERT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return effectue;
    }
    
    public ArrayList<Echantillon> getAll() throws Exception {
        Jdbc.getInstance().connecter();
        ArrayList<Echantillon> result = new ArrayList<Echantillon>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Echantillon unEchantillon = chargerUnEnregistrement(rs);
                result.add(unEchantillon);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return(result);
    }
    
    public Echantillon getOne(String matriculeVis, String depotLegal, int rapport) throws Exception {
        Jdbc.getInstance().connecter();
        Echantillon result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR WHERE MED_DEPOTLEGAL=? AND RAP_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);            
            ps.setString(1, depotLegal);
            ps.setInt(2,rapport);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return (result);
    }
    
    public ArrayList<Echantillon> getEchantillonRapport(int unRapport) throws DaoException, Exception{
        Jdbc.getInstance().connecter();
        ArrayList<Echantillon> result = new ArrayList<Echantillon>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR WHERE RAP_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1,unRapport);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Echantillon unEchantillon = chargerUnEnregistrement(rs);
                result.add(unEchantillon);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getEchantillonRapport : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return(result);
    }
    private Echantillon chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            Echantillon unEchantillon = new Echantillon();
            unEchantillon.setMedicament(daoMedicament.getOne(rs.getString("MED_DEPOTLEGAL")));
            unEchantillon.setRapport(daoRapportVisite.getOne(rs.getInt("RAP_NUM")));
            unEchantillon.setQuantite(rs.getInt("OFF_QTE"));
        
            return unEchantillon;
        } catch (SQLException ex) {
            throw new DaoException("DaoOffrir - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
    
}
