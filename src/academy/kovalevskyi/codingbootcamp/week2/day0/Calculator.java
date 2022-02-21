package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class Calculator {

    public static void main(String[] args) {
        char[] mathSymbols = new char[]{'+', '*', '-', '/', '%'};

        if (args.length != 3) {
            System.out.println("Please provide 3 input arguments, example: 2 + 3");
            return;
        }

        long number1 = 0;
        long number2 = 0;
        try {
            number1 = StringUtils.toInt(args[0].toCharArray());
            number2 = StringUtils.toInt(args[2].toCharArray());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (!(args[1].charAt(0) == '+' || args[1].charAt(0) == '*'
                || args[1].charAt(0) == '-' || args[1].charAt(0) == '/'
                || args[1].charAt(0) == '%' )) {
            throw new IllegalArgumentException();
        }

        if (args[1].charAt(0) == '/' && number2 == 0) {
            System.out.println("Division by zero is impossible!");
            return;
        }

        switch (args[1]) {
            case "+" -> System.out.println("result: " + (number1 + number2));
            case "-" -> System.out.println("result: " + (number1 - number2));
            case "*" -> System.out.println("result: " + (number1 * number2));
            case "/" -> System.out.println("result: " + (double) (number1 / number2));
            case "%" -> System.out.println("result: " + (number1 % number2));
        }
    }
}
