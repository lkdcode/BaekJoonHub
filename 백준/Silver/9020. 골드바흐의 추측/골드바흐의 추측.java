import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final boolean[] IS_PRIME = new boolean[10001];

    public static void main(String[] args) throws IOException {
        makePrime();

        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            calculator(scanner.nextInt());
        }

    }

    private static void calculator(int number) {
        int minIndex = number / 2;
        int maxIndex = number / 2;

        while (true) {

            if (!(IS_PRIME[minIndex]) && !(IS_PRIME[maxIndex])) {
                System.out.println(minIndex + " " + maxIndex);
                return;
            }
            
            minIndex--;
            maxIndex++;
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
