import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int findSum = Integer.parseInt(br.readLine());
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int startIndex = 0;
        int endIndex = size - 1;

        // startIndex + endIndex == sum -> endIndex--; result++;

        // startIndex + endIndex > sum -> endIndex--;
        // startIndex + endIndex < sum -> startIndex++;

        int result = 0;
        while (startIndex != endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];
            if (sum == findSum) {
                endIndex--;
                result++;
            } else if (sum > findSum) {
                endIndex--;
            } else {
                startIndex++;
            }
        }

        System.out.println(result);
    }
}
