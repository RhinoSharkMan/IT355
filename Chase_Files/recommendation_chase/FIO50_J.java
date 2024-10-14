package Chase_Files.recommendation_chase;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule FIO50-J - Do Not Make Assumptions About File Creation
 */
class FIO50_J
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod();
    }

/**
 * Example of FIO50-J with proper usage.
 * 
 * This method attempts to create a new file and handles errors if the file already exists
 * using the Files.newOutputStream() method to create and validate (by throwing an exception)
 * if the file already exists 
 */
    public static void exampleMethod() {
        //define file
        String filePath = "example.txt";
        Path path = Paths.get(filePath);
        //attempt to create a file. Use of Files.newOutputStream() validates that the file is not already created
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE_NEW))) {
            System.out.println("File Created: " + filePath);
        } 
        //if file alreay exists
        catch (FileAlreadyExistsException e) {
            System.err.println("File already exists: " + filePath);
        }
        //other errors
        catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
} // end class

