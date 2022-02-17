package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {
    public static void main(String[] args) {
        printHello();
    }

    public static void printHello() {
        System.out.println("Hello World");
    }

    public static int sumOfTwoNumbers(int a, int b) {
        return a + b;
    }

    public static int convertMinToSec(int minutes) {
        return 60 * minutes;
    }

    public static void compareTwoNumbers(int a, int b) {
        if (a == b) {
            System.out.println("Result: numbers are equal");
        } else {
            System.out.println(a > b ? "Result: a is bigger" : "Result: b is bigger");
        }
    }

    public static void concatTwoStrings(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);
    }

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static boolean divisibleBy5(int num) {
        return num % 5 == 0;
    }

    public static int firstElementOfArray(int[] arr) {
        return arr[0];
    }

    public static int smallestElementOfArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
        if (quick && efficient && reliable) {
            System.out.println("Result of work: excellent, but you are dreaming");
        } else if (quick && reliable) {
            System.out.println("Result of work: poor, but fast enough");
        } else if (efficient && reliable) {
            System.out.println("Result of work: good, but tired of waiting");
        } else if (efficient && quick) {
            System.out.println("Result of work: excellent, but pricey");
        } else {
            System.out.println("Pick at least two");
        }
    }
}
