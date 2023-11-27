/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojdbc;

import java.sql.Connection;
import java.util.List;
import ma.projet.beans.Client;
import ma.projet.connexion.connexion;
import ma.projet.service.ClientService;

/**
 *
 * @author MSI
 */
public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = connexion.getInstance();
        
        //*************Test**************
        ClientService cs =  new ClientService();
        System.out.println("*************Create**************");
        Client o = new Client("Ali", "Harbi");
        Client o2 = new Client("Hichem", "Hichem");
        cs.create(o);

        System.out.println("*************Delete**************");
        System.out.println(cs.delete(20));

        System.out.println("*************Find All**************");
        List<Client> LST = cs.findAll();
        for (Client c: LST){
            System.out.println(c);
        }

        System.out.println("*************Find By Id**************");
        Client c1 = new Client("Hichem", "Ben Hichem");
        System.out.println(cs.findById(22));
        System.out.println(cs.update(19, o2));
    }
    
}
