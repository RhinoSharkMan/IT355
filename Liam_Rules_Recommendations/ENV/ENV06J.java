package Liam_Rules_Recommendations.ENV;

public class ENV06J {
    public boolean authenticate(String username, String password) {
        return "Dave".equals(username) && "TheCoolerDave".equals(password);
    }

    // Unsafe debugging entry point --- Bad Code
    public void debugAccess() {
        // Debug code left in production that allows full access to sensitive operations
        System.out.println("Access granted to all system data");
        System.out.println("Sensitive operations...");
    }

    public static void main(String[] args) {
        ENV06J manager = new ENV06J();
        
        // Production usage
        if (!manager.authenticate("Dave", "TheCoolerDave")) {
            System.out.println("Unauthenticated user");
            System.exit(-1);    //End Program, Bad Code
        }

        System.out.println("Authenticated user:");

        manager.debugAccess(); //This is a security breach --- Bad Code
    }
}
