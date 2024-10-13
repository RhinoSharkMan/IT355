package rules_chase;
/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR04-J - not abruptly return within the finally block
 */
class ERR04_J
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod();
    }
    

/**
 * Example of ERR04-J - not abruptly return within the finally block
 *
 * This method executes and returns 0 if no exception occurs. If an exception occurs,
 * it catches it and returns 1. Regardless of what happens, it will execute
 * the code in the finally block to perform any necessary cleanup.
 * 
 * @return 0 if no exception occurs, 2 if an exception occurs
 */
    public static int exampleMethod() {
        try {
            System.out.println("hello world");
            return 0;
        } 
        catch (Exception e) {
            return 1;
        } 
        finally {
            /*
            Cleanup code here. DO NOT use return, break, continue, or 
            throw statements here. DO NOT abrubtly end the method here.
             */
            System.out.println("Method finished...returning.");
        }
    }
} //end class
