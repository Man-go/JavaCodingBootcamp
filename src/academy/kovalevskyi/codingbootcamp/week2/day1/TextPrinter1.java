package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter1 {

    public static final int NUMBER_OF_MESSAGE_IN_BOX = 1;

    public static void main(String[] args) {
//        args = new String[]{"test in the box"};
        if (args.length != 1) {
            System.out.println(
                    "pLeAsE PrOvIdE OnLy oNe iNpUt aRgUmEnT, cUrReNt aMoUnT: " + args.length);
            return;
        }
        String result = createMessageInBox("/", "\\", "#", args[0], NUMBER_OF_MESSAGE_IN_BOX);
        System.out.println(result);
    }

    public static String createMessageInBox(String connerLeft, String connerRight, String border, String message, int height) {
        int len = message.length() + 4;
        StringBuilder result = new StringBuilder();
        result.append(BoxGenerator.strByTypeElem(connerLeft,connerRight,border, len));
        result.append("\n");
        for (int i = 0; i < height; i++) {
            result.append(BoxGenerator.strByTypeElem(border + " ", " "+ border, message, 3));
            result.append("\n");
        }
        result.append(BoxGenerator.strByTypeElem(connerRight,connerLeft,border, len));
        return result.toString();
    }
}
