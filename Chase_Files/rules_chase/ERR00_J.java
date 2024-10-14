package rules_chase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR00-J - Do Not Suppress or Ignore Checked Exceptions
 */
class ERR00_J
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        String fileName = "dummy.txt"; //edit file name here
        exampleMethod(fileName);
    
    }
    

/**
 * Example of ERR00-J
 *
 * This method attempts to read a file line by line. If an exception occurs,
 * it is not ignorned and the user is informed
 */
    public static void exampleMethod(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found. Please check the file path.");
        } catch (IOException e) {
            System.err.println("FILE ERROR: An error occurred while reading the file.");
        }
    }
} //end class
