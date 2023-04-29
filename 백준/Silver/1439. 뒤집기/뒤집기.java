import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        int result = checkWord(input());
        resultPrint(result);
    }

    private static String input() throws IOException {
        return new BufferedReader(new InputStreamReader(in)).readLine();
    }

    private static int checkWord(String input) {
        int zeroCount = 0;
        int oneCount = 0;

        String[] inputSplit = input.split("1");

        for (int i = 0; i < inputSplit.length; i++) {
            if (inputSplit[i].contains("0")) zeroCount++;
        }

        inputSplit = input.split("0");

        for (int i = 0; i < inputSplit.length; i++) {
            if (inputSplit[i].contains("1")) oneCount++;
        }

        return Math.min(zeroCount, oneCount);
    }

    private static void resultPrint(int result) {
        out.println(result);
    }

}