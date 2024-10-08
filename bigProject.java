/**
 * IT 355 - Group Project 1
 * 
 */


import java.util.Random;
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
             System.out.println("OPTION 81: Request Visitation");
             System.out.println("OPTION 82: Register New Employee");
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
                     System.out.println("Please enter patient's room number to request visitation"); 
                     int roomNum;
 
                     //String input = scanner.nextLine();
                     if (scanner.hasNextInt())
                     {
                         roomNum = scanner.nextInt(); 
                     }
                     else 
                     {
                       System.out.println("Invalid input"); 
                       break; 
                     }
 
                     if (checkRoomNumber(roomNum))
                     {
                         System.out.println("Valid room number entered, request has been created"); 
                     }
                     else
                     {
                         System.out.println("Room number incorrect, please contact patient's medical staff to find correct room"); 
                     }
                     System.out.println(""); 
                     break; 
                case 82:
                System.out.println("You selected OPTION 82.");
                System.out.println("Please provide provided Hospital ID, Name, designated Pay Rate, and Profession");
                
                int tempId;
                String tempName;
                double tempPay;
                String tempProf;
                boolean validInput = true;

                if(scanner.hasNextInt())
                {
                    tempId = scanner.nextInt();
                    //System.out.println("Valid ID");
                }

                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }

                if(validInput && scanner.hasNext())
                {
                    tempName = scanner.next(); 
                    //System.out.println("Valid Name");
                }
                
                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }

                if (validInput && scanner.hasNextDouble())
                {
                    tempPay = scanner.nextDouble(); 
                    //System.out.println("Valid Pay");
                }

                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }

                if (validInput && scanner.hasNext())
                {
                    tempProf = scanner.next(); 
                    //System.out.println("Valid Profession");
                }
                
               else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break; 
               }

              if (tempProf.equals("Janitor"))
              {
                HospitalJanitor jan = new HospitalJanitor(tempId, tempName, tempPay, tempProf);
                jan.getEmployeeInfo();
              } 
              else
              {
               HospitalEmployee emp = new HospitalEmployee(tempId, tempName, tempPay, tempProf); 
               emp.getEmployeeInfo();
              }
              System.out.println("");  
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
 public static boolean checkRoomNumber(int room)
     {
         //validating arguments
         if (room >= 101 && room <= 5099)
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
 
         securityLevel = initialSecurityLevel(profession);
 
         floorLevel = designateFloor(); 
        
         //if (!profession.equals("Janitor"))
         //{
         //getEmployeeInfo();
        // }
      }
 
     /*
     * Satisfied MET05-J, constructor calls this method which is final so it is not overridable. 
     */
     protected final int initialSecurityLevel(String jobTitle)
     {
         if (jobTitle.equals("CEO") || jobTitle.equals( "Executive"))
         {
             return 5;
         }
 
         else if (jobTitle.equals( "Security"))
         {
             return 4; 
         }
         
         else if (jobTitle.equals("Doctor") || jobTitle.equals( "Surgeon"))
         {
             return 3; 
         }    
 
         else if (jobTitle.equals( "Nurse"))
         {
             return 2; 
         }
 
         else if (jobTitle.equals( "Janitor") || jobTitle.equals("Maintenance") || jobTitle.equals( "Electrician"))
         {
             return 1;
         }
 
         else
         {
             return 0; 
         }
     }
     
     /*Designates floor that the hospital employee will work on. 
      * @return random int from 1-50, indicating the hospital's floors.
     */
     protected final int designateFloor()
     {
         Random randNum = new Random(); 
         int floorNum = randNum.nextInt(50) + 1; 
         return floorNum; 
     }

    
     protected void getEmployeeInfo()
     {
        System.out.println("Employee sucessfully created: ");
        System.out.println(profession + " assigned floor: " + floorLevel);
        System.out.println("Designated hospital security level: " + securityLevel); 
     }
 }
 
 class HospitalJanitor extends HospitalEmployee
 {
     int lowestFloorNum;
     int highestFloorNum; 
 
     HospitalJanitor(int HID, String name, double payRate, String profession)
     {
         super(HID, name, payRate, profession); 
         
         lowestFloorNum = designateJanitorFloor(); 
         highestFloorNum = 5 + lowestFloorNum; 

         //getEmployeeInfo(); 
     }

    /* Assigns lowest floor janitor is responsible for cleaning. 
     * Satisfies MET04-J, necessary override of superclass method. Keeps 
     * method secure by not increasing visbility of method. 
     * @return random int that is a multiple of 5. 
    */
     protected final int designateJanitorFloor()
     {
         Random randNum = new Random(); 
        //lowest floor num is multiple of 5 from 1 - 45, highest will be that + 5; 
         int floorNum = randNum.nextInt((9) + 1) * 5; 
         return floorNum; 
     }
 
    /* Prints out Janitor specific information
     * Satisfies MET04-J, necessary override of superclass method. Keeps 
     * method secure by not increasing visbility of method. 
     * Declared final to satisfy MET05-J. 
    */
    @Override
    protected void getEmployeeInfo()
    {
        System.out.println("Janitor succesfully created: ");
        System.out.println("Assigned floors " + lowestFloorNum + " to " + highestFloorNum); 
    }
 }
