package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week1.day1.Sorting;
import java.util.Comparator;

public class MainPrintSortedParam {

    public static void main(String[] args) {
        Sorting.sort(args, Comparator.naturalOrder());
    }
}
