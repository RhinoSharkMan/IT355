/**
 * IT 355 - Group Project 1
 * 
 */


// import java.awt.SystemTray;
// import java.awt.im.InputContext;
import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.*;
import java.net.SocketPermission;
import java.util.logging.*;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.lang.classfile.instruction.ThrowInstruction;

//CLASS: Medication
class Medication {
    // marked private so that internal state of medList is only modified as intended - OBJ01-J
    private String[] medList;

    public Medication(String[] medList){
        this.medList = medList;
    }

    public void displayMeds(){

    }
    /**
     * 
     * @return clone of medList
     */
    public String[] getMedList(){
        //returns a defensive clone of medList OBJ05-J
        return medList.clone();
    }
    public boolean compareMeds(String[] medList1, String[] medList2){
        if(Arrays.equals(medList1, medList2))//correct way to compare arrays EXP02-J
            return true;
        return false;
    }
}//END: medication

/*
* CLASS: HospitalEmployee
* Satisfies OBJ51-J by minimization accessbility of classes and its members, only accessible to package.
*/
class HospitalEmployee{
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


   /*
    * to String
    *
   */
   public String toString(){
       return this.lastName + " the " + this.profession;
   }
}


/*
* CLASS: HospitalJanitor
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


//CLASS: bigProject
public class bigProject {

//bigProject Variables
static final String filePath = "/this PC/Local Disk (C:)/exp/example.txt"; //change to make it in the main for file path allow people to put own file path inside to change it.
private static final Logger logger = Logger.getLogger(bigProject.class.getName());
private static final boolean IS_TEST_ENVIRONMENT = false; // Set to true in a test environment



//CLASS: patientFile
static class patientFiles implements Serializable{
    //marked transiant to prevent others from manipulating the file's path
    transient File patientFile;
    //created an innerclass with acordance to SER05
    class files{
     public void patientfiles(File protectedFile) throws FileNotFoundException{
        //File is not serialized with rest class 
        //File is not exposed to attackes
        patientFile = new File("/this PC/local Disk (C:)/patient.txt");
        }
    }
}//END: patientFile


    /**
     * Main method
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        ArrayList<HospitalEmployee> employeeList = new ArrayList<>();
        HospitalEmployee x = new HospitalEmployee(101, "Radahn", 9999999, "Doctor");
        employeeList.add(x);
        String path;
        int control = 0;
        if (IS_TEST_ENVIRONMENT) {
            System.out.println("This is a test method.");
            control = -1;
        }
        System.out.println("WELCOME TO HOSPITAL DIRECTORY\n");
        while (control != -1) {
            control = 0;
            //Display options
            System.out.println("OPTION 01: Print Current Employees");
            System.out.println("OPTION 02: Get Char array form a File");
            System.out.println("OPTION 03: Open a File path");
            System.out.println("OPTION 04: Verify a file path");
            System.out.println("OPTION 05: Create a Class");
            System.out.println("OPTION 06: Lock Patient Files");
            System.out.println("OPTION 07: Read a File");
            System.out.println("OPTION 08: Write on a File");
            System.out.println("OPTION 09: Create a File");
            System.out.println("OPTION 10: Request Visitation");
            System.out.println("OPTION 11: Register New Employee");
            System.out.println("OPTION 12: Get Average Patients per Doctor");
            System.out.println("OPTION 13: Search For Employee");
            System.out.println("OPTION 14: Delete Trash");
            System.out.println("OPTION 15: Employee Data to A File");
            System.out.println("OPTION 16: Open Package");
            System.out.print("\nEnter your choice (-1 to exit): ");
            //Read user input
            control = validateInput(control, scanner);
            //Handle user choice
            switch (control) {
                case -1:
                    System.out.println("\nThank you...exiting");
                    break; //exit the loop
                case 1:
                    option1(scanner, employeeList);
                    break;
                case 2:
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    System.out.println("Opening the file path");
                    try {
                        FileInputStream fileinput = new FileInputStream(path);
                        char infoData = (char) fileinput.read();
                        //reads the fileInputStream puts the information into a char and returns the char in a char buffer
                        getRefereneCharBuffer(makeCharbuffer(fileinput, infoData));
                    } catch (FileNotFoundException e) {
                        //catches file not found exception
                        System.out.println("File not found: " + e.getMessage());
                    } catch(IOException e) {
                        //catches IO exception
                        System.out.println("Error reading file: " + e.getMessage());
                    }


                    break;
                case 3:
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    System.out.println("Opening the file path");
                    try {
                       testTxt(path);
                    OpenTxtFile(path);
                    } catch (FileNotFoundException e) {
                        //catches file not found exception
                        System.out.println("File Not Found: " + e.getMessage());
                    }
                   
                    break;
                case 4:
                    System.out.println("You selected OPTION 4: Clean a file Path.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    try {
                     System.out.println("Cleaning the file's path");
                    sanatizePath(path);  
                    } catch (FileNotFoundException e) {
                        //catches file not found exception
                        System.out.println("File Not Found: " + e.getMessage());
                    }
                   
                    break;
                case 5:
                    System.out.println("You selected OPTION 5: Create a Class");
                    //creates a trusted class
                    Class<bigProject> trustedClass = null;
                    create(trustedClass);
                    System.out.println("You created a new trusted class.");
                    break;
                case 6:
                    System.out.println("You selected OPTION 6: lock patient files.");
                    patientfileLock();
                    System.out.println("You have locked patient files");
                    break;
                case 7:
                    System.out.println("You selected OPTION 7: read a file.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    //changes a file input stream into an object input stream
                     try (FileInputStream fileInputStream = new FileInputStream(path);
                    ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream))
                    {
                       getRead(objInputStream);
                       //It lets you read the file hopefully
                    } catch (FileNotFoundException e){
                        //catches file not found exception
                        System.err.println("File Not found: " + e.getMessage());
                    } catch (IOException e) {
                        //catches IOE exception
                        System.err.println("I/O error: " + e.getMessage());
                    }
                    break;
                case 8:
                    // Add logic for option 26
                    System.out.println("You selected OPTION 8: write on a file.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    //changes a file output stream into an object output stream
                    try (FileOutputStream fileOutputStream = new FileOutputStream(path);
                    ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutputStream))
                    {
                       getWrite(objOutputStream);
                       //lets it so you can write on the file hopefully
                    } catch (FileNotFoundException e){
                        //catches file not found exception
                        System.err.println("File Not found: " + e.getMessage());
                    } catch (IOException e) {
                           //catches IOE exception
                        System.err.println("I/O error: " + e.getMessage());
                    }
                    break;
                case 9:
                    // Add logic for option 9
                    System.out.println("You selected OPTION 9: Create a file.");
                    System.out.println("Enter a path to a file: ");
                    path = scanner.nextLine(); // Get the file path from the user
                    path = scanner.nextLine();
                    // path = "C:/Users/liamk/OneDrive/Documents/GitHub/IT355/BigProject.java";

                    System.out.println("Enter content to write to the file:");
                    String content = scanner.nextLine(); // Get the content to write

                    try {
                        createFileSafely(path, content); // Call the method to create and write to the file
                    } catch (IOException e) {
                        System.err.println("Error while creating or writing to the file: " + e.getMessage());
                    }
                    break;
                case 10:
                    requstVisit(scanner);
                    break;
                case 11:
                System.out.println("You selected OPTION 11.");
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
                case 12:
                System.out.println("You selected OPTION 12.");
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
                System.out.println("Hospital registry empty.");
                break;
                }
                System.out.println("");  
                break;
                case 13:
                    stupidSearch(scanner, employeeList); //ERR04 - not abruptly return within the finally block | ERR53-J - Try to Gracefully Recover From System Errors |  ERR50-J - Use Exceptions Only for Exceptional Conditions
                    break;
                case 14:
                    deleteTrash(scanner); //FIO02 - Detect and Handle File-Related Errors 
                    break;
                case 15:
                    dataToFile(scanner, employeeList); //FIO04 - Release Resources When They are no Longer Needed
                    break;
                case 16:
                    String message = "hello :)";
                    openPackage(scanner, message); //IDS01-J - Normalize Strings Before Validating Them
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n\n");
            }
        }
        scanner.close();
    }

/*
 * ALL OTHER METHODS
 */

    /**
    * Validates the that the input from main is an int
    * @param input the initial integer value to validate.
    * @param scanner the Scanner object used to read user input.
    * @return the validated integer value from the user input.
    */
    public static int validateInput(int input, Scanner scanner)
    {
        if (scanner.hasNextInt() == true) {
            input = scanner.nextInt();
            } 
        else {
            scanner.next(); //clear the invalid input
            }
        return input;
    }

    /**
    * Buffer to avoid skipping directly to main loop
    * @param scanner the Scanner object used to read user input.
    */
    public static void returnToMain(Scanner scanner)
    {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        System.out.print("\nPress 'enter' to return to the main menu...");
        scanner.nextLine();
        System.out.println(""); // Print a blank line for spacing
    }

    /**
    * prints the list of employees to screen
    * @param scanner the Scanner object used to read user input.
    * @param list the list of employees
    */
    public static void option1(Scanner scanner, ArrayList<HospitalEmployee> list)
    {
        if(list.isEmpty() == false)
        {
            System.out.println("List of Registered Employees:");
            for(int i = 0; i <list.size(); i++)
            {
                System.out.println("\t" + list.get(i).toString());
            }
        }
        else{
            System.out.println("\tNo Employee Data to Print");
        }
        returnToMain(scanner);
    }

    /**
    * Example of - Normalize Strings Before Validating Them
    * This method takes a string - it normalizes it to its canonical form, and validates the string for any malicious content. 
    * Specifically, it checks for unicode angle brackets ("<", ">"), which can be dangerous 
    * @param scanner the Scanner object used to read user input.
    * @param message a string that represents a message 
    */
    public static void openPackage(Scanner scanner, String message)
    {
        //Normalize the string
        message = Normalizer.normalize(message, Form.NFKC);
        // Validate: Check for blacklisted characters like angle brackets
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find() == true) {
            //Found blacklisted tag, throwing exception
            System.out.println("Malicious input detected. Do not print message.)");
        } 
        else {
            // Proceed with normal processing
            System.out.println("Input is safe...");
            System.out.println("Message: " + message);
        }
        returnToMain(scanner);
    }

    /**
    * search for employee using index
    * @param scanner the Scanner object used to read user input.
    * @param list the list of employees
    */
    public static void stupidSearch(Scanner scanner, ArrayList<HospitalEmployee> list) throws Exception{
        try {
            System.out.print("Enter your favorite number: ");
            int target = scanner.nextInt();
            System.out.println("Wow! " + target + " is " + list.get(target).toString() + " favorite number");
            
        } catch (Exception x) { //ERR53-J - Try to Gracefully Recover From System Errors |  ERR50-J - Use Exceptions Only for Exceptional Conditions (could add)
            System.out.println("You picked a bad number. No Employee exists at that index in the arrry.");
        }
        finally{ //do not abruptly return within the finally block
            System.out.println("Never Search like that again :)");
            returnToMain(scanner);
        }
    }
    
    /**
    * deletes a text file - Rule: Detect and Handle File-Related Errors 
    * @param scanner the Scanner object used to read user input.
    */
    public static void deleteTrash(Scanner scanner){
        File file = new File("Trash");
        if (file.delete() == false) {
            //Deletion of file failed. Handle the error 
            System.err.println("Failed to remove trash (ew): " + file.getAbsolutePath());
            returnToMain(scanner);
        } 
        else {
            System.out.println("Trash has been removed :)");
            returnToMain(scanner);
        }
    }

    /**
    * deletes a text file - Rule: Release Resources When They are no Longer Needed
    * @param scanner the Scanner object used to read user input.
     * @throws IOException 
    */
    public static void dataToFile(Scanner scanner, ArrayList<HospitalEmployee> list) throws IOException {
        System.out.print("Enter the filename to save the employee data: ");
        String filename = scanner.nextLine(); // Get the file name from the user
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        try{
            writer.write("Employee Data:\n");
            for (HospitalEmployee employee : list) {
                writer.write(employee.toString());
                writer.newLine();
            System.out.println("Data has been successfully written to " + filename);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage()); //ERR53-J - Try to Gracefully Recover From System Errors
        } 
        finally
        {
            writer.close(); //MAKE SURE RESOURCES ARE CLOSED
            returnToMain(scanner);
        }
    }

    /**
    * displays when a user wants to request a vistiation 
    * @param scanner the Scanner object used to read user input.
    */
    public static void requstVisit(Scanner scanner){
        System.out.println("You selected OPTION 10.");
        System.out.print("Please enter patient's room number to request visitation: "); 
        int roomNum = 0;
       //checks if user input is valid
        roomNum = validateInput(roomNum, scanner);
       //if checks if room number is in valid hospital range (101-5099)
        if (checkRoomNumber(roomNum))
        {
            System.out.println("Valid room number entered, request has been created"); 
        }
        else
        {
            System.out.println("Room number incorrect, please contact patient's medical staff to find correct room"); 
        }
        //return
        returnToMain(scanner);
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

    //calculates the avg # of patients for a doctor
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

    //References getCharBufferedCopy
    public static CharBuffer getRefereneCharBuffer(char importantArray[]) {
        bigProject getReferenceChar = new bigProject();
        return getReferenceChar.getCharBufferedCopy(importantArray);
    }

    //FOI05
    //Arrays get put into charbuffered copys 
    public CharBuffer getCharBufferedCopy(char importantArray[]) {
        return CharBuffer.wrap(importantArray).asReadOnlyBuffer();
    }

    //FIO08 
    //Properly read char from something
    public static char[]  makeCharbuffer(FileInputStream in, char informationData) {
         // Initialize Stream
         int intBuffer;
         char charArray[] = new char[1000000];
         try {
            while ((intBuffer = in.read()) != -1) {
           char infromationData = (char) intBuffer;
            //saftly puts the information into data type char
            charArray[intBuffer] = informationData;
        }
        }   catch (IOException e) {
            // catches the IOException
            }
            return charArray;
        }

    //call functions for the write of an object
    private static void getWrite(final ObjectOutputStream writeOBJ) 
    throws IOException {
        bigProject writeObj = new bigProject();
        writeObj.writeObjectexp(writeOBJ); 
    }

    //call functions for the read of an object
    private static void getRead(final ObjectInputStream readOBJ) 
    throws IOException, ClassNotFoundException {
        bigProject readObj = new bigProject();
        readObj.readObjectexp(readOBJ); 
    }
    
    //SER01 for write and read
    //Allows saftly writing into an object
    private void writeObjectexp(final ObjectOutputStream writeExample)
    throws IOException {
        writeExample.defaultWriteObject();
    }
    
    //Allow saftly reading into and object
    private void readObjectexp(final ObjectInputStream readExample)
    throws IOException, ClassNotFoundException {
        readExample.defaultReadObject();
    }


    //SEC01 Sanatizes the path to a file
    private static void sanatizePath(final String path) throws FileNotFoundException, IOException {
        //Proper way to sanatize a path file
         final String cleanFileName;
         String cleanedFiles[] = null;
         int cleanedFileCount = 0;
            cleanFileName = path;
            cleanedFileCount = cleanedFileCount+1;
            cleanedFiles[cleanedFileCount] = path;
        
        try {
            @SuppressWarnings({ "unchecked", "removal" })
            FileInputStream editFile =
                (FileInputStream) AccessController.doPrivileged(
                    new PrivilegedExceptionAction() {
                        @Override
                        public FileInputStream run() throws FileNotFoundException{
                         return new FileInputStream(cleanFileName);
                        }
                    }   
                );
                // add something extra to do with file
            editFile.close();
        } catch (PrivilegedActionException exception) {
            //forward to a log file
        }
        Runtime.getRuntime().exit(1);
        //this makes it complient to FOI14
    }


     //SEC00
    public static void testTxt(String path) throws FileNotFoundException {
        FileInputStream exp = OpenTxtFile(path);
        if (exp == null)
        {
            //makes sure to throw out file not found exception
        }
       
    //test to see if there is text in file
    }
    
    //SEC00 p2
    @SuppressWarnings("removal")
    private static FileInputStream OpenTxtFile(String path) {
        final String txt_file = path;
        final FileInputStream exp[] = { null };
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    //is a sensitive action the doPrivileged() block
                    exp[0] = new FileInputStream(txt_file);
                } catch (FileNotFoundException e) {
                    // Reports to user
                }
                return null;
            }
        });
        return exp[0];
    }

    //Puts a lock on the patient file
    public static void patientfileLock() throws IOException, ClassNotFoundException{
        patientFiles myObj = new patientFiles();
        lockrefernce((ObjectInput) myObj);
    }

    //allows the communication of lockObject
    public static void lockrefernce(ObjectInput in) throws IOException, ClassNotFoundException {
        bigProject lockObj = new bigProject();
        lockObj.lockObject(in);
    }

    //Creates a 'lock' to sencronize classes that may have untrusted code
    private final Object lock = new Object();
    private boolean initialized = false;
    //Declares strings and ints befor the initialization takes place
    private String exampleString;
    private int exampleInt;
    //SER11
    //Puts a lock on a object or string so it cannot be reused
    public void lockObject(ObjectInput in)
                 throws IOException, ClassNotFoundException{
        synchronized (lock) {
            if (!initialized) {
            //read instance fields
                this.exampleString = (String) in.readObject();
                this.exampleInt = in.readInt();
                initialized = true;

            }else {
                throw new IllegalStateException();
             }
        }
        Runtime.getRuntime().exit(1);
        //makes code complient to FOI14    
    }

    //Write a outputfile
    private static void createFileSafely(String filePath, String content) throws IOException {
        File file = new File(filePath);
        
        // Check if the file already made
        if (file.exists()) {
            System.out.println("File already created: " + file.getAbsolutePath());
        } else {
            boolean fileCreated = file.createNewFile(); //Check to see if file was created
            
            try {
                Files.write(Paths.get(filePath), content.getBytes());
                System.out.println("File written successfully to " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Output statis of the created file
            if (fileCreated) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                throw new IOException("Failed to create the file at: " + file.getAbsolutePath());
            }
        }
    }

    //SEC05
    //Create a trusted class
    public bigProject() {}
    public static <Sec> Sec create(Class<Sec> trustedClass)
           throws InstantiationException, IllegalAccessException {
               //Creates a trusted class
               return trustedClass.newInstance();
           }


} //END bigProject