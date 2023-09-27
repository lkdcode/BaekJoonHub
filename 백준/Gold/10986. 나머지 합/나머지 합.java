import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];
        long sum = 0;
        long result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int remainder = (int) (sum % M);
            count[remainder]++;
        }

        result = count[0];

        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                result += (count[i] * (count[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }

    private static long nCr(long number) {
        long n = factorial(number);
        long r = 2;
        long nMinusR = factorial((number - r));

        return n / (nMinusR * r);
    }

    private static long factorial(long number) {
        if (number <= 1) return 1;

        return factorial(number - 1) * number;
    }

}
