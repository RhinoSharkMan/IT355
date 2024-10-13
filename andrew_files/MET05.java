class Superclass2 {
    /** 
    * superclass constructor - calls superClassPrint method and is invoked by subclass
    */
    public Superclass2()
    {
      superClassPrint();
    }
    /**
    * by declaring system final, it cannot be overriden in the subclass
    * @return - print statement showing method was invoked in constructor. 
    */
    public final void superClassPrint()
    {
       System.out.println("Method called in constructor, cannot be overriden");
    } 

}

class Subclass2 extends Superclass2{
    /** 
    subclass constructor, invokes superclass constructor with additional print statement.
    */
    public Subclass2()
    {
        System.out.println("Subclass created"); 
    }
}   

public class MET05
{
public static void main(String[] args)
{
Subclass2 obj1 = new Subclass2(); 
Superclass2 obj2 = new Superclass2(); 
}
}
