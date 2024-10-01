public class MET50 {
    public static void main(String[] args) {
        
        //demonstrating initialization method 1
        NoOverloading obj1 = new NoOverloading(); 
        obj1.con1(); 
        //demonstrating initialization method 2
        NoOverloading obj2 = new NoOverloading();
        obj2.con2("test");  
        //demonstrating initialization method 3
        NoOverloading obj3 = new NoOverloading();
        obj3.con3(5);
    }
}

//class uses static methods to handle initialization of objects instead of constructors. No overloading
//allows for easier use/reading of code. 
class NoOverloading
{
    static int val; 
    static String str; 

    /** 
    Initialization method resembling default constructor, prints statement declaring method was used.
    * @return a new NoOverloading object
    */
    public static NoOverloading con1() {
        System.out.println("Initialization method 1");
        return new NoOverloading();
    }
    /** 
    * Secondary initialization method with a string parameter, prints statement declaring method was called and prints parameter given.
    * @param   st - string that sets internal variable str and is printed out
    * @return  a new NoOverloading object
    */
    public static NoOverloading con2(String st)
    {
        System.out.println("Initialization method 2: " + st);
        str = st;
        return new NoOverloading(); 
    }
    /** 
    * Tertiary initialization method with a int parameter, prints statement declaring method was called and prints parameter given.
    * @param   value - int that sets internal variable val and is printed out
    * @return  a new NoOverloading object
    */
    public static NoOverloading con3(int value)
    {
        System.out.println("Initialization method 3: " + value);
        val = value; 
        return new NoOverloading(); 
    }
}
