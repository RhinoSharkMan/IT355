package Liam_Rules_Recommendations.ENV;

import java.io.*;

public class ENV00J{
    public static void main(String[] args) {
        // Perform an unprivileged operation: reading a file from the user's home directory
        String userHome = System.getProperty("user.home");
        File file = new File(userHome, "example.txt");

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }
}