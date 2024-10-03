/**
 * IT 355 - Group Project 1
 * 
 */


import java.util.Scanner;
import java.util.Random; 

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
                case 81: 
                    System.out.println("You selected OPTION 81.");
                    System.out.println("Please enter patient's room number to validate"); 
                    int roomNum;

                    String input = scanner.nextLine();
                    if (isInteger(input))
                    {
                        roomNum = input; 
                    }
                    else 
                    {
                      System.out.println("Invalid input"); 
                      break; 
                    }

                    if (checkRoomNumber(roomNum))
                    {
                        System.out.println("Valid room number entered"); 
                    }
                    else
                    {
                        System.out.println("Room number incorrect, please contact patient's medical staff to find correct room"); 
                    }
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


/*
* Utilizing MET00-J by validating the method's arguments. 
* Also satisfies MET01-J by not using assertions to validate the argument. 
* Hospital has 50 floors, room number has to 101 - 5099
* @param room integer describing hospital's room number
* @return true if room is in correct range, false otherwise. 
*/
public static bool checkRoomNumber(int room)
    {
        //validating arguments
        if (num >= 101 && num <= 5099)
        {
           return true; 
        }

        else
        {
          return false; 
        }
    }
    
} //end class



class HospitalEmployee
{
    private int HID; 
    private String name; 
    private double payRate; 
    private String profession; 
    private int securityLevel; 
    protected int floorLevel; 
    
    HospitalEmployee(int HID, String name, double payRate, String profession)
    {
        this.HID = HID;
        this.name = name; 
        this.payRate = payRate; 
        this.profession = profession; 

        securityLevel = initialSecurityLevel(profession)

        floorLevel = designateFloor(); 
     }

    /*
    * Satisfied MET05-J, constructor calls this method which is final so it is not overridable. 
    */
    private final int initialSecurityLevel(String jobTitle)
    {
        if (jobTitle == "CEO" || jobTitle == "Executive")
        {
            return 5;
        }

        else if (jobTitle == "Security")
        {
            return 4; 
        }
        
        else if (jobTitle == "Doctor" || jobTitle == "Surgeon")
        {
            return 3; 
        }    

        else if (jobTitle == "Nurse")
        {
            return 2; 
        }

        else if (jobTitle == "Janitor" || jobTitle == "Maintenance" || jobTitle == "Electrician")
        {
            return 1;
        }

        else
        {
            return 0; 
        }
    }

    protected int designateFloor()
    {
        Random randNum = new Random(); 
        int floorNum = randNum.nextInt(50) + 1; 
    }
}

class HospitalJanitor extends HospitalEmployee
{
    int lowestFloorNum;
    int highestFloorNum; 

    HospitalJanitor(int HID, String name, double payRate, String profession)
    {
        super(int HID, String name, double payRate, String profession); 
        
        lowestFloorNum = designateFloor() 
    }
    
    @Override
    //janitors get multiple floors to work on
    private int designateFloor()
    {
        Random randNum = new Random(); 
        int floorNum = randNum.nextInt(9) + 1 * 5; 
        //lowest floor num is multiple of 5 from 1 - 45, highest will be that + 5; 
    }
    //override designateFloor method, keep int unaccessible for MET04-J

    
}


