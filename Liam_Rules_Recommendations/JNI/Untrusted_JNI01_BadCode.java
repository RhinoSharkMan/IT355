package Liam_Rules_Recommendations.JNI;

import Liam_Rules_Recommendations.TrustedPackage.Trusted;
import Liam_Rules_Recommendations.UntrustedPackage.Untrusted;

@SuppressWarnings("unused")
public class Untrusted_JNI01_BadCode {
 
   public static void main(String[] args) {
      String library = new String("library");

      //Untrusted code is allowed access to trusted code
      Trusted_JNI01_BadCode.loadLibrary(library);
      //Untrusted code...
   }
}
