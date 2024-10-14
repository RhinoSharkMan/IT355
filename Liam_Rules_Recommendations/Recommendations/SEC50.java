package Liam_Rules_Recommendations.Recommendations;
import java.security.*;
import java.io.*;

public class SEC50 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        FilePermission filePermission = new FilePermission("/path/to/file.txt", "read"); //Allow only to read to this file

        // Limit the access that this code has
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            readFile("/path/to/file.txt"); //Place holder
            return null;
        }, null, filePermission);
    }

    // Method to read file content with limited privileges
    private static void readFile(String filePath) {
        // Privileged code for reading a file
        try {
            System.out.println("Reading file: " + filePath);
            // Read file...
        } catch (SecurityException e) {
            System.err.println("Access denied: " + e.getMessage());
        }
    }
}
