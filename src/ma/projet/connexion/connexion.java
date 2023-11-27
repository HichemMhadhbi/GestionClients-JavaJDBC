/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 21652
 */
public class connexion {
    
    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/demojdbc";
    private static Connection cn;

    public static Connection getInstance(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url ,login, password);
            System.out.println("connection succeded");
            return con;
        } 
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
        
    public static Connection getCn() {
        return cn;
    }

}
