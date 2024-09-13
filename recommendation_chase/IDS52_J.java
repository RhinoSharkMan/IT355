package recommendation_chase;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule IDS52-J with proper usage 
 */

class IDS52_J {
/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod("dynamicchase22");
    }
    
/**
 * Example of IDS52-J
 * 
 * This method uses a whitelist approach to sanitize the input by allowing only alphanumeric 
 * characters and underscores. It ensures that the input does not contain any characters 
 * that could potentially be used for code injection or other malicious purposes.
 * 
 * @param firstName The user input to be sanitized and evaluated
 */
    public static void exampleMethod(String name) {
        /*
         * Use Whitelisting to allow only alphanumeric and underscore chars in name. 
         * In other words, sanitze data before it is validated 
        */
        if (name.matches("[\\w]*") == false) {
            // String does not match whitelisted characters
            System.out.println("Invalid Name. Returning....");
            return;
        }
        System.out.println("Welcome " + name);
        /* Code that would work JavaScript functionality(?)
         * 
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        // Use sanitized input in dynamic code
        engine.eval("print('Hello, " + firstName + "!')");
        */
    }
} //end class
