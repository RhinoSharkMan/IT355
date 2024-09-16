public class NUM09
{
    public static void main(String[] args) 
    {
            
        float x = 140.0f; 
        System.out.println(x);
        //using int as a counter to increase float x's value instead of using float as the loop counter
        //loop to increase float by 100
        for(int i = 0; i < 10; i++)
        {
            x = incrementByTen(x);
        }
        System.out.println(x); 
    }

    //adds 10 to given float val
    //@param val floating value to be incremented
    //@return floating value incremented by 10
    public static float incrementByTen(float val)
    {
        return val + 10.0f; 
    }
}