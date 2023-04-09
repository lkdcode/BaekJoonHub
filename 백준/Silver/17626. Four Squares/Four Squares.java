import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] result;

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());

        result = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            result[i] = result[i - 1] + 1;
            for (int j = 1; j * j <= i; j++) {
                result[i] = Math.min(result[i], result[i - j * j] + 1);
            }
        }

        System.out.println(result[number]);
    }
}