import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final boolean[] isPrime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        isPrime();
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        int sumResult = 0;
        int minResult = Integer.MAX_VALUE;

        if (min == 1) {
            min = 2;
        }
        
        for (int i = min; i <= max; i++) {
            if (!(isPrime[i])) {
                sumResult += i;
                minResult = Math.min(minResult, i);
            }
        }

        if (sumResult == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sumResult);
            System.out.println(minResult);
        }
    }

    private static void isPrime() {

        for (int i = 2; i * i <= 10000; i++) {
            if (!(isPrime[i])) {
                for (int j = i * i; j <= 10000; j += i) {
                    isPrime[j] = true;
                }

            }

        }

    }
}
