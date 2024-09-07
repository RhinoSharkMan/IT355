class rule7_04J
{

//main method
    public static void main(String[] args) {
        System.out.println("hello everyone!");
    
    }
    
    public int exampleMethod() {
        try {
            // Some code that might throw an exception
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            // Cleanup code here, no return or throw
            System.out.println("Cleanup performed.");
        }
    }

}
