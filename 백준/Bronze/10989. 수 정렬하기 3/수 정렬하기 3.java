import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(numbers);

        for (int input : numbers) {
            result.append(input).append('\n');
        }

        System.out.print(result);
    }
}