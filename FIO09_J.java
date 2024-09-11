import java.io.File;
import java.io.IOException;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule FI009-J with proper usage 
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
 * Example of FI000-J with proper usage.
 * ?
 */
public static void exampleMethod(int testValue){
        //perform range checking 
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