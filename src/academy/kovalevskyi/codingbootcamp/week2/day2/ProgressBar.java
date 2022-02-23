package academy.kovalevskyi.codingbootcamp.week2.day2;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class ProgressBar {

    public static final int PROGRESSBAR_LEN = 100;

    public static void main(String[] args) {
        //args = new String[]{"15", "1", "1", "1", "5", "7", "1"};
        args = new String[]{"30000", "1"};
        if (args.length < 2) {
            System.out.println("Amount of arguments should be: at least 2");
            System.out.println("example: java -jar ... 2 3");
            return;
        }
        int[] arguments = toIntArray(args);
        createProgressBar(arguments);
    }

    private static int[] toIntArray(String[] args) {
        int len = args.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = StringUtils.toInt(args[i].toCharArray());
        }
        return result;
    }

    public static void createProgressBar(int[] arguments) {
        int len = arguments.length;
        double percent = 0;
        String result;
        String bar = " ".repeat(100);
        int loaded = 0;

        while (loaded <= arguments[0]) {
            int randomIndex = (int) (1 + Math.random() * (len - 1));
            int totalSeconds = (arguments[0] - loaded) * arguments[randomIndex];
            result = String.format("\r %3.0f%% [%s] %3d/ %d, ETA : %s", percent, bar, loaded++, arguments[0], getTime(totalSeconds));
            System.out.print(result);

            try {
                Thread.sleep((long) arguments[randomIndex] * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            percent += ((double) 100 / arguments[0]);
            bar = loaded <= arguments[0] ? getProgressBarString((int) percent) : "";
        }
    }

    private static String getProgressBarString(int percent) {
        if (percent == 0) {
            return " ".repeat(100);
        }
        return "=".repeat(percent - 1) + ">" + " ".repeat(100 - percent);
    }

    private static String getTime(long seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);
    }
}
