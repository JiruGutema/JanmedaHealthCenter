/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_project;
import java.util.Scanner;
/**
 *
 * @author jiren
 */
public class Login_As_Admin {
    static Scanner scanner = new Scanner(System.in);
    
    public static void loginInitializer(){

     if(Authenticator.authenticateUser()){
        
        System.out.println("Welcome to Janmeda Health Center's Database Center!?");
        System.out.println("--------------------------------------------------");
        System.out.println("                    MENU                          ");
        System.out.println("1. Managing Admins");
        System.out.println("2. Managing Patient");
        System.out.println("3. Managing Worker");
        System.out.println("4. Managing Medicine");
        System.out.println("5. Terminate The Program");
        int res = scanner.nextInt();
        
        if (res == 1){
            System.out.println("---------------------------------------------------------------------------");
           SystemAdminManager.adminMenu(); 
        }
        
        else if (res == 2){
            System.out.println("---------------------------------------------------------------------------");
            PatientManager.patientMenu();
        }
        
        else if (res == 3){
            System.out.println("---------------------------------------------------------------------------");
            WorkerManager.workerMenu();
        }
        
        else if (res == 4){
            
            System.out.println("---------------------------------------------------------------------------");
            MedicineManager.MedicineMenu();
        }
        else if (res == 5){
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The program terminated successfully!");
        }
        else{
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Wrong Choice!");
        }
}
    else {
            System.out.println("Invalid user credentials. Access denied.");
        }
    }}