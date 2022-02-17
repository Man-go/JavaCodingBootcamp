package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {

    public static char[] generateAlphabet() {
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        return alphabet;
    }

    public static char[] generateReversedAlphabet() {
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('z' - i);
        }
        return alphabet;
    }
}
