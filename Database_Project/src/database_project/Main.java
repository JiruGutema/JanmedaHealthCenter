
package database_project;

import java.util.Scanner;

/**
 *
 * @author jiren
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("1. Login as an Admin");
        System.out.println("2. Change Database Location");
        System.out.println("3. Exit");
        System.out.println("---------------------------------------------------------------------------");
        int userInput = scanner.nextInt();
        if(userInput == 1){
            Login_As_Admin.loginInitializer();
        }
        else if (userInput == 2){
            Authenticator.databaseSetter();  
        }
        else{
            System.out.println("The program has terminated!");
        }
       

        scanner.close();
    }
        
}
