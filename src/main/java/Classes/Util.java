package Classes;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

public class Util {

    /**
     * UTF-8 Charset for NIO
     */
    public static Charset nioUTF8Charset = Charset.forName("UTF-8");

    /**
     * Convert expection to normal output string for debugging
     */
    public static String expectionToFullString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

}
