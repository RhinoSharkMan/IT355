package Andrew_Files;
import java.util.Arrays;
public class EXP02 {
    public static void main(String[] args) 
    {
        int[] array1 = {1,3,5,6}; 
        int[] array2 = {1,3,5,6};
        int[] array3 = {1,3,5,7,9};

        //calling Arrays.equals method when arrays are equal
        System.out.println(Arrays.equals(array1,array2)); 
        //calling Arrays.equals method when arrays are not equal
        System.out.println(Arrays.equals(array1,array3)); 
    }

}
