package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter2 {

    public static final int NUMBER_OF_MESSAGE_IN_BOX = 1;

    public static void main(String[] args) {
//        args = new String[]{"?", "test"};
        if (args.length != 2) {
            System.out.println(
                    "Please provide 2 input arguments, current amount: " + args.length);
            return;
        }
        if (args[0].length() > 1) {
            System.out.println(
                    "First argument length should be 0 or 1, now it is: " + args[0].length());
            return;
        }
        String border = args[0];
        String result = TextPrinter1.createMessageInBox(border, border, border, args[1], NUMBER_OF_MESSAGE_IN_BOX);
        System.out.println(result);
    }
}
