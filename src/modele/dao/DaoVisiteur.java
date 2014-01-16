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
public class DaoVisiteur implements DaoInterface<Visiteur, String>{

    private DaoSecteur daoSecteur = new DaoSecteur();
    private DaoLabo daoLabo = new DaoLabo();
    @Override
    public int create(Visiteur unVisiteur) throws Exception {
        int rs=0;
        String requete = "INSERT INTO VISITEUR VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1,unVisiteur.getMatricule());
            ps.setString(2,unVisiteur.getNom());
            ps.setString(3,unVisiteur.getPrenom());
            ps.setString(4,unVisiteur.getAdresse());
            ps.setString(5,unVisiteur.getCP());
            ps.setString(6,unVisiteur.getVille());
            ps.setDate(7,unVisiteur.getDateEmbauche());
            ps.setString(8,unVisiteur.getSecteur().getCode());
            ps.setString(9,unVisiteur.getLabo().getCode());
            ps.setString(1,unVisiteur.getLogin());
            rs = ps.executeUpdate(requete);
            return rs;
            
        }catch (SQLException e){
          throw new modele.dao.DaoException("DaoVisiteur::create : erreur requete SELECT : " + e.getMessage());   
          
        }
        
    }

    @Override
    public Visiteur getOne(String idVisiteur) throws Exception {
        Visiteur result = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE=?";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idVisiteur);
            rs = ps.executeQuery();
            if(rs.next()){
                result = chargerUnEnregistrement(rs);
            }
            
            
        }catch (SQLException ex){
          throw new modele.dao.DaoException("DaoVisiteur::getOne : erreur requete SELECT : " + ex.getMessage()); 
        }
        return (result);
    }

    @Override
    public ArrayList<Visiteur> getAll() throws Exception {
        ArrayList<Visiteur> result = new ArrayList<Visiteur>();
        ResultSet rs;
        
        String requete = "SELECT * FROM Visiteur ORDER BY VIS_NOM";
        try{
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            while (rs.next()){
                Visiteur unVisiteur = chargerUnEnregistrement(rs);
                result.add(unVisiteur);
            }
        }catch (Exception e){
            throw new modele.dao.DaoException("DaoVisiteur::getAll : erreur requete SELECT : " + e.getMessage());
        }
        return result;
    }

    @Override
    public int update(String idVisiteur, Visiteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idVisiteur) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Visiteur chargerUnEnregistrement(ResultSet rs) throws DaoException, Exception {
        try {
            Visiteur visiteur = new Visiteur();
            visiteur.setMatricule(rs.getString("VIS_MATRICULE"));
            visiteur.setNom(rs.getString("VIS_NOM"));
            visiteur.setPrenom(rs.getString("Vis_PRENOM"));
            visiteur.setAdresse(rs.getString("VIS_ADRESSE"));
            visiteur.setCP(rs.getString("VIS_CP"));
            visiteur.setVille(rs.getString("VIS_VILLE"));
            visiteur.setDateEmbauche(rs.getDate("VIS_DATEEMBAUCHE"));
            visiteur.setSecteur(daoSecteur.getOne(rs.getString("SEC_CODE")));
            visiteur.setLabo(daoLabo.getOne(rs.getString("LAB_CODE")));
            visiteur.setLogin(rs.getString("VIS_LOGIN"));
            return visiteur;
        } catch (SQLException ex) {
            throw new DaoException("DaoVisiteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    }
    
}
