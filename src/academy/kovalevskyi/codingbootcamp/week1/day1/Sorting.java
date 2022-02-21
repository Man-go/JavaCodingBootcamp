package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {

    public static <T> void sort(T[] target, Comparator<T> comparator) {
        if (target == null || target.length == 0) {
            throw new NullPointerException("array is emptyi");
        }
        T temp;
        for (int i = target.length; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (comparator.compare(target[j], target[j + 1]) > 0) {
                    temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
        sort(target, comparator.reversed());
    }

}
