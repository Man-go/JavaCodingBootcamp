package academy.kovalevskyi.codingbootcamp.week1.day2;

public class StringUtils {

    public static final int ASCII_MAX = 127;

    public static void main(String[] args) {
        System.out.println(toInt(new char[]{}));
    }

    public static void isAscii(char ch) {
        if (ch > ASCII_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isAsciiUppercase(char ch) {
        isAscii(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isAsciiLowercase(char ch) {
        isAscii(ch);
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isAsciiNumeric(char ch) {
        isAscii(ch);
        return ch >= '0' && ch <= '9';
    }

    public static boolean isAsciiAlphabetic(char ch) {
        isAscii(ch);
        return isAsciiUppercase(ch) || isAsciiLowercase(ch);
    }

    public static char toAsciiUppercase(char ch) {
        isAscii(ch);
        if (isAsciiLowercase(ch)) {
            return (char) ((int) ch - 32);
        }
        return ch;
    }

    public static char toAsciiLowercase(char ch) {
        isAscii(ch);
        if (isAsciiUppercase(ch)) {
            return (char) ((int) ch + 32);
        }
        return ch;
    }

    public static StringBuilder makeUppercase(char[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input) {
            stringBuilder.append(toAsciiUppercase(c));
        }
        return stringBuilder;
    }

    public static StringBuilder makeLowercase(char[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input) {
            stringBuilder.append(toAsciiLowercase(c));
        }
        return stringBuilder;
    }

    public static StringBuilder makeCamel(char[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(toAsciiLowercase(input[i]));
            } else {
                stringBuilder.append(toAsciiUppercase(input[i]));
            }
        }
        return stringBuilder;
    }

    public static boolean isSpace(char ch) {
        return ch == ' ';
    }

    public static boolean isStringAlphaNumerical(char[] input) {
        for (char c : input) {
            if (!isAsciiLowercase(c) && !isAsciiUppercase(c) && !isAsciiNumeric(c) && !isSpace(c)) {
                return false;
            }
        }
        return true;
    }

    public static char[] concatStrings(char[][] input) {
        int totalLength = 0;
        for (char[] chars : input) {
            totalLength += chars.length;
            for (char c : chars) {
                isAscii(c);
            }
        }
        char[] result = new char[totalLength];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                result[index++] = input[i][j];
            }
        }
        return result;
    }

    public static int toInt(char[] input) {
        if (input.length == 0) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        int isMinus = input[0] == '-' ? 1 : 0;

        for (int i = isMinus; i < input.length; i++) {
            if (!isAsciiNumeric(input[i])) {
                throw new NumberFormatException();
            }
            result *= 10;
            result += (int) input[i] - 48;
        }
        return input[0] == '-' ? -1 * result : result;
    }
}
