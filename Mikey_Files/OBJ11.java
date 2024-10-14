package Mikey_Trevor_Files;
/**
 * This class demonstrates how to ensure that a resource passed to a constructor is not null.
 * The class is final, and the resource is a final field initialized through the constructor.
 */
public final class OBJ11 {
    private final String resource;
    /**
     * Constructs an OBJ011 object with the specified resource.
     *
     * @param resource The resource to be managed by this object. Must not be null.
     * @throws IllegalArgumentException if the resource is null.
     */
    public OBJ11(String resource) {
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
        this.resource = resource;
    }
    /**
     * Returns the resource associated with this object.
     * 
     * @return The resource string.
     */
    public String getResource() {
        return resource;
    }
    /**
     * The main method demonstrates how the class handles invalid input by catching
     * the {@code IllegalArgumentException} when a null resource is provided.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Attempt to create an OBJ011 object with a null resource
            OBJ11 res = new OBJ11(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create OBJ011: " + e.getMessage());
        }
    }
}
