import java.nio.CharBuffer;

final class FIO05 {
    private char[] importantArray;
    public FIO05() {
        importantArray = new char[100];
        //initialization
    }
    public CharBuffer getImpBufferCopy() {
        return CharBuffer.wrap(importantArray).asReadOnlyBuffer();
    }
}
