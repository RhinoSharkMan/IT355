
/**
 * IT 355 - Group Project 1
 * 
 */
class bigProject
{

/**
 * Main method 
 */
    public static void main(String[] args) {
        exampleMethod();
    
    }
    

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
