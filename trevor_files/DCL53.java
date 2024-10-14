package trevor_files;
import java.util.*;

public class DCL53 {
    /**
     * Adds 1 to the end of arr
     * Non-compliant because int i can be reduced in scope
     * @param arr
     * @return arr with 1 added to end
     */
    public static int[] addOneWrong(int[] arr){
        //non-compliant because i can be declared within the scope of the for loop
        int i;
        int[] newArray = new int [arr.length+1];
        for (i=0; i<arr.length; i++){
            newArray[i] = arr[i];
        }  
        newArray[newArray.length-1] = 1;
        return newArray;      
    }
    /**
     * Creates arr and calls addOneWrong method to add 1 to the end of it
     * Compliant example of for loop. int i has appropriate scope
     */
    public static void main(String[] args){
        int [] arr = {5, 4, 3, 2};
        arr = addOneWrong(arr);
        //compliant because i is declared within the scope of the for loop
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        } 
    }

}
