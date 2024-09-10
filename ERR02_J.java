/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR02-J with proper usage 
 */
class ERR02_J {

    /**
     * Main method 
     */
    public static void main(String[] args) {
        exampleMethod();
    }

    /**
     * Example of ERR02-J - Prevent exceptions while logging data
     */
    public static void exampleMethod() {
        try {
            // Simulate logging operation
            logData("This is a log message.");
        } catch (Exception e) {
            // Handle any exceptions that occur during logging
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

    /**
     * Simulated logging method
     */
    public static void logData(String message) throws Exception {
        // Simulate a condition that might throw an exception
        if (message == null) {
            throw new Exception("Log message cannot be null");
        }
        // Simulate logging the message
        System.out.println("Log: " + message);
    }
} // end class
