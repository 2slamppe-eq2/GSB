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
public class DaoLabo implements DaoInterface<Labo, String>{

    @Override
    public int create(Labo objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Labo getOne(String idLabo) throws Exception {
       Jdbc.getInstance().connecter();
        Labo result = null;
        ResultSet rs = null;
        
        String requete = "SELECT * FROM LABO WHERE LAB_CODE=?";
        try{
            ArrayList<String> params = new ArrayList<>();
            params.add(idLabo);
            rs = Jdbc.getInstance().consulter(requete,params);
            if(rs.next()){
                result = chargerUnEnregistrement(rs);
            }
        }catch (SQLException ex){
             throw new modele.dao.DaoException("DaoLabo::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return result;
    }

    @Override
    public ArrayList<Labo> getAll() throws Exception {
        Jdbc.getInstance().connecter();
        ArrayList<Labo> result = new ArrayList<Labo>();
        ResultSet rs;
        String requete = "SELECT * FROM LABO";
        try{
            rs = Jdbc.getInstance().consulter(requete);
            
            while(rs.next()){
                Labo labo = chargerUnEnregistrement(rs);
                result.add(labo);
            }

            
        }catch (SQLException ex){
             throw new modele.dao.DaoException("DaoLabo::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        Jdbc.getInstance().deconnecter();
        return result;
    }

    @Override
    public int update(String idLabo, Labo objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idLabo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Labo chargerUnEnregistrement(ResultSet rs) throws DaoException{
        try{
            Labo labo = new Labo();
            labo.setCode(rs.getString("LAB_CODE"));
            labo.setNom(rs.getString("LAB_NOM"));
            labo.setChefVente(rs.getString("LAB_CHEFVENTE"));
            return labo; 
        }catch (SQLException ex){            
            throw new DaoException("DaoLabo - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
        
    }
    
}
