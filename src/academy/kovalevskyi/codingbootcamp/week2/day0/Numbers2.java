package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;
import java.util.Arrays;

public class Numbers2 extends Numbers1 {

    public static char[][] generateTriplets() {
        int counter = 0;
        char char1;
        char char2;
        char char3;
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
        return Arrays.stream(generateTuples(4))
                .map(arr ->  new char[]{arr[0], arr[1], ' ', arr[2], arr[3]})
                .toArray(char[][]::new);
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
        for (int i = 0; i < totalElements; i++) {
            result[i] = fillSubArray(amount, i);
        }
        return result;
    }

    private static char[] fillSubArray(int amount, int number) {
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