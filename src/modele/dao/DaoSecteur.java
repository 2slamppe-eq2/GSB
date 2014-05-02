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
import modele.jdbc.*;
import modele.metier.*;
/**
 *
 * @author btssio
 */
public class DaoSecteur implements DaoInterface<Secteur, String>{

    @Override
    public int create(Secteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Secteur getOne(String idSecteur) throws Exception {
        Jdbc.getInstance().connecter();
        Secteur result = null;
        ResultSet rs = null;
        ArrayList<Object> params = new ArrayList<>();
        params.add(idSecteur);
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR WHERE SEC_CODE=?";
        try {
            rs = Jdbc.getInstance().consulter(requete, params);
                    
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoSecteur::getOne : erreur requete SELECT : " + ex.getMessage());
        }
       Jdbc.getInstance().deconnecter();
        return (result);
    }

    @Override
    public ArrayList<Secteur> getAll() throws Exception {
        Jdbc.getInstance().connecter();
        ArrayList<Secteur> result = new ArrayList<Secteur>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM SECTEUR";
        try {
            rs = Jdbc.getInstance().consulter(requete);
                    
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Secteur unSecteur = chargerUnEnregistrement(rs);
                result.add(unSecteur);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoSecteur::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return(result);
    }

    @Override
    public int update(String idMetier, Secteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private Secteur chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Secteur secteur = new Secteur();
            secteur.setCode(rs.getString("SEC_CODE"));
            secteur.setLibelle(rs.getString("SEC_LIBELLE"));
        
            return secteur;
        } catch (SQLException ex) {
            throw new DaoException("DaoSecteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
