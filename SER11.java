
import java.io.IOException;
import java.io.ObjectInput;

public class SER11 {
    //Creates a 'lock' to sencronize classes that may have untrusted code
    private final Object lock = new Object();
    private boolean initialized = false;
    //Declares strings and ints befor the initialization takes place
    private String exampleString;
    private int exampleInt;

    //Constructor 
    public void SER11(ObjectInput in)
                 throws IOException, ClassNotFoundException{
        synchronized (lock) {
            if (!initialized) {
            //read instance fields
                this.exampleString = (String) in.readObject();
                this.exampleInt = in.readInt();
                initialized = true;

            }else {
                throw new IllegalStateException();
             }
        }    
    }
}
