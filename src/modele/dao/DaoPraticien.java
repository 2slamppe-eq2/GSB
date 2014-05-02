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
public class DaoPraticien implements DaoInterface<Praticien, Integer>{

    private DaoTypePraticien daoTypePraticien = new DaoTypePraticien();
    
    

    @Override
    public Praticien getOne(Integer idPraticien) throws Exception {
       Jdbc.getInstance().connecter();
        Praticien result = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM PRATICIEN WHERE PRA_NUM=?";
        ArrayList<Object> params = new ArrayList<>();
        params.add(idPraticien);
        try{
            rs = Jdbc.getInstance().consulter(requete, params);
            if(rs.next()){
                result = chargerUnEnregistrement(rs);
            }
            
            
        }catch (SQLException ex){
          throw new modele.dao.DaoException("DaoPraticien::getOne : erreur requete SELECT : " + ex.getMessage()); 
        }
       Jdbc.getInstance().deconnecter();
        return (result);
    }

    @Override
    public ArrayList<Praticien> getAll() throws Exception {
        Jdbc.getInstance().connecter();
        ArrayList<Praticien> result = new ArrayList<Praticien>();
        ResultSet rs;
        String requete = "SELECT * FROM PRATICIEN ORDER BY PRA_NUM";
        try{
            rs = Jdbc.getInstance().consulter(requete);
            while (rs.next()){
                Praticien unPraticien = chargerUnEnregistrement(rs);
                result.add(unPraticien);
            }
        }catch (Exception e){
            throw new modele.dao.DaoException("DaoPraticien::getAll : erreur requete SELECT : " + e.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return result;
    }

    
    


    @Override
    public int create(Praticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Integer idMetier, Praticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        private Praticien chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            Praticien praticien = new Praticien();
            praticien.setNumero(rs.getInt("PRA_NUM"));
            praticien.setNom(rs.getString("PRA_NOM"));
            praticien.setPrenom(rs.getString("PRA_PRENOM"));
            praticien.setAdresse(rs.getString("PRA_ADRESSE"));
            praticien.setCp(rs.getString("PRA_CP"));
            praticien.setVille(rs.getString("PRA_VILLE"));
            praticien.setCoefNotoriete((float)rs.getObject("PRA_COEFNOTORIETE"));
            praticien.setType(daoTypePraticien.getOne(rs.getString("TYP_CODE")));
            return praticien;
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
