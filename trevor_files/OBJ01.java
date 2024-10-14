package trevor_files;
/**
 * The OBJ01 class represents an individual with a name
 */
public class OBJ01 {
    private String name;
    /**
     * Constructor for OBJ01
     * @param name The OBJ01 name
     */
    public OBJ01(String name) {
        this.name = name;
    }
    /**
     * Sets the OBJ01 name
     * @return The OBJ01 name
     */
    public void setName(String n) {
        this.name = n;
    }
    /**
     * Gets the OBJ01 name
     * @return The OBJ01 name
     */
    public String getName() {
        return name;
    }
    /**
     * Displays information about the OBJ01
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
    }
    public static void main(String[] args) {
        // Create a OBJ01 object
        OBJ01 person = new OBJ01("Fred");
        // Display the OBJ01's information
        person.displayInfo();
    }
}

