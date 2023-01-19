import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String[] inputSplit = input.split(" ");
        int firstDice = Integer.parseInt(inputSplit[0]);
        int secondDice = Integer.parseInt(inputSplit[1]);
        int thirdDice = Integer.parseInt(inputSplit[2]);

        int size = Math.max(10, Math.max((firstDice * secondDice * thirdDice), (firstDice + secondDice + thirdDice)));
        int[] result = new int[size];

        for (int i = 1; i <= firstDice; i++) {
            for (int j = 1; j <= secondDice; j++) {
                for (int k = 1; k <= thirdDice; k++) {
                    result[i + j + k]++;
                }
            }
        }
        int max = 0;

        for (int i = 0; i < result.length; i++) {
            max = Math.max(result[i], max);
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                System.out.println(i);
                break;
            }
        }
    }
}