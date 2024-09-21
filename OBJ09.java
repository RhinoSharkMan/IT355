public class OBJ09 {
    /**
     * Main method demonstrates how to compare the classes of two objects 
     * using the getClass() method. (OBJ09-J compliant)
     */
    public static void main(String[] args) {
        // Creates two Object instances of type String
        Object obj1 = new String("Hello");
        Object obj2 = new String("World");

        // Compare classes directly using getClass() rather than class names.
        if (obj1.getClass() == obj2.getClass()) {
            System.out.println("same class.");
        } else {
            System.out.println("different classes.");
        }
    }
}

