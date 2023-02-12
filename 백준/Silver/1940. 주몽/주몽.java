import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());
        int findNumber = Integer.parseInt(bufferedReader.readLine());

        String[] input = bufferedReader.readLine().split(" ");

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);

        int leftIndex = 0;
        int rightIndex = size - 1;
        int result = 0;

        // sum > number   ->   rightIndex--;
        // sum < number   ->   leftIndex++;
        // sum == number  ->   result++;  leftIndex++;  rightIndex--;

        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];

            if (sum > findNumber) {
                rightIndex--;
            } else if (sum < findNumber) {
                leftIndex++;
            } else {
                result++;
                leftIndex++;
                rightIndex--;
            }
        }

        System.out.println(result);

    }
}
