import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int size = Integer.parseInt(input[0]) + 1;
        int question = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] numbers = new int[size];
        int[] addNumbers = new int[size];
        numbers[0] = 0;
        addNumbers[0] = 0;

        for (int i = 1; i < size; i++) {
            numbers[i] = Integer.parseInt(input[i - 1]);
        }


        for (int i = 1; i < size; i++) {
            addNumbers[i] = addNumbers[i - 1] + numbers[i];
        }

        for (int i = 0; i < question; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            System.out.println(addNumbers[end] - addNumbers[start - 1]);

        }


    }
}
