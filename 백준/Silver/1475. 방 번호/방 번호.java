import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String numbers = br.readLine();
        int[] numberList = new int[11];

        for (int i = 0; i < numbers.length(); i++) {
            int number = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            numberList[number]++;
        }

        int max = 0;
        numberList[6] = ((numberList[6] + numberList[9]) / 2) + ((numberList[6] + numberList[9]) % 2);
        numberList[9] = 0;

        for (int i = 0; i < numberList.length; i++) {
            max = Math.max(max, numberList[i]);
        }

        System.out.println(max);
    }
}
