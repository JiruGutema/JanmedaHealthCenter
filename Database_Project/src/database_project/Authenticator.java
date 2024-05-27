/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_project;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jiren
 */

public class Authenticator {
    //tempo url jdbc:mysql://localhost:3306/Janmeda_Health_Center
    public static  String databaseLocation = "jdbc:mysql://localhost:3306/Janmeda_Health_Center";
    public static   String userName = "Jiren";
    public static   String userPassword = "1441";
      
    
    public static boolean authenticateUser() {
        System.out.println("---------------------------------------------------------------------------");
        
        String id;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("very that you are an Admin first!");
        System.out.print("Enter your ID: ");
        id = scanner.nextLine();
        System.out.print("Enter your Password: ");
        password = scanner.nextLine();
        
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM System_Admin WHERE ID = ? AND Password = ?")) {
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error authenticating user: " + e.getMessage());
            return false;
        }
    }
    public static void databaseSetter(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Current Database: "+Authenticator.databaseLocation);
            System.out.println("");
            System.out.println("Enter the location of the new database!");
            System.out.println("Ex. 'jdbc:mysql://localhost:3306/Janmeda_Health_Center'");
            Authenticator.databaseLocation = scanner.next();
            System.out.println("Your user name for the database server.");
            Authenticator.userName = scanner.next();
            System.out.println("Your user password for your database server.");
            Authenticator.userPassword = scanner.next();
    }

    
}

