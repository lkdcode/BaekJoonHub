import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static int[] D;

    public static void main(String[] args) throws IOException {
        int number = scanner.nextInt();
        D = new int[number + 1];
        for (int i = 0; i < D.length; i++) {
            D[i] = -1;
        }

        D[0] = 0;
        D[1] = 1;

        fibo(number);

        System.out.println(D[number]);
    }

    private static int fibo(int number) {
        
        if (D[number] != -1) {
            return D[number];
        }

        return D[number] = fibo(number - 1) + fibo(number - 2);
    }
}
