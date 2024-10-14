package Mikey_Trevor_Files;

import java.io.File;
import java.io.IOException;

public class FIO16 {


    
    public static void main(String[] args) {
        //Test the method with a safe path
        String filePath = "/safe/directory/myfile.txt";
        isValidFile(filePath);
    }

    /**
     * Validates if the given file path is within the allowed base directory by 
     * canonicalizing the file path.
     *
     * @param filePath The file path to validate.
     * @return true if the file path is valid, false if invalid
     */
    public static boolean isValidFile(String filePath) {
        try {
            //define the allowed base directory
            File baseDir = new File("/safe/directory");
            File fileName = new File(filePath);
            //Canonicalize the path to avoid path traversal vulnerabilities
            String canonicalPath = fileName.getCanonicalPath();
            String baseCanonicalPath = baseDir.getCanonicalPath();
            //Validate that the canonical path starts with the base directory path
            if (canonicalPath.startsWith(baseCanonicalPath)) {
                System.out.println("Valid path: " + canonicalPath);
                return true; //The path is safe
            } else {
                System.out.println("Invalid path.");
                return false;//The path is unsafe
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}

