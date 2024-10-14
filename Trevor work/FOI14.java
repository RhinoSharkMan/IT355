
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FOI14 {
    //class creates a file
    public static void main(String[] args) 
        throws FileNotFoundException, IOException, Exception {
            final PrintStream output = 
            new PrintStream(new BufferedOutputStream(
                //creating a file with txt of FOI14 example text
                new FileOutputStream("example.txt")));
            try {
                output.println("FOI14 example text");
            } 
            finally {
                try {
                    output.close(); 
                    Exception IOException = null;
                    throw IOException; //thows IOExeptipn after closing
                }
                catch (IOException x) {
                    //handles error
                }    
            }           
            Runtime.getRuntime().exit(1);
            //confirms closing of program
        }
    }
