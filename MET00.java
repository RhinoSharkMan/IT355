
public class MET00 {
    public static void main(String[] args) {  
    int x = 5;
    int y = Integer.MAX_VALUE; 
    //example with max value
    int result = addValues(x,y);
    System.out.println(result);
    //example with two valid parameters
    result = addValues(x, 10);
    System.out.println(result); 
    }

    //Method adds two integer values, if it recognizes one of the parameters is the maxiumum integer value it will return that value instead
    //@param val1 integer value to be added
    //@param val2 second integer value to be added
    //@return sum of integers val1 and val2 
    public static int addValues(int val1, int val2)
    {
        if (val1 == Integer.MAX_VALUE || val2 == Integer.MAX_VALUE)
        {
            System.out.println("One or more pararmeters are the maximum integer value, addition will cause overflow");
            System.out.println("Returning max integer value");
            return Integer.MAX_VALUE;
        }
        else{
        return val1 + val2; 
        }
    }

}

