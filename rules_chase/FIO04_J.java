package rules_chase;
import java.io.*;
/**
 * IT 355 - Group Project 1
 * Demonstration of rule FIO04-J with try-with-resources
 */

class FI004_J {

/**
 * Main method
 */
    public static void main(String[] args) {
        String fileName = "dummy.txt"; //file name here
        exampleMethod(fileName);
    }

/**
* Example of FIO04-J with proper usage using try-with-resources. This method reads a file line by line and ensures 
* that the resources (FileInputStream and BufferedReader) are automatically closed when the operation is complete. 
* 
* @param fileName the name of the file to be read
*/
    public static void exampleMethod(String fileName) {
        //using try-with-resources to automatically close resources (stream and reader) when finished
        try (FileInputStream stream = new FileInputStream(fileName);
             BufferedReader bufRead = new BufferedReader(new InputStreamReader(stream))) {
            //Read and process the file line by line
            String line;
            while ((line = bufRead.readLine()) != null) {
                System.out.println("Processing line: " + line);
            }
        } 
        catch (Exception e) {
            //catch exceptions
            System.err.println("ERROR: file issue");
        }
    }
}
