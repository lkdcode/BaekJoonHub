import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Character> CHECK = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        String input = "";
        while (true) {
            input = bf.readLine();
            if (input.equals("#")) {
                break;
            }
            System.out.println(count(input));
        }


    }

    private static int count(String input) {
        input = input.toLowerCase();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (CHECK.contains(input.charAt(i))) {
                result++;
            }
        }

        return result;
    }
}