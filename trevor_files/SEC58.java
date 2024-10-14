package trevor_files;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SEC58 implements Serializable{
    boolean properInitialization;

    public void isInitalized() throws FileNotFoundException{
        properInitialization = true;
    }
//includes proper initialization

    private void writeObjectexp(final ObjectOutputStream writeExample)
    throws IOException {
        writeExample.defaultWriteObject();
    }
//shows the correct was to write an object


    private void readObjectexp(final ObjectInputStream readExample)
    throws IOException, ClassNotFoundException {
        readExample.defaultReadObject();
        properInitialization = false;
    }
//shows the correct way to read an object
//includes proper initialization
}