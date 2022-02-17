package academy.kovalevskyi.codingbootcamp.week0.day4;

import java.util.Arrays;

public class Numbers1 {

    public static void main(String[] args) {
        //System.out.println(findBiggest(-2_147_483_647, 99));
        char[] charTemp = convertToCharArray(0);
        for (char c : charTemp) {
            System.out.print(c + " ");
        }
    }

    public static int[] generateNumbers() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    public static int findBiggest(int left, int right) {
        return left > right ? left : right;
    }

    public static int findBiggest(int left, int mid, int right) {
        return findBiggest(findBiggest(left, mid), findBiggest(mid, right));
    }

    public static int findBiggest(int[] numbers) {
        int valueTemp = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > valueTemp) {
                valueTemp = numbers[i];
            }
        }
        return valueTemp;
    }

    public static int findIndexOfBiggestNumber(int[] numbers) {
        int valueTemp = numbers[0];
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > valueTemp) {
                valueTemp = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

//    public static char[] convertToCharArray(int number) {
//        boolean isnegative = isNegative(number);
//
//        int tempNumber = isnegative ? -1 * number : number;
//        int index = 0;
//        char[] charArray = new char[11];
//
//        do {
//            int lastNumber = tempNumber % 10;
//            tempNumber /= 10;
//            charArray[index] = (char) (lastNumber + 48);
//            index++;
//        } while (tempNumber > 0);
//
//        if (isnegative) {
//            charArray[index] = '-';
//            index++;
//        }
//        charArray = Arrays.copyOf(charArray, index);
//        int charArrayLength = charArray.length;
//        for (int i = 0; i < charArrayLength / 2; i++) {
//            char charTemp = charArray[i];
//            charArray[i] = charArray[charArrayLength - i - 1];
//            charArray[charArrayLength - i - 1] = charTemp;
//        }
//        return charArray;
//    }

    public static char[] convertToCharArray(int number) {
        boolean isnegative = isNegative(number);
        int tempNumber = number;
        int index = 0;
        char[] charArray = new char[11];

        do {
            int lastNumber =  isnegative ? -1 * (tempNumber % 10) : tempNumber % 10;
            tempNumber /= 10;
            charArray[index] = (char) (lastNumber + 48);
            index++;
        } while (tempNumber != 0);

        if (isnegative) {
            charArray[index] = '-';
            index++;
        }

        charArray = Arrays.copyOf(charArray, index);
        int charArrayLength = charArray.length;
        for (int i = 0; i < charArrayLength / 2; i++) {
            char charTemp = charArray[i];
            charArray[i] = charArray[charArrayLength - i - 1];
            charArray[charArrayLength - i - 1] = charTemp;
        }
        return charArray;
    }
}
