import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        boolean[] notPrime = new boolean[1_000_001];

        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i <= (int) Math.sqrt(1_000_000); i++) {
            if (notPrime[i]) continue;
            for (int j = i * 2; j <= 1_000_000; j += i) {
                notPrime[j] = true;
            }
        }

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int count = 0;

            int number = Integer.parseInt(br.readLine());

            for (int j = 2; j <= number / 2; j++) {
                if (!notPrime[j] && !notPrime[number - j]) {
                    count++;
                }
            }

            System.out.println(count);

        }

    }

}
