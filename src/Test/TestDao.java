/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoVisiteur;
import modele.dao.DaoException;
import modele.dao.DaoFamille;
import modele.dao.DaoLabo;
import modele.dao.DaoMedicament;
import modele.dao.DaoOffrir;
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
    static DaoFamille daoFamille = new DaoFamille();
    static DaoMedicament daoMedicament = new DaoMedicament();
    static DaoOffrir daoOffrir = new DaoOffrir();
            

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
    
           // test de lecture des enregistrements de la table RAPPORTVISITE
    public static boolean testDaoLireRapportVisite() throws DaoException, Exception {
        boolean ok = true;
        ArrayList<RapportVisite> lesRapportsVisites = new ArrayList<RapportVisite>();
        lesRapportsVisites = daoRapportVisite.getAll();
        System.out.println("liste des rapports");
        for (RapportVisite unRapportVisite: lesRapportsVisites){
            unRapportVisite.DateToString();
            System.out.println(unRapportVisite);
            
        }
        return ok;
    }
    
           // test de lecture d'un enregistrement de la table RAPPORTVISITE
    public static boolean testDaoLireUnRapportVisite() {
        boolean ok = true;
        RapportVisite unRapportVisite = null;
        try {
            unRapportVisite = daoRapportVisite.getOne(3);
            unRapportVisite.DateToString();
        } catch (Exception ex) {
           ok = false;
        }
        
        System.out.println("le rapport de visite:");
        System.out.println(unRapportVisite);
        
        return ok;
    }
    
     //test d'insertion d'un rapport dans la table RAPPORTVISITE     
    public static boolean testDaoCreateUnRapportVisite(RapportVisite unRapport){
        boolean ok = true;
        try {
            daoRapportVisite.create(unRapport);
        } catch (Exception ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        System.out.println("le rapport de visite créé:");
        System.out.println(unRapport);
        
        return ok; 
    }
   
    // test de lecture des enregistrements de la table FAMILLE
    public static boolean testDaoLireFamille()  {
        boolean ok = true;
        ArrayList<Famille> lesFamilles = new ArrayList<Famille>();
        try {
            lesFamilles = daoFamille.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des familles");
        for (Famille uneFamille: lesFamilles){
            System.out.println(uneFamille);
        }
        return ok;
    }
 
    // test de lecture des enregistrements de la table MEDICAMENT
    public static boolean testDaoLireMedicament()  {
        boolean ok = true;
        ArrayList<Medicament> lesMedicaments = new ArrayList<Medicament>();
        try {
            lesMedicaments = daoMedicament.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des medicaments");
        for (Medicament unMedicament: lesMedicaments){
            System.out.println(unMedicament);
        }
        return ok;
    }
    // test de lecture des enregistrements de la table OFFRIR
    public static boolean testDaoLireOffrir()  {
        boolean ok = true;
        ArrayList<Echantillon> lesEchantillons = new ArrayList<Echantillon>();
        try {
            lesEchantillons = daoOffrir.getAll();
        } catch (Exception ex) {
            ok = false;
        }
        System.out.println("liste des échantillons");
        for (Echantillon unEchantillon: lesEchantillons){
            System.out.println(unEchantillon);
        }
        return ok;
    }
    
    //test d'insertion d'un enregistrement dans la table OFFRIR     
    public static boolean testDaoCreateOffrir(Echantillon unEchantillon){
        boolean ok = true;
        try {
            daoOffrir.create(unEchantillon);
        } catch (Exception ex) {
            Logger.getLogger(TestDao.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        System.out.println("l'échantillon créé:");
        System.out.println(unEchantillon);
        
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
        System.out.println("\nTest DAO CreateUnRapportVisite");
        Visiteur unVisiteur = daoVisiteur.getOne("zzz");
        Praticien unPraticien = daoPraticien.getOne(1);        
        RapportVisite unRapport = new RapportVisite();
        unRapport.setVisiteur(unVisiteur);
        unRapport.setNumero(daoRapportVisite.getMaxNumRapport()+1);
        unRapport.setBilan("test");
        unRapport.setDateDeSaisieString("12/12/12");
        unRapport.setMotif("test");
        unRapport.setPraticien(unPraticien);
        if (testDaoCreateUnRapportVisite(unRapport)) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO LireFamille");
        if (testDaoLireFamille()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO LireMedicament");
        if (testDaoLireMedicament()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO LireOffrir");
        if (testDaoLireOffrir()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        
        System.out.println("\nTest DAO CreateOffrir");
        Echantillon unEchantillon = new Echantillon(unRapport, daoMedicament.getOne("3MYC7"), 10);
 
        if (testDaoCreateOffrir(unEchantillon)) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
       
        System.out.println("\nDéconnexion");
        Jdbc.getInstance().deconnecter();

    }
}


