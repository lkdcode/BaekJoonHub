import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final boolean[] IS_PRIME = new boolean[246912 + 1];

    public static void main(String[] args) throws IOException {
        makePrime();

        while (true) {
            int startNumber = scanner.nextInt();
            if (startNumber == 0) return;
            int endNumber = startNumber * 2;

            int result = 0;

            // 소수 몇개임
            if (startNumber == 1) {
                System.out.println(1);
                continue;
            } else {
                for (int i = startNumber + 1; i <= endNumber; i++) {
                    if (!(IS_PRIME[i])) {
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void makePrime() {


        for (int i = 2; i * i < IS_PRIME.length; i++) {

            for (int j = i * i; j < IS_PRIME.length; j += i) {
                if (!(IS_PRIME[j])) {
                    IS_PRIME[j] = true;
                }
            }
        }

    }
}
