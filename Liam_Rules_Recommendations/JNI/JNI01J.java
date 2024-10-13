package Liam_Rules_Recommendations.JNI;

public class JNI01J {
    // load native libraries
    static {
        // Safely load the native library using the class loader
        loadNativeLibrary("nativeLibName");
    }

    // Safe method to load a native library
    private static void loadNativeLibrary(String libName) {
        try {
            System.out.println("Attempting to load native library: " + libName);
            System.loadLibrary(libName);    //Load the libaray
            System.out.println("Successfully loaded native library: " + libName);
        } catch (SecurityException e) {
            System.err.println("SecurityException: Permission denied to load library: " + libName); //Catch any security excerption
        } catch (UnsatisfiedLinkError e) {
            System.err.println("UnsatisfiedLinkError: Failed to load library: " + libName); //Catch error in linking library 
        } catch (Exception e) {
            System.err.println("Exception: An unexpected error occurred while loading library: " + libName);    //Catch all other errors
        }
    }
  
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        JNI01J loader = new JNI01J();   //Staticly load the libraries
        //Rest of the program...
    }
}
