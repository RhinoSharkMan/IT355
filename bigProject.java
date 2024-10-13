/**
 * IT 355 - Group Project 1
 * 
 */


import java.awt.SystemTray;
import java.awt.im.InputContext;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.nio.CharBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.*;
import java.io.*;
import java.lang.classfile.instruction.ThrowInstruction;

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


//CLASS: Medication
public class bigProject {

//Medication Variables
static final String filePath = "/this PC/Local Disk (C:)/exp/example.txt"; //change to make it in the main for file path allow people to put own file path inside to change it.


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
 */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in); 
        String path;
        int control = 0;
        System.out.println("WELCOME TO X DIRECTORY\n");
        while (control != -1) {
            control = 0;
            //Display options 
            System.out.println("OPTION 1: x");
            System.out.println("OPTION 2: x");
            System.out.println("OPTION 20: Get Char array form a File");
            System.out.println("OPTION 21: Read a file");
            System.out.println("OPTION 22: Verify a file path");
            System.out.println("OPTION 23: Get Information");
            System.out.println("OPTION 24: Create a Class");
            System.out.println("OPTION 25: Lock patient files");
            System.out.println("OPTION 26: x");
            System.out.println("OPTION 27: x");
            System.out.println("OPTION 28: x");
            System.out.println("OPTION 29: x");
            System.out.println("OPTION 100: x");
            System.out.print("\nEnter your choice (-1 to exit): ");

            //Read user input
            control = validateInput(control, scanner);
            //Handle user choice
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
                case 20:
                    // Add logic for option 20
                    System.out.println("You selected OPTION 20: Get Char array from a File.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    System.out.println("Opening the file path");
                    try {
                        FileInputStream fileinput = new FileInputStream(path);
                        char infoData = (char) fileinput.read();
                        //reads the fileInputStream puts the information into a char and returns the char in a char buffer
                        getRefereneCharBuffer(makeCharbuffer(fileinput, infoData));
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + e.getMessage());
                    } catch(IOException e) {
                        System.out.println("Erro reading file: " + e.getMessage());
                    }

                    break;
                case 21:
                    // Add logic for option 21
                    System.out.println("You selected OPTION 21: Open a File.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    System.out.println("Opening the file path");
                    testTxt(path);
                    OpenTxtFile(path);
                    break;
                case 22:
                    // Add logic for option 22
                    System.out.println("You selected OPTION 22: Clean a file Path.");
                    System.out.println("Enter a path to a file");
                    path = scanner.nextLine();
                    System.out.println("Cleaning the file's path");
                    sanatizePath(path);
                    break;
                case 23:
                    // Add logic for option 23
                    System.out.println("You selected OPTION 23: Get Information.");
                    break;
                case 24:
                    // Add logic for option 24
                    System.out.println("You selected OPTION 24: Create a Class");
                    Class<bigProject> trustedClass = null;
                    create(trustedClass);
                    System.out.println("You created a new trusted class.");
                    break;
                case 25:
                    // Add logic for option 25
                    System.out.println("You selected OPTION 25: lock patient files.");
                    patientfileLock();
                    System.out.println("You have locked patient files");
                    break;
                case 26:
                    // Add logic for option 26
                    System.out.println("You selected OPTION 26: read a file.");
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
                case 27:
                    // Add logic for option 27
                    System.out.println("You selected OPTION 27: write on a file.");
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
                case 28:
                    // Add logic for option 28
                    System.out.println("You selected OPTION 28.");
                    break;
                case 29:
                    // Add logic for option 29
                    System.out.println("You selected OPTION 29.");
                    break;
                case 100:
                    // Add logic for option 100
                    System.out.println("You selected OPTION 100.");
                default:
                    System.out.println("Invalid option. Please try again.");
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

    //SEC05
    //Create a trusted class
    public bigProject() {}
   public static <Sec> Sec create(Class<Sec> trustedClass)
           throws InstantiationException, IllegalAccessException {
               //Creates a trusted class
               return trustedClass.newInstance();
           }


} //END bigProject