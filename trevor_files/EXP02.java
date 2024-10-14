package trevor_files;
import java.util.Arrays;

public class EXP02 {
    /**
     * This method demonstrates the correct way to compare arrays using Arrays.equals().
     */
    public void correctArrayComparison() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        // Correct: Using Arrays.equals() to compare the contents of the arrays.
        if (Arrays.equals(array1, array2)) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Arrays are not equal.");
        }
    }
    /**
     * Main method to run the example and demonstrate the rule.
     */
    public static void main(String[] args) {
        EXP02 example = new EXP02();
        // Demonstrate correct comparison
        example.correctArrayComparison();
    }
}
