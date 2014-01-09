/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import modele.metier.RapportVisite;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite implements DaoInterface<RapportVisite, Integer>{

    DaoVisiteur daoVisiteur = new DaoVisiteur();
    DaoPraticien daoPraticien = new DaoPraticien();
    @Override
    public int create(RapportVisite objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RapportVisite getOne(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<RapportVisite> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Integer idMetier, RapportVisite objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private RapportVisite chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            RapportVisite rapportVisite = new RapportVisite();
            rapportVisite.setNumero(rs.getInt("RAP_NUM"));
            rapportVisite.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
            
            
            
            return rapportVisite;
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }

   
}
