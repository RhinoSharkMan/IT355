package Mikey_Trevor_Files;

public class ERR08 {
    /**
     * This method demonstrates incorrect handling by catching NullPointerException.
     */
    public void incorrectMethod() {
        String str = null;
        try {
            // This will throw a NullPointerException
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // Incorrect: catching NullPointerException, which should be avoided
            System.out.println("Caught NullPointerException. Fix the code, don't catch it.");
        }
    }
    /**
     * This method demonstrates the correct approach by preventing NullPointerException
     * instead of catching it.
     */
    public void correctMethod() {
        String str = null;
        // Check for null explicitly before using the object to avoid NullPointerException
        if (str != null) {
            System.out.println(str.length());
        } else {
            System.out.println("String is null, preventing NullPointerException.");
        }
    }
    /**
     * Main method to run the example and demonstrate the rule.
     */
    public static void main(String[] args) {
        ERR08 example = new ERR08();
        // Demonstrate incorrect handling (violating ERR08-J)
        example.incorrectMethod();
        // Demonstrate correct handling (following ERR08-J)
        example.correctMethod();
    }
}
