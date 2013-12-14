/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoVisiteur;
import modele.dao.DaoException;
import modele.dao.DaoLabo;
import modele.dao.DaoSecteur;
import modele.jdbc.FabriqueJdbc;
import modele.jdbc.Jdbc;
import modele.metier.*;
/**
 *
 * @author btssio
 */
public class TestDao {

    static DaoLabo daoLabo = new DaoLabo();
    static DaoSecteur daoSecteur = new DaoSecteur();
    static DaoVisiteur daoVisiteur = new DaoVisiteur();

    // test de lecture des enregistrements de la table LABO 
    public static boolean testDaoLireLabo() throws DaoException, Exception {
        boolean ok = true;
        ArrayList<Labo> lesLabo = new ArrayList<Labo>();
        lesLabo = daoLabo.getAll();
        System.out.println("liste des labos");
        for (Labo unLabo: lesLabo){
            System.out.println(unLabo);
        }
        return ok;
    }
    
    // test de lecture des enregistrements de la table SECTEUR
    public static boolean testDaoLireSecteur() throws DaoException, Exception {
        boolean ok = true;
        ArrayList<Secteur> lesSecteurs = new ArrayList<Secteur>();
        lesSecteurs = daoSecteur.getAll();
        System.out.println("liste des labos");
        for (Secteur unSecteur: lesSecteurs){
            System.out.println(unSecteur);
        }
        return ok;
    }

    // test de lecture des enregistrements de la table VISITEUR
    public static boolean testDaoLireVisiteur() throws DaoException, Exception {
        boolean ok = true;
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        lesVisiteurs = daoVisiteur.getAll();
        System.out.println("liste des labos");
        for (Visiteur unVisiteur: lesVisiteurs){
            System.out.println(unVisiteur);
        }
        return ok;
    }
    
   

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, DaoException, Exception {
        System.out.println("Tests unitaires DAO");
        FabriqueJdbc.creer("GSBJdbc.properties");
        Jdbc.getInstance().connecter();


        System.out.println("\nTest DAO Lire Labo");
        if (testDaoLireLabo()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        System.out.println("\nTest DAO Lire Secteur");
        if (testDaoLireSecteur()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO Lire Visiteur");
        if (testDaoLireVisiteur()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
       
        System.out.println("\nDéconnexion");
        Jdbc.getInstance().deconnecter();

    }
}
