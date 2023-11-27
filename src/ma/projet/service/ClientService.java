/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import ma.projet.beans.Client;
import ma.projet.dao.IDao;
import ma.projet.connexion.connexion;



/**
 *
 * @author MSI
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ma.projet.dao.IDao;

public class ClientService implements IDao<Client>{
    private List<Client> clients = new ArrayList<>();
    private Object Connexion;
    
    @Override
    public boolean create(Client o) {
        
    Connection conn = connexion.getInstance();
      
    Statement stmt;
        try {
           stmt = conn.createStatement();
       
            //exécuter la requête
            System.out.println("Insertion...");
            String sql = "INSERT INTO client (nom, prenom) VALUES ('" + o.getNom() + "','" + o.getPrenom() + "')";
            stmt.executeUpdate(sql);
            
           /* Autre methode
           String req = "INSERT INTO client(nom,prenom)values(?,?)";
           PreparedStatement pstmt = conn.prepareStatement(req);
           pstmt.setString(1, o.getNom());
           pstmt.setString(2, o.getPrenom());
           pstmt.executeUpdate();
            */
        
            System.out.println("Données insérés dans la table...");
            
            //fermez l'objet de connexion
            conn.close();
            return true;
        }
        catch(Exception e){ 
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Connection conn = connexion.getInstance();
        PreparedStatement stmt;
        try {
            
            String sql = "DELETE FROM client WHERE id = " +id;
            stmt = conn.prepareStatement(sql);
            // Exécuter la requête
            System.out.println("Suppression...");
           
            
            stmt.executeUpdate();
            System.out.println("Cette Données supprimées de la table!");

            // Fermer l'objet de connexion
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    @Override
    public boolean update(int id, Client o) {
        Connection conn = connexion.getInstance();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            // Exécuter la requête
            System.out.println("Mise à jour...");
            String sql = "UPDATE client SET nom = '" + o.getNom() + "', prenom = '" + o.getPrenom() + "' WHERE id = " + id;
            stmt.executeUpdate(sql);
            System.out.println("Données mises à jour dans la table...");

            // Fermer l'objet de connexion
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }    


    @Override
    public Client findById(int id) {
        Connection conn = connexion.getInstance();
        Statement stmt;
        ResultSet rs;

        Client client = null;
        try {
            stmt = conn.createStatement();
            // Exécuter la requête
            String sql = "SELECT * FROM client WHERE id = " + id;
            rs = stmt.executeQuery(sql);
            // Vérifier si un enregistrement a été trouvé
            if (rs.next()) {
                int Cid = rs.getInt("id");
                String Cnom = rs.getString("nom");
                String Cprenom = rs.getString("prenom");
                // Créer un nouvel objet Client avec les données récupérées
                client = new Client(Cid, Cnom, Cprenom);     
            }  
        } catch (SQLException e) {
            System.out.println(e);
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        Connection conn = connexion.getInstance();
        Statement stmt;
        ResultSet rs;
        List<Client> clients = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            // Exécuter la requête
            String sql = "SELECT * FROM client";
            rs = stmt.executeQuery(sql);
            // Parcourir tous les enregistrements et créer les objets Client correspondants
            while (rs.next()) {
                int Cid = rs.getInt("id");
                String Cnom = rs.getString("nom");
                String Cprenom = rs.getString("prenom");
                Client client = new Client(Cid, Cnom, Cprenom);
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return clients;
    }
    
}
