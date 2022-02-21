package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {

    public StdString2(char[] base) {
        super(base);
    }

    public StdString2() {
        super(new char[0]);
    }

    public StdString2(StdString2 that) {
        super(that);
    }

    public StdString2 toAsciiLowerCase() {
        return new StdString2(StringUtils.makeLowercase(this.toCharArray())
                .toString().toCharArray());
    }

    public StdString2 toAsciiUpperCase() {
        return new StdString2(StringUtils.makeUppercase(this.toCharArray())
                .toString().toCharArray());
    }

    public StdString2 subString(int from, int to) {
        if (from < 0 || to > this.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (from > to) {
            throw new IllegalArgumentException();
        }
        char[] result = new char[to - from];
        for (int i = from; i < to; i++) {
            result[i - from] = this.charAt(i);
        }
        return new StdString2(result);
    }

    public StdString2 concat(StdString2... that) {
        if (that == null) {
            throw new NullPointerException();
        }
        StdString1 result = new StdString1(this.toCharArray());
        for (int i = 0; i < that.length; i++) {
            if (that[i].length() != 0) {
                result = result.append(that[i]);
            }
        }
        return new StdString2(result.toCharArray());
    }

    public StdString2[] split(char separator) {
        StdString2 str = new StdString2(this);
        int to = 0;
        int len = str.length();
        while (str.charAt(len - 1) == separator && to < len) {
            len--;
        }
        str = subString(to, len);
        StdString2[] result = new StdString2[str.length()];
        int counter = 0;
        while ((to = str.indexOf(separator)) != -1 ) {
            int from = 0;
            result[counter++] = str.subString(from, to);
            str = str.subString(to + 1, str.length());
        }
        if (str.length() > 0) {
            result[counter] = str;
        }
        StdString2[] rsl = new StdString2[counter + 1];
        System.arraycopy(result, 0, rsl, 0, rsl.length);
        return rsl;
    }

    public StdString2 trim() {
        StdString2 str = new StdString2(this);
        int from = 0;
        int to = str.length();

        while (from < to && str.charAt(from) <= ' ') {
            from++;
        }
        while (from < to && str.charAt(to - 1) <= ' ') {
            to--;
        }
        if (from == 0 && to == str.length()) {
            return str;
        }
        return str.subString(from, to);
    }

    public StdString2 removeCharacter(char toRemove) {
        return this.length() == 0 ? new StdString2() : new StdString2().concat(split(toRemove));
    }
}
