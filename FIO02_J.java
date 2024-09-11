import java.io.File;
import java.io.IOException;

public class FIO02_J{
    public static void main(String[] args) {
        File file = new File("example.txt");

        // Attempt to create a new file
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("Error occurred while creating the file: " + e.getMessage());
        }

        // Attempt to delete the file
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.err.println("Failed to delete the file.");
        }
    }
}

