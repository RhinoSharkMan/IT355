import java.io.FileInputStream;
import java.io.IOException;

public class FIO08 {
    FileInputStream in;
    // Initialize Stream
    int intBuffer;
    char infromationData; {
    try {
        while ((intBuffer = in.read()) != -1) {
            infromationData = (char) intBuffer;
            //safly puts the information into data type char
        }
    } catch (IOException e) {
        // catches the IOException
    }

    
}
}
