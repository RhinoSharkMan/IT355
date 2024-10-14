package Mikey_Trevor_Files;
import java.io.FileReader;
import java.io.IOException;

public class ERR07{

    public static void main(String[] args) {
        try {
            /**
             * Attempt to create a FileReader for a file that doesn't exist.
             * This will throw an IOException.
             */
            FileReader reader = new FileReader("nonexistentfile.txt"); // This file does not exist
            reader.read(); // Attempt to read from the file
            reader.close();
        } catch (IOException e) {//Throws a specific exception (IOException) rather than a generic exception
            System.out.println("An IOException occurred: " + e.getMessage());
        }
    }
}
