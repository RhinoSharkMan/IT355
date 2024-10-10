/**
 * IT 355 - Group Project 1
 * 
 */


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


/**
 * Main method 
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int control = 0;
        System.out.println("WELCOME TO X DIRECTORY\n");
        while (control != -1) {
            control = 0;
            //Display options 
            System.out.println("OPTION 1: x");
            System.out.println("OPTION 2: x");
            System.out.println("OPTION 20: Change a File");
            System.out.println("OPTION 21: Read a file");
            System.out.println("OPTION 22: Verify a file path");
            System.out.println("OPTION 23: Get Information");
            System.out.println("OPTION 24: x");
            System.out.println("OPTION 25: x");
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
                    System.out.println("You selected OPTION 20: Change a File.");
                    break;
                case 21:
                    // Add logic for option 21
                    System.out.println("You selected OPTION 21: Read a File.");
                    break;
                case 22:
                    // Add logic for option 22
                    System.out.println("You selected OPTION 22: Verify a file Path.");
                    break;
                case 23:
                    // Add logic for option 23
                    System.out.println("You selected OPTION 23: Get Information.");
                    break;
                case 24:
                    // Add logic for option 24
                    System.out.println("You selected OPTION 24.");
                    break;
                case 25:
                    // Add logic for option 25
                    System.out.println("You selected OPTION 25.");
                    break;
                case 26:
                    // Add logic for option 26
                    System.out.println("You selected OPTION 26.");
                    break;
                case 27:
                    // Add logic for option 27
                    System.out.println("You selected OPTION 27.");
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




    //FOI05
    //Arrays get put into charbuffered copys 
    public CharBuffer getCharBufferedCopy(char importantArray[]) {
        return CharBuffer.wrap(importantArray).asReadOnlyBuffer();
    }


    //FIO08 
    //Properly read char from something
    public static void makeCharbuffer(FileInputStream in, char infromationData) {
         // Initialize Stream
         int intBuffer;
         try {
            while ((intBuffer = in.read()) != -1) {
            infromationData = (char) intBuffer;
            //saftly puts the information into data type char
        }
        }   catch (IOException e) {
            // catches the IOException
            }
        }


    //FOI14 Puts buffers around a file
    public static void getFileBuffer(String[] args) 
        throws FileNotFoundException, IOException, Exception {
            final PrintStream output = 
            new PrintStream(new BufferedOutputStream(
                new FileOutputStream("example.txt")));
            try {
                output.println("FOI14 example text");
            } 
            finally {
                try {
                    readObjectexp(null);
                    output.close(); 
                }
                catch (IOException x) {
                    //handles error
                }    
            }           
            Runtime.getRuntime().exit(1);
        }


    //SER01 for write and read
    //Allows saftly writing into an object or file
    private static void writeObjectexp(final ObjectOutputStream writeExample)
    throws IOException {
        writeExample.defaultWriteObject();
    }
    //Allow saftly reading into and objector file
    private static void readObjectexp(final ObjectInputStream readExample)
    throws IOException, ClassNotFoundException {
        readExample.defaultReadObject();
    }


    //SEC01 Sanatizes the path to a file
    private void privilegedExample() throws FileNotFoundException, IOException {
        //Proper way to sanatize a path file
        try {
            FileInputStream editFile =
                (FileInputStream) AccessController.doPrivileged(
                    new PrivilegedExceptionAction() {
                        @Override
                        public FileInputStream run() throws FileNotFoundException{
                         return new FileInputStream(filePath);
                        }
                    }   
                );
                // add something extra to do with file
            editFile.close();
        } catch (PrivilegedActionException exception) {
            //forward to a log file
        }
    }


     //SEC00
    public static void changeTxt() throws FileNotFoundException {
        FileInputStream exp = OpenTxtFile();
        if (exp == null)
        {
            //makes sure to throw out file not found exception
        }
    //test to see if there is text in file
    }
    //SEC00 p2
    private static FileInputStream OpenTxtFile() {
        final String txt_file = "example";
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
    }

    //SEC05
    //Create a trusted class
    static <Sec> Sec create(Class<Sec> trustedClass)
           throws InstantiationException, IllegalAccessException {
               //Creates a trusted class
               return trustedClass.newInstance();
           }


} //END bigProject
    


    /*Change a class to make it serializable 
     * //SER05
     * public class SER05 implements Serializable{
     *        private int intExp;
     *     class InnerClass{
     *    protected String example;
     *     }
     *    //Serializes the outer class instead of the inner class
     *   }
     * 
     */
    
     /*Trusted Class (SEC05)
      *public class SEC05() { }//Package -private constructor
      *static <Sec> Sec create(Class<Sec> trustedClass)
      *     Throws InstantiationException, IllegalAccessEception{
      *         //Creates a trusted class
      *         return trustedClass.newInstance();
      *     }
      */
