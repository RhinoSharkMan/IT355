package rules_chase;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule FIO03-J - Remove Temporary Files Before Termination 
 */
class FIO03_J {

    /**
     * Main method
     */
    public static void main(String[] args) {
        try {
            exampleMethod();
        } 
        catch (Exception e) {
            // Handle IOException
            System.err.println("ERROR: Example method failed");
        }
    }

/**
 * Example of FIO03-J with proper usage.
 * 
 * This method demonstrates the proper handling of a temporary file
 * using DELETE_ON_CLOSE to ensure it is removed automatically when the file is closed.
 */
    public static void exampleMethod() {
        Path tempFile = null;
        try {
            // Create a temporary file that uses DELETE_ON_CLOSE to enusre the temp. file gets deleted
            tempFile = Files.createTempFile("tempFileExample", ".tmp");
            
            //Open the file and use DELETE_ON_CLOSE to ensure it gets deleted when closed
            try (BufferedWriter writer = Files.newBufferedWriter(tempFile,Charset.forName("UTF8"),StandardOpenOption.DELETE_ON_CLOSE)) {
                writer.write("Test text.");
                System.out.println("Temporary file write done.");
            }
        } 
        catch (IOException e) {
            //Handle exceptions
            System.err.println("ERROR: handling file");
        }
    }

}
