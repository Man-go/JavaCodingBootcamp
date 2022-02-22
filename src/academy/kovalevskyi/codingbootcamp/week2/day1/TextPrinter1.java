package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter1 {

    public static final int NUMBER_OF_MESSAGE_IN_BOX = 1;

    public static void main(String[] args) {
//        args = new String[]{"test in the box"};
        if (args.length != 1) {
            System.out.println(
                    "Please provide only one input argument, current amount: " + args.length);
            return;
        }
        String result = createMessageInBox(args[0], NUMBER_OF_MESSAGE_IN_BOX);
        System.out.println(result);
    }

    private static String createMessageInBox(String message, int height) {
        int len = message.length() + 4;
        StringBuilder result = new StringBuilder();
        result.append(BoxGenerator.strByTypeElem("/","\\","#", len));
        result.append("\n");
        for (int i = 0; i < height; i++) {
            result.append(BoxGenerator.strByTypeElem("# ", " #", message, 3));
            result.append("\n");
        }
        result.append(BoxGenerator.strByTypeElem("\\","/","#", len));
        return result.toString();
    }
}
