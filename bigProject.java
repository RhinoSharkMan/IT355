/**
 * IT 355 - Group Project 1
 * 
 */


import java.util.Random;
import java.util.Scanner; 
import java.util.ArrayList; 
 
 public class bigProject {
 
 /**
  * Main method 
  */
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
         int control = 0;
         ArrayList<HospitalEmployee> employeeList = new ArrayList<>(); 
         System.out.println("WELCOME TO X DIRECTORY\n");
         while (control != -1) {
             // Display options
             System.out.println("OPTION 1: x");
             System.out.println("OPTION 2: x");
             System.out.println("OPTION 81: Request Visitation");
             System.out.println("OPTION 82: Register New Employee");
             System.out.println("OPTION 83: Get Average Patients per Doctor");
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
                    //checks if user input is valid
                     if (scanner.hasNextInt())
                     {
                         roomNum = scanner.nextInt(); 
                     }
                     else 
                     {
                       System.out.println("Invalid input"); 
                       break; 
                     }
                    //if checks if room number is in valid hospital range (101-5099)
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
                System.out.println("Please provide provided Hospital ID, Last Name, designated Pay Rate, and Profession");
                System.out.println("Format: One entry per line");

                int tempId;
                String tempName;
                double tempPay;
                String tempProf;
                boolean validInput = true;

                //checking if inputs are consistent with given format: 
                //checking if int is entered for HID
                if(scanner.hasNextInt())
                {
                    tempId = scanner.nextInt();
                }

                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }
                //checking if String is entered for last name
                if(validInput && scanner.hasNext())
                {
                    tempName = scanner.next(); 
                }
                
                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }
                //checking if double is entered for pay rate
                if (validInput && scanner.hasNextDouble())
                {
                    tempPay = scanner.nextDouble(); 
                }

                else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break;
                    }
                //checking if string is entered for profession 
                if (validInput && scanner.hasNext())
                {
                    tempProf = scanner.next(); 
                }
                
               else{ 
                    System.out.println("Invalid information provided");
                    scanner.next();
                    break; 
               }
              //using HospitalJanitor subclass to create object.
              if (tempProf.equals("Janitor"))
              {
                HospitalJanitor jan = new HospitalJanitor(tempId, tempName, tempPay, tempProf);
                employeeList.add(jan); 
                jan.getEmployeeInfo();
              } 
              //uses HospitalEmployee superclass for any other profession type. 
              else
              {
               HospitalEmployee emp = new HospitalEmployee(tempId, tempName, tempPay, tempProf); 
               employeeList.add(emp); 
               emp.getEmployeeInfo();
              }
              System.out.println("");  
                break;
            
            case 83: 
            System.out.println("You selected OPTION 83.");
            //Ensuring that hospital employees have been registered.
            if (employeeList.size() > 0)
            {
                boolean validEmployee = false; 
                int validIndex = -1; 
                System.out.println("Registered Employees:");
                //Loop satisfies NUM09-J, avoids using a floating point as a loop counter. 
                for (int i = 0; i < employeeList.size(); i++)
                {
                    System.out.println("Employee: " + employeeList.get(i).getName() + " | Profession: " + employeeList.get(i).getProfession());
                    if (!validEmployee && employeeList.get(i).getSecurityLevel() > 0)
                    {
                        //determines if a registered employee has a valid profession, if so that employee object
                        //will be used for the function call. 
                        validEmployee = true;
                        validIndex = i; 
                    }

                }
                //if valid employee found: continue by determining number of patients to find average. 
                if (validEmployee)
                {
                    int numPatients = 0; 
                    double averagePatient = 0.0;
                    System.out.println("Enter number of patients to recieve average: ");

                    if (scanner.hasNextInt())
                    {
                        numPatients = scanner.nextInt();
                        averagePatient = checkAvgPatients(employeeList.get(validIndex), numPatients); 
                        System.out.println("On average, each doctor will treat: " + averagePatient + " patients.");
                    }

                    else
                    {
                        System.out.println("Invalid input.");
                        break; 
                    }

                }
            }
            //else condition for if no employees are registered. 
            else 
            {
            System.out.println("Hospital registry empty, use OPTION 82 to add employees");
            break;
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
     
private static double checkAvgPatients(HospitalEmployee emp, int totalPatientNum)
{
    int hospitalDoctors = emp.getNumDoctors(); 

    //Satisfies MET01-J, validating method arguments without using assertions
    if (emp.getSecurityLevel() == 0)
    {
        System.out.println("Employee entered is not valid"); 
        return -1;
    }
    //Satisfies MET01-J, validating method arguments without using assertions
    if (!(totalPatientNum > 0))
    {
        System.out.println("Invalid number of patients entered"); 
        return -1;
    }
    //Satisfies NUM02-J, ensuring that resulting division does not result in divide by zero error. 
    if (hospitalDoctors == 0)
    {
        System.out.println("No doctors currently stored");
        System.out.println("Cannot compute to avoid dividing by zero");
        return -1; 
    }

    return totalPatientNum / hospitalDoctors; 
}




 } //end class
 
