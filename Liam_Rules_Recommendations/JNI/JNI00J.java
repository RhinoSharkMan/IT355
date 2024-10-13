package Liam_Rules_Recommendations.JNI;

public class JNI00J {
    private native int nativeSum(int a, int b);

    // Load the native library containing the implementation of nativeSum
    static {
        System.loadLibrary("NativeLib");
    }

    // Wrapper method around the nativeSum method
    public int safeSum(int a, int b) {
        // Add safety checks, such as range checking
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Arguments must be non-negative");
        }

        try {
            // Call the native method via the wrapper
            return nativeSum(a, b);
        } catch (Exception e) {
            // Catch any exceptions raised during the native method execution
            System.err.println("Error calling native method: " + e.getMessage());
            return -1; // Return a default value in case of error
        }
    }

    public static void main(String[] args) {
        // Create an instance of the wrapper class
        JNI00J wrapper = new JNI00J();

        // Call the safeSum wrapper method
        int result = wrapper.safeSum(10, 20);
        System.out.println("The sum is: " + result);
    }
}
