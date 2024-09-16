package rules_chase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR02-J with proper usage 
 */
class ERR02_J {
    private static final Logger logger = Logger.getLogger(ERR02_J.class.getName());
    /**
     * Main method 
     */
    public static void main(String[] args) {
        exampleMethod();
    }

/**
 * Demonstrates the ERR02-J rule by simulating a logging operation that could 
 * throw an exception if the log message is null.
 * Catches and handles any exceptions that occur during the logging process.
 */
    public static void exampleMethod() {
        try {
            // Simulate logging operation
            logData("Data Entry 1"); //edit message here
        } 
        catch (Exception e) {
            // Handle any exceptions that occur during the logging process
            try {
                /*
                 * This compliant solution uses java.util.logging.Logger, 
                 * the default logging API provided by JDK 1.4 and later. Use of other compliant 
                 * logging mechanisms,such as log4j, is also permitted.
                 */
                logger.log(Level.SEVERE, "ERROR: Logging failed", e); 
            } 
            catch (Exception logException) {
                // Handle logging failure if necessary
                System.err.println("Failed to log the original exception: " + logException.getMessage());
            }
        }
    }

/**
 * Simulates logging a message to the system. 
 * Throws an exception if the input message is null.
 *
 * @param message the message to be logged
 * @throws Exception if the log message is null
 */
    public static void logData(String message) throws Exception {
        // Simulate a condition that might throw an exception
        if (message == null) {
            throw new Exception("Log string CANNOT be null");
        }
        // "Log" the message to the console
        System.out.println("String Logged: " + message);
    }
} // end class
