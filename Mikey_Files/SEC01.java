package Mikey_Trevor_Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class SEC01 {

    /**
     * @param filePath the chosen files path
     */
    static final String filePath = "/this PC/Local Disk (C:)/exp/example.txt";


    private void privilegedExample() throws FileNotFoundException, IOException {
        //Proper way to sanatize a path file
        try {
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
        } catch (PrivilegedActionException exception) {
            //forward to a log file
        }
    }
}
