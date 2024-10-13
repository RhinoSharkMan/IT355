public class MET53 implements Cloneable
{
    int val = 0; 
    //clone method utilizing super.clone() to ensure a deep copy is created. 
    @Override
    public Object clone() throws CloneNotSupportedException {
     return super.clone();
    } 

    //default constructor with print statement indicating constructor was invoked
    MET53()
    {
        System.out.println("Superclass Constructor called");
    }
    //Sets variable val's value to input argument.
    public void setVal(int x)
    {
        val = x;
    }
   /** 
    * Prints value of val
    * @return  print statement showing values of object's val variable
    */
    public void getVal()
    {
        System.out.println(val); 
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MET53 obj1 = new MET53();  

        obj1.setVal(5);
        System.out.println("Object's val:");
        obj1.getVal();

        MET53 obj2 = (MET53)obj1.clone(); 

        System.out.println("Cloned object's val:");
        obj2.getVal();
    }
}
