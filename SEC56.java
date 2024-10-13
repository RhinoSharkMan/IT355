

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

final class SEC56 implements Serializable{
    transient File exampleFile;
    public SEC56() throws FileNotFoundException{ 
        //file not serialized with the rest of the class
        //therefor file is not exposed to attackers
        exampleFile = new File("/this PC/Local Disk (C:)/exp/example.txt");
    }
}
        
