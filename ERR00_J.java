import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR00-J with proper usage 
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
 * This method attempts to read a file line by line. If no exception occurs, 
 * it successfully prints the file content. If an IOException occurs during 
 * file reading, it asks the user to input a try a different file 
 * 
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
        catch (IOException e) {
            /* 
            proper handling if an exception occurs
            */
            System.err.println("FILE ERROR. Please try a new file.");
        }
    }
} //end class
