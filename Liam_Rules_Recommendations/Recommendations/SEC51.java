package Liam_Rules_Recommendations.Recommendations;
import java.security.*;
import java.io.*;

public class SEC51 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        String filePath = "/path/to/privileged/file.txt";
        
        try {
            // Minimize the scope of privileged code
            String contents = AccessController.doPrivileged((PrivilegedAction<String>) () -> readFile(filePath));
            System.out.println("File Contents: " + contents);
        } catch (SecurityException e) {
            System.err.println("Access to the file was denied: " + e.getMessage());
        }
    }

    // Non-privileged method
    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return content.toString();
    }
}
