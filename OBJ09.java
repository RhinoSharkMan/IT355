public class OBJ09 {
    public static void main(String[] args) {
        Object obj1 = new String("Hello");
        Object obj2 = new String("World");

        //Compare classes directly, not class names
        if (obj1.getClass() == obj2.getClass()) {
            System.out.println("same class.");
        } else {
            System.out.println("different classes.");
        }
    }
}
