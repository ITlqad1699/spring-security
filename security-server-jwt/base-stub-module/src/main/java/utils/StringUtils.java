package utils;

import org.springframework.lang.Nullable;

/**
 * The type String utils.
 */
public class StringUtils {
    public static final String HYPHEN = "-";
    public static final String UNDERSCORE = "_";
    public static final String DOT = ".";
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";
    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String EQUALS = "=";
    public static final String DASH = "-";
    public static final String PLUS = "+";
    public static final String ASTERISK = "*";
    public static final String SLASH = "/";
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String HASH = "#";
    public static final String AT = "@";
    public static final String PERCENT = "%";

    /**
     * Is empty boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Is not empty boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean startsWithIgnoreCase(@Nullable String str, @Nullable String prefix) {
        return str != null && prefix != null && str.length() >= prefix.length() && str.regionMatches(true, 0, prefix,
                0, prefix.length());
    }

}
