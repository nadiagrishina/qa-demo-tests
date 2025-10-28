public class BufferHelper {
    private static StringBuffer verificationErrors;

    public static StringBuffer getNewBuffer(){
        verificationErrors = new StringBuffer();
        return verificationErrors;
    }
    public static void appendBuffer(String str){
        verificationErrors.append(str);
    }
    public static StringBuffer returnCurrentBuffer(){
        return verificationErrors;
    }
}
