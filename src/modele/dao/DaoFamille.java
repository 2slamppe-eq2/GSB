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
import modele.metier.Famille;
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class DaoFamille implements DaoInterface<Famille, String>{

    @Override
    public int create(Famille objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Famille getOne(String idFamille) throws Exception {
        Famille result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR WHERE FAM_CODE=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idFamille);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoFamille::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        return (result);
    }

    @Override
    public ArrayList<Famille> getAll() throws Exception {
        ArrayList<Famille> result = new ArrayList<Famille>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM FAMILLE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Famille uneFamille = chargerUnEnregistrement(rs);
                result.add(uneFamille);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoFamille::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return(result);
    }

    @Override
    public int update(String idMetier, Famille objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private Famille chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Famille famille = new Famille();
            famille.setCode(rs.getString("FAM_CODE"));
            famille.setLibelle(rs.getString("FAM_LIBELLE"));
        
            return famille;
        } catch (SQLException ex) {
            throw new DaoException("DaoFamille - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
