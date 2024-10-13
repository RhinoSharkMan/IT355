
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class SEC00 {
// this will be a txt changer
    public static void changeTxt() throws FileNotFoundException {
        FileInputStream exp = OpenTxtFile();
        if (exp == null)
        {
            //makes sure to throw out file not found exception
        }
    //test to see if there is text in file
    }
    private static FileInputStream OpenTxtFile() {
        final String txt_file = "example";
        final FileInputStream exp[] = { null };
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    //is a sensitive action the doPrivileged() block
                    exp[0] = new FileInputStream(txt_file);
                } catch (FileNotFoundException e) {
                    // Reports to user
                }
                return null;
            }
        });
        return exp[0];
    }
}