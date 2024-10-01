
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FOI14v2 {
    //class creates a file
    public static void main(String[] args) 
        throws FileNotFoundException, IOException {
            final PrintStream output = 
            new PrintStream(new BufferedOutputStream(
                new FileOutputStream("example.txt")));
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run(){
                output.close();
            } 
        }));
        output.println("FOI14v2 example");
        Runtime.getRuntime().exit(1);
        }
    }