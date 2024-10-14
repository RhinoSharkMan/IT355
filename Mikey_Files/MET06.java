package Mikey_Files;
class MET06 implements Cloneable {
    int[] data;
    /**
     * Constructor to initialize the data array.
     * 
     * @param data integer array to initialize the object
     */
    MET06(int[] data) {
        this.data = data;
    }
    /**
     * Clones this object. 
     * This method follows MET06-J by avoiding calls to overridable methods.
     * 
     * @return a clone of this object
     * @throws CloneNotSupportedException if cloning is not supported
     */
    public Object clone() throws CloneNotSupportedException {
        MET06 clone = (MET06) super.clone();
        // Avoid calling overridable methods
        return clone;
    }
    /**
     * Modifies the data array by multiplying each element by 2.
     */
    final void modifyData() { // Final to prevent overriding
        for (int i = 0; i < data.length; i++) {
            data[i] *= 2;
        }
    }
}
/**
 * Subclass that extends MET06 but cannot override modifyData() because it's final.
 */
class SubClass extends MET06 {
    /**
     * Constructor to initialize the subclass with data.
     * 
     * @param data integer array to initialize the object
     */
    SubClass(int[] data) {
        super(data);
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] data = {1, 2, 3};
        MET06 obj = new SubClass(data);
        MET06 clone = (MET06) obj.clone(); // Safe cloning
    }
}
