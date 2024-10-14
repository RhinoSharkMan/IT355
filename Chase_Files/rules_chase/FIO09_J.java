package Chase_Files.rules_chase;
import java.io.IOException;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule FI009-J - Do Not Rely on the write() Method to Output Integers Outside 
 * The Range of 0 to 255  
 */
class FI009_J
{

/**
 * Main method 
 * @throws IOException 
 * @throws NumberFormatException 
 */
    public static void main(String[] args) throws NumberFormatException, IOException {
        exampleMethod(46);
    
    }
    

/**
 * Example of FI009-J with proper usage.
 * 
 * This method demonstrates the write() method to output an int value within
 * within the valid byte range  (0-255). The input is validated 
 * to ensure that it falls within this range, and if not, an exception occurs 
 * 
 * @param testValue The integer value to be written, expected to be within 0-255.
 * @throws ArithmeticException if the value is outside the range of 0-255.
 */
public static void exampleMethod(int testValue){
        //perform range validation
        int value = Integer.valueOf(testValue);
        if (value < 0 || value > 255) {
          throw new ArithmeticException("Value is out of valid range (0-255)");
        }
        //print output
        System.out.print("char value: ");
        System.out.write(value);
        System.out.flush();
    }
}//end class