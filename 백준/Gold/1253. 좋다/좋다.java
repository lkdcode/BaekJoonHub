import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());

        String[] inputNumbers = br.readLine().split(" ");

        long[] numbers = new long[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        Arrays.sort(numbers);

        int result = 0;

        for (int i = 0; i < size; i++) {
            long findNumber = numbers[i];
            int startIndex = 0;
            int endIndex = size - 1;

            while (startIndex < endIndex) {
                long sum = numbers[startIndex] + numbers[endIndex];

                if (sum == findNumber) {
                    if (startIndex != i && endIndex != i) {
                        result++;
                        break;
                    } else if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                } else if (sum < findNumber) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }

        }
        System.out.println(result);

    }
}
