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
import modele.dao.DaoPraticien;
import modele.dao.DaoRapportVisite;
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
    static DaoPraticien daoPraticien = new DaoPraticien();
    static DaoRapportVisite daoRapportVisite = new DaoRapportVisite();

    // test de lecture des enregistrements de la table LABO 
    public static boolean testDaoLireLabo() {
        boolean ok = true;
        ArrayList<Labo> lesLabo = new ArrayList<Labo>();
        try {
            lesLabo = daoLabo.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des labos");
        for (Labo unLabo: lesLabo){
            System.out.println(unLabo);
        }
        return ok;
    }
    
    // test de lecture des enregistrements de la table SECTEUR
    public static boolean testDaoLireSecteur()  {
        boolean ok = true;
        ArrayList<Secteur> lesSecteurs = new ArrayList<Secteur>();
        try {
            lesSecteurs = daoSecteur.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des secteurs");
        for (Secteur unSecteur: lesSecteurs){
            System.out.println(unSecteur);
        }
        return ok;
    }

    // test de lecture des enregistrements de la table VISITEUR
    public static boolean testDaoLireVisiteur() {
        boolean ok = true;
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
        try {
            lesVisiteurs = daoVisiteur.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des visiteurs");
        for (Visiteur unVisiteur: lesVisiteurs){
            System.out.println(unVisiteur);
        }
        return ok;
    }
    
    
        // test de lecture des enregistrements de la table PRATICIEN
    public static boolean testDaoLirePraticien() {
        boolean ok = true;        
        ArrayList<Praticien> lesPraticiens = new ArrayList<Praticien>();
        try {
            lesPraticiens = daoPraticien.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des praticiens");
        for (Praticien unPraticien: lesPraticiens){
            System.out.println(unPraticien);
        }
        return ok;
        
    }
    
           // test de lecture des enregistrements de la table VISITEUR
    public static boolean testDaoLireRapportVisite() throws DaoException, Exception {
        boolean ok = true;
        ArrayList<RapportVisite> lesRapportsVisites = new ArrayList<RapportVisite>();
        lesRapportsVisites = daoRapportVisite.getAll();
        System.out.println("liste des rapports");
        for (RapportVisite unRapportVisite: lesRapportsVisites){
            System.out.println(unRapportVisite);
        }
        return ok;
    }
    
           // test de lecture des enregistrements de la table VISITEUR
    public static boolean testDaoLireUnRapportVisite() {
        boolean ok = true;
        RapportVisite unRapportVisite = null;
        try {
            unRapportVisite = daoRapportVisite.getOne(3);
        } catch (Exception ex) {
           ok = false;
        }
        
        System.out.println("le rapport de visite:");
        System.out.println(unRapportVisite);
        
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
        
        System.out.println("\nTest DAO Lire Praticiens");
        if (testDaoLirePraticien()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO Lire RapportVisite");
        if (testDaoLireRapportVisite()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO Lire UnRapportVisite");
        if (testDaoLireUnRapportVisite()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
       
        System.out.println("\nDéconnexion");
        Jdbc.getInstance().deconnecter();

    }
}
