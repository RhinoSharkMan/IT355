package Liam_Rules_Recommendations.ENV;

import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.Permission;

@SuppressWarnings("removal")
public class ENV03J extends SecurityManager{
    @Override
    public void checkPermission(Permission perm) {
        // Allow other permissions by default
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // Detect and block dangerous combinations of permissions
        if (perm instanceof FilePermission && perm.getActions().contains("read")) {
            if (context instanceof SocketPermission && ((SocketPermission) context).getActions().contains("connect")) {
                throw new SecurityException("Dangerous combination of File and Socket permissions denied.");
            }
        }
    }

    public static void main(String[] args) {
        // Set our custom security manager
        System.setSecurityManager(new ENV03J());

        try {
            // Example of FilePermission
            FilePermission filePerm = new FilePermission("/path/to/file", "read");
            System.getSecurityManager().checkPermission(filePerm);

            System.out.println("Permissions granted safely.");
        } catch (SecurityException se) {
            System.err.println("SecurityException: " + se.getMessage());
        }
    }

}