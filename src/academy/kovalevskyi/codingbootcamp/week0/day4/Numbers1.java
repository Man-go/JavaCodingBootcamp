package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

    public static int[] generateNumbers() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    public static int findBiggest(int left, int right) {
        return left >= right ? left : right;
    }

    public static int findBiggest(int left, int mid, int right) {
        return findBiggest(findBiggest(left, mid), findBiggest(mid, right));
    }

    public static int findBiggest(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findIndexOfBiggestNumber(int[] numbers) {
        int max = numbers[0];
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static char[] convertToCharArray(int number) {
        boolean isnegative = isNegative(number);
        int tempNumber = number;
        int index = 0;
        int maxRange = 11;
        char[] charArray = new char[maxRange];
        do {
            int lastNumber = isnegative ? -1 * (tempNumber % 10) : tempNumber % 10;
            tempNumber /= 10;
            charArray[index] = (char) (lastNumber + 48);
            index++;
        } while (tempNumber != 0);
        if (isnegative) {
            charArray[index] = '-';
            index++;
        }
        char[] clonArrayChar = new char[index];
        System.arraycopy(charArray, 0, clonArrayChar, 0, index);
        int charArrayLength = clonArrayChar.length;
        for (int i = 0; i < charArrayLength / 2; i++) {
            char charTemp = clonArrayChar[i];
            clonArrayChar[i] = clonArrayChar[charArrayLength - i - 1];
            clonArrayChar[charArrayLength - i - 1] = charTemp;
        }
        return clonArrayChar;
    }
}
