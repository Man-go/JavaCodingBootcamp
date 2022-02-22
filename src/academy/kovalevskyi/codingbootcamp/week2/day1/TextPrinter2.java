package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter2 {

    public static final int NUMBER_OF_MESSAGE_IN_BOX = 1;

    public static void main(String[] args) {
//        args = new String[]{"?", "test"};
        if (args.length != 2) {
            System.out.println(
                    "Please provide only one input argument, current amount: " + args.length);
            return;
        }
        if (args[0].length() != 1) {
            throw new IllegalArgumentException();
        }
        String border = args[0];
        String result = TextPrinter1.createMessageInBox(border, border, border, args[1], NUMBER_OF_MESSAGE_IN_BOX);
        System.out.println(result);
    }
}
