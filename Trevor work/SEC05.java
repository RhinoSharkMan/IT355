
public class SEC05 {
    SEC05() { } // Package - private constructor
    static <Sec> Sec create(Class<Sec> trustedClass)
        throws InstantiationException, IllegalAccessException{
            //creates a trusted class
            return trustedClass.newInstance();
        }

}