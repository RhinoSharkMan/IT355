package Recommendations;

public class MET54 {
    /**
     * Non-compliant because no feedback was given
     * we don't know if the word was added successfully
     * @param arr
     * @param word
     */
    public static void addToArrWithoutFeedback(String arr[], String word){
        for(int i=0; i<arr.length;i++){
            if(arr[i] == null){
                arr[i] = word;
            }
        }
    }
    /**
     * compliant because this method returns true if the
     * word was added successfully
     * @param arr
     * @param word
     * @return true if successfull
     */
    public static boolean addToArrWithFeedback(String arr[], String word){
        for(int i=0; i<arr.length;i++){
            if(arr[i] == null){
                arr[i] = word;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String [] arr1 = new String [2];
        //returns true on successful entry
        addToArrWithFeedback(arr1, "hello");
        //does not return anything regardless of success
        addToArrWithoutFeedback(arr1, "world");
    }
}
