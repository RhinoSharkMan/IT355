/**
 * The OBJ13 class represents an object with a list of immutable elements.
 * The class ensures encapsulation by preventing external modification of internal state.
 */
public class OBJ13 {

    /** The private elements of the Object */
    public static final String[] elements = {"123", "456"};

    /**
     * Constructs a new Object.
     * 
     * @param elements An array of static elements associated with the Object.
     * A defensive copy is made to prevent modification of the internal state.
     * 
     */
    public OBJ13() {
    }

    /**
     * Returns a copy of the private elements array to prevent external modification of internal state.
     * 
     * @return A clone of the private elements array.
     */
    public static final String[] getelements() {
        // Return a defensive copy of the array
        return elements.clone();
    }

    public static void main(String[] args) {
        OBJ13 object1 = new OBJ13();

        // Display the initial elements
        System.out.println("Initial elements: ");
        for (String elements : object1.getelements()) {
            System.out.println(elements);
        }

        // Attempt to modify the elements array externally
        String[] externalElements = object1.getelements();
        externalElements[0] = "111"; // This should not affect the internal state of the object

        // Display the elements after attempted external modification
        System.out.println("\nelements after external modification attempt: ");
        for (String elements : object1.getelements()) {
            System.out.println(elements);
        }
    }
}
