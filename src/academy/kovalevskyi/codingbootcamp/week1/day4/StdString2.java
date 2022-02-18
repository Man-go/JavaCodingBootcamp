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
        return new StdString2(StringUtils.
                makeLowercase(this.toCharArray()).toString().toCharArray());
    }

    public StdString2 toAsciiUpperCase() {
        return new StdString2(StringUtils.
                makeUppercase(this.toCharArray()).toString().toCharArray());
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
        char[][] interArr = new char[][];
        for (int i = 0; i < that.length; i++) {
            for (int j = 0; j < that[i].length(); j++) {
                interArr[i][j] = that[i].charAt(j);
            }
        }
        return new StdString2(StringUtils.concatStrings(interArr));
    }

    public StdString2[] split(char separator) {
        int totalSeparators = 0;
        for (int i = 0; i < this.length(); i++) {
            if (this.charAt(i) == separator) {
                totalSeparators++;
            }
        }
        if (totalSeparators == 0) {
            return new StdString2[]{this};
        }

        int counter = 0;
        int startIndex = 0;
        StdString2[] result = new StdString2[totalSeparators + 1];
        for (int i = 0; i < this.length(); i++) {
            if (this.charAt(i) == separator) {
                result[counter++] = subString(startIndex, i);
                startIndex = i + 1;
            }
        }
        return result;
    }

    public StdString2 trim() {
        int indexLastLeftSpace = 0;
        int indexLastRightSpace = this.length() - 1;

        for (int i = 0; i < this.length(); i++) {
            if (this.charAt(i) != ' ') {
                indexLastLeftSpace = i;
                break;
            }
        }
        for (int i = this.length() - 1; i >= 0; i--) {
            if (this.charAt(i) != ' ') {
                indexLastRightSpace = i;
            }
        }
        return this.subString(indexLastLeftSpace, indexLastRightSpace);
    }

    public StdString2 removeCharacter(char toRemove) {
        int index = this.indexOf(toRemove);
        if (index == -1) {
            return this;
        }

    }
}
