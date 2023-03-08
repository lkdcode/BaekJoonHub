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

        int[] numbers = new int[size + 1];
        int[] sumList = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
        }

        Arrays.sort(numbers);


        sumList[0] = 0;

        for (int i = 1; i <= size; i++) {
            sumList[i] = sumList[i - 1] + numbers[i];
        }

        int result = 0;

        for (int i = 1; i <= size; i++) {
            result += sumList[i];
        }

        System.out.println(result);

    }
}
