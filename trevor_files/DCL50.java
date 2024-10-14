package trevor_files;

public class DCL50 {
    public static void main(String[] args){
        /**
        * While the declaration int o = 10 is correct it 
        * is easy to assume int O is a value 0. 
        */
        int o = 10; 
        /**
         * Use variable x instead if possible
         * as it is visually distinct
         */
        int x = 10;

        //this is confusing, may expect value of 5 instead of 15
        System.out.println(5+o);
        //this is better, it is clear that x is a variable
        System.out.println(5+x);
    }
}
