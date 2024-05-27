/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_project;

/**
 *
 * @author jiren
 */

import java.sql.*;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class WorkerManager {
    
    static String databaseLocation = Authenticator.databaseLocation;
    static String userName = Authenticator.userName;
    static String userPassword = Authenticator.userPassword;
    
    public static void addWorker(String name, String phone, String role, String hiredate, Double salary) {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Worker (Name,Phone,Role,Hiredate,Salary) VALUES (?, ?, ?, ?, ?)")) {
      
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, role);
            stmt.setString(4, hiredate);
            stmt.setDouble(5, salary);
            stmt.executeUpdate();
            System.out.println("Worker added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding system admin: " + e.getMessage());
        }
    }

    public static void removeWorker(String id) {
        viewWorker();
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Worker WHERE ID = ?")) {
            stmt.setString(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Worker removed successfully.");
            } else {
                System.out.println("No Worker found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing Worker: " + e.getMessage());
        }
    }

    public static void viewWorker() {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Worker")) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Worker:");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String phone = rs.getString("Phone");
                String role = rs.getString("Role");
                String hiredate = rs.getString("Hiredate");
                String salary = rs.getString("Salary");
                System.out.printf("ID: %s, Name: %s, Phone: %s, Role: %s, Hiredate: %s, Salary: %s%n", id, name, phone,role,hiredate,salary);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Worker database: " + e.getMessage());
        }
    }

 
        
 public static void workerMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
       
            do {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Woker Management");
                System.out.println("1. Add Woker");
                System.out.println("2. Remove Worker");
                System.out.println("3. View Worker");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                       System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter Worker Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Worker Phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter Worker Role: ");
                        String role = scanner.nextLine();
                        System.out.println("Enter Worker Hiredate: ");
                        String hiredate = scanner.nextLine();
                        System.out.println("Enter Worker Salary: ");
                        Double salary = scanner.nextDouble();
                        addWorker(name, phone,role,hiredate,salary );
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case 2:
                        viewWorker();
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter Worker ID to remove: ");
                        String id = scanner.nextLine();
                        removeWorker(id);
                        break;
                    case 3:
                        viewWorker();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
         scanner.close();

       
    }

}
