package Liam_Rules_Recommendations.ENV;
import java.util.regex.*;

public class ENV02J {
    public static void main(String[] args) {
        // Get the username from the environment variable properly
        String username = System.getProperty("user.name");

        //Prints out if username is valid or invalid
        if (validUsername(username)) {
            System.out.println("Valid username: " + username);
        } else {
            System.out.println("Invalid username");
        }
    }

    // Method to validate username format
    private static boolean validUsername(String username) {
        // Regex for username
        String usernamePattern = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(usernamePattern);

        return username != null && pattern.matcher(username).matches(); //Return true if username is allowed
    }
}
