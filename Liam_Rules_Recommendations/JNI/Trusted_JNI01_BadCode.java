package Liam_Rules_Recommendations.JNI;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class Trusted_JNI01_BadCode {
    
    @SuppressWarnings("removal")
    public static void loadLibrary(final String library){
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
           public Void run() {
               System.loadLibrary(library);
               return null;
           }
        });
     }

    static{
        System.loadLibrary("library");
    }
    public static void main(String[] args) {
        Trusted_JNI01_BadCode loader = new Trusted_JNI01_BadCode(); 
        loader.sensitiveOpertation();   //Allow library access to native code
    }

public native void sensitiveOpertation();
}

