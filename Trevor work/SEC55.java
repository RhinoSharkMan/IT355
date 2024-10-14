import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class SEC55 {

    /**
     * @param filePath the chosen files path
     */
    static final String filePath = "/this PC/Local Disk (C:)/exp/example.txt";
    
    //Converted to add a new variable that provides context to access control
    private void privilegedExample() throws FileNotFoundException, IOException {
        //Proper way to sanatize a path file
        String accessControlContext = "context example";
        //initialized variable
        try {
            if (accessControlContext == null) {
                //makes sure if no reason for access given it ignores the privledged action.
                throw new SecurityException("Missing access control context");
            }
            else {
               FileInputStream editFile =
                (FileInputStream) AccessController.doPrivileged(
                    new PrivilegedExceptionAction() {
                        @Override
                        public FileInputStream run() throws FileNotFoundException{
                         return new FileInputStream(filePath);
                        }
                    }  
                );
                // add something extra to do with file
            editFile.close(); 
            }
            
        }
        catch (PrivilegedActionException exception) {
            //forward to a log file
        }
    }

}
