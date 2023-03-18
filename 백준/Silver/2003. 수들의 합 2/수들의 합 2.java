import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int findNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < size; i++) {
            int sum = numbers[i];

            for (int j = i + 1; j < size; j++) {
                if (sum == findNumber) {
                    break;
                } else if (sum > findNumber) {
                    break;
                }
                sum += numbers[j];
            }
            if (sum == findNumber) {
                result++;
            }

        }

        System.out.println(result);


    }
}
