
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SER01{
    private void writeObjectexp(final ObjectOutputStream writeExample)
    throws IOException {
        writeExample.defaultWriteObject();
    }

    private void readObjectexp(final ObjectInputStream readExample)
    throws IOException, ClassNotFoundException {
        readExample.defaultReadObject();
    }
}