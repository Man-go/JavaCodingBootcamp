package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class BoxGenerator {

    public static void main(String[] args) {
//        args = new String[]{"6", "4", "-", "#"};
        if (args.length != 4) {
            System.out.println("Please provide 4 input arguments, current amount: " + args.length);
            return;
        }
        int width;
        int height;
        try {
            width = StringUtils.toInt(args[0].toCharArray());
            height = StringUtils.toInt(args[1].toCharArray());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (args[2].length() != 1 || args[3].length() != 1) {
            throw new IllegalArgumentException();
        }
        String wallStr = args[2];
        String connerStr = args[3];
        String result = createBox(width, height, wallStr, connerStr);
        System.out.println(result);
    }

    public static String strByTypeElem(String connerLeft, String connerRight, String inside, int len) {
        StringBuilder stringValue = new StringBuilder();
        stringValue.append(connerLeft);
        stringValue.append(String.valueOf(inside).repeat(Math.max(0, len - 2)));
        stringValue.append(connerRight);
        return stringValue.toString();
    }

    private static String createBox(int len, int height, String wallStr, String conner) {
        StringBuilder stringValue = new StringBuilder();
        stringValue.append(strByTypeElem(conner, conner, wallStr, len));
        stringValue.append("\n");
        for (int i = 0; i < height - 2; i++) {
            stringValue.append(strByTypeElem(wallStr, wallStr, " ", len));
            stringValue.append("\n");
        }
        stringValue.append(strByTypeElem(conner, conner, wallStr, len));
        return stringValue.toString();
    }

}
