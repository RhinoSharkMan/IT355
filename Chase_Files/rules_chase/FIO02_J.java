package Chase_Files.rules_chase;
import java.io.File;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule FI002-J - Detect and Handle File-Related Errors 
 */
class FI002_J
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod();
    
    }
    

/**
 * Example of FI002-J with proper usage.
 * 
 * This method demonstrates the proper handling of the return value from the delete() method.
 * The method attempts to delete a file checks whether the operation succeeded.
 * If the deletion fails, an error message is printed to the standard error output.
 */
public static void exampleMethod() {
    File file = new File("example.txt");
    if (file.delete() == false) {
        //Deletion of file failed. Handle the error 
        System.err.println("Failed to delete the file: " + file.getAbsolutePath());
    } 
    else {
        System.out.println("File deleted successfully.");
    }
}
} //end class

