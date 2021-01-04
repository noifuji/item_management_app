package ao.app.productmaster.tool;

import java.util.regex.Pattern;

public class Util {
    public static boolean isHalfNumeric(String str) {
        return Pattern.matches("^[0-9]*$", str);
    }
}