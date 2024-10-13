package Liam_Rules_Recommendations.ENV;    //This is a trusted package
import java.security.*;
import java.io.*;

import Liam_Rules_Recommendations.UntrustedPackage.Untrusted;

//Created by Liam Knap 
public class ENV01JFail {
    @SuppressWarnings("unused")
    private void privilegedMethod() throws IOException{
        try{
            @SuppressWarnings("removal")
            final FileInputStream fis = AccessController.doPrivileged(
                new PrivilegedExceptionAction<FileInputStream>() {
                    public FileInputStream run() throws FileNotFoundException{
                        return new FileInputStream("File.txt");
                    }
                }
            );
            try{
                Untrusted un = new Untrusted();
    
                if(un.untrustedFunc() == true){
                    //Access sensitive file
                }
            }
            finally{
                fis.close();
            }
        }
        catch (PrivilegedActionException e) {
            //Forward to handler and log
        }
    }
}
