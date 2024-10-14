package trevor_files;

import java.io.Serializable;

public class SER05 implements Serializable{
    private int intExp;
    class InnerClass{
        protected String example;
    }
//Serializes the outer class instead of the inner class
}