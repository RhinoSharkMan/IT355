package recommendation_chase;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule ERR53-J with proper usage 
 */
class ERR53_J
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod(10, 0);
    }

/**
 * Example of ERR53-J with proper usage.
 * 
 * This method divides two integers and handles potential exceptions in accordance 
 * with the ERR53-J recommendation, ensuring that system errors (such as division 
 * by zero) are handled gracefully without crashing the program.
 * 
 * @param num1 the numerator
 * @param num2 the denominator (if zero, will trigger an ArithmeticException)
 */
    public static void exampleMethod(int num1, int num2) {
        try {
            int result = num1/num2;
            System.out.println("Result: " + result);
        } 
        catch (ArithmeticException e) {
            //ability to handle divide by 0 error without crashing program
            System.out.println("ERROR: Division by zero is not allowed.");
        } 
        catch (Throwable t) {
            //ability to handle other errors without crashing program
            System.out.println("ERROR: An unexpected error occurred.");
        } 
        finally {
            System.out.println("Returning...");
        }
    }
} // end class
