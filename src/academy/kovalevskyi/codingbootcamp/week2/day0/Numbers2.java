package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;

import java.util.Arrays;

public class Numbers2 extends Numbers1 {
    public static void main(String[] args) {
        char[][] test = generateTuples(0);
        System.out.println(Arrays.deepToString(test));
        System.out.println(test.length);

    }

    public static char[][] generateTriplets() {
        int counter = 0;
        char char1, char2, char3;
        char[][] result = new char[120][];
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                for (int k = j + 1; k < 10; k++) {
                    char1 = (char) (i + 48);
                    char2 = (char) (j + 48);
                    char3 = (char) (k + 48);
                    result[counter++] = new char[]{char1, char2, char3};
                }
            }
        }
        return result;
    }

    public static char[][] generateTuples() {
        int counter = 0;
        char char1, char2, char3, char4;
        char[][] result = new char[10000][];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        char1 = (char) (i + 48);
                        char2 = (char) (j + 48);
                        char3 = (char) (k + 48);
                        char4 = (char) (l + 48);
                        result[counter++] =
                                new char[]{char1, char2, ' ', char3, char4};
                    }
                }
            }
        }
        return result;
    }

    public static char[][] generateTuples(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        if (amount == 0) {
            return new char[][]{};
        }
        int totalElements = (int) NumberUtils.power(10, amount);
        char[][] result = new char[totalElements][];
        int counter = 0;
        for (int i = 0; i < totalElements; i++) {
            result[counter++] = fillArray(amount, i);
        }
        return result;
    }

    public static char[] fillArray(int amount, int number) {
        char[] result = new char[amount];
        char[] numberToCharArr = convertToCharArray(number);

        for (int i = 0; i < amount; i++) {
            result[i] = '0';
        }
        for (int i = 0; i < numberToCharArr.length; i++) {
            result[amount - i - 1] = numberToCharArr[numberToCharArr.length - 1 - i];
        }
        return result;
    }

}
