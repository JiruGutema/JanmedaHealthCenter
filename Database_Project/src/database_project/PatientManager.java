package database_project;

import java.sql.*;
import java.util.Scanner;




/**
 *
 * @author jiren
 */
public class PatientManager {
    
    static String databaseLocation = Authenticator.databaseLocation;
    static String userName = Authenticator.userName;
    static String userPassword = Authenticator.userPassword;
    
    public static void addPatient(String name, int age, char gender, String address, String phone, String medCase, String paid) {
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Patient (Name, Age, Gender, Address, Phone, Med_Case, Paid) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, String.valueOf(gender));
            stmt.setString(4, address);
            stmt.setString(5, phone);
            stmt.setString(6, medCase);
            stmt.setString(7, paid);
            stmt.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        }
    }

    public static void removePatient(int id) {
        viewPatients();
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Patient WHERE ID = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Patient removed successfully.");
            } else {
                System.out.println("No patient found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error removing patient: " + e.getMessage());
        }
    }

    public static void viewPatients() {
        
        try (Connection conn = DriverManager.getConnection(databaseLocation, userName, userPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Patient")) {
            System.out.println("Patients:");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                char gender = rs.getString("Gender").charAt(0);
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String medCase = rs.getString("Med_Case");
                String paid = rs.getString("Paid");
                System.out.printf("ID: %d, Name: %s, Age: %d, Gender: %c, Address: %s, Phone: %s, Med Case: %s, Paid: %s%n",
                                  id, name, age, gender, address, phone, medCase, paid);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving patients: " + e.getMessage());
        }
    }

   
    
    public static void patientMenu(){
        
        Scanner scanner = new Scanner(System.in);
        int choice;
       
         
            do {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Patient Management");
                System.out.println("1. Add Patient");
                System.out.println("2. Remove Patient");
                System.out.println("3. View Patients");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");
               
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Patient Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Patient Gender (M/F): ");
                        char gender = scanner.nextLine().charAt(0);
                        System.out.print("Enter Patient Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Patient Phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter Patient Medical Case: ");
                        String medCase = scanner.nextLine();
                        System.out.print("Enter Patient Paid Status: ");
                        String paid = scanner.nextLine();
                        addPatient(name, age, gender, address, phone, medCase, paid);
                        break;
                    case 2:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Enter Patient ID to remove: ");
                        int patientId = scanner.nextInt();
                        scanner.nextLine(); 
                        removePatient(patientId);
                        break;
                    case 3:
                        System.out.println("---------------------------------------------------------------------------");
                        viewPatients();
                        break;
                    case 4:
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } 
        
    }
    

    
    
    



