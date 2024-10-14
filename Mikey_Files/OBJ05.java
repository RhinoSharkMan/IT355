package Mikey_Files;
/**
 * The OBJ05 class represents an object with a name and a list of private elements.
 * The class ensures encapsulation by preventing external modification of internal state.
 */
public class OBJ05 {
    /** The name of the Object */
    private String name;

    /** The private elements of the Object */
    private String[] elements;

    /**
     * Constructs a new Object with the specified name and private elements.
     * 
     * @param name The name of the Object.
     * @param elements An array of private elements associated with the Object.
     * A defensive copy is made to prevent modification of the internal state.
     * 
     */
    public OBJ05(String name, String[] elements) {
        this.name = name;
        // Defensive copy to avoid exposing the mutable reference
        this.elements = elements.clone();
    }

    /**
     * Returns a copy of the private elements array to prevent external modification of internal state.
     * 
     * @return A clone of the private elements array.
     */
    public String[] getelements() {
        // Return a defensive copy of the array
        return elements.clone();
    }

    /**
     * Sets the private elements for the Object. A defensive copy is made to prevent 
     * external modification of internal state.
     * 
     * @param elements An array of private elements to be set.
     */
    public void setelements(String[] elements) {
        this.elements = elements.clone();
    }
    public static void main(String[] args) {
        String [] elem = {"123", "456"};
        OBJ05 object1 = new OBJ05("OBJ1", elem);

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

        // Modify elements using the setter method
        String[] newElements = {"789", "987"};
        object1.setelements(newElements);

        // Display the elements after using the setter method
        System.out.println("\nElements after using setter method: ");
        for (String elements : object1.getelements()) {
            System.out.println(elements);
        }
    }
}
