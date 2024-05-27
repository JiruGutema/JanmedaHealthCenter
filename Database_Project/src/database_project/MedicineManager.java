package database_project;

import java.sql.*;
import java.util.Scanner;




/**
 *
 * @author jiren
 */
public class MedicineManager {
    
    static String databaseLocation = Authenticator.databaseLocation;
    static String userName = Authenticator.userName;
    static String userPassword = Authenticator.userPassword;
    
    public static void addMedicine(String name, int quantity, String exp_date, int price) {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Medicine (Name, Quantity, Expiration_date, price) VALUES (?, ?, ?, ?,)")) {
            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setString(3, exp_date);
            stmt.setInt(5, price);
            stmt.executeUpdate();
            System.out.println("Medicine added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding Medicine: " + e.getMessage());
        }
    }

    public static void removeMedicine(int id) {
            viewMedicine();
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Medicine WHERE ID = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Medicine removed successfully.");
            } else {
                System.out.println("No Medicine found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing Medicine: " + e.getMessage());
        }
    }

    public static void viewMedicine() {
        
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Medicine")) {
            System.out.println("Medicine:");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int quantity = rs.getInt("Quantity");
           
                String exp_date = rs.getString("Expiration_Date");
                String price = rs.getString("Price");
                
                System.out.printf("ID: %d, Name: %s, Quantity: %d, Expiration_Date: %s, Price: %s%n",
                                  id, name, quantity,exp_date, price);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Medicine: " + e.getMessage());
        }
    }

   
    
    public static void MedicineMenu(){
        
        Scanner scanner = new Scanner(System.in);
        int choice;
       
         
            do {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Medicine Management");
                System.out.println("1. Add Medicine");
                System.out.println("2. Remove Medicine");
                System.out.println("3. View medicine");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");

                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter medicine Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        System.out.print("Enter Expiration_Date: ");
                        String Exp_date = scanner.nextLine();
                        
                        System.out.print("Enter Price: ");
                        int price = scanner.nextInt();
                        
                        addMedicine(name, quantity, Exp_date,price);
                        break;
                        
                    case 2:
                        viewMedicine();
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter Medicine ID to remove: ");
                        int patientId = scanner.nextInt();
                        scanner.nextLine(); 
                        removeMedicine(patientId);
                        break;
                    case 3:
                        System.out.println("---------------------------------------------------------------------------");
                        viewMedicine();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } 
        
    }
    

    
    
    



