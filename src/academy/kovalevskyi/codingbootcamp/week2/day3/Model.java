package academy.kovalevskyi.codingbootcamp.week2.day3;

public class Model {
    public int n;
    public char[][] moves;

    public Model(int n) {
        this.n = n;
        this.moves = new char[n][n];
        setEmptyMoves();
    }

    public void setEmptyMoves() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.moves[i][j] = ' ';
            }
        }
    }

    public void setMove(int x, int y, char ch) {
        this.moves[x][y] = ch;
    }

    public boolean isValid(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            System.out.printf("Не верные координаты. Выберете число от 0 до %d%n", (n - 1));
            System.out.println();
            return false;
        }
        if (moves[x][y] != ' ') {
            System.out.println("Поле уже занято. Введите другие координаты");
            System.out.println();
            return false;
        }
        return true;
    }

    public boolean checkRow(int index) {
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < n; i++) {
            if (moves[index][i] == 'X') {
                counterX++;
            }
            if (moves[index][i] == 'O') {
                counterO++;
            }
        }
        return counterO == n || counterX == n;
    }

    public boolean checkColumn(int index) {
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < n; i++) {
            if (moves[i][index] == 'X') {
                counterX++;
            }
            if (moves[i][index] == 'O') {
                counterO++;
            }
        }
        return counterO == n || counterX == n;
    }

    public boolean checkDiagonal() {
        int counterXMain = 0;
        int counterOMain = 0;
        int counterXSecondary = 0;
        int counterOSecondary = 0;
        for (int i = 0; i < n; i++) {
            if (moves[i][i] == 'X') {
                counterXMain++;
            }
            if (moves[i][i] == 'O') {
                counterOMain++;
            }
            if (moves[i][n - i - 1] == 'X') {
                counterXSecondary++;
                if (moves[i][n - i - 1] == 'O') {
                    counterOSecondary++;
                }
            }
        }
        return counterXMain == n || counterOMain == n
                || counterXSecondary == n || counterOSecondary == n;
    }

    public boolean isWin() {
        if (checkDiagonal()) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDimension(int dimension) {
        return dimension > 2;
    }
}
