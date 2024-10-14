package Andrew_Files;
final class OBJ51
{
    //restricts access to password, value can only be set by constructor 
    private final String password; 

    //constructor that takes given parameter and sets class's password variable to that value
    OBJ51(String password)
    {
        this.password = password; 
    }
    
    /** 
     * @return prints password saved by constructor
    */
    public void getPassword()
    {
        System.out.println(password);
    }

    public static void main(String[] args) {
        OBJ51 object1 = new OBJ51("abc");
        OBJ51 object2 = new OBJ51("123");

        object1.getPassword();
        object2.getPassword();
    }
}

