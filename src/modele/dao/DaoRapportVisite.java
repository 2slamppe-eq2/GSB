/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modele.jdbc.Jdbc;
import modele.metier.RapportVisite;
import modele.metier.Secteur;
import modele.metier.TypePraticien;
import oracle.sql.ROWID;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite implements DaoInterface<RapportVisite, Integer>{

    DaoVisiteur daoVisiteur = new DaoVisiteur();
    DaoPraticien daoPraticien = new DaoPraticien();
    @Override
    public int create(RapportVisite unRapport) throws Exception {
        Jdbc.getInstance().connecter();
        int effectue = 0;
        String requete = "INSERT INTO RAPPORT_VISITE(VIS_MATRICULE, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF) VALUES(?,?,to_date(?, 'DD/MM/YYYY'),?,?)";
        ResultSet rs = null;
        
        try {
           Jdbc.getInstance().debuterTransaction();
           ArrayList<Object> params = new ArrayList<>();

            params.add(unRapport.getVisiteur().getMatricule());
            params.add(unRapport.getPraticien().getNumero());
            params.add(unRapport.getDateDeSaisieString());
            params.add(unRapport.getBilan());
            params.add(unRapport.getMotif());           
            rs = Jdbc.getInstance().mettreAJourAvecClefsGenereesRetournees(requete, params);
            Jdbc.getInstance().validerTransaction();
        }catch (Exception ex){
            Jdbc.getInstance().annulerTransaction();
            throw new modele.dao.DaoException("DaoRapportVisite::create : erreur requete INSERT : " + ex.getMessage());
        }
        if(rs.next()){
            effectue = getNumRapportInsere(rs.getString(1));
        }
        Jdbc.getInstance().deconnecter();
        return effectue;
    }

    @Override
    public RapportVisite getOne(Integer idRapport) throws Exception {
       Jdbc.getInstance().connecter();
        RapportVisite result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM=?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(idRapport);
        try {
            rs = Jdbc.getInstance().consulter(requete, params);
                    
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapportVisite::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return (result);
    }

    @Override
    public ArrayList<RapportVisite> getAll() throws Exception {
       Jdbc.getInstance().connecter();
        ArrayList<RapportVisite> result = new ArrayList<>();
        ResultSet rs;
        String requete = "SELECT * FROM RAPPORT_VISITE ORDER BY RAP_NUM";
        try{
            rs = Jdbc.getInstance().consulter(requete);
            while (rs.next()){
                RapportVisite rapportVisite = chargerUnEnregistrement(rs);
                result.add(rapportVisite);
            }
        }catch (Exception e){
            throw new modele.dao.DaoException("DaoRApportVisite::getAll : erreur requete SELECT : " + e.getMessage());
        }
        Jdbc.getInstance().deconnecter();
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
        Jdbc.getInstance().connecter();
        int result = 0;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT  \"auto_RAPPORT_VISITE\".NEXTVAL as nextval " +
"FROM dual";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);            
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("nextval");
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapportVisite::getMax : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().connecter();
        return (result);
        
    }
    
    public int getNumRapportInsere(String rowid) throws Exception{
        Jdbc.getInstance().connecter();
        int result = 0;
        ResultSet rs = null;
        // préparer la requête
        String requete = "select RAP_NUM from rapport_visite where rowid = ?";
        ArrayList<String> params = new ArrayList<>();
        params.add(rowid);
        rs = Jdbc.getInstance().consulter(requete, params);
        if(rs.next()){
            result = rs.getInt("RAP_NUM");
        }
        Jdbc.getInstance().deconnecter();
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
            throw new DaoException("DaoRapportVisite - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }

   
}
