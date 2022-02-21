package academy.kovalevskyi.codingbootcamp.week2.day0;

public class MainPrintReversedParam {

    public static void main(String[] args) {
        int len = args.length;
        if (len == 0) {
            System.out.println("Please specify at least one argument!");
            return;
        }
        for (int i = 0; i < len ; i++) {
            System.out.println(args[len - 1 - i]);
        }
    }
}
