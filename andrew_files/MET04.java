package andrew_files;

public class MET04 
{
    boolean boolVal = false; 
    /**  
    * By declaring method private and final, prevents subclass from calling or overwriting method so only superclass has access.
    * @return sets boolVal to true
    */
    private final void setTrue()
    {
        boolVal = true; 
    }
    /** 
    * @return returns boolVal
    */
    protected boolean getBool()
    {
        return boolVal; 
    }

    public static void main(String[] args) {
        
        MET04 class1 = new MET04(); 
        Subclass class2 = new Subclass(); 
    
        class2.checkVal(class1.getBool());
        class1.setTrue(); 
        class2.checkVal(class1.getBool());
    
        }
}

class Subclass extends MET04
{
    /** 
    * checks value of given boolean, in this case boolVal. Depending on value prints different responses, subclass cannot overwrite 
    * setTrue method so output is directly dependent on superclass. 
    * @param boolean value that get checked for its value
    * @return prints different statements depending on value of boolean. 
    */
    public void checkVal(boolean bool)
    {
        if (bool)
        {
            System.out.println("Bool is true");
        }
        else
        {
            System.out.println("Bool is false");
        }
    }
}
