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
import modele.metier.Medicament;
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class DaoMedicament implements DaoInterface<Medicament, String>{
    
    private DaoFamille daoFamille = new DaoFamille();
    @Override
    public int create(Medicament objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicament getOne(String idMedicament) throws Exception {
        Medicament result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM MEDICAMENT WHERE MED_DEPOTLEGAL=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idMedicament);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoMedicament::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        return (result);
    }

    @Override
    public ArrayList<Medicament> getAll() throws Exception {
        ArrayList<Medicament> result = new ArrayList<Medicament>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM MEDICAMENT";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Medicament unMedicament = chargerUnEnregistrement(rs);
                result.add(unMedicament);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoMedicament::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return(result);
    }

    @Override
    public int update(String idMetier, Medicament objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Medicament chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            Medicament medicament = new Medicament();
            medicament.setDepotLegal(rs.getString("MED_DEPOTLEGAL"));
            medicament.setNomCommercial(rs.getString("MED_NOMCOMMERCIAL"));
//            medicament.setFamille(daoFamille.getOne(rs.getString("FAM_CODE")));
            medicament.setComposition(rs.getString("MED_COMPOSITION"));
            medicament.setEffet(rs.getString("MED_EFFETS"));
            medicament.setContreIndic(rs.getString("MED_CONTREINDIC"));
            medicament.setPrixEchantillon(rs.getFloat("MED_PRIXECHANTILLON"));
            
            return medicament;
        } catch (SQLException ex) {
            throw new DaoException("DaoSecteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
