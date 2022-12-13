import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static boolean next;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        int inputSize = Integer.parseInt(bf.readLine());
        result = inputSize;

        setSize(inputSize);

        System.out.println(result);

    }

    private static void setSize(int inputSize) throws IOException {
        for (int i = 0; i < inputSize; i++) {
            next = false;
            String inputWord = bf.readLine();
            validate(inputWord);
        }
    }

    private static void validate(String inputWord) {
        for (int i = 0; i < inputWord.length() - 1; i++) {
            char word = inputWord.charAt(i);

            if (inputWord.charAt(i + 1) != word) {
                makeWord(word, inputWord, i + 1);
            }

            if (next) {
                break;
            }
        }
    }

    private static void makeWord(char word, String inputWord, int i) {
        String restWord = "";
        for (int j = i; j < inputWord.length(); j++) {
            restWord += String.valueOf(inputWord.charAt(j));
        }

        if (validateDuplicationCheck(word, restWord)) {
            result--;
            next = true;
        }

    }

    private static boolean validateDuplicationCheck(char word, String restWord) {
        for (int i = 0; i < restWord.length(); i++) {
            if (restWord.charAt(i) == word) {
                return true;
            }
        }
        return false;
    }


}