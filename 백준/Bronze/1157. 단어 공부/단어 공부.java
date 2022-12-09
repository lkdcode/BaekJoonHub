import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class Main으로 수정
public class Main {
    private static final int[] result = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        input = input.toUpperCase();
        char[] inputWord = input.toCharArray();
        for (int i = 0; i < inputWord.length; i++) {
            int location = (inputWord[i] - 'A');
            result[location]++;
        }

        int maxNumber = 0;

        for (int i = 0; i < result.length; i++) {
            maxNumber = Math.max(result[i], maxNumber);
        }


        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == maxNumber) {
                count++;
            }
        }

        int wordLocation = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == maxNumber) {
                wordLocation = i;
            }
        }

        if (count >= 2) {
            System.out.println("?");
        }

        if (count < 2) {
            System.out.println((char) (wordLocation + 'A'));
        }

    }
}