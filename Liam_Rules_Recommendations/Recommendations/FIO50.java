package Liam_Rules_Recommendations.Recommendations;
import java.io.*;

public class FIO50 {
    public static void main(String[] args) {
        String filePath = "/path/to/file.txt";
        
        try {
            // Attempt to create the file
            createFileSafely(filePath);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    // Method to safely create a file
    private static void createFileSafely(String filePath) throws IOException {
        File file = new File(filePath);
        
        // Check if the file already made
        if (file.exists()) {
            System.out.println("File already created: " + file.getAbsolutePath());
        } else {
            boolean fileCreated = file.createNewFile(); //Check to see if file was created
            
            //Output statis of the created file
            if (fileCreated) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
            } else {
                throw new IOException("Failed to create the file at: " + file.getAbsolutePath());
            }
        }
    }
}
