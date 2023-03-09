import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        // [N] = [N - 1] + [N - 5]

        int size = Integer.parseInt(br.readLine());

        long[] numbers = new long[101];

        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 1;
        numbers[3] = 1;
        numbers[4] = 2;
        numbers[5] = 2;
        numbers[6] = 3;

        for (int i = 7; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 5];
        }

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(numbers[number]);

        }
    }
}
