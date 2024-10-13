package andrew_files;

import java.util.regex.Pattern;

public class IDS55
{
    //uses extra backslash to indicate looking for breaks in words, rather than 
    //checking for the backspace escape character. 
    private static final String wordBreak = "\\b";
    //single backslash indicates backspace escape character
    private static final String backSlash = "\b"; 

    public static void main(String[] args) {
        String split1 = "Split string by wordseparation";
        String split2 = "Splitsstring\bby\bbackspaces\b";
        String [] split1Array = stringSplit(split1, wordBreak);
        String [] split2Array = stringSplit(split2, backSlash);
        
        for (String element : split1Array)
        {
            System.out.print(element);
        }
    
        System.out.println("\nSplit2 before function call: " + split2);
        
        for (String element : split2Array)
        {
            System.out.print(element );
        }

    }

    /**
     * Takes a string as an input as well as a regex pattern. Splits string 
     * into an array, separating elements by using the pattern. 
     * @param input String to be split
     * @param patternString pattern to split by 
     * @return array of separated string elements 
    */
    public static String[] stringSplit(String input, String patternString)
    {
        Pattern pat = Pattern.compile(patternString);
        String[] returnArray = pat.split(input);
        return returnArray; 
    }
}
