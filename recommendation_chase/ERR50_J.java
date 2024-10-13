package recommendation_chase;
import java.util.Scanner;
/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR50-J - Use Exceptions Only for Exceptional Conditions
 */
public class ERR50_J {
/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod();
    }


/**
 * Example of ERR50-J with proper usage.
 * 
 */
    public static void exampleMethod() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter Your Favorite Number: ");
            int favNum = scan.nextInt(); 
            System.out.println("Your favorite number is: " + favNum + " what a good number!");
        } 
        catch (Exception e) {
            /* notice here that the exception is only being caught here in exceptional circumstances.
            it is NOT being used to control program flow or logic */
            System.err.println("Invalid input. Please enter a valid number next time.");
        } finally {
            scan.close(); 
        }
    }
} // end class
