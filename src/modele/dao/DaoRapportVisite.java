/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modele.jdbc.Jdbc;
import modele.metier.RapportVisite;
import modele.metier.Secteur;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite implements DaoInterface<RapportVisite, Integer>{

    DaoVisiteur daoVisiteur = new DaoVisiteur();
    DaoPraticien daoPraticien = new DaoPraticien();
    @Override
    public int create(RapportVisite unRapport) throws Exception {
        int effectue;
        String requete = "INSERT INTO RAPPORT_VISITE(VIS_MATRICULE, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF) VALUES(?,?,to_date(?, 'DD/MM/YYYY'),?,?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1,unRapport.getVisiteur().getMatricule());
            ps.setInt(2, unRapport.getPraticien().getNumero());
            ps.setString(3, unRapport.getDateDeSaisieString());
            ps.setString(4,unRapport.getBilan());
            ps.setString(5,unRapport.getMotif());
            effectue = ps.executeUpdate();
        }catch (Exception ex){
            throw new modele.dao.DaoException("DaoRapportVisite::create : erreur requete INSERT : " + ex.getMessage());
        }
        return effectue;
    }

    @Override
    public RapportVisite getOne(Integer idRapport) throws Exception {
       RapportVisite result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idRapport);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapportVisite::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        return (result);
    }

    @Override
    public ArrayList<RapportVisite> getAll() throws Exception {
        ArrayList<RapportVisite> result = new ArrayList<RapportVisite>();
        ResultSet rs;
        String requete = "SELECT * FROM RAPPORT_VISITE ORDER BY RAP_NUM";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            while (rs.next()){
                RapportVisite rapportVisite = chargerUnEnregistrement(rs);
                result.add(rapportVisite);
            }
        }catch (Exception e){
            throw new modele.dao.DaoException("DaoRApportVisite::getAll : erreur requete SELECT : " + e.getMessage());
        }
        return result;
    }

    @Override
    public int update(Integer idMetier, RapportVisite objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getMaxNumRapport() throws Exception{
        
        int result = 0;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT MAX(RAP_NUM) AS MAX FROM RAPPORT_VISITE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);            
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapportVisite::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        
        return (result);
        
    }
    
    private RapportVisite chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            RapportVisite rapportVisite = new RapportVisite();
            rapportVisite.setNumero(rs.getInt("RAP_NUM"));
            rapportVisite.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
            rapportVisite.setBilan(rs.getString("RAP_BILAN"));
            rapportVisite.setMotif(rs.getString("RAP_MOTIF"));
            rapportVisite.setDateDeSaisie(rs.getDate("RAP_DATE"));
            rapportVisite.setPraticien(daoPraticien.getOne(rs.getInt("PRA_NUM")));
                      
            
            return rapportVisite;
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }

   
}
