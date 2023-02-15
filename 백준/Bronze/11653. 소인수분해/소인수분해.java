import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int number = scanner.nextInt();

        int n = 2;

        while (number != 1) {

            if (number % n == 0) {
                System.out.println(n);
                number/=n;
            } else {
                n++;
            }
        }

    }
}
