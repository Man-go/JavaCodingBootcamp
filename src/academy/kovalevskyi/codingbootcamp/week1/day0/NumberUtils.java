package academy.kovalevskyi.codingbootcamp.week1.day0;

public class NumberUtils {

    public static void main(String[] args) {
//        System.out.println(getFactorial(5));
//        System.out.println(factorialRecursive(5));
        System.out.println(power(0, 0));
        System.out.println(powerRecursive(0, 0));
//        System.out.println(fibRecursive(10));
//        int[] test = fibSequence(10);
//        for (int i = 0; i < test.length; i++) {
//            System.out.print(test[i] + " ");
//        }

//        System.out.println(sqrt(16));
//        System.out.println(isPrime(4));
//        System.out.println(findNextPrime(-13));
//        int[] test = new int[]{-5, 0, -5, 2, 10, -3, 18, -30};
//        sort(test);
//        for (int i : test) {
//            System.out.print(i + " ");
//        }
    }

    public static long getFactorial(final int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException();
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialRecursive(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException();
        }
        if (number == 1 || number == 0) {
            return 1;
        }
        return number * factorialRecursive(number - 1);
    }

    public static double power(int base, int power) {
        double result = 1;
        if (power > 0) {
            while (power > 0) {
                result *= base;
                power--;
            }
            return result;
        }
        if (power < 0) {
            while (power < 0) {
                result *= base;
                power++;
            }
            return 1 / result;
        }
        return 1;
    }

    public static double powerRecursive(int base, int power) {
        if (base == 0) {
            return 0;
        }
        return power > 0 ? base * powerRecursive(base, power - 1)
                : power < 0 ? powerRecursive(base, power + 1) / base : 1;
    }

    public static int fibRecursive(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 1) {
            return 1;
        }
        if (index == 0) {
            return 0;
        }
        return fibRecursive(index - 2) + fibRecursive(index - 1);
    }

    public static int[] fibSequence(int length) {
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        int[] fibArray = new int[length];
        for (int i = 0; i < length; i++) {
            fibArray[i] = fibRecursive(i);
        }
        return fibArray;
    }

    public static int sqrt(int target) {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        int result = 0;
         do {
            if (result * result == target) {
                return result;
            }
            result++;
        } while (result <= target / 2 + 1);
        return -1;
    }

    public static boolean isPrime(int target) {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        int counter = 0;
        for (int i = 1; i < target / 2 + 1; i++) {
            if (target % i == 0) {
                counter++;
            }
        }
        return counter == 1;
    }

    public static int findNextPrime(int target) {
        if (target < 0) {
            throw new IllegalArgumentException();
        }
        int result = target;
        while (!isPrime(result)) {
            result++;
        }
        return result;
    }

    public static void sort(int[] target) {
        if (target != null) {
            return;
        }
        int temp = 0;
        for (int i = target.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (target[j] > target[j + 1]) {
                    temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }

    }
}
