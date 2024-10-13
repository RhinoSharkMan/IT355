package Liam_Rules_Recommendations.SEC;
import java.security.*;

@SuppressWarnings("removal")
class SEC07J extends Policy{

    @Override
    public PermissionCollection getPermissions(CodeSource cs) {
        PermissionCollection permission = super.getPermissions(cs);
        permission.add(new RuntimePermission("Sensitive Operation..."));
        return permission;
    }


    //Bad code
    // protected PermissionCollection getPremission(CodeSource cs){
    //     PermissionCollection pc = new Permissions();
    //     pc.add(new RuntimePermission("Exit the VM"));
    //     return pc;
    // }
    
}