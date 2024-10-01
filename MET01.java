public class MET01 {

    public static void main(String[] args) {
    
    String nullEx = null;
    String word1 = "Hello";
    String word2 = "Hi"; 
    
    //example with null, uses error handling 
    joinStrings(nullEx,word1);
    //valid example
    joinStrings(word1,word2); 
    }

 /** 
    * joins two strings, uses exception handling that does not use the assertion keyword.
    * @param s1 first string to be joined
    * @param s2 second string to be joined
    * @return joined strings if valid, if one or more strings is null returns print statement
    */
    public static void joinStrings(String s1, String s2)
    {
        if(s1 == null|| s2 == null)
        {
            System.out.println("One or more parameters is null, invalid operation");
        }
        else
        {
        System.out.println(s1.concat(s2));
        }
    }
}
