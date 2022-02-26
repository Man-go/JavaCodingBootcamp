package academy.kovalevskyi.codingbootcamp.week2.day3;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Вы хотите сыграть в игру? (y or n): ");
            if (scanner.nextLine().equals("n")) {
                return;
            }

            int boardSize;
            while (true) {
                try {
                    System.out.print("Введите размер поля (от 3 до N): ");
                    boardSize = Integer.parseInt(scanner.nextLine());
                    if (Model.isValidDimension(boardSize)) {
                        break;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Введите цифру от 3 до N!\n");
                }
            }
            Model model = new Model(boardSize);

            View board = new View();

            String x;
            String y;
            int counter = 0;
            char ch;
            int xIntValue = -1;
            int yIntValue = -1;
            boolean flag = true;

            while (!model.isWin()) {
                while (true) {
                    System.out.println(board.printBoard(model.moves));
                    ch = counter % 2 == 0 ? 'X' : 'O';
                    try {
                        System.out.println("Сейчас ходит: " + (counter % 2 == 0 ? "Крестик" : "Нолик"));
                        System.out.print("Введите x: ");
                        xIntValue = Integer.parseInt(scanner.nextLine());
                        System.out.print("Введите y: ");
                        yIntValue = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.printf("Введите цифру от 0 до %d, а не какую-то фигню!\n\n", (boardSize - 1));
                        flag = false;
                    }
                    if (flag) {
                        if (model.isValid(xIntValue, yIntValue)) {
                            break;
                        }
                    }
                    flag = true;
                }

                model.setMove(xIntValue, yIntValue, ch);
                counter++;
            }
            //??????? почему он помнит коунтер, но не помнит ch
            String string = counter % 2 == 0 ? "Нолик" : "Крестик";
            System.out.println(board.printBoard(model.moves));
            System.out.println("Игра окончена, выйграл: " + string);
        }
    }
}