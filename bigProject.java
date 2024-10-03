/**
 * IT 355 - Group Project 1
 * 
 */


import java.util.Scanner;

public class bigProject {

/**
 * Main method 
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        int control = 0;
        System.out.println("WELCOME TO X DIRECTORY\n");
        while (control != -1) {
            // Display options
            System.out.println("OPTION 1: x");
            System.out.println("OPTION 2: x");
            System.out.println("OPTION 100: x");
            System.out.print("\nEnter your choice (-1 to exit):");

            // Read user input
            control = scanner.nextInt(); // Get user input

            // Handle user choice
            switch (control) {
                case -1:
                    System.out.println("\nThank you...exiting");
                    break; // Exit the loop
                case 1:
                    // Add logic for option 1
                    System.out.println("You selected OPTION 1.");
                    break;
                case 2:
                    // Add logic for option 2
                    System.out.println("You selected OPTION 2.");
                    break;
                case 100:
                    // Add logic for option 100
                    System.out.println("You selected OPTION 100.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close(); // Close the scanner to free resources
    }

/*
 * ALL OTHER METHODS
 */
    public static int exampleMethod() {
    try {
        System.out.println("hello world");
        return 0;
    } 
    catch (Exception e) {
        return 1;
    } 
    finally {
        /*
        Cleanup code here. DO NOT use return, break, continue, or 
        throw statements here. DO NOT abrubtly end the method here.
         */
        System.out.println("Method finished...returning.");
    }
    }


    
} //end class
