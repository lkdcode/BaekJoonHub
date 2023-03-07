import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int count;

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            System.out.println(isPalindrome(input) + " " + count);

        }

    }

    private static int isPalindrome(String word) {
        count = 0;
        return recursion(word, 0, word.length() - 1);
    }

    private static int recursion(String word, int startIndex, int endIndex) {
        count++;
        if (startIndex >= endIndex) {
            return 1;
        } else if (word.charAt(startIndex) != word.charAt(endIndex)) {
            return 0;
        } else {
            return recursion(word, startIndex + 1, endIndex - 1);
        }
    }
}
