package rules_chase;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule IDS01-J
 */

class IDS01_J {

/**
 * Main method
 */
    public static void main(String[] args) {
        exampleMethod();
    }

/**
 * Example of IDS01-J with proper usage
 * 
 * This method takes a string containing alternative Unicode representations of angle brackets,
 * normalizes it to its canonical form, and validates the string for any malicious content. 
 * Specifically, it checks for angle brackets ("<", ">"),
*/
    public static void exampleMethod() {
        //string containing alternative representations of angle brackets
        String test = "\uFE64" + "script" + "\uFE65";  //representing <script>
        //Normalize the string
        test = Normalizer.normalize(test, Form.NFKC);
        // Validate: Check for blacklisted characters like angle brackets
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(test);
        if (matcher.find()) {
            // Found blacklisted tag, throwing exception
            throw new IllegalStateException("Malicious input detected.");
        } 
        else {
            // Proceed with normal processing
            System.out.println("Input is safe...");
            System.out.println("Input: " + test);
        }
    }
}
