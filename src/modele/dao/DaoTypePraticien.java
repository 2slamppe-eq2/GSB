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
import modele.metier.Praticien;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class DaoTypePraticien implements DaoInterface<TypePraticien, String> {

    @Override
    public int create(TypePraticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TypePraticien getOne(String idType) throws Exception {
        TypePraticien result = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM TYPE_PRATICIEN WHERE TYP_CODE=?";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idType);
            rs = ps.executeQuery();
            if(rs.next()){
                result = chargerUnEnregistrement(rs);
            }
            
            
        }catch (SQLException ex){
          throw new modele.dao.DaoException("DaoTypePraticien::getOne : erreur requete SELECT : " + ex.getMessage()); 
        }
        return (result);
    }

    @Override
    public ArrayList<TypePraticien> getAll() throws Exception {
        ArrayList<TypePraticien> result = new ArrayList<TypePraticien>();
        ResultSet rs;
        
        String requete = "SELECT * FROM TYPE_PRATICIEN ORDER BY TYP_CODE";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            while (rs.next()){
                TypePraticien typePraticien = chargerUnEnregistrement(rs);
                result.add(typePraticien);
            }
        }catch (Exception e){
            throw new modele.dao.DaoException("DaoPraticien::getAll : erreur requete SELECT : " + e.getMessage());
        }
        return result;
    }

    @Override
    public int update(String idMetier, TypePraticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private TypePraticien chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            TypePraticien typePraticien = new TypePraticien();
            typePraticien.setCode(rs.getString("TYP_CODE"));
            typePraticien.setLibelle(rs.getString("TYP_LIBELLE"));
            typePraticien.setLieu(rs.getString("TYP_LIEU"));
            return typePraticien;
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
