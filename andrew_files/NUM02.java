package Andrew_Files;
public class NUM02 {

public static void main(String[] args) {
    int numZero = 0;
    int x = 10; 
    int y = 5; 

    int result1 = division(x, numZero);
    int result2 = division(x,y);

    System.out.println(result1);
    System.out.println(result2);
}    

/** 
* divides first argument by second, printing statement if divisor = 0
* @param dividend int value to be divided 
* @param divisor  int value dividing
* @return integer result from dividend/divisor, returns 0 if divisor = 0
*/
public static int division(int dividend, int divisor)
{
    if (divisor == 0)
    {
        System.out.println("Attempting to divide by zero, returning value 0");
        return 0; 
    }

    return dividend / divisor; 
}

}
