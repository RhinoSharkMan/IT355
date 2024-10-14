package Mikey_Trevor_Files;

import java.security.AccessController;
import java.security.PrivilegedAction;



public class SEC52 {
    
private void loadHawkmark() {
    //doesn't expose method that use reduced-security checks
    AccessController.doPrivileged((PrivilegedAction) () -> {
        //access solution through hard coded to prvent tainted values
        System.loadLibrary("hawkmarket");
        return null;
        //loads the hawkmarket system
    });
}
}