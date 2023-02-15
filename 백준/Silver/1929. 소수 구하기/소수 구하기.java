import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        makePrime();

        String[] input = br.readLine().split(" ");

        int min = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[1]);

        if (min <= 1) {
            min = 2;
        }

        for (int i = min; i <= max; i++) {
            if (!(isPrime[i])) {
                System.out.println(i);
            }
        }


    }


    private static void makePrime() {

        for (int i = 2; i * i <= 1000000; i++) {

            for (int j = i * i; j <= 1000000; j += i) {
                if (!(isPrime[j])) {
                    isPrime[j] = true;
                }
            }

        }

    }
}
