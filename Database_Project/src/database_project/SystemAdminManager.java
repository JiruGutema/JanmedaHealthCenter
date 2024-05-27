package database_project;

import java.sql.*;
import java.util.Scanner;


public class SystemAdminManager {
    
    static String databaseLocation = Authenticator.databaseLocation;
    static String userName = Authenticator.userName;
    static String userPassword = Authenticator.userPassword;
    
    public static void addSystemAdmin(String id, String name, String password, String phone) {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO System_Admin (ID, Name, Password, Phone) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, password);
            stmt.setString(4, phone);
            stmt.executeUpdate();
            System.out.println("System admin added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding system admin: " + e.getMessage());
        }
    }

    public static void removeSystemAdmin(String id) {
        viewSystemAdmins();
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM System_Admin WHERE ID = ?")) {
            stmt.setString(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("System admin removed successfully.");
            } else {
                System.out.println("No system admin found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing system admin: " + e.getMessage());
        }
    }

    public static void viewSystemAdmins() {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM System_Admin")) {
            System.out.println("System Admins:");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                String phone = rs.getString("Phone");
                System.out.printf("ID: %s, Name: %s, Password: %s, Phone: %s%n", id, name, password, phone);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving system admins: " + e.getMessage());
        }
    }

 
        
 public static void adminMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
  

      
            do {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("System Admin Management");
                System.out.println("1. Add System Admin");
                System.out.println("2. Remove System Admin");
                System.out.println("3. View System Admins");
                System.out.println("4. Exit");
                System.out.println("Enter your choice (1-4): ");
                

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter System Admin ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter System Admin Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter System Admin Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter System Admin Phone: ");
                        String phone = scanner.nextLine();
                        addSystemAdmin(id, name, password, phone);
                        
                        
                        break;
                    case 2:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter System Admin ID to remove: ");
                        id = scanner.nextLine();
                        removeSystemAdmin(id);
                        
                        break;
                    case 3:
                        System.out.println("---------------------------------------------------------------------------");
                        viewSystemAdmins();
                        
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
