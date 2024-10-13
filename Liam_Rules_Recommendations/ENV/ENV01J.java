package Liam_Rules_Recommendations.ENV;    //Trusted package
import java.io.*;
import java.security.*;

import Liam_Rules_Recommendations.TrustedPackage.Trusted;

//Created by Liam Knap
public class ENV01J {
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
                Trusted un = new Trusted();
    
                if(un.trustedFunction() == true){
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