/* 
* Class that initailizes stored HospitalEmployees 
* Satisfies OBJ51-J by minimization accessbility of classes and its members, only accessible to package. 
*/
class HospitalEmployee
 {
     private int HID; 
     private String lastName; 
     private double payRate; 
     private String profession; 
     private int securityLevel; 
     private int floorLevel; 

     private static int numDoctors = 0;
    
     /* 
      * Constructor to set object's variable values. 
     */
     HospitalEmployee(int HID, String name, double payRate, String profession)
     {
         this.HID = HID;
         this.lastName = name; 
         this.payRate = payRate; 
         this.profession = profession; 
 
         securityLevel = initialSecurityLevel(profession);
 
         floorLevel = designateFloor(); 

         if (this.profession.equals("Doctor"))
         {
            numDoctors++;
         }
        
      }
 
     /*
     * Determines security clearance employee will have in hospital depending on their profession. 
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

    /* 
     * Prints Hospital Employee information
    */
    protected void getEmployeeInfo()
    {
        System.out.println("\nEmployee sucessfully created: ");
        System.out.println(profession + " assigned floor: " + floorLevel);
        System.out.println("Designated hospital security level: " + securityLevel); 
    }

    /* 
     * Returns the security level of this HosptialEmployee object
     * @return value of securityLevel variable for this object. 
    */
    protected final int getSecurityLevel()
    {
        return this.securityLevel; 
    }

    /* 
    * Returns the number of doctors that are stored in the same hospital system as this employee object. 
    * @return value of numDoctors variable. 
    */
    protected final int getNumDoctors()
    {
        return this.numDoctors;  
    }

    /* 
     * Returns the stored name of this employee
     * @return value of object's name variable.
    */
    protected final String getName()
    {
        return this.lastName; 
    }

    /* 
     * Returns the stored profession of this employee
     * @return value stored in profession variable
    */
    protected final String getProfession()
    {
        return this.profession; 
    }
 }
 

 /* 
  * Subclass of HospitalEmployee, specifically for Janitor profession. 
 */
 class HospitalJanitor extends HospitalEmployee
 {
     int lowestFloorNum;
     int highestFloorNum; 

     /* 
      * Constructor to set object's variable values as well as Janitor specific values. 
     */
     HospitalJanitor(int HID, String name, double payRate, String profession)
     {
         super(HID, name, payRate, profession); 
         
         lowestFloorNum = designateJanitorFloor(); 
         highestFloorNum = 5 + lowestFloorNum; 
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
        System.out.println("\nJanitor succesfully created: ");
        System.out.println("Assigned floors " + lowestFloorNum + " to " + highestFloorNum); 
    }
 }
